import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class saturdayProject12 extends BaseDriver {
    public static void main(String[] args) {

        //Navigate to https://app.hubspot.com/login
        driver.navigate().to("https://app.hubspot.com/login");

        //Enter the user name and password click on login button
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("yakupbulut11@gmail.com");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("1@9814Eyblt");

        WebElement loginButton = driver.findElement(By.id("loginBtn"));
        loginButton.click();

        //Click on Sales
        WebElement sales = driver.findElement(By.id("nav-primary-sales-branch"));
        sales.click();

        //Click on Deals
        WebElement deals = driver.findElement(By.id("nav-secondary-deals"));
        deals.click();

        //Click on Create Deal (Note: After clicking on the Deals in the automation not able to see the table just refresh the browser)
        driver.navigate().refresh();

        //Enter the Deal name
        WebElement deal = driver.findElement(By.cssSelector("button[data-selenium-test='new-object-button']"));
        deal.click();

        WebElement dealName = driver.findElement(By.id("UIFormControl-19"));
        dealName.sendKeys("Group2");

        //Click on sales Pipeline (Verify second page URL is -->
        // https://app.hubspot.com/pricing/7766931/sales?upgradeSource=deals-create-deal-general-create-deal-multiple-pipelines-pql-feature-lock&term=annual&edition=starter )
        WebElement pipeline = driver.findElement(By.xpath("(//span[text()='Sales Pipeline'])[2]"));
        pipeline.click();

        String parentWindow = driver.getWindowHandle();

        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            if (!window.contains(parentWindow)) {
                driver.switchTo().window(window);
                String secondWindow = driver.getCurrentUrl();
                Assert.assertTrue(secondWindow.contains("pricing"));
            }
        }
        driver.close();
        driver.switchTo().window(parentWindow);

        // Choose random from the Deal Stage dropdown-- we couldn't use select
        WebElement dealStageButton = driver.findElement(By.cssSelector("button[objecttype='DEAL']"));
        dealStageButton.click();

        List<WebElement> dealStagelist = driver.findElements(By.cssSelector("button[class='uiTypeaheadResults__item private-typeahead-result-label truncate-text private-button--unstyled']"));
        Random randDealStage = new Random();
        int index = randDealStage.nextInt(dealStagelist.size());
        WebElement clickDealStage = dealStagelist.get(index);
        clickDealStage.click();

        // Choose random from the Deal Type dropdown-- no select class in this dropdown either
        WebElement dealTypeButton = driver.findElement(By.id("uiabstractdropdown-button-37"));
        dealTypeButton.click();

        List<WebElement> dealTypeList = driver.findElements(By.cssSelector("button[class='uiTypeaheadResults__item private-typeahead-result-label truncate-text private-button--unstyled']"));
        Random randDealType = new Random();
        int index2 = randDealType.nextInt(dealTypeList.size());
        WebElement clickDealType = dealTypeList.get(index2);
        clickDealType.click();

        // Click on Create button- need to put dollar amount first
        WebElement dollarAmount = driver.findElement(By.id("UIFormControl-27"));
        dollarAmount.sendKeys("1000");

        WebElement createButton = driver.findElement(By.cssSelector("button[data-selenium-test='base-dialog-confirm-btn']"));
        createButton.click();

        // Click on the pen icon next to dollar amount on the left top
        WebElement pen_icon = driver.findElement(By.cssSelector("span[data-selenium-test='highlight-editor-icon']"));
        pen_icon.click();

        //        Change the name
        WebElement name_input = driver.findElement(By.cssSelector("input[value='Group2']"));
        name_input.clear();
        String new_name = "New Jersey Campus";
        name_input.sendKeys(new_name);

        //        And click on the save
        WebElement save_button = driver.findElement(By.cssSelector("button[data-button-use='tertiary']"));
        save_button.click();


    }
}
