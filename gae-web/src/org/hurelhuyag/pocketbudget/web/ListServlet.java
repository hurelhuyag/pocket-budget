package org.hurelhuyag.pocketbudget.web;

import com.google.appengine.api.users.User;
import org.hurelhuyag.pocketbudget.web.domain.Finance;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * User: hurelhuyag
 * Email: hurle0409@gmail.com
 * Date: 12/9/12
 * Time: 2:33 PM
 */
public class ListServlet extends BaseServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userService.getCurrentUser();
        List<Finance> finances = financeService.list(user.getUserId());

        req.setAttribute("finances", finances);
        String accepttype = req.getHeader("Accept");

        System.out.println(accepttype);
        req.getRequestDispatcher("/list.jsp").forward(req, resp);
    }
}
