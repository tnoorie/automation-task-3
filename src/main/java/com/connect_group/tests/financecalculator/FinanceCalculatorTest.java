package com.connect_group.tests.financecalculator;

import com.connect_group.pages.financecalculator.FilterByPage;
import com.connect_group.pages.financecalculator.ModelSelectPage;
import com.connect_group.pages.financecalculator.PersonalisedQuotePage;
import com.connect_group.tests.helloworld.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FinanceCalculatorTest extends BaseTest {

  private ModelSelectPage modelSelectPage;
  private FilterByPage filterByPage;
  private PersonalisedQuotePage personalisedQuotePage;

  @BeforeEach
  void setupAndNavigateToUrl() {
    modelSelectPage = new ModelSelectPage(driver);
    filterByPage = new FilterByPage(driver);
    personalisedQuotePage = new PersonalisedQuotePage(driver);

    open("https://www.landrover.co.uk/offers-and-finance/finance-calculator.html");
   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   driver.findElement(By.id("truste-consent-button")).click();
    driver.findElement(By.id("psyma_close_link_container_text")).click();


  }

  @Test
  void ensureModelSelectPageIsPresent() {
    assertTrue(modelSelectPage.isInitialized());
  }

  // TODO: Complete the each of the tests under the "Tasks to Complete" section of the README.md
  @Test
  void task1Test(){
    assertEquals(6,modelSelectPage.getAllModels().size());
    screenShotService.takeScreenshot("_success");
  }

  @Test
  void task3Test(){
    driver.findElement(By.xpath("//div[@id='model-select-render']//div[1]//div[1]//div[1]//a[1]//span[1]//div[1]")).click();
    assertTrue(driver.getPageSource().contains("PERSONALISE QUOTE"));
    driver.findElement(By.xpath("//span[normalize-space()='Change Vehicle']")).click();
    assertEquals("https://www.landrover.co.uk/offers-and-finance/finance-calculator.html#/models",driver.getCurrentUrl());

  }
  @Test
  void task4Test(){
    driver.findElement(By.xpath("//div[@id='model-select-render']//div[1]//div[1]//div[1]//a[1]//span[1]//div[1]")).click();
    assertTrue(driver.getPageSource().contains("PERSONALISE QUOTE"));
    WebElement button = driver.findElement(By.id("dropdown__button-engines"));
    button.click();
    WebElement we = new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='dropdown__button-engines']")));
    By pathOfSelection = By.xpath("//a[normalize-space()='D350 AWD AUTOMATIC MHEV']"); // if you need to select options other than Google, you can change the text to any of the options.
    WebElement option = null;
    try {
      option = we.findElement(pathOfSelection);
    } catch(NoSuchElementException e){
      System.out.println("No such option. " + e.getMessage());
      throw e;
    }
    option.click();

  }


}