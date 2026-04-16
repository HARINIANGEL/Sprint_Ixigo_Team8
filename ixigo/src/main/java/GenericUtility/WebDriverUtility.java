package GenericUtility;


	import java.time.Duration;
	import java.util.Set;

	import org.openqa.selenium.Dimension;
	import org.openqa.selenium.Point;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class WebDriverUtility {
		WebDriver driver;
		WebDriverWait wait;
		public WebDriverUtility(WebDriver driver) {
			this.driver=driver;
		}
		
		//Manage
		//maximize
		public void configMaximizedBrowser() {
			driver.manage().window().maximize();
		}
		//minimize
		public void configMinimizedBrowser() {
			driver.manage().window().minimize();
		}
		//fullscreen
		public void configFullscreenBrowser() {
			driver.manage().window().fullscreen();
		}
		//fetching browser size
		public Dimension fetchBrowserSize() {
			Dimension dimension =driver.manage().window().getSize();
			return dimension;
		}
		//setting browser size
		public void configBrowserSize(int width,int height) {
			driver.manage().window().setSize(new Dimension(width,height));
		}
		//getting position
		public Point fetchBrowserCoordinates() {
			Point point = driver.manage().window().getPosition();
			return point;
		}
		//setting position
		public void ConfigBrowserCoordinates(int width,int height) {
			driver.manage().window().setPosition(new Point(width,height));
		}
		//Navigate
		//navigate to string url
		public void navigateToApplication(String fullUrl) {
			driver.navigate().to(fullUrl);
		}
		//forward 
		public void navigateToForward() {
			driver.navigate().forward();
		}
		//backward
		public void navigateToBackward() {
			driver.navigate().back();
		}
		//refresh
		public void Refresh() {
			driver.navigate().refresh();
		}
		//get
		public void enterUrl(String url) {
			driver.get(url);
		}
		//Get Title
		public String fetchApplicationTitle() {
			String title=driver.getTitle();
			return title;
		}
		//GetURL
		public String fetchApplicationUrl() {
			String Url = driver.getCurrentUrl();
			return Url;
		}
		//close
		public void closingBrowserTab() {
			driver.close();
		}
		//quit
		public void quitBrowserWindow() {
			driver.quit();
		}
		//implicit wait 
		public void waitForElementsToLoad(int seconds) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
		}
		//explicit wait
		//Element to be clickable
		public void waitTillTheElementIsClickable(WebElement element, long maximumTimeToWait) {
			wait= new WebDriverWait(driver,Duration.ofSeconds(maximumTimeToWait));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		//Visibility of element
		public void waitTillTheElementIsVisible(WebElement element, long maximumTimeToWait) {
			wait= new WebDriverWait(driver,Duration.ofSeconds(maximumTimeToWait));
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		//popups
		//Alert
		public void clickOnAccept() {
			driver.switchTo().alert().accept();
		}
		public void clickOnDismiss() {
			driver.switchTo().alert().dismiss();
		}
		public void typeMessageInJavascriptPopup(String text) {
			driver.switchTo().alert().sendKeys(text);
		}
		public void printJavascriptPopupMessage() {
			System.out.println(driver.switchTo().alert().getText());
		}
		//using fetch
		public String fetchJavascriptPopupMessage() {
			String message = driver.switchTo().alert().getText();
			return message;
		}
		//child window switching
		public void windowSwitchingByTitle(String childApplicationTitle) {
			String parentId = driver.getWindowHandle();
			Set<String> childIds = driver.getWindowHandles();
			childIds.remove(parentId);
			for(String child:childIds) {
				driver.switchTo().window(child);
				String title = driver.getTitle();
				if(title.contains(childApplicationTitle)) {
					break;
				}
			}
		}
		//child switching by url
		public void windowSwitchingByURL(String childApplicationurl) {
			String parentId = driver.getWindowHandle();
			Set<String> childIds = driver.getWindowHandles();
			childIds.remove(parentId);
			for(String child:childIds) {
				driver.switchTo().window(child);
				String title = driver.getCurrentUrl();
				if(title.contains(childApplicationurl)) {
					break;
				}
			}
		}
		
		//iFrame
		public void switchToFrameByIndex(int indexno) {
			driver.switchTo().frame(indexno);
		}
		public void switchToFrameByIdOrName(String idOrName) {
			driver.switchTo().frame(idOrName);
		}
		public void switchToFrameByFrameElement(WebElement frameElement) {
			driver.switchTo().frame(frameElement);
		}
		public void switchBacktheControlToPreviousFrame() {
			driver.switchTo().parentFrame();
		}
		public void switchBacktheControlToMainPage() {
			driver.switchTo().defaultContent();
		}
	}
