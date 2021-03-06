package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.datamodel.ContactPersonalDATA;
import ru.stqa.pft.addressbook.datamodel.Contacts;
import ru.stqa.pft.addressbook.datamodel.GroupData;
import ru.stqa.pft.addressbook.datamodel.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeleteContactFromGroupTests extends TestBase {

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
      app.contact().create(new ContactPersonalDATA().withFirstname("test_contact").withLastname("test_contactDeleteFromGroup").inGroup(groups.iterator().next()));
      app.goTo().homepage();
    }

    if (app.contact().findTakenContact(contacts) == null) {
      ContactPersonalDATA preContact = contacts.iterator().next();
      GroupData preGroup = groups.iterator().next();
      app.contact().addContactToGroup(preContact, preGroup);
      app.goTo().homepage();
    }

  }

  @Test
  public void testAddContactToGroup() {
    //Groups groups = app.db().groups();
    Contacts contacts = app.db().contacts();

    ContactPersonalDATA contactToDelete = app.contact().findTakenContact(contacts);
    GroupData groupToDelete = contactToDelete.getGroups().iterator().next();

    app.goTo().homepage();
    app.contact().deleteContactFromGroup(contactToDelete, groupToDelete);

    ContactPersonalDATA contactAfterDeleting = app.db().contactRefresh(contactToDelete);
    GroupData groupAfterDeleting = app.db().groupRefresh(groupToDelete);

    assertThat(contactAfterDeleting.getGroups(), not(hasItem(groupToDelete)));
    assertThat(groupAfterDeleting.getContacts(), not(hasItem(contactToDelete)));
  }
}
