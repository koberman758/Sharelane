import jdk.jfr.StackTrace;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class SignUpTest {

    /*
    0. Открыть браузер
    1. Переходим на страницу https://www.sharelane.com/cgi-bin/register.py
    2. Вводим в поле Zip Code 11111
    3. Нажимаем на Continue
    4. Убеждаемся, что перед нами форма регистрации
    5. Закрыть браузер
     */
    //<input type="submit" value="Continue">
    //input[value=Continue]

    @Test
    public void zipCode5Digits(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");//выставление системной переменной
        WebDriver driver = new ChromeDriver();  //0. Открыть браузер
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.sharelane.com/cgi-bin/register.py"); //шаг1
        driver.findElement(By.name("zip_code")).sendKeys("11111");
        driver.findElement(By.cssSelector("input[value=Continue]")).click();
        boolean isSignUpPageOpened = driver.findElement(By.cssSelector("input[value=Register]")).isDisplayed();
        assertTrue(isSignUpPageOpened, "страница регистрации не открылась");
        driver.quit(); //5
    }

    @Test
    public void zipCode4Digits(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");//выставление системной переменной
        WebDriver driver = new ChromeDriver();  //0. Открыть браузер
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("1111");
        driver.findElement(By.cssSelector("input[value=Continue]")).click();
        String actualError = driver.findElement(By.cssSelector("span[class=error_message]")).getText();
        assertEquals(actualError, "Oops, error on page. ZIP code should have 5 digits",
                "wrong error message show");
        driver.quit();
    }

    @Test
    public void zipCode6Digits(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");//выставление системной переменной
        WebDriver driver = new ChromeDriver();  //0. Открыть браузер
        driver.get("https://www.sharelane.com/cgi-bin/register.py"); //шаг1
        driver.findElement(By.name("zip_code")).sendKeys("111111");
        driver.findElement(By.cssSelector("input[value=Continue]")).click();
        String actualError = driver.findElement(By.cssSelector("span[class=error_message]")).getText();
        assertEquals(actualError, "Oops, error on page. ZIP code should have 5p  digits",
                "wrong error message show");
        driver.quit();
    }

    @Test
    public void successfulSignUp(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");//выставление системной переменной
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=21333");
        driver.findElement(By.name("first_name")).sendKeys("Name");
        driver.findElement(By.name("last_name")).sendKeys("lName");
        driver.findElement(By.name("email")).sendKeys("nik@yandex.ru");
        driver.findElement(By.name("password1")).sendKeys("123456");
        driver.findElement(By.name("password2")).sendKeys("123456");
        driver.findElement(By.cssSelector("input[value=Register]")).click();
        String actualError = driver.findElement(By.cssSelector("span[class=confirmation_message]")).getText();
        assertEquals(actualError, "Account is created!",
                "user was not register");
        driver.quit();
    }


    @Test
    public void unSuccessfulSignUp(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");//выставление системной переменной
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=21333");
        driver.findElement(By.name("first_name")).sendKeys("Name");
        driver.findElement(By.name("last_name")).sendKeys("lName");
        driver.findElement(By.name("email")).sendKeys("testtest.ru");
        driver.findElement(By.name("password1")).sendKeys("123456");
        driver.findElement(By.name("password2")).sendKeys("123456");
        driver.findElement(By.cssSelector("input[value=Register]")).click();
        String actualError = driver.findElement(By.cssSelector("span[class=error_message]")).getText();
        assertEquals(actualError, "Oops, error on page. Some of your fields have invalid data or email " +
                        "was previously used", "wrong error message show");
        driver.quit();
    }

}
