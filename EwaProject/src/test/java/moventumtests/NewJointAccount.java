package moventumtests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewJointAccount extends NewPersonalAccount
{
    NewJointAccount() {
        super();
    }

//    @BeforeTest
//    public void loginPlatform()
//    {
//        super.login();
//    }

    @Test
    public void GivenLoginModel_WhenLoginIsSubmitted_ThenShowSuccessMessage()
    {
        wait("IndexLink");

        driver.findElement(By.id("AccountBrowseLink")).click();
        driver.findElement(By.id("new_account_item")).click();
        driver.findElement(By.id("new_account_joint_item")).click();

        wait("NewAccountPage1_NewAccountBasicInfo_MoreInfo");

        super.baseInfo();
        super.personalDetails();
        super.fiscalResidence();

        WebElement yes = driver.findElement(By.xpath("//*[@id=\"NewAccountPage1_NewAccountFiscalResidenceGroup_LegalCompliance\"]/div/label[1]/span"));
        yes.click();

        WebElement next = driver.findElement(By.id("NewPersonalAccountViewModel_NewAccountControlsPanelCopy_Next"));
        next.click();
    }

    @AfterTest
    public void quitPlatform()
    {
        super.closePage();
    }
}
