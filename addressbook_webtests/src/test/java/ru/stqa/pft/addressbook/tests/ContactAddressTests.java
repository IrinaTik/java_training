package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.datamodel.ContactPersonalDATA;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressTests extends TestBase{

  @Test
  public void testContactAddress () {
    app.goTo().homepage();
    ContactPersonalDATA contact = app.contact().all().iterator().next();
    ContactPersonalDATA contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getContactConnectDATA().getAddress(), equalTo(contactInfoFromEditForm.getContactConnectDATA().getAddress()));
  }
}
