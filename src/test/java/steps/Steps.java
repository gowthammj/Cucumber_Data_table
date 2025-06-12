package steps;


import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import pages.LoginPage;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Steps {

        WebDriver driver;
        LoginPage loginPage;

        @Given("user is on login page")
        public void user_is_on_login_page() {
            driver = new EdgeDriver();
            driver.get("https://magento.softwaretestingboard.com/customer/account/login/");
            driver.manage().window().maximize();
            loginPage = new LoginPage(driver);
        }

        @When("user enters credentials")
        public void user_enters_credentials(DataTable dataTable) {
            List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
            String Email = data.get(0).get("Email");
            String Password = data.get(0).get("Password");

            loginPage.enterUsername(Email);
            loginPage.enterPassword(Password);
            loginPage.clickLogin();
        }

        @Then("user should be navigated to the home page")
        public void user_should_be_navigated_to_the_home_page() throws InterruptedException, IOException {
            String title=driver.getTitle();
            System.out.println("Current page title is : "+title);

            Thread.sleep(3000);
            TakesScreenshot success_screenshot=(TakesScreenshot)driver;
            File source=success_screenshot.getScreenshotAs(OutputType.FILE);
            File Target=new File("C:\\Users\\gowth\\IdeaProjects\\cucumber_dataTable_Project\\target\\screenshots\\page.png");
            FileUtils.copyFile(source, Target);

            driver.close();
        }
    }



