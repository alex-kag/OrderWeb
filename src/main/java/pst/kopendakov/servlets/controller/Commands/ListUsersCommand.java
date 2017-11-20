package pst.kopendakov.servlets.controller.Commands;


import pst.kopendakov.dbService.dao.impl.UserDaoImpl;
import pst.kopendakov.servlets.controller.ActionCommand;
import pst.kopendakov.servlets.controller.PageURL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by b.yacenko on 13.06.2017.
 */
public class ListUsersCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        UserDaoImpl userDao = new UserDaoImpl();

        req.setAttribute("users", userDao.getAll(0,0));
        return PageURL.LIST_USER;
    }
}