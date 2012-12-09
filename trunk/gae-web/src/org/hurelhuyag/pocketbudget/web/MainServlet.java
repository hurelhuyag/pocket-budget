package org.hurelhuyag.pocketbudget.web;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import org.hurelhuyag.pocketbudget.web.domain.Finance;
import org.hurelhuyag.pocketbudget.web.service.FinanceService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * User: hurelhuyag
 * Email: hurle0409@gmail.com
 * Date: 12/8/12
 * Time: 7:04 PM
 */
public class MainServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        UserService userService = UserServiceFactory.getUserService();
        FinanceService financeService = FinanceService.getFinanceService();

        User user = userService.getCurrentUser();
        String userid = user.getUserId();
        String logouturl = userService.createLogoutURL("/index.jsp");
        List<Finance> result = financeService.list(userid);
        System.out.println("finances size: "+result.size());
        req.setAttribute("finances", result);
        req.setAttribute("user", user);
        req.setAttribute("logout", logouturl);
        RequestDispatcher rd = req.getRequestDispatcher("/main.jsp");
        rd.forward(req, res);
    }
}
