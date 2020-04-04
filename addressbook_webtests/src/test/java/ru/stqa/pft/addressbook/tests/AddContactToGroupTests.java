package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.datamodel.ContactPersonalDATA;
import ru.stqa.pft.addressbook.datamodel.Contacts;
import ru.stqa.pft.addressbook.datamodel.GroupData;
import ru.stqa.pft.addressbook.datamodel.Groups;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertNotEquals;

public class AddContactToGroupTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {

    Groups groups = app.db().groups();
    Contacts contacts = app.db().contacts();

    if (groups.size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test_group").withHeader("header_testgroup").withFooter("footer_testgroup"));
      app.goTo().homepage();
    }

    if (contacts.size() == 0) {
      app.contact().create(new ContactPersonalDATA().withFirstname("test_contact").withLastname("test_contactAddToGroup"));
      app.goTo().homepage();
    }

    if (app.contact().findFreeContact(contacts, groups) == null) {
      ContactPersonalDATA preContact = contacts.iterator().next();
      GroupData preGroup = groups.iterator().next();
      app.contact().deleteContactFromGroup(preContact, preGroup);
      app.goTo().homepage();
    }

  }

  @Test
  public void testAddContactToGroup() {
    Groups groups = app.db().groups();
    Contacts contacts = app.db().contacts();

    ContactPersonalDATA contactToAdd = app.contact().findFreeContact(contacts, groups);
    GroupData groupToAdd = app.group().findGroupWithoutCurrentContact(groups, contactToAdd);

    app.goTo().homepage();
    app.contact().addContactToGroup(contactToAdd, groupToAdd);

    ContactPersonalDATA contactAfterAdding = app.db().contactRefresh(contactToAdd);
    GroupData groupAfterAdding = app.db().groupRefresh(groupToAdd);

    assertThat(groupAfterAdding.getContacts(), hasItem(contactToAdd));
    assertThat(contactAfterAdding.getGroups(), hasItem(groupToAdd));
  }

}
