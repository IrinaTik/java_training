package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.datamodel.ContactCompanyDATA;
import ru.stqa.pft.addressbook.datamodel.ContactConnectDATA;
import ru.stqa.pft.addressbook.datamodel.ContactPersonalDATA;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactPersonalDATA("1", "2", "3", "qwer", new ContactCompanyDATA("qweh", "qwwerrttty", "notfound", "test1"),
            new ContactConnectDATA("moscow", "12345", "123456789", "hard", "mail1", "mail2", "mail3", "localhost", "address1", "fortress"), "20", "March", "1980", "i am the god"), true);
    app.getContactHelper().submitFilledContactForm();
    app.getNavigationHelper().returnToHomepage();
  }


}
