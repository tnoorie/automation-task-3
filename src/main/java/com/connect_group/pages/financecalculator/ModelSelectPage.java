package com.connect_group.pages.financecalculator;

import com.connect_group.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ModelSelectPage extends BasePage {

  public ModelSelectPage(WebDriver driver) {
    super(driver);
  }

  private WebElement getModelSelectNameplateContainer() {
    return until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".fc-nameplates__nameplateContainer")));
  }

  public List<WebElement> getAllNameplates() {
    return until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".fc-nameplates__nameplateContainer .fc-cta__cta--size-primary")));
  }

  public boolean isInitialized() {
    return getModelSelectNameplateContainer().isDisplayed();
  }

  // TODO: Add methods in to support interacting with the model selection page
  //public int numberOfVehicles(){return getAllNameplates().size();}

  public List<WebElement> getAllModels(){
    return until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("fc-nameplate__title")));
  }
}