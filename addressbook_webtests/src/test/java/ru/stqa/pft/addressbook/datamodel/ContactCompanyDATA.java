package ru.stqa.pft.addressbook.datamodel;

public class ContactCompanyDATA {
  private final String title;
  private final String companyName;
  private final String faxNumber;
  private String group;

  public ContactCompanyDATA(String title, String companyName, String faxNumber, String group) {
    this.title = title;
    this.companyName = companyName;
    this.faxNumber = faxNumber;
    this.group = group;
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

  public String getGroup() {
    return group;
  }
}
