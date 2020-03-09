package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.datamodel.ContactCompanyDATA;
import ru.stqa.pft.addressbook.datamodel.ContactConnectDATA;
import ru.stqa.pft.addressbook.datamodel.ContactPersonalDATA;
import ru.stqa.pft.addressbook.datamodel.Contacts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wb) {
    super(wb);
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void submitFilledContactForm() {

    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void returnToHomepage() {
    click(By.linkText("home page"));
  }

  public void fillContactForm(ContactPersonalDATA contactPersonalDATA, boolean creation) {
    type(By.name("firstname"), contactPersonalDATA.getFirstname());
    type(By.name("middlename"), contactPersonalDATA.getMiddlename());
    type(By.name("lastname"), contactPersonalDATA.getLastname());
    type(By.name("nickname"), contactPersonalDATA.getNick());
    type(By.name("byear"), contactPersonalDATA.getBirthYear());
    type(By.name("notes"), contactPersonalDATA.getNote());

    if (! (contactPersonalDATA.getContactCompanyDATA() == null)) {
      type(By.name("title"), contactPersonalDATA.getContactCompanyDATA().getTitle());
      type(By.name("company"), contactPersonalDATA.getContactCompanyDATA().getCompanyName());
      type(By.name("fax"), contactPersonalDATA.getContactCompanyDATA().getFaxNumber());
    }

    if (! (contactPersonalDATA.getContactConnectDATA() == null)) {
      type(By.name("address"), contactPersonalDATA.getContactConnectDATA().getAddress());
      type(By.name("home"), contactPersonalDATA.getContactConnectDATA().getHomePhone());
      type(By.name("mobile"), contactPersonalDATA.getContactConnectDATA().getMobilePhone());
      type(By.name("work"), contactPersonalDATA.getContactConnectDATA().getWorkPhone());
      type(By.name("email"), contactPersonalDATA.getContactConnectDATA().getEmail_1());
      type(By.name("email2"), contactPersonalDATA.getContactConnectDATA().getEmail_2());
      type(By.name("email3"), contactPersonalDATA.getContactConnectDATA().getEmail_3());
      type(By.name("homepage"), contactPersonalDATA.getContactConnectDATA().getHomepage());
      type(By.name("address2"), contactPersonalDATA.getContactConnectDATA().getAddressSecondary());
      type(By.name("phone2"), contactPersonalDATA.getContactConnectDATA().getPhoneSecondary());
    }

    if (contactPersonalDATA.getBirthDay() != null) {
      chooseFromList(By.name("bday"), contactPersonalDATA.getBirthDay());
    }
    if (contactPersonalDATA.getBirthMonth() != null) {
      chooseFromList(By.name("bmonth"), contactPersonalDATA.getBirthMonth());
    }

    if (creation && contactPersonalDATA.getContactCompanyDATA() != null) {
      new Select(wb.findElement(By.name("new_group"))).selectByVisibleText(contactPersonalDATA.getContactCompanyDATA().getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }

  }

  public void initContactModification() {
    click(By.xpath("//img[@alt='Edit']"));
  }

  public void submitContactModification() {
    click(By.xpath("(//input[@name='update'])[2]"));
  }

  public void deleteSelectedContacts() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void create(ContactPersonalDATA contact) {
    initContactCreation();
    fillContactForm(contact, true);
    submitFilledContactForm();
    contactCache = null;
    returnToHomepage();
  }

  public void modify(ContactPersonalDATA contact) {
    fillContactForm(contact, false);
    submitContactModification();
    contactCache = null;
    returnToHomepage();
  }

  public void delete(ContactPersonalDATA deletedContact) {
    selectById(deletedContact.getId());
    deleteSelectedContacts();
    contactCache = null;
    alertAccept();
  }

  public int getContactCount() {
    return wb.findElements(By.name("selected[]")).size();
  }

  public List<ContactPersonalDATA> list() {
    List<ContactPersonalDATA> contacts = new ArrayList<ContactPersonalDATA>();
    List<WebElement> rows = wb.findElements(By.name("entry"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      String firstname = cells.get(2).getText();
      String lastname = cells.get(1).getText();
      int id = Integer.parseInt(row.findElement(By.tagName("input")).getAttribute("value"));
      ContactPersonalDATA contact = new ContactPersonalDATA().withId(id).withFirstname(firstname).withLastname(lastname);
      contacts.add(contact);
    }
    return contacts;
  }

  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> rows = wb.findElements(By.name("entry"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      String firstname = cells.get(2).getText();
      String lastname = cells.get(1).getText();
      int id = Integer.parseInt(row.findElement(By.tagName("input")).getAttribute("value"));
      ContactPersonalDATA contact = new ContactPersonalDATA().withId(id).withFirstname(firstname).withLastname(lastname);
      contactCache.add(contact);
    }
    return new Contacts(contactCache);
  }
}
