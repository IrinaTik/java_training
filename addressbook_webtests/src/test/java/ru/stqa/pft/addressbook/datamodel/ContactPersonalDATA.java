package ru.stqa.pft.addressbook.datamodel;

public class ContactPersonalDATA {
  private int id;
  private String firstname;
  private String middlename;
  private String lastname;
  private String nick;
  private ContactCompanyDATA contactCompanyDATA;
  private ContactConnectDATA contactConnectDATA;
  private String birthDay;
  private String birthMonth;
  private String birthYear;
  private String note;

 /* public ContactPersonalDATA(int id, String firstname, String middlename, String lastname, String nick, ContactCompanyDATA contactCompanyDATA, ContactConnectDATA contactConnectDATA, String birthDay, String birthMonth, String birthYear, String note) {
    this.id = id;
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

  public ContactPersonalDATA(String firstname, String middlename, String lastname, String nick, ContactCompanyDATA contactCompanyDATA, ContactConnectDATA contactConnectDATA, String birthDay, String birthMonth, String birthYear, String note) {
    this.id = Integer.MAX_VALUE;
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

  public ContactPersonalDATA(int id, String firstname, String lastname) {
    this.id = id;
    this.firstname = firstname;
    this.middlename = null;
    this.lastname = lastname;
    this.nick = null;
    this.contactCompanyDATA = new ContactCompanyDATA(null, null, null, null);
   // this.contactCompanyDATA = null;
    this.contactConnectDATA = new ContactConnectDATA(null, null, null, null, null, null, null, null, null, null);
   // this.contactConnectDATA = null;
    this.birthDay = null;
    this.birthMonth = null;
    this.birthYear = null;
    this.note = null;
  } */

  public int getId() {
    return id;
  }

  public ContactPersonalDATA withId(int id) {
    this.id = id;
    return this;
  }

  public ContactPersonalDATA withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public ContactPersonalDATA withMiddlename(String middlename) {
    this.middlename = middlename;
    return this;
  }

  public ContactPersonalDATA withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactPersonalDATA withNick(String nick) {
    this.nick = nick;
    return this;
  }

  public ContactPersonalDATA withContactCompanyDATA(ContactCompanyDATA contactCompanyDATA) {
    this.contactCompanyDATA = contactCompanyDATA;
    return this;
  }

  public ContactPersonalDATA withContactConnectDATA(ContactConnectDATA contactConnectDATA) {
    this.contactConnectDATA = contactConnectDATA;
    return this;
  }

  public ContactPersonalDATA withBirthDay(String birthDay) {
    this.birthDay = birthDay;
    return this;
  }

  public ContactPersonalDATA withBirthMonth(String birthMonth) {
    this.birthMonth = birthMonth;
    return this;
  }

  public ContactPersonalDATA withBirthYear(String birthYear) {
    this.birthYear = birthYear;
    return this;
  }

  public ContactPersonalDATA withNote(String note) {
    this.note = note;
    return this;
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

  @Override
  public String toString() {
    return "ContactPersonalDATA{" +
            "id=" + id +
            ", firstname='" + firstname + '\'' +
            ", middlename='" + middlename + '\'' +
            ", lastname='" + lastname + '\'' +
            ", nick='" + nick + '\'' +
            ", contactCompanyDATA=" + contactCompanyDATA +
            ", contactConnectDATA=" + contactConnectDATA +
            ", birthDay='" + birthDay + '\'' +
            ", birthMonth='" + birthMonth + '\'' +
            ", birthYear='" + birthYear + '\'' +
            ", note='" + note + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactPersonalDATA that = (ContactPersonalDATA) o;

    if (id != that.id) return false;
    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;

  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
  }

}


