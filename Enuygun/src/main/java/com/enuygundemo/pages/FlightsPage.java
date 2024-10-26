package com.enuygundemo.pages;

//import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FlightsPage extends BasePage {
	BasePage bp = new BasePage();
	private JavascriptExecutor js;

	WebElement fromD = bp.find(By.xpath("//input[@data-testid='endesign-flight-origin-autosuggestion-input']"));
	WebElement toD = bp.find(By.xpath("//input[@data-testid='endesign-flight-destination-autosuggestion-input']"));
	WebElement searchButton = bp.find(By.xpath("//button[@data-testid='enuygun-homepage-flight-submitButton']"));

	/*
	 * public void selectRoundTrip() { WebElement roundTripRadioButton =
	 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	 * "//input[@id='radio-flightTrip-ic3795d513fa89dbb2ad3']")));
	 * System.out.println("Selecting 'Gidiş-dönüş' (Round Trip) radio button...");
	 * bp.click(roundTripRadioButton);
	 * 
	 * }
	 * 
	 */
	public void setFromDestination(String from) {
		fromD.clear();
		fromD.click();
		fromD.sendKeys(from);

		System.out.print(fromD.toString());
		// Wait for the drop to appear
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("[data-testid='autosuggestion-custom-item-istanbul']")));
		// Find the drop item and click on it
		WebElement dropdownItem = driver
				.findElement(By.cssSelector("[data-testid='autosuggestion-custom-item-istanbul']"));
		dropdownItem.click();
		System.out.println("Selected 'İstanbul' from the dropdown.");
	}

	public void setToDestination(String to) {
		toD.clear();
		toD.click();
		toD.sendKeys(to);

		// Wait for the drop to appear
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("[data-testid='autosuggestion-custom-item-ankara-esenboga-havalimani']")));

		// click on drop
		WebElement dropdownItem = driver
				.findElement(By.cssSelector("[data-testid='autosuggestion-custom-item-ankara-esenboga-havalimani']"));
		dropdownItem.click();

		System.out.println("Selected 'Ankara' from the dropdown.");
	}

	public void selectDepartureDate(String departureDateInput, String day) {
		WebElement departureDate = driver
				.findElement(By.cssSelector("[data-testid='enuygun-homepage-flight-departureDate-datepicker-input']"));
		departureDate.click();

		// select the day
		String dayButtonSelector = String.format("button[title='%s']", departureDateInput + "-" + day);
		WebElement dayButton = driver.findElement(By.cssSelector(dayButtonSelector));
		dayButton.click();
		System.out.println("Selected the departure date: " + departureDateInput + " - " + day);
	}

	public void selectArrivalDate(String returnDateInput, String day) {
		try {
			// Find both the input and the label
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			    js.executeScript(
			        "document.evaluate(arguments[0], document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.remove();", 
			        "/html/body/div[1]/div/div[2]/div/div[1]/div/div[2]/div/div/div/form/div/div[2]/div[1]/div[1]/div/div[4]/div/div/div[1]/div/div/div/div/div[1]/label/div[1]"
			    );
			WebElement returnDate = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div/div[2]/div/div/div/form/div/div[2]/div[1]/div[1]/div/div[4]/div/div/div[1]/div/div/div/div/div[1]/label/div/input"));
			returnDate.click();
			WebElement xxx = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div/div[2]/div/div/div/form/div/div[2]/div[1]/div[1]/div/div[4]/div/div/div[1]/div/div/div/div/div[1]/label/div[2]/input"));
			xxx.click();
			System.out.print("clicked DATE return");
			// Wait for calendar to be visible
			Thread.sleep(1000);

			String dayButtonSelector = String.format("button[title='%s']", returnDateInput + "-" + day);

			WebElement dayButton = driver.findElement(By.cssSelector(dayButtonSelector));

			dayButton.click();
			System.out.println("Selected the arrival date: " + returnDateInput + " - " + day);
		} catch (Exception e) {
			System.out.println("Error selecting arrival date: " + e.getMessage());
			throw new RuntimeException("Failed to select arrival date", e);
		}
	}

	public void clickSearchButton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", searchButton);
	}
}