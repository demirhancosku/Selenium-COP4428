import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertTrue;

public class FirstTest {

    private WebDriver driver;
    private String searchKey = "Samsung";


    @Test
    public void shouldLogin(){

        WebElement signInButton = this.driver.findElement(By.cssSelector("a.btnSignIn"));
        signInButton.click();

        WebElement usernameBox = this.driver.findElement(By.id("email"));
        usernameBox.sendKeys("cosku@dokuziki.com");

        WebElement passwordBox = this.driver.findElement(By.id("password"));
        passwordBox.sendKeys("Mxqrm123!");

        WebElement signInCButton = this.driver.findElement(By.id("loginButton"));
        signInCButton.click();

        String username = this.driver.findElement(By.className("username")).getText();

        assertThat("When a buyyer logged in",username,equalTo("Coşku Demirhan"));

    }


    @Test
    public void sholdSearch(){

        WebElement searchBox = this.driver.findElement(By.id("searchData"));
        searchBox.sendKeys(searchKey);


        WebElement searchButton = this.driver.findElement(By.className("searchBtn"));
        searchButton.click();

        String searchResultBreadCrumb = this.driver.findElement(By.id("breadCrumb")).getText();

        //hamcrest assertion
        assertThat("When a buyyer search for a key",searchResultBreadCrumb,containsString(searchKey));

    }


    @Test
    public void sholdAddToFavorite(){

        WebElement favoriteButton = this.driver.findElement(By.cssSelector("#view li .textImg.followBtn"));
        favoriteButton.click();
        String buttonClasses = favoriteButton.getAttribute("class");

        //junit assertion
        assertTrue("When a buyyer click add to favorites", buttonClasses.contains("ok"));

    }


    @Test
    public void TestAddFavorite() {
        System.setProperty("webdriver.chrome.driver", "/Users/coskudemirhan/Google Drive/chromedriver");

        this.driver = new ChromeDriver();
        this.driver.get("http://www.n11.com");

        this.shouldLogin();
        this.sholdSearch();
        this.sholdAddToFavorite();
    }

}