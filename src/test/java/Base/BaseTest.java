package Base;

import Pages.HomepagePage;
import Pages.SidebarPage;
import Pages.TextBoxPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    public WebDriver driver;
    public HomepagePage homepagePage;
    public SidebarPage sidebarPage;
    public TextBoxPage textBoxPage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        homepagePage = new HomepagePage(driver);
        sidebarPage = new SidebarPage(driver);
        textBoxPage = new TextBoxPage(driver);

    }
}
