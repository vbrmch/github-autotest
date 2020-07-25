import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginPageTest {

    private ChromeDriver driver;
    private MainPage mainPage;


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vadim\\IdeaProjects\\autotest\\drivers\\chromedriver8_3.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/login");
        LoginPage loginPage = new LoginPage(driver);
    }





    @After
    public void tearDown() {
        driver.quit();
    }



}
