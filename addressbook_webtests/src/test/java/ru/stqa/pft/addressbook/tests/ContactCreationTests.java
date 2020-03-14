package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.datamodel.ContactCompanyDATA;
import ru.stqa.pft.addressbook.datamodel.ContactConnectDATA;
import ru.stqa.pft.addressbook.datamodel.ContactPersonalDATA;
import ru.stqa.pft.addressbook.datamodel.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    Contacts before = app.contact().all();
    File photo = new File("src/test/resources/stru.jpg");
    ContactPersonalDATA contact = new ContactPersonalDATA().withFirstname("1").withMiddlename("2").withLastname("3").withNick("qwer")
            .withContactCompanyDATA(new ContactCompanyDATA().withTitle("qweh").withCompanyName("qwerrrrrrty").withFaxNumber("notfound").withGroup("test1"))
            .withContactConnectDATA(new ContactConnectDATA().withAddress("moscow").withHomePhone("12345").withMobilePhone("123456789").withWorkPhone("hard")
                    .withEmail_1("mail1").withEmail_2("mail2").withEmail_3("mail3").withHomepage("localhost").withAddress("address1").withAddressSecondary("fortress").withPhoneSecondary("123"))
            .withBirthDay("20").withBirthMonth("March").withBirthYear("1980").withNote("i am the god").withPhoto(photo);
    app.contact().create(contact);
    app.goTo().homepage();
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts  after = app.contact().all();

    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }

}
