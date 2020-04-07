package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase{

  public NavigationHelper(ApplicationManager app) {
    super(app);
  }

  public void login(String username, String password) {
    wb.get(app.getProperty("web.baseURL") + "/login.php");
    type(By.name("username"), username);
    click(By.cssSelector("input[type='submit']"));
    type(By.name("password"), password);
    click(By.cssSelector("input[type='submit']"));
  }

  public void loginAsAdmin() {
    wb.get(app.getProperty("web.baseURL") + "/login.php");
    type(By.name("username"), app.getProperty("web.adminLogin"));
    click(By.cssSelector("input[type='submit']"));
    type(By.name("password"), app.getProperty("web.adminPassword"));
    click(By.cssSelector("input[type='submit']"));
  }

  public void logout() {
   // click(By.cssSelector(String.format("<span class=\"user-info\">%s</span>", app.getProperty("web.adminLogin"))));
   // click(By.cssSelector(String.format("a[href='/%s%s']", app.getProperty("web.baseURL"), "/logout_page.php")));
   // wb.get(app.getProperty("web.baseURL") + "/logout_page.php");
  }

  public void goToUsersPage() {
    wb.get(app.getProperty("web.baseURL") + "manage_user_page.php");
  }

  public void chooseUserById(int id) {
    click(By.cssSelector(String.format("a[href='manage_user_edit_page.php?user_id=%s']", id)));
  }

  public void resetPassword() {
    click(By.cssSelector("input[value='Сбросить пароль']"));
  }
}
