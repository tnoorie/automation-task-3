package com.connect_group.pages.financecalculator;

import com.connect_group.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FilterByPage extends BasePage {

  public FilterByPage(WebDriver driver) {
    super(driver);
  }

  private WebElement getFilterByToggle() {
    return until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".fc-toggle-switch__toggle-switch-icon")));
  }
}