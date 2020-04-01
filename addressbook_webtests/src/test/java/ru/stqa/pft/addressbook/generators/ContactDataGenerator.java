package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.stqa.pft.addressbook.datamodel.ContactPersonalDATA;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

  @Parameter(names = "-c", description = "Contact count")
  public int count;

  @Parameter(names = "-f", description = "Target file")
  public String file;

  @Parameter(names = "-d", description = "Data format")
  public String format;

  public static void main(String[] args) throws IOException {
    ContactDataGenerator generator = new ContactDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    } catch (ParameterException ex) {
      jCommander.usage();
      return;
    }
    generator.run();
  }

  private void run() throws IOException {
    List<ContactPersonalDATA> contacts = generateContacts(count);
     if (format.equals("json")) {
      saveAsJSON(contacts, new File(file));
    } else {
      System.out.println("Unrecognized format " + format);
    }
  }

  private void saveAsJSON(List<ContactPersonalDATA> contacts, File file) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json = gson.toJson(contacts);
    Writer writer = new FileWriter(file);
    writer.write(json);
    writer.close();
  }

  private List<ContactPersonalDATA> generateContacts(int count) {
    List<ContactPersonalDATA> contacts = new ArrayList<ContactPersonalDATA>();
    for (int i = 1; i <= count; i++) {
      String birthDay = chooseBirthDay(i);
      String birthMonth = chooseBirthMonth(i);
      String birthYear = chooseBirthYear(i);
      contacts.add(new ContactPersonalDATA().withFirstname(String.format("first name %s", i)).withMiddlename(String.format("middle name %s", i))
              .withLastname(String.format("last name %s", i)).withNick(String.format("nick %s", i)).withTitle(String.format("title %s", i)).withCompanyName(String.format("company %s", i))
              .withFaxNumber(String.format("fax %s", i)).withGroup("test1").withHomePhone(String.format("+7(987) %s", i)).withAddress(String.format("address %s", i))
              .withMobilePhone(String.format("22-2%s", i)).withWorkPhone(String.format("12345678%s", i))
              .withEmail_1(String.format("mail1_%s@mail.ru", i)).withEmail_2(String.format("mail2_%s@mail.ru", i)).withEmail_3(String.format("mail13_%s@mail.ru", i))
              .withHomepage(String.format("localhost %s", i)).withAddressSecondary(String.format("fortress %s", i)).withPhoneSecondary(String.format("%s", i))
              .withBirthDay(birthDay).withBirthMonth(birthMonth).withBirthYear(birthYear).withNote(String.format("i am the №%s god", i)));
    }
    return contacts;
  }

  private String chooseBirthYear(int i) {
    return Integer.toString(1980 + computeModule(i, 11, 10));
  }

  private String chooseBirthMonth(int i) {
    int bMonth = computeModule(i, 13, 12);
    if (bMonth == 0) {
      bMonth = 12;
    }
    switch (bMonth) {
      case 1: return "January";
      case 2: return "February";
      case 3: return "March";
      case 4: return "April";
      case 5: return "May";
      case 6: return "June";
      case 7: return "July";
      case 8: return "August";
      case 9: return "September";
      case 10: return "October";
      case 11: return "November";
      case 12: return "December";
      default: return "";
    }
  }

  private String chooseBirthDay(int i) {
    int bday = computeModule(i, 25, 10);
    if (bday == 0) {
      bday = 1;
    }
    return Integer.toString(bday);
  }


  private int computeModule(int compareNum, int limitNum, int modNum) {
    if (compareNum < limitNum) {
      return compareNum;
    } else {
      return (compareNum%modNum);
    }
  }
}
