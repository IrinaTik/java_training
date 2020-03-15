package ru.stqa.pft.addressbook.datamodel;

import com.google.gson.annotations.Expose;

public class ContactCompanyDATA {
  @Expose
  private String title;
  @Expose
  private String companyName;
  @Expose
  private String faxNumber;
  @Expose
  private String group;

  /* public ContactCompanyDATA(String title, String companyName, String faxNumber, String group) {
    this.title = title;
    this.companyName = companyName;
    this.faxNumber = faxNumber;
    this.group = group;
  } */

  public String getTitle() {
    return title;
  }

  public String getCompanyName() {
    return companyName;
  }

  public String getFaxNumber() {
    return faxNumber;
  }

  public String getGroup() {
    return group;
  }

  public ContactCompanyDATA withTitle(String title) {
    this.title = title;
    return this;
  }

  public ContactCompanyDATA withCompanyName(String companyName) {
    this.companyName = companyName;
    return this;
  }

  public ContactCompanyDATA withFaxNumber(String faxNumber) {
    this.faxNumber = faxNumber;
    return this;
  }

  public ContactCompanyDATA withGroup(String group) {
    this.group = group;
    return this;
  }

  @Override
  public String toString() {
    return "ContactCompanyDATA{" +
            "title='" + title + '\'' +
            ", companyName='" + companyName + '\'' +
            ", faxNumber='" + faxNumber + '\'' +
            ", group='" + group + '\'' +
            '}';
  }
}
