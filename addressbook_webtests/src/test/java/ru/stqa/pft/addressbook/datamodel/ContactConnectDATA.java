package ru.stqa.pft.addressbook.datamodel;

public class ContactConnectDATA {
  private final String address;
  private final String homePhone;
  private final String mobilePhone;
  private final String workPhone;
  private final String email_1;
  private final String email_2;
  private final String email_3;
  private final String homepage;
  private final String addressSecondary;
  private final String phoneSecondary;

  public ContactConnectDATA(String address, String homePhone, String mobilePhone, String workPhone, String email_1, String email_2, String email_3, String homepage, String addressSecondary, String phoneSecondary) {
    this.address = address;
    this.homePhone = homePhone;
    this.mobilePhone = mobilePhone;
    this.workPhone = workPhone;
    this.email_1 = email_1;
    this.email_2 = email_2;
    this.email_3 = email_3;
    this.homepage = homepage;
    this.addressSecondary = addressSecondary;
    this.phoneSecondary = phoneSecondary;
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

  @Override
  public String toString() {
    return "ContactConnectDATA{" +
            "address='" + address + '\'' +
            ", homePhone='" + homePhone + '\'' +
            ", mobilePhone='" + mobilePhone + '\'' +
            ", workPhone='" + workPhone + '\'' +
            ", email_1='" + email_1 + '\'' +
            ", email_2='" + email_2 + '\'' +
            ", email_3='" + email_3 + '\'' +
            ", homepage='" + homepage + '\'' +
            ", addressSecondary='" + addressSecondary + '\'' +
            ", phoneSecondary='" + phoneSecondary + '\'' +
            '}';
  }
}
