package org.hurelhuyag.pocketbudget.web;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import org.hurelhuyag.pocketbudget.web.domain.Finance;
import org.hurelhuyag.pocketbudget.web.domain.Type;
import org.hurelhuyag.pocketbudget.web.service.FinanceService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

/**
 * User: hurelhuyag
 * Email: hurle0409@gmail.com
 * Date: 12/8/12
 * Time: 7:51 PM
 */
public class EditServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        Finance f = financeService.get(id);
        req.setAttribute("finance", f);
        req.getRequestDispatcher("/edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> params = req.getParameterMap();
        String idParam = req.getParameter("id");
        String amountParam = req.getParameter("amount");
        String typeParam = req.getParameter("type");
        String descParam = req.getParameter("description");

        Long id = null;
        if (idParam!=null && !idParam.equals("")){
            id = Long.parseLong(idParam);
        }
        Type type = null;
        if (typeParam!=null && !typeParam.equals("")){
            type = Type.valueOf(typeParam);
        }
        Integer amount = null;
        if (amountParam!=null && !typeParam.equals("")){
            amount = Integer.parseInt(amountParam);
        }
        Finance f;
        if (id!=null){
            f = financeService.get(id);
        }else{
            User user = userService.getCurrentUser();
            f = new Finance();
            f.setCreated(new Date());
            f.setUserid(user.getUserId());
        }
        f.setAmount(amount);
        f.setType(type);
        f.setDescription(descParam);
        financeService.save(f);
        req.setAttribute("message", "Successfully saved");
        req.getRequestDispatcher("/edit.jsp").forward(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        Finance f = financeService.get(id);
        financeService.delete(f);
        req.setAttribute("message", "successfully deleted");
        req.getRequestDispatcher("/message.jsp").forward(req, resp);
    }
}
