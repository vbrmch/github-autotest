import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    WebDriver driver;

    private final By hiding = By.xpath("//h1[@class='d-none d-md-block mt-0 mb-3 text-center h00-mktg lh-condensed-ultra ']");
    private final By userLoginSignUp = By.xpath("//input[@id='user_login']");
    private final By userEmailSignUp = By.xpath("//input[@id='user_email']");
    private final By userPasswordSignUp = By.xpath("//input[@id='user_password']");
    private final By createAccount = By.xpath("//button[@id='signup_button']");
    private final By errorLogin = By.xpath("//dd[text()='Username is not available']");
    private final By errorEmail = By.xpath("//dd[text()='Email is invalid or already taken']");

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public SignUpPage typeUserLoginSignUp(String userName){
        driver.findElement(userLoginSignUp).sendKeys(userName);
        return new SignUpPage(driver);
    }

    public SignUpPage typeUserEmailSignUp(String email){
        driver.findElement(userEmailSignUp).sendKeys(email);
        return new SignUpPage(driver);
    }

    public SignUpPage typeuserPasswordSignUp(String pass){
        driver.findElement(userPasswordSignUp).sendKeys(pass);
        return new SignUpPage(driver);
    }

    public String getHiding(){
        return driver.findElement(hiding).getText();
    }

    public String errLogin(){
         return driver.findElement(errorLogin).getText();
    }

    public String errEmail(){
        return driver.findElement(errorEmail).getText();
    }

    public SignUpPage createAcc (String login,String pass,String email){
        this.typeUserLoginSignUp(login);
        this.typeuserPasswordSignUp(pass);
        this.typeUserEmailSignUp(email);
        driver.findElement(createAccount).click();
        return new SignUpPage(driver);

    }

}
