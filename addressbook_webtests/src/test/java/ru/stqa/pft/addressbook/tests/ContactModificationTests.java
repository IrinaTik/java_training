package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.datamodel.ContactCompanyDATA;
import ru.stqa.pft.addressbook.datamodel.ContactConnectDATA;
import ru.stqa.pft.addressbook.datamodel.ContactPersonalDATA;
import ru.stqa.pft.addressbook.datamodel.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.goTo().homepage();
      app.contact().create(new ContactPersonalDATA().withFirstname("1").withMiddlename("2").withLastname("3").withNick("qwer")
              .withContactCompanyDATA(new ContactCompanyDATA().withTitle("qweh").withCompanyName("qwerrrrrrty").withFaxNumber("notfound").withGroup("test1"))
              .withContactConnectDATA(new ContactConnectDATA().withAddress("moscow").withHomePhone("12345").withMobilePhone("123456789").withWorkPhone("hard")
                      .withEmail_1("mail1").withEmail_2("mail2").withEmail_3("mail3").withHomepage("localhost").withAddress("address1").withAddressSecondary("fortress").withPhoneSecondary("123"))
              .withBirthDay("20").withBirthMonth("March").withBirthYear("1980").withNote("i am the god"));
    }
  }

  @Test
  public void testContactModification(){
    Contacts before = app.db().contacts();
    ContactPersonalDATA modifiedContact = before.iterator().next();
    app.goTo().homepage();
    app.contact().initContactModification();
    ContactPersonalDATA contact = new ContactPersonalDATA().withId(modifiedContact.getId()).withFirstname("sau").withMiddlename("ilu").withLastname("vatar").withNick("qwerrrrrrty")
            .withBirthDay("10").withBirthMonth("May").withBirthYear("1999").withNote("i am the mighty god!!!!");
    app.contact().modify(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();

    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));

    verifyContactListInUI();
  }



}
