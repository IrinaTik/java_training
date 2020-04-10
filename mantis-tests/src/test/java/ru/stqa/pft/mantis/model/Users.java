package ru.stqa.pft.mantis.model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Users extends ForwardingSet<UserData> {

  private Set<UserData> delegate;

  public Users(Collection<UserData> contacts) {
    this.delegate = new HashSet<UserData>(contacts);
  }

  @Override
  protected Set<UserData> delegate() {
    return delegate;
  }

  public Users() {
    this.delegate = new HashSet<UserData>();
  }

  public Users(Users users) {
    this.delegate = new HashSet<UserData>(users.delegate());
  }

  public Users withAdded(UserData user) {
    Users users = new Users(this); //создание копии множества
    users.add(user);
    return users;
  }

  public Users without(UserData user) {
    Users users = new Users(this); //создание копии множества
    users.remove(user);
    return users;
  }
}