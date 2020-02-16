package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase{

  public NavigationHelper(WebDriver wb) {

    super(wb);
  }

  public void gotoGroupPage() {

    click(By.linkText("groups"));
  }

  public void gotoHomepage() {
    click(By.linkText("home"));
  }

  public void returnToGroupPage() {

    click(By.linkText("group page"));
  }

  public void returnToHomepage() {

    click(By.linkText("home page"));
  }

}
