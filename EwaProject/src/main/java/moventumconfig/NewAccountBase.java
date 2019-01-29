package moventumconfig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;

public class NewAccountBase extends TestConfigurationBase {
    public static String username =  "";
    public static String password = ""

    @BeforeTest
    public void loginPlatform()
    {
        login();
    }

    public void login()
    {
        By usernameInput = By.id("Login_UserName");
        By passwordInput = By.id("Login_Password");

        sendKeysElement("Login_UserName", username);
        sendKeysElement("Login_Password", password);
        driver.findElement(By.id("Login_Submit")).click();
    }

    public void baseInfo()
    {
        clickElement("NewAccountPage1_NewAccountBasicInfo_MoventumAccountType", "option[10]");

        wait("NewAccountPage1_NewAccountBasicInfo_ServiceFee");
        clickElement("NewAccountPage1_NewAccountBasicInfo_ServiceFee", "option[6]");

        sendKeysElement("NewAccountPage1_NewAccountBasicInfo_AccountName", "Szalony");

        wait("NewAccountPage1_NewAccountBasicInfo_Currency");
        clickElement("NewAccountPage1_NewAccountBasicInfo_Currency", "option[2]");

        wait("NewAccountPage1_NewAccountBasicInfo_MoreInfo");
        WebElement moreinfo = driver.findElement(By.id("NewAccountPage1_NewAccountBasicInfo_MoreInfo"));
        moreinfo.click();

        wait("DiscountViewModel_Discount");
        clickElement("DiscountViewModel_Discount", "option[5]");

        WebElement okbutton = driver.findElement(By.id("DiscountViewModel_OkButton"));
        okbutton.click();
    }

    public void disbursementAccount()
    {
        sendKeysElement("NewAccountPage2_NewAccountDisbursementAccount_Name", "Szalone");

        clickElement("NewAccountPage2_NewAccountDisbursementAccount_Country", "option[171]");

        sendKeysElement("NewAccountPage2_NewAccountDisbursementAccount_Number", "6639821234");

        WebElement verifyIBAN = driver.findElement(By.id("NewAccountPage2_NewAccountDisbursementAccount_VerifyIban"));
        verifyIBAN.click();

        sendKeysElement("NewAccountPage2_NewAccountDisbursementAccount_SwiftCode", "6639821234");

        WebElement researchTool = driver.findElement(By.id("NewAccountPage2_NewAccountDisbursementAccount_ResearchTool"));
        researchTool.click();

        sendKeysElement("NewAccountPage2_NewAccountDisbursementAccount_BankName", "Szalony");
    }

    public void financialSituation()
    {
        clickElement("NewAccountPage3_DisposableNetAssets", "option[4]");

        clickElement("NewAccountPage3_MainIncomeDerivesFrom", "option[4]");
    }

    public void fiscalResidence()
    {
        clickElement("NewAccountPage1_NewAccountFiscalResidenceGroup_Country_FiscalResidenceFirst", "option[176]");

        sendKeysElement("NewAccountPage1_NewAccountFiscalResidenceGroup_TaxIdentificationNumber_FiscalResidenceFirst", "663123654");
    }

    public void personalDetails()
    {
        clickElement("NewAccountPage1_NewAccountPersonalDetails_Title", "option[4]");

        sendKeysElement("NewAccountPage1_NewAccountPersonalDetails_FirstName", "Szalony");

        sendKeysElement("NewAccountPage1_NewAccountPersonalDetails_LastName", "Szalony");

        sendKeysElement("NewAccountPage1_NewAccountPersonalDetails_StreetName", "Szaleństwo");

        sendKeysElement("NewAccountPage1_NewAccountPersonalDetails_StreetNumber", "30");

        sendKeysElement("NewAccountPage1_NewAccountPersonalDetails_PostalCode", "24-087");

        sendKeysElement("NewAccountPage1_NewAccountPersonalDetails_City", "Szaleństwo");

        clickElement("NewAccountPage1_NewAccountPersonalDetails_Country", "option[176]");

        sendKeysElement("NewAccountPage1_NewAccountPersonalDetails_DateOfBirth", "20.04.1987");

        sendKeysElement("NewAccountPage1_NewAccountPersonalDetails_CityOfBirth", "Szaleństwo");

        clickElement("NewAccountPage1_NewAccountPersonalDetails_CountryOfBirth", "option[176]");

        clickElement("NewAccountPage1_NewAccountPersonalDetails_Nationality", "option[169]");

        clickElement("NewAccountPage1_NewAccountPersonalDetails_MaritalStatus", "option[3]");

        clickElement("NewAccountPage1_NewAccountPersonalDetails_EmploymentStatus", "option[2]");

        clickElement("NewAccountPage1_NewAccountPersonalDetails_Occupation", "option[33]");

        sendKeysElement("NewAccountPage1_NewAccountPersonalDetails_NameOfEmployer", "Szalony");
    }

    public void investmentObjectives()
    {
        WebElement conservative = driver.findElement(By.xpath("//*[@id=\"NewAccountPage3_InvestmentObjectives\"]/div/label[1]/span"));
        conservative.click();

        WebElement act = driver.findElement(By.xpath("//*[@id=\"NewPersonalAccountViewModel\"]/div[3]/div/div/div[3]/div/div/div[19]/div/label/span"));
        act.click();
    }

    public void communicationMeans()
    {
        WebElement sca = driver.findElement(By.xpath("//*[@id=\"NewPersonalAccountViewModel\"]/div[3]/div/div/div[3]/div/div/div[21]/div/label/span"));
        sca.click();

        sendKeysElement("NewAccountPage3_PlaceAndDate", "Szalony");
    }

    public void closePage()
    {
        driver.quit();
    }
}
