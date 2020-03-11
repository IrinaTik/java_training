package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.datamodel.ContactPersonalDATA;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase{

  @Test
  public void testContactPhones() {
    app.goTo().homepage();
    ContactPersonalDATA contact = app.contact().all().iterator().next();
    ContactPersonalDATA contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getContactConnectDATA().getHomePhone(), equalTo(cleaned(contactInfoFromEditForm.getContactConnectDATA().getHomePhone())));
    assertThat(contact.getContactConnectDATA().getMobilePhone(), equalTo(cleaned(contactInfoFromEditForm.getContactConnectDATA().getMobilePhone())));
    assertThat(contact.getContactConnectDATA().getWorkPhone(), equalTo(cleaned(contactInfoFromEditForm.getContactConnectDATA().getWorkPhone())));
  }

  public String cleaned (String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }
}
