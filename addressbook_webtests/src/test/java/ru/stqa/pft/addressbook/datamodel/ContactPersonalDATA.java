package ru.stqa.pft.addressbook.datamodel;

public class ContactPersonalDATA {
  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String nick;
  private final ContactCompanyDATA contactCompanyDATA;
  private final ContactConnectDATA contactConnectDATA;
  private final String birthDay;
  private final String birthMonth;
  private final String birthYear;
  private final String note;

  public ContactPersonalDATA(String firstname, String middlename, String lastname, String nick, ContactCompanyDATA contactCompanyDATA, ContactConnectDATA contactConnectDATA, String birthDay, String birthMonth, String birthYear, String note) {
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nick = nick;
    this.contactCompanyDATA = contactCompanyDATA;
    this.contactConnectDATA = contactConnectDATA;
    this.birthDay = birthDay;
    this.birthMonth = birthMonth;
    this.birthYear = birthYear;
    this.note = note;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNick() {
    return nick;
  }

  public ContactCompanyDATA getContactCompanyDATA() {
    return contactCompanyDATA;
  }

  public ContactConnectDATA getContactConnectDATA() {
    return contactConnectDATA;
  }

  public String getBirthDay() {
    return birthDay;
  }

  public String getBirthMonth() {
    return birthMonth;
  }

  public String getBirthYear() {
    return birthYear;
  }

  public String getNote() {
    return note;
  }
}
