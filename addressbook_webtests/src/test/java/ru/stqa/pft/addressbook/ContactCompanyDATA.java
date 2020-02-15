package ru.stqa.pft.addressbook;

public class ContactCompanyDATA {
  private final String title;
  private final String companyName;
  private final String faxNumber;

  public ContactCompanyDATA(String title, String companyName, String faxNumber) {
    this.title = title;
    this.companyName = companyName;
    this.faxNumber = faxNumber;
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
}
