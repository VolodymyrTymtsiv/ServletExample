package ua.lviv.lgs;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {

  private UserService userService = UserService.getUserService();


  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String firstName = request.getParameter("firstName");
    String lastName = request.getParameter("lastName");
    String email = request.getParameter("email");
    String password = request.getParameter("password");

    userService.saveUser(new User(firstName, lastName, email, password));
    request.setAttribute("userEmail", email);
    request.getRequestDispatcher("cabinet.jsp").forward(request, response);
  }

}
