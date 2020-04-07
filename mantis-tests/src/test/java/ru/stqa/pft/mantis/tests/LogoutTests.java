package ru.stqa.pft.mantis.tests;

import org.testng.annotations.Test;

public class LogoutTests extends TestBase {

  @Test
  public void testLogout() {
    app.session().loginAsAdmin();
    app.session().logout();
  }
}
