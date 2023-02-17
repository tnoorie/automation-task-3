package com.connect_group.pages.helloworld;

import com.connect_group.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReceiptPage extends BasePage {

  @FindBy(tagName = "h1")
  private WebElement header;

  public ReceiptPage(WebDriver driver) {
    super(driver);
  }

  public boolean isInitialized() {
    return header.isDisplayed();
  }

  public String confirmationHeader() {
    return header.getText();
  }
}