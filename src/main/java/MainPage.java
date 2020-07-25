import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //PageFactoryModel
//    @FindBy(xpath = "//a[@class='HeaderMenu-link no-underline mr-3']")
//    private WebElement signInButon;
//
//    @FindBy(xpath = "//a[@class='HeaderMenu-link d-inline-block no-underline border border-gray-dark rounded-1 px-2 py-1']")
//    private WebElement signUpButon;
//
//    @FindBy(xpath = "//input[@id='user[login]']")
//    private WebElement userInput;
//
//    @FindBy(xpath = "//input[@id='user[email]']")
//    private WebElement emailInput;
//
//    @FindBy(xpath = "//input[@id='user[password]']")
//    private WebElement passwordInput;
//
//    @FindBy(xpath = "//button[@class='btn-mktg btn-primary-mktg btn-large-mktg f4 btn-block my-3']")
//    private WebElement getSignUpButon;

    private By signInButon = By.xpath("//a[@class='HeaderMenu-link no-underline mr-3']");
    private By signUpButon = By.xpath("//a[@class='HeaderMenu-link d-inline-block no-underline border border-gray-dark rounded-1 px-2 py-1']");
    private By userInput = By.xpath("//input[@id='user[login]']");
    private By emailInput = By.xpath("//input[@id='user[email]']");
    private By passwordInput = By.xpath("//input[@id='user[password]']");
    private By getSignUpButon = By.xpath("//button[@class='btn-mktg btn-primary-mktg btn-large-mktg f4 btn-block my-3']");

    public LoginPage clickSignIn() {
       driver.findElement(signInButon).click();
        return new LoginPage(driver);
    }

    public SignUpPage clickRegister() {
        driver.findElement(getSignUpButon) .click();
        return new SignUpPage(driver);
    }

    public SignUpPage linkSignUpButon() {
        driver.findElement(signUpButon) .click();
        return new SignUpPage(driver);
    }

    public MainPage typeUserName(String username) {
        driver.findElement(userInput) .sendKeys(username);
        return this;
    }

    public MainPage typePassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
        return this;
    }

    public MainPage typeEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
        return this;
    }


    public SignUpPage register(String userName, String email, String pass) {

        this.typeUserName(userName);
        this.typeEmail(email);
        this.typePassword(pass);
        this.clickRegister();
        return new SignUpPage(driver);
    }

}
