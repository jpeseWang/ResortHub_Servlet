package Services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Domain.DTOs.CustomerDto.CreateCustomerDto;
import Domain.DTOs.CustomerDto.UpdateCustomerDto;
import Domain.Enums.CustomerType;
import Domain.Exceptions.ConflictException;
import Domain.Exceptions.NotFoundException;
import Domain.Models.Customer;
import Repositories.Common.RepositoryBase;
import Repositories.Entities.CustomerEntity;

public class CustomerService extends RepositoryBase<CustomerEntity> {

    @Override
    protected String getTableName() {
        return "Customers";
    }

    @Override
    protected CustomerEntity createEntityFromResultSet(ResultSet rs) throws SQLException {
        return new CustomerEntity(rs);
    }

    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        List<CustomerEntity> entities = super.getAll();

        for (CustomerEntity entity : entities)
            customers.add(mapEntityToCustomer(entity));

        return customers;
    }

    public Customer getCustomerById(String id) {
        CustomerEntity entity = super.getById(id);

        return mapEntityToCustomer(entity);
    }

    public void createCustomer(CreateCustomerDto dto) throws ConflictException {
        CustomerEntity entity = super.getById(dto.getId());

        if (entity != null) {
            throw new ConflictException("Customer ID already exists.");
        }

        String query = String.format(
                "INSERT INTO %s (Id,FullName,BirthDate,Gender,IdNumber,PhoneNumber,Email,CustomerType,Address) VALUES (?,?,?,?,?,?,?,?,?);",
                getTableName());

        List<Object> params = new ArrayList<>();
        params.add(dto.getId());
        params.add(dto.getFullName());
        params.add(dto.getBirthDate());
        params.add(dto.getGender());
        params.add(dto.getIdNumber());
        params.add(dto.getPhoneNumber());
        params.add(dto.getEmail());
        params.add(dto.getCustomerType().getIndex());
        params.add(dto.getAddress());

        super.executeNonQuery(query, params);
    }

    public void updateCustomer(String id, UpdateCustomerDto dto) {
        CustomerEntity entity = super.getById(id);

        if (entity == null) {
            throw new NotFoundException("Customer ID not found.");
        }

        if (dto.getFullName() == null)
            dto.setFullName(entity.getFullName());
        if (dto.getBirthDate() == null)
            dto.setBirthDate(entity.getBirthDate());
        if (dto.getGender() == null)
            dto.setGender(entity.getGender());
        if (dto.getIdNumber() == null)
            dto.setIdNumber(entity.getIdNumber());
        if (dto.getPhoneNumber() == null)
            dto.setPhoneNumber(entity.getPhoneNumber());
        if (dto.getEmail() == null)
            dto.setEmail(entity.getEmail());
        if (dto.getCustomerType() == CustomerType.None)
            dto.setCustomerType(CustomerType.fromIndex(entity.getCustomerType()));
        if (dto.getAddress() == null)
            dto.setAddress(entity.getAddress());

        String query = String.format(
                "UPDATE %s SET FullName=?,BirthDate=?,Gender=?,IdNumber=?,PhoneNumber=?,Email=?,CustomerType=?,Address=? WHERE Id = %s;",
                getTableName(), id);

        List<Object> params = new ArrayList<>();
        params.add(dto.getFullName());
        params.add(dto.getBirthDate());
        params.add(dto.getGender());
        params.add(dto.getIdNumber());
        params.add(dto.getPhoneNumber());
        params.add(dto.getEmail());
        params.add(dto.getCustomerType().getIndex());
        params.add(dto.getAddress());

        super.executeNonQuery(query, params);
    }

    private Customer mapEntityToCustomer(CustomerEntity entity) {
        Customer customer = new Customer();
        customer.setId(entity.getId());
        customer.setFullName(entity.getFullName());
        customer.setBirthDate(entity.getBirthDate());
        customer.setGender(entity.getGender());
        customer.setIdNumber(entity.getIdNumber());
        customer.setPhoneNumber(entity.getPhoneNumber());
        customer.setEmail(entity.getEmail());
        customer.setCustomerType(CustomerType.fromIndex(entity.getCustomerType()));
        customer.setAddress(entity.getAddress());

        return customer;
    }
}
