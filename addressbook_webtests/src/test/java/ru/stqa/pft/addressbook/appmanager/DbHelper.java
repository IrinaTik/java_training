package ru.stqa.pft.addressbook.appmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.stqa.pft.addressbook.datamodel.ContactPersonalDATA;
import ru.stqa.pft.addressbook.datamodel.Contacts;
import ru.stqa.pft.addressbook.datamodel.GroupData;
import ru.stqa.pft.addressbook.datamodel.Groups;

import java.util.List;

public class DbHelper {

  private final SessionFactory sessionFactory;

  public DbHelper() {
    // A SessionFactory is set up once for an application!
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();
    sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
  }

  public Groups groups() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<GroupData> result = session.createQuery("from GroupData").list();
    session.getTransaction().commit();
    session.close();
    return new Groups(result);
  }

  public Contacts contacts() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<ContactPersonalDATA> result = session.createQuery("from ContactPersonalDATA where deprecated = '0000-00-00'").list();
    session.getTransaction().commit();
    session.close();
    return new Contacts(result);
  }

  public ContactPersonalDATA contactRefresh(ContactPersonalDATA contact) {
    Session session = sessionFactory.openSession();
    session.refresh(contact);
    session.close();
    return contact;
  }

  public GroupData groupRefresh(GroupData group) {
    Session session = sessionFactory.openSession();
    session.refresh(group);
    session.close();
    return group;
  }
}
