/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Services;

import Domain.DTOs.CustomerDto.CreateVoucherRecipientCustomersDto;
import Domain.DTOs.PageDto.PageDto;
import Domain.DTOs.PageDto.PageQueryDto;
import Domain.Models.VoucherRecipientCustomer;
import Repositories.Entities.VoucherRecipientCustomerEntity;
import java.sql.ResultSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class PromotionServiceTest {
    
    public PromotionServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
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
