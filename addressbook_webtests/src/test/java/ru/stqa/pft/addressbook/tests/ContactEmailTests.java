package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.datamodel.ContactConnectDATA;
import ru.stqa.pft.addressbook.datamodel.ContactPersonalDATA;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactEmailTests extends TestBase {

  @Test
  public void testContactEmails () {
    app.goTo().homepage();
    ContactPersonalDATA contact = app.contact().all().iterator().next();
    ContactPersonalDATA contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getContactConnectDATA().getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm.getContactConnectDATA())));
  }

  private String mergeEmails(ContactConnectDATA contactEmails) {
    return Arrays.asList(contactEmails.getEmail_1(), contactEmails.getEmail_2(), contactEmails.getEmail_3())
            .stream().filter((s) -> ! s.equals(""))
            .collect(Collectors.joining("\n"));
  }

}
