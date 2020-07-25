
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By userNameLoginPage = (By.xpath("//input[@id='login_field']"));
    private final By passwordLoginPage = (By.xpath("//input[@id='password']"));
    private final By submitLoginPage = (By.xpath("//input[@class='btn btn-primary btn-block']"));
    private final By heading = (By.xpath("//div/h1"));
    private final By erroe = (By.xpath("//div[@class='container-lg px-2']"));
    private final By createAccLink = (By.xpath("//a[@data-ga-click='Sign in, switch to sign up']"));

public  LoginPage typeUserName(String userName){
    driver.findElement(userNameLoginPage).sendKeys(userName);
    return new LoginPage(driver);
}

    public  LoginPage typePassword(String password){
        driver.findElement(passwordLoginPage).sendKeys(password);
        return new LoginPage(driver);
    }

    public  LoginPage loginWithInvalidData(String username,String pass){
this.typeUserName(username);
this.typePassword(pass);
driver.findElement(submitLoginPage).click();
return new LoginPage(driver);
    }

    public String getHidingText(){
return driver.findElement(heading).getText();
    }

public String getErrorText(){
    return driver.findElement(erroe).getText();
}

    public SignUpPage createAccount(){
        driver.findElement(createAccLink).click();
        return new SignUpPage(driver);
    }


}
