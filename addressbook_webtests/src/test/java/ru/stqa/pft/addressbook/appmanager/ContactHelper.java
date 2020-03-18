package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.datamodel.ContactConnectDATA;
import ru.stqa.pft.addressbook.datamodel.ContactPersonalDATA;
import ru.stqa.pft.addressbook.datamodel.Contacts;

import java.util.ArrayList;
import java.util.List;

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
    attach(By.name("photo"), contactPersonalDATA.getPhoto());

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

  public int count() {
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
      String allPhones = cells.get(5).getText();
      String allEmails = cells.get(4).getText();
      String address = cells.get(3).getText();
    //  String[] phones = cells.get(5).getText().split("\n"); //по переносу строки
      ContactPersonalDATA contact = new ContactPersonalDATA().withId(id).withFirstname(firstname).withLastname(lastname)
              .withContactConnectDATA(new ContactConnectDATA().withAllPhones(allPhones).withAllEmails(allEmails).withAddress(address));
      contactCache.add(contact);
    }
    return new Contacts(contactCache);
  }

  public ContactPersonalDATA infoFromEditForm(ContactPersonalDATA contact) {
    initContactModificationById(contact.getId());
    String firstname = wb.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wb.findElement(By.name("lastname")).getAttribute("value");

    String homePhone = wb.findElement(By.name("home")).getAttribute("value");
    String mobilePhone = wb.findElement(By.name("mobile")).getAttribute("value");
    String workPhone = wb.findElement(By.name("work")).getAttribute("value");
    String secPhone = wb.findElement(By.name("phone2")).getAttribute("value");

    String email_1 = wb.findElement(By.name("email")).getAttribute("value");
    String email_2 = wb.findElement(By.name("email2")).getAttribute("value");
    String email_3 = wb.findElement(By.name("email3")).getAttribute("value");

    String address = wb.findElement(By.name("address")).getAttribute("value");

    wb.navigate().back();
    return new ContactPersonalDATA().withId(contact.getId()).withFirstname(firstname).withLastname(lastname)
            .withContactConnectDATA(new ContactConnectDATA().withHomePhone(homePhone).withMobilePhone(mobilePhone).withWorkPhone(workPhone).withPhoneSecondary(secPhone)
                    .withEmail_1(email_1).withEmail_2(email_2).withEmail_3(email_3)
                    .withAddress(address));
  }

  private void initContactModificationById(int id) {
    wb.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
  }
}
