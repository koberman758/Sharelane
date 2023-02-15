import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NegativeTestsForZipCodeAndSignUp {
    @Test
    public void zipCode4Digits(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
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
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py"); //шаг1
        driver.findElement(By.name("zip_code")).sendKeys("111111");
        driver.findElement(By.cssSelector("input[value=Continue]")).click();
        String actualError = driver.findElement(By.cssSelector("span[class=error_message]")).getText();
        assertEquals(actualError, "Oops, error on page. ZIP code should have 5  digits",
                "wrong error message show");
        driver.quit();
    }

    @Test
    public void zipCode0Digits(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("");
        driver.findElement(By.cssSelector("input[value=Continue]")).click();
        String actualError = driver.findElement(By.cssSelector("span[class=error_message]")).getText();
        assertEquals(actualError, "Oops, error on page. ZIP code should have 5 digits",
                "wrong error message show");
        driver.quit();
    }

    @Test
    public void zipCodeLetters(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");//выставление системной переменной
        WebDriver driver = new ChromeDriver();  //0. Открыть браузер
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("qwerty");
        driver.findElement(By.cssSelector("input[value=Continue]")).click();
        String actualError = driver.findElement(By.cssSelector("span[class=error_message]")).getText();
        assertEquals(actualError, "Oops, error on page. ZIP code should have 5 digits",
                "wrong error message show");
        driver.quit();
    }

    @Test
    public void zipCodeSymbols(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");//выставление системной переменной
        WebDriver driver = new ChromeDriver();  //0. Открыть браузер
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("@!&*()");
        driver.findElement(By.cssSelector("input[value=Continue]")).click();
        String actualError = driver.findElement(By.cssSelector("span[class=error_message]")).getText();
        assertEquals(actualError, "Oops, error on page. ZIP code should have 5 digits",
                "wrong error message show");
        driver.quit();
    }

    @Test
    public void FirstNameEmpty(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name("first_name")).sendKeys("");
        driver.findElement(By.name("last_name")).sendKeys("Last");
        driver.findElement(By.name("email")).sendKeys("test@test.ru");
        driver.findElement(By.name("password1")).sendKeys("123456");
        driver.findElement(By.name("password2")).sendKeys("123456");
        driver.findElement(By.cssSelector("input[value=Register]")).click();
        String actualError = driver.findElement(By.cssSelector("span[class=error_message]")).getText();
        assertEquals(actualError, "Oops, error on page. Some of your fields have invalid data or email was " +
                "previously used", "wrong error message show");
        driver.quit();
    }

    @Test
    public void FirstNameLettersSymbols(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name("first_name")).sendKeys("Name@$%");
        driver.findElement(By.name("last_name")).sendKeys("Last");
        driver.findElement(By.name("email")).sendKeys("test@test.ru");
        driver.findElement(By.name("password1")).sendKeys("123456");
        driver.findElement(By.name("password2")).sendKeys("123456");
        driver.findElement(By.cssSelector("input[value=Register]")).click();
        String actualError = driver.findElement(By.cssSelector("span[class=error_message]")).getText();
        assertEquals(actualError, "Oops, error on page. Some of your fields have invalid data or email was " +
                "previously used", "wrong error message show");
        driver.quit();
    }

    @Test
    public void FirstNameSymbols(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name("first_name")).sendKeys("@$%!&");
        driver.findElement(By.name("last_name")).sendKeys("Last");
        driver.findElement(By.name("email")).sendKeys("test@test.ru");
        driver.findElement(By.name("password1")).sendKeys("123456");
        driver.findElement(By.name("password2")).sendKeys("123456");
        driver.findElement(By.cssSelector("input[value=Register]")).click();
        String actualError = driver.findElement(By.cssSelector("span[class=error_message]")).getText();
        assertEquals(actualError, "Oops, error on page. Some of your fields have invalid data or email was " +
                "previously used", "wrong error message show");
        driver.quit();
    }

    @Test
    public void FirstNameNumbers(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name("first_name")).sendKeys("1234");
        driver.findElement(By.name("last_name")).sendKeys("Last");
        driver.findElement(By.name("email")).sendKeys("test@test.ru");
        driver.findElement(By.name("password1")).sendKeys("123456");
        driver.findElement(By.name("password2")).sendKeys("123456");
        driver.findElement(By.cssSelector("input[value=Register]")).click();
        String actualError = driver.findElement(By.cssSelector("span[class=error_message]")).getText();
        assertEquals(actualError, "Oops, error on page. Some of your fields have invalid data or email was " +
                "previously used", "wrong error message show");
        driver.quit();
    }

    @Test
    public void LastNameSymbols(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name("first_name")).sendKeys("Name");
        driver.findElement(By.name("last_name")).sendKeys("@@@@");
        driver.findElement(By.name("email")).sendKeys("test@test.ru");
        driver.findElement(By.name("password1")).sendKeys("123456");
        driver.findElement(By.name("password2")).sendKeys("123456");
        driver.findElement(By.cssSelector("input[value=Register]")).click();
        String actualError = driver.findElement(By.cssSelector("span[class=error_message]")).getText();
        assertEquals(actualError, "Oops, error on page. Some of your fields have invalid data or email was " +
                "previously used", "wrong error message show");
        driver.quit();
    }

    @Test
    public void LastNameNumbers(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name("first_name")).sendKeys("Name");
        driver.findElement(By.name("last_name")).sendKeys("12345");
        driver.findElement(By.name("email")).sendKeys("test@test.test");
        driver.findElement(By.name("password1")).sendKeys("123456");
        driver.findElement(By.name("password2")).sendKeys("123456");
        driver.findElement(By.cssSelector("input[value=Register]")).click();
        String actualError = driver.findElement(By.cssSelector("span[class=error_message]")).getText();
        assertEquals(actualError, "Oops, error on page. Some of your fields have invalid data or email was " +
                "previously used", "wrong error message show");
        driver.quit();
    }

    @Test
    public void DoubleAtForEmail(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name("first_name")).sendKeys("Name");
        driver.findElement(By.name("last_name")).sendKeys("Last");
        driver.findElement(By.name("email")).sendKeys("test@@test.test");
        driver.findElement(By.name("password1")).sendKeys("123456");
        driver.findElement(By.name("password2")).sendKeys("123456");
        driver.findElement(By.cssSelector("input[value=Register]")).click();
        String actualError = driver.findElement(By.cssSelector("span[class=error_message]")).getText();
        assertEquals(actualError, "Oops, error on page. Some of your fields have invalid data or email was " +
                "previously used", "wrong error message show");
        driver.quit();
    }

    @Test
    public void NoDomainForEmail(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name("first_name")).sendKeys("Name");
        driver.findElement(By.name("last_name")).sendKeys("Last");
        driver.findElement(By.name("email")).sendKeys("test@test.");
        driver.findElement(By.name("password1")).sendKeys("123456");
        driver.findElement(By.name("password2")).sendKeys("123456");
        driver.findElement(By.cssSelector("input[value=Register]")).click();
        String actualError = driver.findElement(By.cssSelector("span[class=error_message]")).getText();
        assertEquals(actualError, "Oops, error on page. Some of your fields have invalid data or email was " +
                "previously used", "wrong error message show");
        driver.quit();
    }

    @Test
    public void ForbiddenCharactersForEmail(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name("first_name")).sendKeys("Name");
        driver.findElement(By.name("last_name")).sendKeys("Last");
        driver.findElement(By.name("email")).sendKeys("test!@test.test");
        driver.findElement(By.name("password1")).sendKeys("123456");
        driver.findElement(By.name("password2")).sendKeys("123456");
        driver.findElement(By.cssSelector("input[value=Register]")).click();
        String actualError = driver.findElement(By.cssSelector("span[class=error_message]")).getText();
        assertEquals(actualError, "Oops, error on page. Some of your fields have invalid data or email was " +
                "previously used", "wrong error message show");
        driver.quit();
    }

    @Test
    public void EmptyEmail(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name("first_name")).sendKeys("Name");
        driver.findElement(By.name("last_name")).sendKeys("Last");
        driver.findElement(By.name("email")).sendKeys("");
        driver.findElement(By.name("password1")).sendKeys("123456");
        driver.findElement(By.name("password2")).sendKeys("123456");
        driver.findElement(By.cssSelector("input[value=Register]")).click();
        String actualError = driver.findElement(By.cssSelector("span[class=error_message]")).getText();
        assertEquals(actualError, "Oops, error on page. Some of your fields have invalid data or email was " +
                "previously used", "wrong error message show");
        driver.quit();
    }

    @Test
    public void EmptyPassword(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name("first_name")).sendKeys("Name");
        driver.findElement(By.name("last_name")).sendKeys("Last");
        driver.findElement(By.name("email")).sendKeys("test@test.test");
        driver.findElement(By.name("password1")).sendKeys("");
        driver.findElement(By.name("password2")).sendKeys("123456");
        driver.findElement(By.cssSelector("input[value=Register]")).click();
        String actualError = driver.findElement(By.cssSelector("span[class=error_message]")).getText();
        assertEquals(actualError, "Oops, error on page. Some of your fields have invalid data or email was " +
                "previously used", "wrong error message show");
        driver.quit();
    }

    @Test
    public void ShortPassword(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name("first_name")).sendKeys("Name");
        driver.findElement(By.name("last_name")).sendKeys("Last");
        driver.findElement(By.name("email")).sendKeys("test@test.test");
        driver.findElement(By.name("password1")).sendKeys("123");
        driver.findElement(By.name("password2")).sendKeys("123");
        driver.findElement(By.cssSelector("input[value=Register]")).click();
        String actualError = driver.findElement(By.cssSelector("span[class=error_message]")).getText();
        assertEquals(actualError, "Oops, error on page. Some of your fields have invalid data or email was " +
                "previously used", "wrong error message show");
        driver.quit();
    }

    @Test
    public void EmptyConfirmPassword(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name("first_name")).sendKeys("Name");
        driver.findElement(By.name("last_name")).sendKeys("Last");
        driver.findElement(By.name("email")).sendKeys("test@test.test");
        driver.findElement(By.name("password1")).sendKeys("123456");
        driver.findElement(By.name("password2")).sendKeys("");
        driver.findElement(By.cssSelector("input[value=Register]")).click();
        String actualError = driver.findElement(By.cssSelector("span[class=error_message]")).getText();
        assertEquals(actualError, "Oops, error on page. Some of your fields have invalid data or email was " +
                "previously used", "wrong error message show");
        driver.quit();
    }

    @Test
    public void MismatchConfirmPassword(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name("first_name")).sendKeys("Name");
        driver.findElement(By.name("last_name")).sendKeys("Last");
        driver.findElement(By.name("email")).sendKeys("test@test.test");
        driver.findElement(By.name("password1")).sendKeys("123456");
        driver.findElement(By.name("password2")).sendKeys("12345");
        driver.findElement(By.cssSelector("input[value=Register]")).click();
        String actualError = driver.findElement(By.cssSelector("span[class=error_message]")).getText();
        assertEquals(actualError, "Oops, error on page. Some of your fields have invalid data or email was " +
                "previously used", "wrong error message show");
        driver.quit();
    }

}
