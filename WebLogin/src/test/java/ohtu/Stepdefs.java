package ohtu;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import ohtu.UserDaoForTests;
import ohtu.authentication.AuthenticationService;
import ohtu.data_access.UserDao;
import ohtu.domain.User;

public class Stepdefs {
    //WebDriver driver = new ChromeDriver();
    WebDriver driver = new HtmlUnitDriver();
    String baseUrl = "http://localhost:4567";
    UserDao userDao;
    AuthenticationService auth;


    @Before
    public void setup() {
        userDao = new UserDaoForTests();
        auth = new AuthenticationService(userDao);
    }

    
    @Given("login is selected")
    public void loginIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click();   
    }    
    
    @When("correct username {string} and password {string} are given")
    public void correctUsernameAndPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }    
    
    @Then("user is logged in")
    public void userIsLoggedIn() {
        pageHasContent("Ohtu Application main page");
    }    
 
    @When("correct username {string} and incorrect password {string} are given")
    public void correctUsernameAndIncorrectPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }    
    
    @Then("user is not logged in and error message is given")
    public void userIsNotLoggedInAndErrorMessageIsGiven() {
        pageHasContent("invalid username or password");
        pageHasContent("Give your credentials to login");
    }    

    @When("nonexisting username {string} and password {string} are given")
    public void nonExistingUsernameAndPasswordAreGiven(String username, String password) throws Throwable {
        logInWith(username, password);
    }   

    @When("username {string} and password {string} are given")
    public void usernameAndPasswordAreGiven(String username, String password) throws Throwable {
        logInWith(username, password);
    }   
    
    @Then("system will respond {string}")
    public void systemWillRespond(String pageContent) throws Throwable {
        assertTrue(driver.getPageSource().contains(pageContent));
    }


    @Given("command new user is selected")
    public void newUserIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));       
        element.click();   
    }    


    @When("a valid username {string} and password {string} and matching password confirmation are entered")
    public void validUserIsCreated(String username, String password) throws Throwable{
        registerWith(username, password, password);
    }

    @When("an invalid username {string} and a valid password {string} and matching password confirmation are entered")
    public void invalidUserIsNotCreated(String username, String password) throws Throwable{
        registerWith(username, password, password);
    }

    @When("a valid username {string} and an invalid password {string} and matching password confirmation are entered")
    public void validUserWithInvalidPasswordIsNotCreated(String username, String password) throws Throwable{
        registerWith(username, password, password);
    }

    @When("a valid username {string} and password {string} and non matching password {string} confirmation are entered")
    public void validUserWithNonmatchingPasswordIsNotCreated(String username, String password, String confirmation) throws Throwable{
        registerWith(username, password, confirmation);
    }

    @Given("user with username {string} with password {string} is successfully created")
    public void userCreated(String username, String password) throws Throwable{
        userDao.add(new User(username, password));
    }

    @Given("user with username {string} and password {string} is tried to be created")
    public void userNotCreated(String username, String password) throws Throwable{
//        registerWith(username, password, password);
    }
    @Given ("user returns from registration form")
    public void userReturnsFromRegistrationForm(){
        WebElement element = driver.findElement(By.linkText("back to home"));       
        element.click();   
    }

    @Given ("newly registered user continues to application mainpage")
    public void continueToApplicationMainPage(){
        WebElement element = driver.findElement(By.linkText("continue to application mainpage"));       
        element.click();   

    }
    @Then ("user is logged out")
    public void userLogout(){
        WebElement element = driver.findElement(By.linkText("logout"));       
        element.click();   
    }
        @Then ("logout")   
    public void logout(){
        WebElement element = driver.findElement(By.linkText("logout"));       
        element.click();   
    }


    @Then("a new user is created")
    public void aNewUserIsCreated() {
        pageHasContent("Welcome to Ohtu Application!");
    }    

    @Then("user is not created and error {string} is reported")
    public void userIsNotCreatedAndAnErrorIsReported(String error) {
        pageHasContent("Create username and give password");
        pageHasContent(error);
    }    

    
    @After
    public void tearDown(){
        driver.quit();
    }
        
    /* helper methods */
 
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }
        
    private void logInWith(String username, String password) {
        assertTrue(driver.getPageSource().contains("Give your credentials to login"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();  
    } 

    private void registerWith(String username, String password, String confirmation){
        assertTrue(driver.getPageSource().contains("Create username and give password"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(confirmation);
        element = driver.findElement(By.name("signup"));
        element.submit();  
    }
}
