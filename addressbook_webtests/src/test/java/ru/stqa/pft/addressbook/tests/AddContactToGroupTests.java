package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.datamodel.ContactPersonalDATA;
import ru.stqa.pft.addressbook.datamodel.Contacts;
import ru.stqa.pft.addressbook.datamodel.GroupData;
import ru.stqa.pft.addressbook.datamodel.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddContactToGroupTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {

    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test_group").withHeader("header_testgroup").withFooter("footer_testgroup"));
      app.goTo().homepage();
    }

    if (app.db().contacts().size() == 0) {
      app.contact().create(new ContactPersonalDATA().withFirstname("test_contact").withLastname("test_contactAddToGroup"));
      app.goTo().homepage();
    }

    //здесь еще должна быть проверка на наличие контакта без группы
  }

  @Test
  public void testAddContactToGroup() {
    Groups groups = app.db().groups();
    Contacts contacts = app.db().contacts();

    ContactPersonalDATA contactToAdd = contacts.iterator().next();
    GroupData groupToAdd = groups.iterator().next();
    app.contact().addContactToGroup(contactToAdd, groupToAdd);

    ContactPersonalDATA contactAfterAdding = app.db().contactRefresh(contactToAdd);
    GroupData groupAfterAdding = app.db().groupRefresh(groupToAdd);

    assertThat(contactAfterAdding, equalTo(contactToAdd.inGroup(groupToAdd)));
    assertThat(groupAfterAdding.getContacts(), hasItem(contactToAdd));
  }

}
