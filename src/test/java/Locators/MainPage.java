package Locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MainPage {
    private  WebDriver driver;

    public WebDriverWait wait;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait=new WebDriverWait(this.driver,15);
        PageFactory.initElements(driver,this);
    }
    @FindBy(id="login-username")
    public WebElement fieldLogin;

    @FindBy(id="login-password")
    public WebElement fieldPassword;

    @FindBy(tagName="iframe")
    public List<WebElement> listFrame;

    @FindBy(partialLinkText="Далее")
    public WebElement buttonNext;

    @FindBy(id="a-logo")
    public WebElement svgPicture;

    @FindBy(xpath="/html/body/main/div[2]/div[3]/a[3]")
    public WebElement buttonLink;

    @FindBy(xpath="//span")
    public List<WebElement> listSpan;

    @FindBy(xpath="//*[@id=\"content\"]/div[2]/div/div[2]/div[2]/main/div/div[2]/div[2]/section/div/div[2]/div/div[2]/div/a/img")
    public WebElement searchByAttribute;

    @FindBy(xpath = "//*[text()='Информация']")
    public WebElement searchByText;

    public void openShutterstock(){

        driver.get("https://contributor-accounts.shutterstock.com/");
    }
    public void openAkniga(){

        driver.get("https://akniga.org/");
    }
    public void openShutterstockZaretsky(){

        driver.get("https://www.shutterstock.com/g/Zaretsky?rid=181467612");
    }
    public void openShutterstockZaretskyIMG(){

        driver.get("https://www.shutterstock.com/g/Zaretsky");
    }
}
