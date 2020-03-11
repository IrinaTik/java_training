package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.datamodel.ContactConnectDATA;
import ru.stqa.pft.addressbook.datamodel.ContactPersonalDATA;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase{

  @Test
  public void testContactPhones() {
    app.goTo().homepage();
    ContactPersonalDATA contact = app.contact().all().iterator().next();
    ContactPersonalDATA contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

  /*  assertThat(contact.getContactConnectDATA().getHomePhone(), equalTo(cleaned(contactInfoFromEditForm.getContactConnectDATA().getHomePhone())));
    assertThat(contact.getContactConnectDATA().getMobilePhone(), equalTo(cleaned(contactInfoFromEditForm.getContactConnectDATA().getMobilePhone())));
    assertThat(contact.getContactConnectDATA().getWorkPhone(), equalTo(cleaned(contactInfoFromEditForm.getContactConnectDATA().getWorkPhone()))); */

    assertThat(contact.getContactConnectDATA().getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm.getContactConnectDATA())));
  }

  private String mergePhones(ContactConnectDATA contactPhones) {
    return Arrays.asList(contactPhones.getHomePhone(), contactPhones.getMobilePhone(), contactPhones.getWorkPhone())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContactPhoneTests::cleaned) //применить к элементам потока функцию
            .collect(Collectors.joining("\n"));
    //отбрасывает пустые строки, чистит от лишних символов, вставляет переход строки
  }

  public static String cleaned (String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }
}
