package case1.com.enuygundemo.tests.filters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.enuygundemo.pages.BasePage;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.interactions.Actions;

public class Filters extends BasePage {
	BasePage bp = new BasePage();

	public void closePopUp() {
		WebElement popUp = driver.findElement(By.id("onetrust-accept-btn-handler"));
		popUp.click();
	}

	// Uçuş Saati 10.00 - 18.00 filtreleme
	public boolean adjustSliders() {
		try {
			System.out.println("Before Departure Time Filter Clicked");
			WebElement departureTimeFilter = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("/html/body/div[3]/div[4]/div[2]/div[1]/div[3]/div[4]/div[1]")));
			// Click the departure time filter
			departureTimeFilter.click();
			// Wait for sliders to be visible

			WebElement firstSlider = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//div[@role='slider' and @class='rc-slider-handle rc-slider-handle-1']")));
			WebElement secondSlider = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//div[@role='slider' and @class='rc-slider-handle rc-slider-handle-2']")));

			Actions actions = new Actions(driver);

			// Get the slider track for relative positioning
			WebElement sliderTrack = driver.findElement(By.className("rc-slider-track"));
			int trackWidth = sliderTrack.getSize().getWidth() / 24;

			int firstSliderOffset = (int) (trackWidth * 10);
			actions.clickAndHold(firstSlider).moveByOffset(firstSliderOffset, 0).release().perform();
			System.out.println("FIRST SLIDER moved");
			Thread.sleep(500);

			int secondSliderOffset = (int) (trackWidth * (-6));
			actions.clickAndHold(secondSlider).moveByOffset(secondSliderOffset, 0).release().perform();

			Thread.sleep(1000);
			System.out.println("SECOND SLIDER moved");

			WebElement filterText = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//div[@class='filter-slider-content'][contains(text(), '10:00 ile 18:00 arası')]")));

			return filterText.getText().equals("10:00 ile 18:00 arası");

		} catch (Exception e) {
			System.out.println("Error during slider adjustment: " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	// THY filtreleme
	public void flightFilter() {
		try {
			// Click on Havayolları filter
			WebElement airlinesFilter = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//span[@class='card-title'][contains(., 'Havayolları')]")));
			airlinesFilter.click();
			System.out.println("Airlines filter clicked");

			// Wait for checkbox to be visible and clickable
			WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("/html/body/div[3]/div[4]/div[2]/div[1]/div[3]/div[6]/div[2]/div/label[3]")));
			checkbox.click();
			System.out.println("Checkbox selected");

			// Wait briefly for the filter to be applied
			Thread.sleep(1000);

		} catch (Exception e) {
			System.out.println("Error during flight filter selection: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// Artan özellikte sıralama
	public boolean priceSort() {
		try {
			// Find the cheapest sort button
			WebElement cheapestSortButton = wait
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-testid='sortButtons0']")));

			if (cheapestSortButton.getAttribute("class").contains("active")) {
				System.out.println("Cheapest sort is already selected");
				return true;
			} else {
				System.out.println("Selecting cheapest sort option");
				cheapestSortButton.click();

				wait.until(ExpectedConditions.attributeContains(By.xpath("//div[@data-testid='sortButtons0']"), "class",
						"active"));

				// Verify it's now selected
				WebElement verifyButton = driver.findElement(By.xpath("//div[@data-testid='sortButtons0']"));
				boolean isSelected = verifyButton.getAttribute("class").contains("active");

				if (isSelected) {
					System.out.println("Successfully selected cheapest sort");
					return true;
				} else {
					System.out.println("Failed to select cheapest sort");
					return false;
				}
			}

		} catch (Exception e) {
			System.out.println("Error during sort selection: " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	public void selectFlight() throws InterruptedException {
		bp.click(By.xpath(
				"/html/body/div[3]/div[4]/div[2]/div[2]/div/div[1]/div/div[2]/div[1]/div/div[1]/div[1]/div/div[5]/button"));
		Thread.sleep(1000);
		bp.click(By.xpath(
				"/html/body/div[3]/div[4]/div[2]/div[2]/div/div[1]/div/div[2]/div[1]/div/div[1]/div[6]/div[1]/div[4]/div[2]/div[1]/span"));
		Thread.sleep(1000);
		bp.click(By.xpath(
				"/html/body/div[3]/div[4]/div[2]/div[2]/div/div[1]/div/div[2]/div[1]/div/div[1]/div[6]/div[2]/button"));
		Thread.sleep(1000);
		bp.click(By.xpath(
				"/html/body/div[3]/div[4]/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[1]/div/div[1]/div[1]/div/div[4]/button"));
		Thread.sleep(1000);
		bp.click(By.xpath(
				"/html/body/div[3]/div[4]/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[1]/div/div[1]/div[6]/div/div[1]"));
	}

	public boolean formSelect() throws InterruptedException {
		Thread.sleep(1000);
		bp.set(By.xpath("//*[@id=\"contact_email\"]"), "marcelineozd@gmail.com");
		Thread.sleep(1000);
		bp.set(By.xpath("//*[@id=\"contact_cellphone\"]"), "@123456789");
		Thread.sleep(1000);
		bp.set(By.xpath("//*[@id=\"firstName_0\"]"), "Celine Dilara");
		Thread.sleep(1000);
		bp.set(By.xpath("//*[@id=\"lastName_0\"]"), "Ozdemir");
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Select Day
		WebElement day = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("birthDateDay_0")));
		js.executeScript("arguments[0].value = '25';" + "arguments[0].dispatchEvent(new Event('change'));", day);

		// Select Month
		WebElement month = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("birthDateMonth_0")));
		js.executeScript("arguments[0].value = '09';" + "arguments[0].dispatchEvent(new Event('change'));", month);

		// Select Year
		WebElement year = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("birthDateYear_0")));
		js.executeScript("arguments[0].value = '2002';" + "arguments[0].dispatchEvent(new Event('change'));", year);
		WebElement femaleRadio = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("gender_F_0")));

		// Click using JavaScript
		js.executeScript("arguments[0].click(); arguments[0].checked = true;", femaleRadio);

		// Verify selection
		boolean isSelected = (boolean) js.executeScript("return arguments[0].checked;", femaleRadio);
		// Assert.assertTrue("Female gender should be selected", isSelected);
		bp.set(By.xpath("/html/body/div[3]/div[3]/div/div[1]/form[1]/div[4]/div/div[2]/div[5]/input"), "11111111111");
		bp.click(By.xpath("//*[@id=\"continue-button\"]"));

		WebElement errorMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("/html/body/div[3]/div[3]/div/div[1]/form[1]/div[4]/div/div[2]/div[5]/span")));

		// Verify the error message text
		String actualError = errorMessage.getText();
		String expectedError = "Lütfen yolcuya ait TC Kimlik Numarasını girin.";

		// Log the result
		if (actualError.equals(expectedError)) {
			System.out.println("TC No error message verified successfully");
			return true;
		} else {
			System.out.println(
					"Error message mismatch. Expected: '" + expectedError + "' but got: '" + actualError + "'");
			return false;
		}

	}

}
