package ru.stqa.pft.addressbook.datamodel;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Contacts extends ForwardingSet<ContactPersonalDATA> {

  private Set<ContactPersonalDATA> delegate;

  public Contacts(Collection<ContactPersonalDATA> contacts) {
    this.delegate = new HashSet<ContactPersonalDATA>(contacts);
  }

  @Override
  protected Set<ContactPersonalDATA> delegate() {
    return delegate;
  }

  public Contacts() {
    this.delegate = new HashSet<ContactPersonalDATA>();
  }

  public Contacts(Contacts contacts) {
    this.delegate = new HashSet<ContactPersonalDATA>(contacts.delegate());
  }

  public Contacts withAdded(ContactPersonalDATA contact) {
    Contacts contacts = new Contacts(this); //создание копии множества
    contacts.add(contact);
    return contacts;
  }

  public Contacts without(ContactPersonalDATA contact) {
    Contacts contacts = new Contacts(this); //создание копии множества
    contacts.remove(contact);
    return contacts;
  }
}
