/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Services;

import Domain.DTOs.CustomerDto.CreateVoucherRecipientCustomersDto;
import Domain.DTOs.PageDto.PageDto;
import Domain.DTOs.PageDto.PageQueryDto;
import Domain.Models.VoucherRecipientCustomer;
import Repositories.Entities.VoucherRecipientCustomerEntity;
import java.sql.ResultSet;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author jpesewang
 */
public class PromotionServiceTest {
    
    public PromotionServiceTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getTableName method, of class PromotionService.
     */
    @Test
    public void testGetTableName() {
        System.out.println("getTableName");
        PromotionService instance = new PromotionService();
        String expResult = "";
        String result = instance.getTableName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createEntityFromResultSet method, of class PromotionService.
     */
    @Test
    public void testCreateEntityFromResultSet() throws Exception {
        System.out.println("createEntityFromResultSet");
        ResultSet rs = null;
        PromotionService instance = new PromotionService();
        VoucherRecipientCustomerEntity expResult = null;
        VoucherRecipientCustomerEntity result = instance.createEntityFromResultSet(rs);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVoucherRecipientCustomers method, of class PromotionService.
     */
    @Test
    public void testGetVoucherRecipientCustomers() {
        System.out.println("getVoucherRecipientCustomers");
        PageQueryDto dto = null;
        int year = 0;
        int month = 0;
        PromotionService instance = new PromotionService();
        PageDto<VoucherRecipientCustomer> expResult = null;
        PageDto<VoucherRecipientCustomer> result = instance.getVoucherRecipientCustomers(dto, year, month);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createVoucherRecipientCustomers method, of class PromotionService.
     */
    @Test
    public void testCreateVoucherRecipientCustomers() {
        System.out.println("createVoucherRecipientCustomers");
        CreateVoucherRecipientCustomersDto dto = null;
        PromotionService instance = new PromotionService();
        instance.createVoucherRecipientCustomers(dto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
