package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {
    private WebDriver driver;

    // Constructor
    public InventoryPage (WebDriver driver){
        this.driver=driver;
    }

    //Element Locators
    private static By pageTitleLocator = By.xpath("//div[@class='app_logo']");
    private static By cartIconLocator = By.className("shopping_cart_link");
   //dynamic locator for inventory items

    private static By inventoryItemsLocator(int index){
            return By.xpath("(//div[@class='inventory_item'])["+index+"]'");

}
    //Validation Methods
    public InventoryPage validatePageTitle(String expectedTitle){
        String title = driver.findElement(pageTitleLocator).getText();
        return this;
    }
    public InventoryPage validateCartIconIsDisplayed(){
        boolean isCartIconDisplayed = driver.findElement(cartIconLocator).isDisplayed();
        return this;
    }
    public InventoryPage validateInventoryItemIsDisplayed(int index){
        boolean isInventoryItemDisplayed = driver.findElement(inventoryItemsLocator(index)).isDisplayed();
        return this;
    }
}
