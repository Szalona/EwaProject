package onwelo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Sale
{

    public static final int MILLIS = 500;

    @Test (priority = 3)
    public void sale () throws InterruptedException {
        WebDriver driver;

        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.get("https://ontalent-tst.onwelo.com/auth/realms/master/protocol/openid-connect/auth?client_id=ontalent&redirect_uri=https%3A%2F%2Fontalent-tst.onwelo.com%2F&state=6dabd4e4-848f-414e-829f-71726a178ab6&nonce=cc7e8f4d-c8b7-43da-8029-7ba197b474e7&response_mode=fragment&response_type=code&scope=openid");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 30);

        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        username.sendKeys("ewa.tusinska@onwelo.com");

        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        password.sendKeys("Syriuszka18");

        WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("login")));
        submit.click();

        By platformLogo = By.xpath("//div[@class='logo']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(platformLogo));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(platformLogo));

        WebElement sales = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Sales']")));
        sales.click();

        WebElement recentlyvisitedclient = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Recently visited clients']")));
        recentlyvisitedclient.click();

        WebElement newclient = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"new-client\"]/md-icon")));
        newclient.click();

        Thread.sleep(MILLIS);

        WebElement fullname = driver.findElement(By.name("name"));
        fullname.sendKeys("HuekHuek_HuekHuek_HuekHuek_HuekHuek_HuekHuek");

        WebElement shortname = driver.findElement(By.name("shortName"));
        shortname.sendKeys("HH_HH_HH_HH_HH");

        WebElement region = driver.findElement(By.name("region"));
        region.click();
        driver.findElement(By.xpath("//md-option[@value='ER']")).click();

        WebElement industry = driver.findElement(By.name("industry"));
        industry.click();
        driver.findElement(By.xpath("//md-option[@value='SRV']")).click();

        WebElement accountmanager = driver.findElement(By.cssSelector("[ng-model=\"vm.model.accountManager\"] input"));
        accountmanager.sendKeys("Ewa Testowa");

      //  WebElement save = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Save']")));
     //   save.click();

    }
}
