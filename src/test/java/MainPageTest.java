import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MainPageTest {
    private ChromeDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vadim\\IdeaProjects\\autotest\\drivers\\chromedriver8_3.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/");
        mainPage = new MainPage(driver);

    }

    @Test
    public void signIn() {
        LoginPage loginPage = mainPage.clickSignIn();
        String heading = loginPage.getHidingText();
        Assert.assertEquals("Sign in to GitHub", heading);
    }

    @Test
    public void clickRegisterButton() {
        SignUpPage signUpPage = mainPage.register("awddwad", "uiiwue@gmail.com", "12345213Qadwlk");
        String head = signUpPage.getHiding();
        Assert.assertEquals("Create your account", head);
    }


    @Test
    public void invalidLogin() {
        mainPage.register("awd", "awd", "M8exJj8UGfU7J48");
        SignUpPage signUpPage = new SignUpPage(driver);
        String line1 = signUpPage.errLogin();
        Assert.assertEquals("Username is not available", line1);
    }

    @Test
    public void invalidEmail() {
        mainPage.register("awd", "awd", "M8exJj8UGfU7J48");
        SignUpPage signUpPage = new SignUpPage(driver);
        String line2 = signUpPage.errEmail();
        Assert.assertEquals("Email is invalid or already taken", line2);
    }

    //M8exJj8UGfU7J48
    // Username is not available
    // Email is invalid or already taken


    @After
    public void tearDown() {
        driver.quit();
    }

}
