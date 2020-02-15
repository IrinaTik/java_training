package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Morkan on 15.02.2020.
 */
public class NavigationHelper {
  private WebDriver wb;

  public NavigationHelper(WebDriver wb) {
    this.wb = wb;
  }

  public void gotoGroupPage() {
    wb.findElement(By.linkText("groups")).click();
  }
}
