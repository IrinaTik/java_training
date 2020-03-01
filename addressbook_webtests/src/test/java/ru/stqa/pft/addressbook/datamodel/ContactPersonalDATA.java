package ru.stqa.pft.addressbook.datamodel;

public class ContactPersonalDATA {
  private int id;
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

  public ContactPersonalDATA(int id, String firstname, String middlename, String lastname, String nick, ContactCompanyDATA contactCompanyDATA, ContactConnectDATA contactConnectDATA, String birthDay, String birthMonth, String birthYear, String note) {
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
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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


