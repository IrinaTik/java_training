package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.datamodel.GroupData;

import java.util.ArrayList;
import java.util.List;

public class GroupHelper extends HelperBase{

  public GroupHelper(WebDriver wb) {
    super(wb);
  }

  public void submitCreation() {
    click(By.name("submit"));
  }

  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void deleteSelectedGroups() {
    click(By.name("delete"));
  }

  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }

  public void create(GroupData group) {
    initGroupCreation();
    fillGroupForm(group);
    submitCreation();
    returnToGroupPage();
  }

  public void modify(int index, GroupData group) {
    select(index);
    initGroupModification();
    fillGroupForm(group);
    submitGroupModification();
    returnToGroupPage();
  }

  public void delete(int index) {
    select(index);
    deleteSelectedGroups();
    returnToGroupPage();
  }

  public int getGroupCount() {
    return wb.findElements(By.name("selected[]")).size();
  }

  public List<GroupData> list() {
    List<GroupData> groups = new ArrayList<GroupData>();
    List<WebElement> elements = wb.findElements(By.cssSelector("span.group"));
    for (WebElement element : elements) {
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      GroupData group = new GroupData(id, name, null, null);
      groups.add(group);
    }
    return groups;
  }
}
