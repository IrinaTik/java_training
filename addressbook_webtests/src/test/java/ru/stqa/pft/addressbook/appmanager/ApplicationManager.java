package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

  WebDriver wb;
  private  NavigationHelper navigationHelper;
  private GroupHelper groupHelper;
  private ContactHelper contactHelper;
  private SessionHelper sessionHelper;
  private String browser;

  public ApplicationManager(String browser) {
    this.browser = browser;
  }

  public void init() {

    if (Objects.equals(browser, BrowserType.FIREFOX)) {
      System.setProperty("webdriver.gecko.driver", "D:\\JAVAtools\\geckodriver.exe");
      wb = new FirefoxDriver();
    } else if (Objects.equals(browser, BrowserType.CHROME)) {
      System.setProperty("webdriver.chrome.driver", "D:\\JAVAtools\\chromedriver.exe");
      wb = new ChromeDriver();
    } else if (Objects.equals(browser, BrowserType.IE)) {
      System.setProperty("webdriver.ie.driver", "D:\\JAVAtools\\IEDriverServer.exe");
      wb = new InternetExplorerDriver();
    }

    wb.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    wb.get("http://localhost/addressbook/group.php");
    groupHelper = new GroupHelper(wb);
    contactHelper = new ContactHelper(wb);
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

  public ContactHelper getContactHelper() {
    return contactHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }
}
