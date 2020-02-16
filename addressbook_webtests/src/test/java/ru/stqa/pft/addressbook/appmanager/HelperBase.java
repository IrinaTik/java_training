package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class HelperBase {
  protected WebDriver wb;

  public HelperBase(WebDriver wb) {
    this.wb = wb;
  }

  protected void click(By locator) {
    wb.findElement(locator).click();
  }

  protected void type(By locator, String text) {
    click(locator);
    wb.findElement(locator).clear();
    wb.findElement(locator).sendKeys(text);
  }
  public boolean isAlertPresent() {
    try {
      wb.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
}
