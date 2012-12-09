package org.hurelhuyag.pocketbudget.web;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import org.hurelhuyag.pocketbudget.web.service.FinanceService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: hurelhuyag
 * Email: hurle0409@gmail.com
 * Date: 12/9/12
 * Time: 2:35 PM
 */
public class BaseServlet extends HttpServlet {

    FinanceService financeService;
    UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        financeService = FinanceService.getFinanceService();
        userService = UserServiceFactory.getUserService();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userService.getCurrentUser();
        if (user==null){
            resp.sendRedirect(userService.createLoginURL("/index.jsp"));
        }else{
            super.service(req, resp);
        }
    }
}
