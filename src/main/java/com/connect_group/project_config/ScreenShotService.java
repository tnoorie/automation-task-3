package com.connect_group.project_config;

import java.io.File;
import java.lang.reflect.Method;
import java.util.function.Supplier;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotService implements BeforeTestExecutionCallback, AfterTestExecutionCallback {

  private final Logger LOGGER = Logger.getLogger(ScreenShotService.class.getSimpleName());

  private final Supplier<WebDriver> driverSupplier;
  private Class testClass;
  private Method testMethod;

  public ScreenShotService(Supplier<WebDriver> driverSupplier) {
    this.driverSupplier = driverSupplier;
  }

  @Override
  public void beforeTestExecution(ExtensionContext context) {
    testClass = context.getRequiredTestClass();
    testMethod = context.getRequiredTestMethod();
  }

  @Override
  public void afterTestExecution(ExtensionContext context) {
    boolean testFailed = context.getExecutionException().isPresent();
    if (testFailed) {
      takeScreenshot("_failure");
    }
  }

  private WebDriver getDriver() {
    return driverSupplier.get();
  }

  public void takeScreenshot(String label) {
    String targetDir = getScreenshotBaseDirForThisTest(label);
    takeFullLengthScreenshot(label, targetDir);
    LOGGER.info("Screenshot taken within - " + targetDir);
  }

  private String getScreenshotBaseDirForThisTest(String label) {
    LOGGER.info("Creating the directory for the screenshot");
    return "target/test-screenshots/" + testClass.getSimpleName() + "/" + testMethod.getName() + label + "/";
  }

  private void takeFullLengthScreenshot(String label, String targetDir) {
    WebDriver driver = getDriver();

    Dimension originalSize = driver.manage().window().getSize();
    try {
      driver.manage().window().setSize(new Dimension(originalSize.getWidth(), 5000));
      String fileName = targetDir + testMethod.getName() + label + ".png";
      File destiny = new File(fileName);
      FileUtils.copyFile(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE), destiny);

    } catch (Exception e) {
      LOGGER.warning("Could not take screenshot: " + label);
    } finally {
      driver.manage().window().setSize(originalSize);
    }
  }
}