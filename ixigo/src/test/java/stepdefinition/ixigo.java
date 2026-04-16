package stepdefinition;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import GenericUtility.BaseClass;
import GenericUtility.ExcelUtility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ixigo {
	  WebDriver driver;
	    WebDriverWait wait;
	    ExcelUtility excel = new ExcelUtility();
	    

	    public ixigo(BaseClass b) {
	        this.driver = b.driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    }
	@Given("user launches the ixigo website")

		 public void user_launches_the_ixigo_website() throws InterruptedException, EncryptedDocumentException, IOException {


		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		        try {
		            WebElement closeBtn = wait.until(
		                ExpectedConditions.elementToBeClickable(By.id("closeButton"))
		            );
		            closeBtn.click();
		        } catch (Exception e) {
		            System.out.println("Popup not displayed");
		        }
		        excel.loadExcelFile("C:\\Users\\KARTHIGA\\Downloads\\Source.xlsx","Sheet1");
	}
	@When("user selects Bus option")
		 public void user_selects_bus_option() throws InterruptedException {

		        WebElement buses = wait.until(
		            ExpectedConditions.presenceOfElementLocated(
		                By.xpath("(//p[contains(.,'Buses')])[2]")
		            )
		        );
		       
		        ((JavascriptExecutor) driver).executeScript(
		            "arguments[0].scrollIntoView(true);", buses
		        );

		        try {
		            Thread.sleep(1000);
		        } catch (InterruptedException e) {}
		        ((JavascriptExecutor) driver).executeScript(
		            "arguments[0].click();", buses
		        );
		      
		      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		        try {
		         

		            Thread.sleep(3000);

		            JavascriptExecutor js = (JavascriptExecutor) driver;

		            String script =
		                "var selectors = ["
		                + "'iframe[src*=\"sso-login\"]',"
		                + "'.login-modal',"
		                + "'.modal-backdrop',"
		                + "'.abrs-backdrop',"
		                + "'[class*=\"Overlay\"]',"
		                + "'[class*=\"backdrop\"]',"
		                + "'[role=\"dialog\"]'"
		                + "];"
		                + "selectors.forEach(function(sel){"
		                + "  document.querySelectorAll(sel).forEach(function(el){"
		                + "    if (el && el.parentNode) { el.parentNode.removeChild(el); }"
		                + "  });"
		                + "});"
		                + "document.body.style.overflow = 'auto';"
		                + "document.documentElement.style.overflow = 'auto';"
		                + "document.body.style.pointerEvents = 'auto';"
		                + "document.documentElement.style.pointerEvents = 'auto';";

		            js.executeScript(script);

		            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".abrs-backdrop")));

		            js.executeScript(
		                "var ele = document.querySelector('.abrs-backdrop');"
		                + "if (ele && ele.parentNode) ele.parentNode.removeChild(ele);"
		            );

		            System.out.println("Login popup removed. You can now proceed with automation.");

		           
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        } 
		    }
		    

		    
		    
		    @When("user enters source city")
		    public void user_enters_source_city() {

		        String fromCity = excel.getDataFromSingleCell(1, 0);

		        WebElement from = wait.until(
		            ExpectedConditions.elementToBeClickable(
		                By.cssSelector("[placeholder='From Station']")
		            )
		        );

		        from.click();
		        from.clear();
		        from.sendKeys(fromCity);

		        List<WebElement> options = wait.until(
		            ExpectedConditions.visibilityOfAllElementsLocatedBy(
		                By.xpath("//ul//li")
		            )
		        );

		        for (WebElement option : options) {
		            if (option.getText().contains(fromCity)) {
		                option.click();
		                break;
		            }
		        }
	}
	
	@When("user enters destination city")
	public void user_enters_destination_city() {
		

	        String toCity = excel.getDataFromSingleCell(1, 1);

	        WebElement to = wait.until(
	            ExpectedConditions.elementToBeClickable(
	                By.cssSelector("[placeholder='To Station']")
	            )
	        );

	        to.click();
	        to.clear();
	        to.sendKeys(toCity);

	        List<WebElement> options = wait.until(
	            ExpectedConditions.visibilityOfAllElementsLocatedBy(
	                By.xpath("//ul//li")
	            )
	        );

	        for (WebElement option : options) {
	            if (option.getText().contains(toCity)) {
	                option.click();
	                break;
	            }
	        }
	}
	@When("user selects travel date")
	public void user_selects_travel_date() {
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(
		            By.cssSelector(".abrs-backdrop")
		        ));

		        WebElement dateField = wait.until(
		            ExpectedConditions.elementToBeClickable(
		                By.xpath("//input[@placeholder='Onward Journey Date']")
		            )
		        );
		        dateField.click();

		        WebElement tomorrow = wait.until(
		            ExpectedConditions.elementToBeClickable(
		                By.xpath("//button[normalize-space()='Tomorrow']")
		            )
		        );

		        ((JavascriptExecutor) driver).executeScript(
		            "arguments[0].click();", tomorrow
		        );
	}
	@When("user clicks on search button")
	public void user_clicks_on_search_button() {
	    
	}
	@Then("user should see list of available buses")
	public void user_should_see_list_of_available_buses() {
	    
	}
	@When("user selects a bus")
	public void user_selects_a_bus() {
	  
	}
	@When("user selects seat")
	public void user_selects_seat() {
	    
	}
	@When("user clicks on continue")
	public void user_clicks_on_continue() {

	}
	@Then("user should be navigated to passenger details page")
	public void user_should_be_navigated_to_passenger_details_page() {
	   
	}
	@When("user enters passenger details")
	public void user_enters_passenger_details() {
	    
	}
	@When("user enters contact details")
	public void user_enters_contact_details() {
	   
	}
	@When("user clicks on proceed to payment")
	public void user_clicks_on_proceed_to_payment() {
	   
	}
	@Then("user should be navigated to payment page")
	public void user_should_be_navigated_to_payment_page() {
	    
	}
}
