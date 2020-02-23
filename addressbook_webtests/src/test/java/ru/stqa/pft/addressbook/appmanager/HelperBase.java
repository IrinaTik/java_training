package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

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
    if (text != null) {
      String existingText = wb.findElement(locator).getAttribute("value");
      if (! text.equals(existingText)) {
        wb.findElement(locator).clear();
        wb.findElement(locator).sendKeys(text);
      }
    }
  }

  public boolean isAlertPresent() {
    try {
      wb.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public void chooseFromList(By locator,  String text) {
    click(locator);
    new Select(wb.findElement(locator)).selectByVisibleText(text);
    click(By.xpath("//option[@value='" + text + "']"));
  }

  public void alertAccept() {
    wb.switchTo().alert().accept();
  }

  public void select() {
    click(By.name("selected[]"));
  }

  protected boolean isElementPresent(By locator) {
    try {
      wb.findElement(locator);
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }

  }

  public boolean isThereAThing() {
    return isElementPresent(By.name("selected[]"));
  }
}
