package moventumtests;

import moventumconfig.NewAccountBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

public class NewPersonalAccount extends NewAccountBase
{
    NewPersonalAccount() {
        super();
    }

//    @BeforeTest
//    public void loginPlatform()
//    {
//        super.login();
//    }

    @Test
    public void personalAccount()
    {
        wait("AccountBrowseLink");
        driver.findElement(By.id("AccountBrowseLink")).click();
        driver.findElement(By.id("new_account_item")).click();
        driver.findElement(By.id("new_account_personal_item")).click();

        wait("NewAccountPage1_NewAccountBasicInfo_MoreInfo");

        super.baseInfo();
        super.personalDetails();
        super.fiscalResidence();

        WebElement yes = driver.findElement(By.xpath("//*[@id=\"NewAccountPage1_NewAccountFiscalResidenceGroup_LegalCompliance\"]/div/label[1]/span"));
        yes.click();
        WebElement next = driver.findElement(By.id("NewPersonalAccountViewModel_NewAccountControlsPanelCopy_Next"));
        next.click();

        wait("NewAccountPage2_NewAccountDisbursementAccount_BankName");
        super.disbursementAccount();
        next.click();

        wait("NewAccountPage3_PlaceAndDate");
        super.financialSituation();
        super.investmentObjectives();
        super.communicationMeans();

        WebElement send = driver.findElement(By.id("NewPersonalAccountViewModel_NewAccountControlsPanelCopy_Send"));
        send.click();

        //Then

        String actual =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("window_GenericMessageButton_Window"))).getText();
        Assert.assertNotEquals("Not working", "Account " + NewAccountBase.username + " has been successfully transmitted for FA# %s. Save was successful", actual);
        System.out.println("Not working");
    }

    @AfterTest
    public void closePlatform()
    {
        super.closePage();
    }
}