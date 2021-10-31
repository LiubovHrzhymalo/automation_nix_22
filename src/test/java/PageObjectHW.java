import Locators.MainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;
public class PageObjectHW {
    WebDriver driver;
    MainPage mainPage;
    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

        mainPage=new MainPage(driver);
    }
    @AfterEach
    public void  tearDown(){
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.close();
    }
    @Test
    public void findByIdTest()  {
        mainPage.openShutterstock();
        mainPage.fieldLogin.sendKeys("test123456");
        mainPage.fieldPassword.sendKeys("test123456");
        System.out.println("Test findByIdTest :The test finds the required ID fields and enters information into them");
    }
    @Test
    public void findByTagNameTest()  {
        mainPage.openAkniga();
        System.out.println("Count frame : " +  mainPage.listFrame.size());
        System.out.println("Test findByTagNameTest: The test finds the required frame tag and counts the number of items");

    }

    @Test
    public void findByLinkTest()  {
        mainPage.openShutterstockZaretsky();
        mainPage.wait.until(ExpectedConditions.elementToBeClickable(mainPage.buttonNext));
        mainPage.buttonNext.click();
        System.out.println("Test findByLinkText: The test finds the necessary" +
                " link for the \"Далее\" button, clicks on the button and goes to the next page");
    }
    @Test
    public void findByCssSelectorTest()  {
        mainPage.openAkniga();
        mainPage.wait.until(ExpectedConditions.visibilityOf(mainPage.svgPicture));
        System.out.println("Test findByCssSelectorTest: The test finds a code element" +
                " according to the given css selectors path");
    }
    @Test
    public void findCssSelectorChildElementTest()  {
        mainPage.openAkniga();
        mainPage.wait.until(ExpectedConditions.elementToBeClickable(mainPage.buttonLink));
        mainPage.buttonLink.click();
        System.out.println("Test findByCssSelectorTest: The test finds a code element" +
                " according to the given css selectors path");
    }
    @Test
    public void findByXpathTest() {
        mainPage.openAkniga();
        System.out.println("Count Span : " + mainPage.listSpan.size());
        System.out.println("Test findByXpathTest: " +
                "The test finds the required elements tag and counts the number of items");
    }
    @Test
    public void findByXpathAttributeTest()  {
        mainPage.openShutterstockZaretskyIMG();
        mainPage.wait.until(ExpectedConditions.visibilityOf(mainPage.searchByAttribute));
        System.out.println("Test findByXpathAttributeTest: The test finds the required alt attribute Image");
    }
    @Test
    public void findByXpathTextTest() {
        mainPage.openShutterstockZaretskyIMG();
        mainPage.wait.until(ExpectedConditions.textToBePresentInElement(mainPage.searchByText,"Информация"));
        mainPage.searchByText.click();
        System.out.println("Test findByXpathTextTest: The test found the 'Information' button and opened the page");
    }
}
