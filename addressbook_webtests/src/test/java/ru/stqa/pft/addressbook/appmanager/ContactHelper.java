package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.datamodel.ContactPersonalDATA;

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

  public void fillContactForm(ContactPersonalDATA contactPersonalDATA) {
    type(By.name("firstname"), contactPersonalDATA.getFirstname());
    type(By.name("middlename"), contactPersonalDATA.getMiddlename());
    type(By.name("lastname"), contactPersonalDATA.getLastname());
    type(By.name("nickname"), contactPersonalDATA.getNick());
    type(By.name("title"), contactPersonalDATA.getContactCompanyDATA().getTitle());
    type(By.name("company"), contactPersonalDATA.getContactCompanyDATA().getCompanyName());
    type(By.name("address"), contactPersonalDATA.getContactConnectDATA().getAddress());
    type(By.name("home"), contactPersonalDATA.getContactConnectDATA().getHomePhone());
    type(By.name("mobile"), contactPersonalDATA.getContactConnectDATA().getMobilePhone());
    type(By.name("work"), contactPersonalDATA.getContactConnectDATA().getWorkPhone());
    type(By.name("fax"), contactPersonalDATA.getContactCompanyDATA().getFaxNumber());
    type(By.name("email"), contactPersonalDATA.getContactConnectDATA().getEmail_1());
    type(By.name("email2"), contactPersonalDATA.getContactConnectDATA().getEmail_2());
    type(By.name("email3"), contactPersonalDATA.getContactConnectDATA().getEmail_3());
    type(By.name("homepage"), contactPersonalDATA.getContactConnectDATA().getHomepage());

    chooseFromList(By.name("bday"), contactPersonalDATA.getBirthDay());
    chooseFromList(By.name("bmonth"), contactPersonalDATA.getBirthMonth());

    type(By.name("byear"), contactPersonalDATA.getBirthYear());
    type(By.name("address2"), contactPersonalDATA.getContactConnectDATA().getAddressSecondary());
    type(By.name("phone2"), contactPersonalDATA.getContactConnectDATA().getPhoneSecondary());
    type(By.name("notes"), contactPersonalDATA.getNote());
  }

  public void initContactModification() {
    click(By.xpath("//img[@alt='Edit']"));
  }

  public void submitContactModification() {
    click(By.xpath("(//input[@name='update'])[2]"));
  }
}
