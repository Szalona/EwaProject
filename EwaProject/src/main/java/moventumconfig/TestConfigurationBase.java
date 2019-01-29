package moventumconfig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class TestConfigurationBase
{
    public WebDriver driver;
    public WebDriverWait wait;

    public TestConfigurationBase() {
        this.driverInit();
        this.waitInit();
    }

    public void wait(String id)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
    }


    public WebElement sendKeysElement(By elementId, String value)
    {
        WebElement element = driver.findElement(elementId);
        element.sendKeys(value);
        return element;
    }

    public WebElement clickElement(By elementId, String xpath)
    {
        WebElement element = driver.findElement(elementId);
        element.click();
        element.findElement(By.xpath(xpath)).click();
        return element;
    }

    private void driverInit()
    {
        if(driver == null){
            System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.get("");
            driver.manage().window().maximize();
        }
    }

    private void waitInit() {
        this.wait = new WebDriverWait(driver, 300);
    }
}
