package ru.stqa.pft.addressbook;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactCreationTests {
  private WebDriver wb;

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    System.setProperty("webdriver.gecko.driver", "utils/geckodriver.exe");
    wb = new FirefoxDriver();
    wb.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wb.get("http://localhost/addressbook/");
    login("admin", "secret");
  }

  private void login(String username, String password) {
    wb.findElement(By.name("user")).clear();
    wb.findElement(By.name("user")).sendKeys(username);
    wb.findElement(By.name("pass")).clear();
    wb.findElement(By.name("pass")).sendKeys(password);
    wb.findElement(By.xpath("//input[@value='Login']")).click();
  }

  @Test
  public void testContactCreationTests() throws Exception {

    initContactCreation();
    fillContactForm(new ContactPersonalDATA("1", "2", "3", "qwer", new ContactCompanyDATA("qweh", "qwwerrttty", "notfound"), new ContactConnectDATA("moscow", "12345", "123456789", "hard", "mail1", "mail2", "mail3", "localhost", "address1", "fortress"), "20", "March", "1980", "i am the god"));
    submitFilledContactForm();
    returnToHomepage();
  }

  private void logout() {
    wb.findElement(By.linkText("Logout")).click();
  }

  private void returnToHomepage() {
    wb.findElement(By.linkText("home page")).click();
  }

  private void submitFilledContactForm() {
    wb.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
  }

  private void fillContactForm(ContactPersonalDATA contactPersonalDATA) {
    wb.findElement(By.name("firstname")).click();
    wb.findElement(By.name("firstname")).clear();
    wb.findElement(By.name("firstname")).sendKeys(contactPersonalDATA.getFirstname());
    wb.findElement(By.name("middlename")).clear();
    wb.findElement(By.name("middlename")).sendKeys(contactPersonalDATA.getMiddlename());
    wb.findElement(By.name("lastname")).clear();
    wb.findElement(By.name("lastname")).sendKeys(contactPersonalDATA.getLastname());
    wb.findElement(By.name("nickname")).clear();
    wb.findElement(By.name("nickname")).sendKeys(contactPersonalDATA.getNick());
    wb.findElement(By.name("title")).click();
    wb.findElement(By.name("title")).clear();
    wb.findElement(By.name("title")).sendKeys(contactPersonalDATA.getContactCompanyDATA().getTitle());
    wb.findElement(By.name("company")).click();
    wb.findElement(By.name("company")).clear();
    wb.findElement(By.name("company")).sendKeys(contactPersonalDATA.getContactCompanyDATA().getCompanyName());
    wb.findElement(By.name("address")).click();
    wb.findElement(By.name("address")).clear();
    wb.findElement(By.name("address")).sendKeys(contactPersonalDATA.getContactConnectDATA().getAddress());
    wb.findElement(By.name("home")).click();
    wb.findElement(By.name("home")).clear();
    wb.findElement(By.name("home")).sendKeys(contactPersonalDATA.getContactConnectDATA().getHomePhone());
    wb.findElement(By.name("mobile")).click();
    wb.findElement(By.name("mobile")).clear();
    wb.findElement(By.name("mobile")).sendKeys(contactPersonalDATA.getContactConnectDATA().getMobilePhone());
    wb.findElement(By.name("work")).click();
    wb.findElement(By.name("work")).clear();
    wb.findElement(By.name("work")).sendKeys(contactPersonalDATA.getContactConnectDATA().getWorkPhone());
    wb.findElement(By.name("fax")).click();
    wb.findElement(By.name("fax")).clear();
    wb.findElement(By.name("fax")).sendKeys(contactPersonalDATA.getContactCompanyDATA().getFaxNumber());
    wb.findElement(By.name("email")).click();
    wb.findElement(By.name("email")).clear();
    wb.findElement(By.name("email")).sendKeys(contactPersonalDATA.getContactConnectDATA().getEmail_1());
    wb.findElement(By.name("email2")).clear();
    wb.findElement(By.name("email2")).sendKeys(contactPersonalDATA.getContactConnectDATA().getEmail_2());
    wb.findElement(By.name("email3")).clear();
    wb.findElement(By.name("email3")).sendKeys(contactPersonalDATA.getContactConnectDATA().getEmail_3());
    wb.findElement(By.name("homepage")).click();
    wb.findElement(By.name("homepage")).clear();
    wb.findElement(By.name("homepage")).sendKeys(contactPersonalDATA.getContactConnectDATA().getHomepage());
    wb.findElement(By.name("bday")).click();
    new Select(wb.findElement(By.name("bday"))).selectByVisibleText(contactPersonalDATA.getBirthDay());
    wb.findElement(By.xpath("//option[@value='" + contactPersonalDATA.getBirthDay() + "']")).click();
    wb.findElement(By.name("bmonth")).click();
    new Select(wb.findElement(By.name("bmonth"))).selectByVisibleText(contactPersonalDATA.getBirthMonth());
    wb.findElement(By.xpath("//option[@value='" + contactPersonalDATA.getBirthMonth() + "']")).click();
    wb.findElement(By.name("byear")).click();
    wb.findElement(By.name("byear")).clear();
    wb.findElement(By.name("byear")).sendKeys(contactPersonalDATA.getBirthYear());
    wb.findElement(By.name("address2")).click();
    wb.findElement(By.name("address2")).clear();
    wb.findElement(By.name("address2")).sendKeys(contactPersonalDATA.getContactConnectDATA().getAddressSecondary());
    wb.findElement(By.name("phone2")).click();
    wb.findElement(By.name("phone2")).clear();
    wb.findElement(By.name("phone2")).sendKeys(contactPersonalDATA.getContactConnectDATA().getPhoneSecondary());
    wb.findElement(By.name("notes")).click();
    wb.findElement(By.name("notes")).clear();
    wb.findElement(By.name("notes")).sendKeys(contactPersonalDATA.getNote());
  }

  private void initContactCreation() {
    wb.findElement(By.linkText("add new")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    logout();
    wb.quit();
  }

  private boolean isElementPresent(By by) {
    try {
      wb.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      wb.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

}
