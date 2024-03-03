/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Services;

import Domain.DTOs.BookingDto.CreateBookingDto;
import Domain.DTOs.PageDto.PageDto;
import Domain.DTOs.PageDto.PageQueryDto;
import Domain.Models.Booking;
import Repositories.Entities.BookingEntity;
import java.sql.ResultSet;
import java.util.List;
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
public class BookingServiceTest {
    
    public BookingServiceTest() {
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
     * Test of getTableName method, of class BookingService.
     */
    @Test
    public void testGetTableName() {
        System.out.println("getTableName");
        BookingService instance = new BookingService();
        String expResult = "";
        String result = instance.getTableName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createEntityFromResultSet method, of class BookingService.
     */
    @Test
    public void testCreateEntityFromResultSet() throws Exception {
        System.out.println("createEntityFromResultSet");
        ResultSet rs = null;
        BookingService instance = new BookingService();
        BookingEntity expResult = null;
        BookingEntity result = instance.createEntityFromResultSet(rs);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllBookings method, of class BookingService.
     */
    @Test
    public void testGetAllBookings() {
        System.out.println("getAllBookings");
        PageQueryDto dto = null;
        BookingService instance = new BookingService();
        PageDto<Booking> expResult = null;
        PageDto<Booking> result = instance.getAllBookings(dto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBookingById method, of class BookingService.
     */
    @Test
    public void testGetBookingById() {
        System.out.println("getBookingById");
        String id = "2";
        BookingService instance = new BookingService();
        Booking expResult = null;
        Booking result = instance.getBookingById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBookingsOfCustomer method, of class BookingService.
     */
    @Test
    public void testGetBookingsOfCustomer() {
        System.out.println("getBookingsOfCustomer");
        String customerId = "";
        BookingService instance = new BookingService();
        List<Booking> expResult = null;
        List<Booking> result = instance.getBookingsOfCustomer(customerId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBookingsByYear method, of class BookingService.
     */
    @Test
    public void testGetBookingsByYear() {
        System.out.println("getBookingsByYear");
        int year = 0;
        BookingService instance = new BookingService();
        List<Booking> expResult = null;
        List<Booking> result = instance.getBookingsByYear(year);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBookingsByYearAndMonth method, of class BookingService.
     */
    @Test
    public void testGetBookingsByYearAndMonth() {
        System.out.println("getBookingsByYearAndMonth");
        int year = 0;
        int month = 0;
        BookingService instance = new BookingService();
        List<Booking> expResult = null;
        List<Booking> result = instance.getBookingsByYearAndMonth(year, month);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createBooking method, of class BookingService.
     */
    @Test
    public void testCreateBooking() {
        System.out.println("createBooking");
        CreateBookingDto dto = null;
        BookingService instance = new BookingService();
        int expResult = 0;
        int result = instance.createBooking(dto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteBooking method, of class BookingService.
     */
    @Test
    public void testDeleteBooking() {
        System.out.println("deleteBooking");
        String id = "";
        BookingService instance = new BookingService();
        instance.deleteBooking(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
