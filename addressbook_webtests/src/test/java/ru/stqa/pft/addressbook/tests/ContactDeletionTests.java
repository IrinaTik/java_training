package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.datamodel.ContactPersonalDATA;
import ru.stqa.pft.addressbook.datamodel.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homepage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactPersonalDATA().withFirstname("1").withMiddlename("2").withLastname("3").withNick("qwer")
              .withTitle("qweh").withCompanyName("qwerrrrrrty").withFaxNumber("notfound")
              .withAddress("moscow").withHomePhone("12345").withMobilePhone("123456789").withWorkPhone("hard")
              .withEmail_1("mail1").withEmail_2("mail2").withEmail_3("mail3").withHomepage("localhost").withAddress("address1")
              .withAddressSecondary("fortress").withPhoneSecondary("123").withBirthDay("20").withBirthMonth("March")
              .withBirthYear("1980").withNote("i am the god"));
    }
  }

  @Test
  public void testContactDeletion() {
    Contacts before = app.db().contacts();
    ContactPersonalDATA deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    app.goTo().homepage();
    assertThat(app.contact().count(), equalTo(before.size() - 1));
    Contacts  after = app.db().contacts();

    assertThat(after, equalTo(before.without(deletedContact)));

    verifyContactListInUI();
  }

}
