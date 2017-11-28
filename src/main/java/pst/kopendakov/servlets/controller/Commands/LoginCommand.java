package pst.kopendakov.servlets.controller.Commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pst.kopendakov.dbService.dao.AuthorizationDao;
import pst.kopendakov.dbService.dao.impl.UserDaoImpl;
import pst.kopendakov.dbService.hibernate.models.TblUserEntity;
import pst.kopendakov.servlets.controller.ActionCommand;
import pst.kopendakov.servlets.controller.PageURL;
import pst.kopendakov.servlets.model.UserRole;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by b.yacenko on 13.06.2017.
 */
public class LoginCommand implements ActionCommand {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginCommand.class);

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        UserRole role = null;

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (login==null || password==null){
            return PageURL.LOGIN_PAGE;
        }

        AuthorizationDao dao = new AuthorizationDao();

        TblUserEntity tblUserEntity = dao.checkAccess(login, password);

        if(null!=tblUserEntity){
            role = dao.getRole(tblUserEntity.getTblCehEntity().getIdCeh());
        }
        if (role!=null) {
            HttpSession session = req.getSession();
            session.setAttribute("user", login);
            session.setAttribute("user_id", dao.getUserId(login));
            session.setAttribute("role", role);
            session.setMaxInactiveInterval(30 * 60);
            //добавлено мной
            session.setAttribute("userCeh",tblUserEntity.getTblCehEntity().getCehName());
            LOGGER.info(String.format("Login successfull: login = %s, role: %s", login, session.getAttribute("role")));
            return PageURL.LIST_WORKTASK_ACTION;
        } else {
            LOGGER.info(String.format("Login unsuccessfull: login = %s, password: %s.", login, password));
            return PageURL.LOGIN_PAGE;
        }
    }
}
