package moventumtests;

import moventumconfig.NewAccountBase;
import moventumconfig.UserModel;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTest extends NewAccountBase {

    @Test
    public void correctLogin() {

        UserModel user = new UserModel();

        user.setUsername("delta");
        user.user


        {
            sendKeysElement("Login_UserName", username);
            sendKeysElement("Login_Password", password);
            driver.findElement(By.id("Login_Submit")).click();
        }

        assertEquals

    }
}


