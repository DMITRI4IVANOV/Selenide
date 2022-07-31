import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CallbackTest {
    private WebDriver driver;
    @BeforeAll
    public static void setUpAll (){
        System.setProperty("webdriver.chrome.driver","./driver/win/chromedriver.exe");
    }
    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
    }
//    @BeforeAll
//    static void setUpAll() {
//        WebDriverManager.chromedriver().setup();
//    }

//    @BeforeEach
//    void setUp() {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-dev-shm-usage");
//        options.addArguments("--no-sandbox");
//        options.addArguments("--headless");
//        driver = new ChromeDriver(options);
//    }


    @AfterEach
    public void tearDown() {
        driver.quit();
        driver = null;
    }
//    @Test
//    public void shouldSendForm(){
//        driver.get("http://localhost:9999/");
//        List<WebElement> textFields = driver.findElements(By.className("input__control"));
//        textFields.get(0).sendKeys("Прунь Дмитрий");
//        textFields.get(1).sendKeys("+79272079668");
//        driver.findElement(By.className("checkbox__box")).click();
//        driver.findElement(By.tagName("button")).click();
//        String actualText = driver.findElement(By.className("paragraph")).getText().trim();
//        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
//        assertEquals(expected, actualText);
//    }
    @Test
//    cssSelector
    void shouldTestData() {
        driver.get("http://localhost:9999/");
        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Макаров Виктор");
        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+79272079600");
        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
        driver.findElement(By.cssSelector("button")).click();
        String actualText = driver.findElement(By.cssSelector(".paragraph")).getText().trim();
        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        assertEquals(expected, actualText);
    }
}
