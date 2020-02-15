package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.datamodel.GroupData;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  public WebDriver wb;

  public void init() {
    System.setProperty("webdriver.gecko.driver", "utils/geckodriver.exe");
    wb = new FirefoxDriver();
    wb.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wb.get("http://localhost/addressbook/group.php");
    login("admin", "secret");
  }

  public void login(String username, String password) {
    wb.findElement(By.name("user")).clear();
    wb.findElement(By.name("user")).sendKeys(username);
    wb.findElement(By.name("pass")).clear();
    wb.findElement(By.name("pass")).sendKeys(password);
    wb.findElement(By.xpath("//input[@value='Login']")).click();
  }

  public void logout() {
    wb.findElement(By.linkText("Logout")).click();
  }

  public void returnToGroupPage() {
    wb.findElement(By.linkText("group page")).click();
  }

  public void submitCreation() {
    wb.findElement(By.name("submit")).click();
  }

  public void fillGroupForm(GroupData groupData) {
    wb.findElement(By.name("group_name")).click();
    wb.findElement(By.name("group_name")).clear();
    wb.findElement(By.name("group_name")).sendKeys(groupData.getName());
    wb.findElement(By.name("group_header")).clear();
    wb.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
    wb.findElement(By.name("group_footer")).clear();
    wb.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
  }

  public void initGroupCreation() {
    wb.findElement(By.name("new")).click();
  }

  public void gotoGroupPage() {
    wb.findElement(By.linkText("groups")).click();
  }

  public void stop() {
    logout();
    wb.quit();
  }

  public boolean isElementPresent(By by) {
    try {
      wb.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
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

  public void deleteSelectedGroups() {
    wb.findElement(By.name("delete")).click();
  }

  public void selectGroup() {
    wb.findElement(By.name("selected[]")).click();
  }
}
