package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.datamodel.ContactCompanyDATA;
import ru.stqa.pft.addressbook.datamodel.ContactConnectDATA;
import ru.stqa.pft.addressbook.datamodel.ContactPersonalDATA;

import java.util.List;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification(){
    app.getNavigationHelper().gotoHomepage();
    if (! app.getContactHelper().isThereAThing()) {
      app.getContactHelper().createContact(new ContactPersonalDATA("1", "2", "3", "qwer", new ContactCompanyDATA("qweh", "qwwerrttty", "notfound", "test1"),
              new ContactConnectDATA("moscow", "12345", "123456789", "hard", "mail1", "mail2", "mail3", "localhost", "address1", "fortress"), "20", "March", "1980", "i am the god"));
    }
    List<ContactPersonalDATA> before = app.getContactHelper().getContactList();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactPersonalDATA("4", "5", "6", "wasd", new ContactCompanyDATA("qweh", "qwwerrttty", "notfound", null),
            new ContactConnectDATA("moscow", "12345", "123456789", "hard", "mail1", "mail2", "mail3", "localhost", "address1", "fortress"), "1", "March", "1980", "i am the new god"), false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomepage();

    List<ContactPersonalDATA> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());
  }

}
