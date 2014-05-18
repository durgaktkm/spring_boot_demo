package demo;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class ApplicationTests {

    @Autowired
    ReservationRepository reservationRepository;
	@Test
	public void contextLoads() {
        Assert.assertNotNull(reservationRepository);
    }

    @Test
    public void testLoadingResultsInDatabase(){
        List<Booking> bookingList = reservationRepository.findAll();
        Assert.assertNotNull(bookingList);
        Assert.assertTrue(bookingList.size() >0);
    }

    @Test
    public void testReadingKittuBookingResultsInDatabase(){
        List<Booking> bookingList = reservationRepository.findByBookingName("Kittu");
        Assert.assertNotNull(bookingList);
        Assert.assertTrue(bookingList.size() ==1);
    }
}
