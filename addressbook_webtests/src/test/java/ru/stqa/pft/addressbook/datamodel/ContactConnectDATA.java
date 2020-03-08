package ru.stqa.pft.addressbook.datamodel;

public class ContactConnectDATA {
  private String address;
  private String homePhone;
  private String mobilePhone;
  private String workPhone;
  private String email_1;
  private String email_2;
  private String email_3;
  private String homepage;
  private String addressSecondary;
  private String phoneSecondary;

 /* public ContactConnectDATA(String address, String homePhone, String mobilePhone, String workPhone, String email_1, String email_2, String email_3, String homepage, String addressSecondary, String phoneSecondary) {
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
  } */

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

  public ContactConnectDATA withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactConnectDATA withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }

  public ContactConnectDATA withMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

  public ContactConnectDATA withWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
  }

  public ContactConnectDATA withEmail_1(String email_1) {
    this.email_1 = email_1;
    return this;
  }

  public ContactConnectDATA withEmail_2(String email_2) {
    this.email_2 = email_2;
    return this;
  }

  public ContactConnectDATA withEmail_3(String email_3) {
    this.email_3 = email_3;
    return this;
  }

  public ContactConnectDATA withHomepage(String homepage) {
    this.homepage = homepage;
    return this;
  }

  public ContactConnectDATA withAddressSecondary(String addressSecondary) {
    this.addressSecondary = addressSecondary;
    return this;
  }

  public ContactConnectDATA withPhoneSecondary(String phoneSecondary) {
    this.phoneSecondary = phoneSecondary;
    return this;
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
