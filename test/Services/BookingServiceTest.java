/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Services;

import Domain.DTOs.BookingDto.CreateBookingDto;
import Domain.DTOs.PageDto.PageDto;
import Domain.DTOs.PageDto.PageQueryDto;
import Domain.Enums.Order;
import Domain.Models.Booking;
import Repositories.Entities.BookingEntity;
import java.sql.ResultSet;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jpesewang
 */
public class BookingServiceTest {

    public BookingServiceTest() {
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

    @Test
    public void testGetTableName() {
        System.out.println("getTableName");
        BookingService instance = new BookingService();
        String expResult = "Bookings";
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
        int page = 1;
        int pageSize = 10;
        Order order = Order.DESC;
        PageQueryDto dto = new PageQueryDto(page, pageSize, order);
        BookingService instance = new BookingService();

        PageDto<Booking> result = instance.getAllBookings(dto);
        assertNotNull(result);
        
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of getBookingById method, of class BookingService.
     */
    @Test
    public void testGetBookingById() {
        System.out.println("getBookingById");
        String id = "23";
        BookingService instance = new BookingService();
        Booking expectedBooking = new Booking();
        expectedBooking.setId(Integer.parseInt(id));
        Booking expResult = null;
        Booking result = instance.getBookingById(id);

        assertEquals(expectedBooking.getId(), result.getId());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBookingsOfCustomer method, of class BookingService.
     */
    @Test
    public void testGetBookingsOfCustomer() {
        System.out.println("getBookingsOfCustomer");
        PageQueryDto dto = null;
        String customerId = "";
        BookingService instance = new BookingService();
        PageDto<Booking> expResult = null;
        PageDto<Booking> result = instance.getBookingsOfCustomer(dto, customerId);
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
