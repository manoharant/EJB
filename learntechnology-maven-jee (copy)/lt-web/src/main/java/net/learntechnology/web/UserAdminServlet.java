package net.learntechnology.web;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.learntechnology.persistence.entity.User;
import net.learntechnology.service.UserService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class UserAdminServlet extends HttpServlet {
    private static Log log = LogFactory.getLog(UserAdminServlet.class);
  
    @EJB
    private UserService userService;
     
    public void init() throws ServletException {
        super.init();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		log.debug("retrieving users");
		List<User> users = userService.getUsers();
		request.setAttribute("users", users );
		getServletConfig().getServletContext().getRequestDispatcher("/users.jsp").forward(request,response);
    }
}
