package cz.profinit.sep.civka6;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.vaadin.testbench.By;
import com.vaadin.testbench.ScreenshotOnFailureRule;
import com.vaadin.testbench.TestBench;
import com.vaadin.testbench.TestBenchTestCase;

public class MyAppUITests extends TestBenchTestCase {
	private String baseUrl;

	@Rule
	public ScreenshotOnFailureRule screenshotOnFailureRule = new ScreenshotOnFailureRule(this, true);

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\keschaf\\cvika6\\sep.civka6\\misc\\chromedriver.exe");
		setDriver(TestBench.createDriver(new ChromeDriver(DesiredCapabilities.chrome())));
		baseUrl = "http://localhost:8080/";
	}

    @Test
    public void basic() throws Exception {
        driver.get(baseUrl);
        
        // Click the button
        WebElement element = findElement(By.xpath("//*[@id=\"ROOT-2521314\"]/div/div[2]/div[1]/div/div[3]/table/tbody/tr[2]"));
        element.click();

        // Check that the label text is correct
        WebElement textField = findElement(By.xpath("//*[@id=\"ROOT-2521314\"]/div/div[2]/div[3]/div/div[3]/input"));
        Assert.assertEquals("IbanZdroj2", textField.getAttribute("value"));
    }
	
}
