package Services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Domain.DTOs.FacilityDto.CreateFacilityDto;
import Domain.DTOs.PageDto.PageDto;
import Domain.DTOs.PageDto.PageMetaDto;
import Domain.DTOs.PageDto.PageQueryDto;
import Domain.Enums.FacilityType;
import Domain.Enums.Order;
import Domain.Exceptions.ConflictException;
import Domain.Models.Booking;
import Domain.Models.Facility;
import Domain.Models.MaintenanceFacility;
import Repositories.Common.RepositoryBase;
import Repositories.Entities.FacilityEntity;

public class FacilityService extends RepositoryBase<FacilityEntity> {

    private VillaService villaService;
    private HouseService houseService;
    private RoomService roomService;

    @Override
    protected String getTableName() {
        return "Facilities";
    }

    @Override
    protected FacilityEntity createEntityFromResultSet(ResultSet rs) throws SQLException {
        return new FacilityEntity(rs);
    }

    public FacilityService() {
        villaService = new VillaService();
        houseService = new HouseService();
        roomService = new RoomService();
    }

    public PageDto<Facility> getAllFacilities(PageQueryDto dto) {
        List<Facility> facilities = new ArrayList<>();
        List<FacilityEntity> entities = super.getAllWithOffset(dto.getOffset(), dto.getPageSize(),
                dto.getOrder() == Order.ASC);
        int itemCount = super.getTotalCount();

        for (FacilityEntity entity : entities) {
            facilities.add(mapEntityToFacility(entity));
        }

        PageMetaDto meta = new PageMetaDto(dto, itemCount);

        return new PageDto<>(facilities, meta);
    }

    public PageDto<Facility> getAllFacilities(PageQueryDto dto, FacilityType facilityType) {
        List<Facility> facilities = new ArrayList<>();
        List<FacilityEntity> entities = super.getAllWithOffset(
                String.format("FacilityType = %d", facilityType.getIndex()), dto.getOffset(), dto.getPageSize(),
                dto.getOrder() == Order.ASC);
        int itemCount = super.getTotalCount();

        for (FacilityEntity entity : entities) {
            facilities.add(mapEntityToFacility(entity));
        }

        PageMetaDto meta = new PageMetaDto(dto, itemCount);

        return new PageDto<>(facilities, meta);
    }

    public Facility getFacilityById(String id) {
        FacilityEntity entity = super.getById(id);
        Facility facility = mapEntityToFacility(entity);

        switch (facility.getFacilityType()) {
            case Villa:
                facility.setVilla(villaService.getVillaById(id));
                break;
            case House:
                facility.setHouse(houseService.getHouseById(id));
                break;
            case Room:
                facility.setRoom(roomService.getRoomById(id));
                break;
            default:
                break;
        }

        return facility;
    }

    public List<MaintenanceFacility> getFacilitiesForMaintenance(int year, int month) {
        BookingService bookingService = new BookingService();
        List<Booking> bookings = bookingService.getBookingsByYearAndMonth(year, month);

        Map<String, String> facilityIdToNameMap = new HashMap<>();

        Map<String, Integer> facilityUsageCountMap = new HashMap<>();

        for (Booking booking : bookings) {
            String facilityId = booking.getFacilityId();
            facilityUsageCountMap.put(facilityId, facilityUsageCountMap.getOrDefault(facilityId, 0) + 1);
            Facility facility = this.getFacilityById(facilityId);
            if (facility != null) {
                facilityIdToNameMap.putIfAbsent(facilityId, facility.getName());
            }
        }

        List<MaintenanceFacility> maintenanceFacilities = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : facilityUsageCountMap.entrySet()) {
            MaintenanceFacility maintenanceFacility = new MaintenanceFacility();
            String facilityId = entry.getKey();

            maintenanceFacility.setId(facilityId);
            maintenanceFacility.setUsageCount(entry.getValue());
            maintenanceFacility.setName(facilityIdToNameMap.getOrDefault(facilityId, "Unknown"));

            maintenanceFacilities.add(maintenanceFacility);
        }

        return maintenanceFacilities;
    }

    public void createFacility(CreateFacilityDto dto) {
        FacilityEntity entity = super.getById(dto.getId());

        if (entity != null) {
            throw new ConflictException("Facility ID already exists.");
        }

        String query = String.format(
                "INSERT INTO %s (Id,Name,Area,RentalCost,MaxOccupancy,RentType,FacilityType, ImgSrc) VALUES (?,?,?,?,?,?,?,?);",
                getTableName());

        List<Object> params = new ArrayList<>();
        params.add(dto.getId());
        params.add(dto.getName());
        params.add(dto.getArea());
        params.add(dto.getRentalCost());
        params.add(dto.getMaxOccupancy());
        params.add(dto.getRentType());
        params.add(dto.getFacilityType().getIndex());
        params.add(dto.getImgSrc());

        super.executeNonQuery(query, params);

        switch (dto.getFacilityType()) {
            case Villa:
                villaService.createVilla(dto.getId(), dto.getVilla());
                break;
            case House:
                houseService.createHouse(dto.getId(), dto.getHouse());
                break;
            case Room:
                roomService.createRoom(dto.getId(), dto.getRoom());
                break;
            default:
                break;
        }
    }

    private Facility mapEntityToFacility(FacilityEntity entity) {
        Facility facility = new Facility();
        facility.setId(entity.getId());
        facility.setName(entity.getName());
        facility.setArea(entity.getArea());
        facility.setRentalCost(entity.getRentalCost());
        facility.setMaxOccupancy(entity.getMaxOccupancy());
        facility.setRentType(entity.getRentType());
        facility.setFacilityType(FacilityType.fromIndex(entity.getFacilityType()));
        facility.setImgSrc(entity.getImgSrc());

        return facility;
    }

}
