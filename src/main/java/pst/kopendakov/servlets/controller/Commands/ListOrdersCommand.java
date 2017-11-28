package pst.kopendakov.servlets.controller.Commands;


import pst.kopendakov.dbService.dao.impl.OrdersDaoImpl;
import pst.kopendakov.dbService.dao.impl.UserDaoImpl;
import pst.kopendakov.dbService.hibernate.models.TblOneRecordEntity;
import pst.kopendakov.dbService.hibernate.models.TblUserEntity;
import pst.kopendakov.servlets.controller.ActionCommand;
import pst.kopendakov.servlets.controller.PageURL;
import pst.kopendakov.servlets.model.UserRole;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by b.yacenko on 13.06.2017.
 */
public class ListOrdersCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        UserDaoImpl userDao = new UserDaoImpl();
        HttpSession session = req.getSession(false);
        String strReturn = "";

        long userId = (long) session.getAttribute("user_id");

        TblUserEntity user =  userDao.getUserById(userId);

        UserRole role = (UserRole) session.getAttribute("role");

        if (role == UserRole.user){
            strReturn = PageURL.LIST_ORDER_USER;
//            strReturn = PageURL.LIST_ORDER_BOSS;

            String strAttribute = BuildOrderSingleTable(user);
        }else
        {
            strReturn = PageURL.LIST_ORDER_BOSS;
        }
        String strAttribute = BuildOrderSingleTable(user);



        req.setAttribute("orderTableRows", strAttribute);
        return strReturn;
    }

    private String BuildOrderSingleTable(TblUserEntity user) throws IOException {
        String retOrderTable = "";
        StringBuilder  my = new StringBuilder("");

        OrdersDaoImpl ordersDao = new OrdersDaoImpl();


        //эта дикая конструкция получает текущее время
////        java.util.Date jutilDate = new java.util.Date();
////        java.sql.Date jsqlDate = new Date(new java.util.Date().getTime());
        List<TblOneRecordEntity> tblOneRecordEntity = ordersDao.getAll(new Date(new java.util.Date().getTime()), user.getTblCehEntity());

        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
//        String text = df.format(date);

        for(TblOneRecordEntity oneRecordEntity :tblOneRecordEntity){
            my.append("<tr><td>");
//            String strData = oneRecordEntity.getDateRec().toString().fo;
            my.append(df.format(oneRecordEntity.getDateRec()));
            my.append("</td><td>");
            my.append(oneRecordEntity.getNariad());
            my.append("</td><td>");
            my.append(oneRecordEntity.getRaspor());
            my.append("</td><td>");
            my.append(oneRecordEntity.getCount());
            my.append("</td><td>");
            my.append(oneRecordEntity.getPodrForm());
            my.append("</td><td>");
            my.append(oneRecordEntity.getPodrCount());
            my.append("</td></tr>\n");
        }

//        List<TblOneRecordEntity> tblOneRecordEntity = ordersDao.getAll(0,0);


        //        List<TblOneRecordEntity> tblOneRecordEntity = new ArrayList<>();
//        tblOneRecordEntity.addAll(user.getTblCehEntity().getTblOneRecordEntities());

                //(List<TblOneRecordEntity>) user.getTblCehEntity().getTblOneRecordEntities();
        return my.toString();
    }
}