package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static java.lang.Thread.sleep;

public class SearchProductPage {
    private WebDriver driver;
    private By searchBox = By.xpath("//*[@id=\"sfx-discovery-search-suggestions\"]/div/div/div/input");
    private By clickSearchBtn = By.xpath("//*[@id=\"sfx-discovery-search-suggestions\"]/div/div/div/i");
    private By clickSuggested = By.xpath("//*[@id=\"search-app\"]/div/div[1]/div[2]/div[1]/div[2]/select");

    private By clickfreeCargo = By.xpath("//*[@id=\"sticky\"]/div/div[10]/div[1]/a");

    private By  productNameLocator= By.xpath("//*[@id=\"search-app\"]/div/div[1]/div[2]/div[5]/div[1]/div/div");

    private By  clickAddProduct= By.xpath("//*[@id=\"product-detail-app\"]/div/div[2]/div[1]/div[2]/div[2]/div[5]/button");
    public SearchProductPage(WebDriver driver){ this.driver = driver; }

    //aranılacak değer girişi
    public void setSearch(String search){
        driver.findElement(searchBox).sendKeys(search);
    }

    //arama merceğine tıkla
    public void clickIcon(){
        driver.findElement(clickSearchBtn).click(); }

    //ücretsiz kargoyu işaretle
    public void freeCargo(){
        driver.findElement(clickfreeCargo).click(); }

    //En çok değerlendirilen ürünü seç
    public void Dropdown() {
        Select Sugggested = new Select(driver.findElement(clickSuggested));
        Sugggested.selectByVisibleText("En Çok Değerlendirilenler"); }

    //Ürünleri listele ve ilk ürünü seç
    public List<WebElement> findAll(By locator){
        return driver.findElements(locator);
    }
    private List<WebElement> getAllProducts(){
        return findAll(productNameLocator);
    }

    public void selectProduct(int i) {
        getAllProducts().get(i).click();
    }

    //ürünü sepete ekle
    public void addProduct(){

        driver.findElement(clickAddProduct).click();
        }


}
