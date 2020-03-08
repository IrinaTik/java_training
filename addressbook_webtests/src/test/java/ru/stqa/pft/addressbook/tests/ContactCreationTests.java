package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.datamodel.ContactCompanyDATA;
import ru.stqa.pft.addressbook.datamodel.ContactConnectDATA;
import ru.stqa.pft.addressbook.datamodel.ContactPersonalDATA;
import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    List<ContactPersonalDATA> before = app.contact().list();
    ContactPersonalDATA contact = new ContactPersonalDATA().withFirstname("1").withMiddlename("2").withLastname("3").withNick("qwer")
            .withContactCompanyDATA(new ContactCompanyDATA().withTitle("qweh").withCompanyName("qwerrrrrrty").withFaxNumber("notfound").withGroup("test1"))
            .withContactConnectDATA(new ContactConnectDATA().withAddress("moscow").withHomePhone("12345").withMobilePhone("123456789").withWorkPhone("hard")
                    .withEmail_1("mail1").withEmail_2("mail2").withEmail_3("mail3").withHomepage("localhost").withAddress("address1").withAddressSecondary("fortress").withPhoneSecondary("123"))
            .withBirthDay("20").withBirthMonth("March").withBirthYear("1980").withNote("i am the god");
    app.contact().create(contact);
    app.goTo().homepage();
    List<ContactPersonalDATA>  after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(contact);

    Comparator<? super ContactPersonalDATA> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    //Assert.assertEquals(before, after);
    Assert.assertTrue(before.equals(after)); //assertEquals сравнивает все поля, а нам надо только id и имя\фамилия, поэтому используем функцию из класса
  }


}
