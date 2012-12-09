package org.hurelhuyag.pocketbudget.web;

import com.google.appengine.api.users.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.hurelhuyag.pocketbudget.web.domain.Finance;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: hurlee
 * Date: 12/9/12
 * Time: 4:55 PM
 */
public class MobileServlet extends BaseServlet {

    Gson gson;

    @Override
    public void init() throws ServletException {
        super.init();
        gson = new GsonBuilder().create();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userService.getCurrentUser();
        List<Finance> finances = financeService.list(user.getUserId());
        gson.toJson(finances, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
