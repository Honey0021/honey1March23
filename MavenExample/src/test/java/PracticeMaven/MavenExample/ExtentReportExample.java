package PracticeMaven.MavenExample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportExample {

	ExtentReports extent;
	@BeforeMethod
	public void beforeConfig() {
		
		//ExtentSparkReporter ,ExtentReports
		
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("WebAutomation Results");
		reporter.config().setDocumentTitle("Results title");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		
	}
	
	@Test
	public void InitialDemo()
	{
		extent.createTest("intial demo");
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\ChromeDriver.exe");
		WebDriver driver=new ChromeDriver();
		String url = "https://rahulshettyacademy.com/#/index";
		driver.get(url);
		driver.close();
		extent.flush();
	}
}
