package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

  private final Properties properties;
  WebDriver wb;
  private  NavigationHelper navigationHelper;
  private GroupHelper groupHelper;
  private ContactHelper contactHelper;
  private SessionHelper sessionHelper;
  private String browser;
  private DbHelper dbHelper;

  public ApplicationManager(String browser)  {
    this.browser = browser;
    properties = new Properties();
  }

  public void init() throws IOException {
    String target = System.getProperty("target", "local");
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

    dbHelper = new DbHelper();

    if ("".equals(properties.getProperty("selenium.server"))) {
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
    } else {
      DesiredCapabilities capabilities = new DesiredCapabilities();
      capabilities.setBrowserName(browser);
      wb = new RemoteWebDriver(new URL(properties.getProperty("selenium.server")), capabilities);
    }

    wb.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    wb.get(properties.getProperty("web.baseURL"));
    groupHelper = new GroupHelper(wb);
    contactHelper = new ContactHelper(wb);
    navigationHelper = new NavigationHelper(wb);
    sessionHelper = new SessionHelper(wb);
    sessionHelper.login(properties.getProperty("web.adminLogin"), properties.getProperty("web.adminPassword"));

  }

  public void stop() {
    sessionHelper.logout();
    wb.quit();
  }

  public GroupHelper group() {
    return groupHelper;
  }

  public ContactHelper contact() {
    return contactHelper;
  }

  public NavigationHelper goTo() {
    return navigationHelper;
  }

  public DbHelper db() {
    return dbHelper;
  }
}
