package Services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Domain.DTOs.FacilityDto.CreateFacilityDto;
import Domain.Enums.FacilityType;
import Domain.Exceptions.ConflictException;
import Domain.Models.Facility;
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

    public List<Facility> getAllFacilities() {
        List<Facility> facilities = new ArrayList<>();
        List<FacilityEntity> entities = super.getAll();

        for (FacilityEntity entity : entities)
            facilities.add(mapEntityToFacility(entity));

        return facilities;
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

    public void createFacility(CreateFacilityDto dto) {
        FacilityEntity entity = super.getById(dto.getId());

        if (entity != null) {
            throw new ConflictException("Facility ID already exists.");
        }

        String query = String.format(
                "INSERT INTO %s (Id,Name,Area,RentalCost,MaxOccupancy,RentType,FacilityType) VALUES (?,?,?,?,?,?,?);",
                getTableName());

        List<Object> params = new ArrayList<>();
        params.add(dto.getId());
        params.add(dto.getName());
        params.add(dto.getArea());
        params.add(dto.getRentalCost());
        params.add(dto.getMaxOccupancy());
        params.add(dto.getRentType());
        params.add(dto.getFacilityType().getIndex());

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

        return facility;
    }

}
