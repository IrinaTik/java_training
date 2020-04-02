package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

  private final Properties properties;
  WebDriver wb;

  private String browser;


  public ApplicationManager(String browser)  {
    this.browser = browser;
    properties = new Properties();
  }

  public void init() throws IOException {
    String target = System.getProperty("target", "local");
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

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

    wb.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    wb.get(properties.getProperty("web.baseURL"));
   }

  public void stop() {
    wb.quit();
  }
}
