package ru.stqa.pft.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.datamodel.ContactPersonalDATA;
import ru.stqa.pft.addressbook.datamodel.Contacts;
import ru.stqa.pft.addressbook.datamodel.Groups;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContactsFromJSON() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")));
    String json = "";
    String line = reader.readLine();
    while (line != null) {
      json += line;
      line = reader.readLine();
    }
    Gson gson = new Gson();
    List<ContactPersonalDATA> contacts = gson.fromJson(json, new TypeToken<List<ContactPersonalDATA>>(){}.getType());
    return contacts.stream().map((c) -> new Object[] {c}).collect(Collectors.toList()).iterator();
  }

  @Test(dataProvider = "validContactsFromJSON")
  public void testContactCreation(ContactPersonalDATA contact) throws Exception {
    Contacts before = app.db().contacts();
    Groups groups = app.db().groups();
    File photo = new File("src/test/resources/stru.jpg");
    app.contact().create(contact.withPhoto(photo).inGroup(groups.iterator().next()));
    app.goTo().homepage();
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.db().contacts();

    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));

    verifyContactListInUI();
  }

}
