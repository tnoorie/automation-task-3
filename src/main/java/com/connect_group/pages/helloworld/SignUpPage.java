package com.connect_group.pages.helloworld;

import com.connect_group.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpPage extends BasePage {

  private WebElement getFirstName() {
    return getDriver().findElement(By.id("firstname"));
  }

  private WebElement getLastName() {
    return getDriver().findElement(By.id("lastname"));
  }

  private WebElement getAddress() {
    return getDriver().findElement(By.id("address"));
  }

  private WebElement getZipCode() {
    return getDriver().findElement(By.id("zipcode"));
  }

  private WebElement getSubmitButton() {
    return getDriver().findElement(By.id("signup"));
  }

  public SignUpPage(WebDriver driver) {
    super(driver);
  }

  public boolean isInitialized() {
    return getFirstName().isDisplayed();
  }

  public void enterName(String firstName, String lastName) {
    getFirstName().clear();
    getFirstName().sendKeys(firstName);

    getLastName().clear();
    getLastName().sendKeys(lastName);
  }

  public void enterAddress(String address, String zipCode) {
    getAddress().clear();
    getAddress().sendKeys(address);

    getZipCode().clear();
    getZipCode().sendKeys(zipCode);
  }

  public ReceiptPage submit() {
    getSubmitButton().click();
    return new ReceiptPage(driver);
  }
}