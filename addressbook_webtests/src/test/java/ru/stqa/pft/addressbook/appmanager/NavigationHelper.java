package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class NavigationHelper extends HelperBase{

  public NavigationHelper(WebDriver wb) {

    super(wb);
  }

  public void groupPage() {
    if (isElementPresent(By.tagName("h1"))
            && wb.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPresent(By.name("new"))) {
      return;
    }
    click(By.linkText("groups"));
  }

  public void homepage() {
    if (isElementPresent(By.id("maintable"))) {
      return;
    }
    click(By.linkText("home"));
    new Select(wb.findElement(By.name("group"))).selectByVisibleText("[all]");
  }


}
