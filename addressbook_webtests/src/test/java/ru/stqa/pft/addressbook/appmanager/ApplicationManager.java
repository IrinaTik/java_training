package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

  WebDriver wb;
  private  NavigationHelper navigationHelper;
  private GroupHelper groupHelper;
  private SessionHelper sessionHelper;

  public void init() {
    System.setProperty("webdriver.gecko.driver", "utils/geckodriver.exe");
    wb = new FirefoxDriver();
    wb.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wb.get("http://localhost/addressbook/group.php");
    groupHelper = new GroupHelper(wb);
    navigationHelper = new NavigationHelper(wb);
    sessionHelper = new SessionHelper(wb);
    sessionHelper.login("admin", "secret");
  }

  public void stop() {
    sessionHelper.logout();
    wb.quit();
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }
}
