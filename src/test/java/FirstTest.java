import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FirstTest {

    public WebDriver driver;

    @Test
    public void myFirstTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\cosku.demirhan\\Desktop\\chromedriver.exe");
        this.driver = new ChromeDriver();

        this.driver.get("http://www.n11.com");

        WebElement signInButton = this.driver.findElement(By.cssSelector("a.btnSignIn"));
        signInButton.click();

        WebElement usernameBox = this.driver.findElement(By.id("email"));
        usernameBox.sendKeys("mukkosokka@deyom.com");

        WebElement passwordBox = this.driver.findElement(By.id("password"));
        passwordBox.sendKeys("Mxqrm123!");

        WebElement signInCButton = this.driver.findElement(By.id("loginButton"));
        signInCButton.click();

        WebElement searchBox = this.driver.findElement(By.id("searchData"));
        searchBox.sendKeys("Samsung");


        WebElement searchButton = this.driver.findElement(By.className("searchBtn"));
        searchButton.click();

        WebElement featuredProduct = this.driver.findElement(By.cssSelector(".catalogView .pro:first-child a"));
        featuredProduct.click();

        Thread.sleep(2000);

        try {
            this.addToCart();
        } catch (NoSuchElementException ex) {
            try {
                WebElement fancybox = this.driver.findElement(By.className("fancybox-close"));
                fancybox.click();
            } catch (NoSuchElementException ex2) {
            }

            this.addToCart();
        }


        //driver.quit();

    }


    private void addToCart() {
        new Select(this.driver.findElement(By.cssSelector("#skuArea select"))).selectByVisibleText("Siyah");

        WebElement instantPay = this.driver.findElement(By.id("instantPay"));
        instantPay.click();

    }
}