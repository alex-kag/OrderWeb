package pst.kopendakov.servlets.controller.Commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pst.kopendakov.servlets.controller.ActionCommand;
import pst.kopendakov.servlets.controller.PageURL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by b.yacenko on 13.06.2017.
 */
public class LogOutCommand implements ActionCommand {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogOutCommand.class);

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession(false);
        if (session != null) {
            LOGGER.info(String.format("User logout: %s, role: %s",
                    session.getAttribute("user"), session.getAttribute("role")));
            session.invalidate();
        }

        return PageURL.LOGIN_PAGE;
    }
}
