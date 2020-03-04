package ua.lviv.lgs;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.getRequestDispatcher("login.jsp").forward(req, resp);
  }


  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String login = request.getParameter("login");
    String password = request.getParameter("password");

    UserService userService = UserService.getUserService();
    User user = userService.getUser(login);

    if(user == null) {
      request.getRequestDispatcher("login.jsp").forward(request, response);;
      return;
    }

    if(user.getPassword().equals(password)) {
      request.setAttribute("userEmail", login);
      request.getRequestDispatcher("cabinet.jsp").forward(request, response);;
    }

    request.getRequestDispatcher("login.jsp").forward(request, response);;
  }
}
