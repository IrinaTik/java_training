package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.datamodel.ContactCompanyDATA;
import ru.stqa.pft.addressbook.datamodel.ContactConnectDATA;
import ru.stqa.pft.addressbook.datamodel.ContactPersonalDATA;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification(){
    app.getNavigationHelper().gotoHomepage();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactPersonalDATA("4", "5", "6", "wasd", new ContactCompanyDATA("qweh", "qwwerrttty", "notfound", null),
            new ContactConnectDATA("moscow", "12345", "123456789", "hard", "mail1", "mail2", "mail3", "localhost", "address1", "fortress"), "1", "March", "1980", "i am the new god"), false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomepage();
  }

}
