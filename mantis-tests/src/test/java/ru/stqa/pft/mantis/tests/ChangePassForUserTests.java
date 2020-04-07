package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.mantis.appmanager.HttpSession;
import ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.model.UserData;
import ru.stqa.pft.mantis.model.Users;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ChangePassForUserTests extends TestBase{

  @BeforeMethod
  public void startMailServer() {
    app.mail().start();
  }

  @Test
  public void testChangePasswordForUser() throws IOException, MessagingException {
    Users users = app.db().users();
    UserData userForChange = users.stream().filter((u) -> u.getId() != 1).findAny().get();
    String newPass = "changed_password";

    app.session().loginAsAdmin();
    app.session().goToUsersPage();
    app.session().chooseUserById(userForChange.getId());
    app.session().resetPassword();
   // app.session().logout();

    List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
    String confirmationLink = findConfirmationLink(mailMessages, userForChange.getEmail());
    app.registration().finish(confirmationLink, newPass);

    HttpSession session = app.newSession();
    assertTrue(session.login(userForChange.getUsername(), newPass));
    assertTrue(session.isLoggedInAs(userForChange.getUsername()));
  }

  @AfterMethod(alwaysRun = true)
  public void stopMailServer() {
    app.mail().stop();
  }
}
