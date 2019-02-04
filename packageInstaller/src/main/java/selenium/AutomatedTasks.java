package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AutomatedTasks {
	private String userName;
	private String password;
	String clientMnemonic;
	public AutomatedTasks(String userName, String password, String clientMnemonic)
	{
		this.userName=userName;
		this.password=password;
		this.clientMnemonic=clientMnemonic;
	}
	public void getReport()
	{
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
        driver.get("https://distributions.cerner.com/");
        driver.switchTo().frame(0);
        setXpath(driver,"//div[@class='header']/following::p/a");
        setXpath(driver,"//*[@id=\"divNav\"]/table/tbody/tr/td/table[4]/tbody/tr/td[1]");
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        setXpath(driver, "//*[@id=\"div_1_11\"]/table[2]");
        WebElement element = driver.findElement(By.name("txtClientMnemonic"));
        element.sendKeys(clientMnemonic);
        setXpath(driver, "(//*[@id=\"btnSubmit\"])[2]");
        setXpath(driver, "//*[@id=\"cmdGetReport\"]");
	}
	private void setXpath(WebDriver driver, String path)
	{
		 driver.findElement(By.xpath(path)).click();
	}
}