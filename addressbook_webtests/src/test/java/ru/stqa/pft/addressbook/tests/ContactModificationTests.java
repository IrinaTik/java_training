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
      app.contact().create(new ContactPersonalDATA().withFirstname("1").withMiddlename("2").withLastname("3").withNick("qwer")
              .withContactCompanyDATA(new ContactCompanyDATA().withTitle("qweh").withCompanyName("qwerrrrrrty").withFaxNumber("notfound").withGroup("test1"))
              .withContactConnectDATA(new ContactConnectDATA().withAddress("moscow").withHomePhone("12345").withMobilePhone("123456789").withWorkPhone("hard")
                      .withEmail_1("mail1").withEmail_2("mail2").withEmail_3("mail3").withHomepage("localhost").withAddress("address1").withAddressSecondary("fortress").withPhoneSecondary("123"))
              .withBirthDay("20").withBirthMonth("March").withBirthYear("1980").withNote("i am the god"));
    }
  }

  @Test
  public void testContactModification(){
    List<ContactPersonalDATA> before = app.contact().list();
    app.contact().initContactModification();
    ContactPersonalDATA contact = new ContactPersonalDATA().withId(before.get(0).getId()).withFirstname("4").withLastname("6");
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
