package case1.com.enuygundemo.tests.flights;

import case1.com.enuygundemo.base.BaseTest;
import case1.com.enuygundemo.tests.filters.Filters;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.enuygundemo.pages.FlightsPage;

public class FlightsTest extends BaseTest {
	private FlightsPage flightsPage;
	private Filters filtersPage;

	@Override
	@Before
	public void setUp() {
		super.setUp();
		flightsPage = new FlightsPage();
		filtersPage = new Filters();
	}

	// CASE 1 :
	@Test
	public void case01() throws InterruptedException {
		try {
			// flightsPage.selectRoundTrip();
			System.out.println("CASE 1 Test is Started. ");
			System.out.println("PopUp engellendi");
			filtersPage.closePopUp();
			System.out.println("1.1) Setting departure city to Istanbul..");
			flightsPage.setFromDestination("İstanbul");

			System.out.println("1.2) Setting arrival city to Ankara...");
			flightsPage.setToDestination("Ankara");

			System.out.println("1.3) Selecting departure date...");
			flightsPage.selectDepartureDate("2024-11", "05");

			System.out.println("Selecting arrival date...");
			flightsPage.selectArrivalDate("2024-12", "01");

			System.out.println("1.4) Clicking search button...");
			flightsPage.clickSearchButton();

			Thread.sleep(2000);

			String currentUrl = driver.getCurrentUrl();
			Assert.assertTrue("URL should contain search parameters",
					currentUrl.contains("istanbul") && currentUrl.contains("ankara"));

			System.out.println("1.5Filtering Flights from 10.00 to 18.00");
			filtersPage.adjustSliders();
			Thread.sleep(2000);
			System.out.println("CASE 1 completed successfully!");

		} catch (Exception e) {
			System.err.println("CASE 1 TEST FAILED" + e.getMessage());
			throw new RuntimeException(e);
		}
	}

	// CASE 2 :
	@Test
	public void case02() throws InterruptedException {
		try {
			// flightsPage.selectRoundTrip();
			System.out.println("CASE 2 Test is Started. ");
			System.out.println("2.1) PopUp engellendi");
			filtersPage.closePopUp();
			System.out.println("2.2) Setting departure city to Istanbul...");
			flightsPage.setFromDestination("İstanbul");
			Thread.sleep(1000);
			System.out.println("2.3) Setting arrival city to Ankara...");
			flightsPage.setToDestination("Ankara");
			Thread.sleep(1000);
			System.out.println("2.4) Selecting departure date...");
			flightsPage.selectDepartureDate("2024-11", "05");
			Thread.sleep(1000);
			System.out.println("2.5) Selecting arrival date...");
			flightsPage.selectArrivalDate("2024-12", "01");
			Thread.sleep(1000);
			System.out.println("2.6) Clicking search button...");
			Thread.sleep(1000);
			flightsPage.clickSearchButton();

			Thread.sleep(3000);

			String currentUrl = driver.getCurrentUrl();
			Assert.assertTrue("URL should contain search parameters",
					currentUrl.contains("istanbul") && currentUrl.contains("ankara"));
			System.out.println("2.7) Started Turkish Airlines Filter");
			filtersPage.flightFilter();
			Thread.sleep(1000);
			boolean isSorted = filtersPage.priceSort();
			Assert.assertTrue("2.8) Failed to sort by cheapest price", isSorted);
			Thread.sleep(1000);
			System.out.println("CASE 2 completed successfully!");

		} catch (Exception e) {
			System.err.println("Test CASE 2 is failed: " + e.getMessage());
			throw new RuntimeException(e);
		}

	}

	// CASE 3:

	@Test
	public void case03() throws InterruptedException {
		try {
			// flightsPage.selectRoundTrip();
			System.out.println("CASE 3 Test is Started. ");
			System.out.println("3.1) PopUp engellendi");
			filtersPage.closePopUp();
			Thread.sleep(1000);
			System.out.println("3.2) Setting departure city to Istanbul...");
			flightsPage.setFromDestination("İstanbul");
			Thread.sleep(1000);
			System.out.println("3.3) Setting arrival city to Ankara...");
			flightsPage.setToDestination("Ankara");
			Thread.sleep(1000);
			System.out.println("3.4) Selecting departure date...");
			flightsPage.selectDepartureDate("2024-11", "05");
			Thread.sleep(1000);
			System.out.println("3.5) Selecting arrival date...");
			flightsPage.selectArrivalDate("2024-12", "01");
			Thread.sleep(1000);
			System.out.println("3.6) Clicking search button...");
			flightsPage.clickSearchButton();
			Thread.sleep(1000);
			

			String currentUrl = driver.getCurrentUrl();
			Assert.assertTrue("URL should contain search parameters",
					currentUrl.contains("istanbul") && currentUrl.contains("ankara"));

			System.out.println("3.7) Started Turkish Airlines Filter");
			filtersPage.flightFilter();
			Thread.sleep(1000);
			boolean isSorted = filtersPage.priceSort();
			Assert.assertTrue("Failed to sort by cheapest price", isSorted);
			Thread.sleep(1000);
			System.out.println("3.8) Started Flight Selection...");
			filtersPage.selectFlight();
			Thread.sleep(1000);
			System.out.println("3.9) Started Form Selection...");
			filtersPage.formSelect();
			Thread.sleep(1000);
			System.out.println("CASE 3 completed successfully!");

		} catch (Exception e) {
			System.err.println("Test CASE 3 is failed: " + e.getMessage());
			throw new RuntimeException(e);
		}
	}

}