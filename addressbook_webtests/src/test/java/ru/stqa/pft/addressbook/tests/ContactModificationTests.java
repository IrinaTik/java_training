package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.datamodel.ContactCompanyDATA;
import ru.stqa.pft.addressbook.datamodel.ContactConnectDATA;
import ru.stqa.pft.addressbook.datamodel.ContactPersonalDATA;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homepage();
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactPersonalDATA("1", "2", "3", "qwer", new ContactCompanyDATA("qweh", "qwwerrttty", "notfound", "test1"),
              new ContactConnectDATA("moscow", "12345", "123456789", "hard", "mail1", "mail2", "mail3", "localhost", "address1", "fortress"), "20", "March", "1980", "i am the god"));
    }
  }

  @Test
  public void testContactModification(){
    List<ContactPersonalDATA> before = app.contact().list();
    app.contact().initContactModification();
    ContactPersonalDATA contact = new ContactPersonalDATA(before.get(0).getId(), "4", "6");
    app.contact().modify(contact);

    List<ContactPersonalDATA> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(0);
    before.add(contact);

    Comparator<? super ContactPersonalDATA> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }



}
