import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class FirstTest {

    public WebDriver driver;


    @Test
    public void shouldLogin() throws InterruptedException {
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

        String username = this.driver.findElement(By.className("username")).getText();

        assertThat("When a buyyer logged in",username,equalTo("Test Mock"));

    }


    @Test
    public void sholdSearch() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\cosku.demirhan\\Desktop\\chromedriver.exe");

        this.driver = new ChromeDriver();
        this.driver.get("http://www.n11.com");

        WebElement searchBox = this.driver.findElement(By.id("searchData"));
        searchBox.sendKeys("Samsung");


        WebElement searchButton = this.driver.findElement(By.className("searchBtn"));
        searchButton.click();

        String searchResultBreadCrumb = this.driver.findElement(By.id("breadCrumb")).getText();

        assertThat("When a buyyer search for a key",searchResultBreadCrumb,containsString("Samsung"));

    }

}