package ru.stqa.pft.addressbook.datamodel;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "addressbook")
public class ContactPersonalDATA {
  @Id
  @Column(name = "id")
  private int id;

  @Expose
  @Column(name = "firstname")
  private String firstname;

  @Expose
  @Column(name = "middlename")
  private String middlename;

  @Expose
  @Column(name = "lastname")
  private String lastname;

  @Expose
  @Column(name = "nickname")
  private String nick;

  @Expose
  @Column(name = "bday", columnDefinition = "TINYINT")
  private String birthDay;

  @Expose
  @Column(name = "bmonth")
  private String birthMonth;

  @Expose
  @Column(name = "byear")
  private String birthYear;

  @Expose
  @Transient
  private String title;

  @Expose
  @Transient
  private String companyName;

  @Expose
  @Transient
  private String faxNumber;

  @Expose
  @Transient
  private String address;

  @Expose
  @Transient
  private String homePhone;

  @Expose
  @Transient
  private String mobilePhone;

  @Expose
  @Transient
  private String workPhone;

  @Expose
  @Transient
  private String email_1;

  @Expose
  @Transient
  private String email_2;

  @Expose
  @Transient
  private String email_3;

  @Expose
  @Transient
  private String homepage;

  @Expose
  @Transient
  private String addressSecondary;

  @Expose
  @Transient
  private String phoneSecondary;

  @Transient
  private String allPhones;
  @Transient
  private String allEmails;

  @Expose
  @Column(name = "notes")
  @Type(type = "text")
  private String note;

  @Column(name = "photo")
  @Type(type = "text")
  private String photo;

  @ManyToMany(fetch = FetchType.EAGER) //для извлечения бОльшего объема инфы. Вместо LAZY по умолчанию
  @JoinTable(name = "address_in_groups",
          joinColumns = @JoinColumn(name = "id"),
          inverseJoinColumns = @JoinColumn(name = "group_id"))
  private Set<GroupData> groups = new HashSet<GroupData>();

  public ContactPersonalDATA withTitle(String title) {
    this.title = title;
    return this;
  }

  public ContactPersonalDATA withCompanyName(String companyName) {
    this.companyName = companyName;
    return this;
  }

  public ContactPersonalDATA withFaxNumber(String faxNumber) {
    this.faxNumber = faxNumber;
    return this;
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

  public ContactPersonalDATA withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }

  public ContactPersonalDATA withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactPersonalDATA withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }

  public ContactPersonalDATA withMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

  public ContactPersonalDATA withWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
  }

  public ContactPersonalDATA withEmail_1(String email_1) {
    this.email_1 = email_1;
    return this;
  }

  public ContactPersonalDATA withEmail_2(String email_2) {
    this.email_2 = email_2;
    return this;
  }

  public ContactPersonalDATA withEmail_3(String email_3) {
    this.email_3 = email_3;
    return this;
  }

  public ContactPersonalDATA withHomepage(String homepage) {
    this.homepage = homepage;
    return this;
  }

  public ContactPersonalDATA withAddressSecondary(String addressSecondary) {
    this.addressSecondary = addressSecondary;
    return this;
  }

  public ContactPersonalDATA withPhoneSecondary(String phoneSecondary) {
    this.phoneSecondary = phoneSecondary;
    return this;
  }

  public ContactPersonalDATA withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public ContactPersonalDATA withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public Groups getGroups() {
    return new Groups(groups);
  }

  public ContactPersonalDATA inGroup(GroupData group) {
    groups.add(group);
    return this;
  }

  public int getId() {
    return id;
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

  public File getPhoto() {
    return new File(photo);
  }

  public String getAddress() {
    return address;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public String getTitle() {
    return title;
  }

  public String getCompanyName() {
    return companyName;
  }

  public String getFaxNumber() {
    return faxNumber;
  }

  public String getEmail_1() {
    return email_1;
  }

  public String getEmail_2() {
    return email_2;
  }

  public String getEmail_3() {
    return email_3;
  }

  public String getHomepage() {
    return homepage;
  }

  public String getAddressSecondary() {
    return addressSecondary;
  }

  public String getPhoneSecondary() {
    return phoneSecondary;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public String getAllEmails() {
    return allEmails;
  }

  @Override
  public String toString() {
    return "ContactPersonalDATA{" +
            "id=" + id +
            ", firstname='" + firstname + '\'' +
            ", middlename='" + middlename + '\'' +
            ", lastname='" + lastname + '\'' +
            ", nick='" + nick + '\'' +
            ", birthDay='" + birthDay + '\'' +
            ", birthMonth='" + birthMonth + '\'' +
            ", birthYear='" + birthYear + '\'' +
            ", title='" + title + '\'' +
            ", companyName='" + companyName + '\'' +
            ", faxNumber='" + faxNumber + '\'' +
            ", address='" + address + '\'' +
            ", homePhone='" + homePhone + '\'' +
            ", mobilePhone='" + mobilePhone + '\'' +
            ", workPhone='" + workPhone + '\'' +
            ", email_1='" + email_1 + '\'' +
            ", email_2='" + email_2 + '\'' +
            ", email_3='" + email_3 + '\'' +
            ", homepage='" + homepage + '\'' +
            ", addressSecondary='" + addressSecondary + '\'' +
            ", phoneSecondary='" + phoneSecondary + '\'' +
            ", allPhones='" + allPhones + '\'' +
            ", allEmails='" + allEmails + '\'' +
            ", note='" + note + '\'' +
            ", photo='" + photo + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactPersonalDATA that = (ContactPersonalDATA) o;

    if (id != that.id) return false;
    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    if (middlename != null ? !middlename.equals(that.middlename) : that.middlename != null) return false;
    if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
    if (nick != null ? !nick.equals(that.nick) : that.nick != null) return false;
    if (birthDay != null ? !birthDay.equals(that.birthDay) : that.birthDay != null) return false;
    if (birthMonth != null ? !birthMonth.equals(that.birthMonth) : that.birthMonth != null) return false;
    if (birthYear != null ? !birthYear.equals(that.birthYear) : that.birthYear != null) return false;
    return note != null ? note.equals(that.note) : that.note == null;

  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
    result = 31 * result + (middlename != null ? middlename.hashCode() : 0);
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    result = 31 * result + (nick != null ? nick.hashCode() : 0);
    result = 31 * result + (birthDay != null ? birthDay.hashCode() : 0);
    result = 31 * result + (birthMonth != null ? birthMonth.hashCode() : 0);
    result = 31 * result + (birthYear != null ? birthYear.hashCode() : 0);
    result = 31 * result + (note != null ? note.hashCode() : 0);
    return result;
  }

}


