package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.datamodel.ContactPersonalDATA;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactConnectDataTests extends TestBase {

  @Test
  public void testContactConnectData () {
    app.goTo().homepage();
    ContactPersonalDATA contact = app.contact().all().iterator().next();
    ContactPersonalDATA contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
    assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));
  }

  private String mergePhones(ContactPersonalDATA contactPhones) {
    return Arrays.asList(contactPhones.getHomePhone(), contactPhones.getMobilePhone(), contactPhones.getWorkPhone(), contactPhones.getPhoneSecondary())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContactConnectDataTests::cleaned) //применить к элементам потока функцию
            .collect(Collectors.joining("\n"));
    //отбрасывает пустые строки, чистит от лишних символов, вставляет переход строки
  }

  private String mergeEmails(ContactPersonalDATA contactEmails) {
    return Arrays.asList(contactEmails.getEmail_1(), contactEmails.getEmail_2(), contactEmails.getEmail_3())
            .stream().filter((s) -> ! s.equals(""))
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned (String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }


}
