package ru.stqa.pft.addressbook.datamodel;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

public class Groups extends ForwardingSet<GroupData> {

  private Set<GroupData> delegate;

  public Groups() {
    this.delegate = new HashSet<GroupData>();
  }

  public Groups(Groups groups) {
    this.delegate = new HashSet<GroupData>(groups.delegate());
  }

  @Override
  protected Set<GroupData> delegate() {
     return delegate;
  }

  public Groups withAdded(GroupData group) {
    Groups groups = new Groups(this); //создание копии множества
    groups.add(group);
    return groups;
  }

  public Groups without(GroupData group) {
    Groups groups = new Groups(this); //создание копии множества
    groups.remove(group);
    return groups;
  }
}
