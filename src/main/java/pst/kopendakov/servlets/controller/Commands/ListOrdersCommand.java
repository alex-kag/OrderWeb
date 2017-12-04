package pst.kopendakov.servlets.controller.Commands;


import pst.kopendakov.dbService.dao.impl.CehDaoImpl;
import pst.kopendakov.dbService.dao.impl.OrdersDaoImpl;
import pst.kopendakov.dbService.dao.impl.UserDaoImpl;
import pst.kopendakov.dbService.hibernate.models.TblCehEntity;
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
import java.util.Calendar;
import java.util.List;

/**
 * Created by b.yacenko on 13.06.2017.
 */
public class ListOrdersCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        UserDaoImpl userDao = new UserDaoImpl(TblUserEntity.class);
        HttpSession session = req.getSession(false);
        String strReturn = "";

        long userId = (long) session.getAttribute("user_id");

        TblUserEntity user =  userDao.getById(userId);

        UserRole role = (UserRole) session.getAttribute("role");
        String strAttribute = "";


//      AddCeh();


        if (role == UserRole.user){
            strReturn = PageURL.LIST_ORDER_USER;
//            strReturn = PageURL.LIST_ORDER_BOSS;

//            strAttribute =
            BuildOrderSingleTable(user,req);
        }else
        {
            strReturn = PageURL.LIST_ORDER_BOSS;
//            strAttribute =

            BuildOrderSingleTable(user,req);
        }



        req.setAttribute("orderTableRows", strAttribute);
        return strReturn;
    }

    private void AddCeh() {
        TblCehEntity tblCehEntity = new TblCehEntity();

        CehDaoImpl cehDao = new CehDaoImpl(TblCehEntity.class);

        tblCehEntity.setCehName("хреновый цех1");
//        tblCehEntity.setIdCeh(200);


        try {
            cehDao.insert(tblCehEntity);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void BuildOrderSingleTable(TblUserEntity user, HttpServletRequest req) throws IOException {
        String retOrderTable = "";
        StringBuilder  my = new StringBuilder("");

        OrdersDaoImpl ordersDao = new OrdersDaoImpl(TblOneRecordEntity.class);


        //эта дикая конструкция получает текущее время
////        java.util.Date jutilDate = new java.util.Date();
////        java.sql.Date jsqlDate = new Date(new java.util.Date().getTime());
        List<TblOneRecordEntity> tblOneRecordEntity = ordersDao.getOneCehAll(new Date(new java.util.Date().getTime()), user.getTblCehEntity());

        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        Calendar cal = Calendar.getInstance();
//        cal.add(Calendar.DATE,1);

//        String text = df.format(date);

        ArrayList<TblOneRecordEntity> recordEntities = new ArrayList<>();

        recordEntities.add(tblOneRecordEntity.get(0));

        TblOneRecordEntity tempRecord = reFillTempRecord(user);
//                new TblOneRecordEntity();
//        tempRecord.setTblCehEntity(user.getTblCehEntity());
//        tempRecord.setNariad(0);
//        tempRecord.setRaspor(0);
//        tempRecord.setCount(0);
//        tempRecord.setPodrForm(0);
//        tempRecord.setPodrCount(0);
//        tempRecord.setIdOneRecord(-1);


        for(TblOneRecordEntity oneRecordEntity :tblOneRecordEntity){

            cal.setTime(recordEntities.get(recordEntities.size()-1).getDateRec());
            cal.add(cal.DATE,-1);

            while (cal.getTime().getTime() > oneRecordEntity.getDateRec().getTime()){
                cal.setTime(recordEntities.get(recordEntities.size()-1).getDateRec());
                cal.add(cal.DATE,-1);
                tempRecord = reFillTempRecord(user);
                tempRecord.setDateRec(new Date(cal.getTime().getTime()));
                recordEntities.add(tempRecord);
                cal.add(cal.DATE,-1);
            }

            if (recordEntities.get(recordEntities.size()-1).getDateRec().getTime() !=
                    oneRecordEntity.getDateRec().getTime()){
                recordEntities.add(oneRecordEntity);
            }

        }

        req.setAttribute("listRecords",recordEntities);



//        for(TblOneRecordEntity oneRecordEntity :tblOneRecordEntity){
//            my.append("<tr><td>");
////            String strData = oneRecordEntity.getDateRec().toString().fo;
//            my.append(df.format(oneRecordEntity.getDateRec()));
//            my.append("</td><td>");
//            my.append(oneRecordEntity.getNariad());
//            my.append("</td><td>");
//            my.append(oneRecordEntity.getRaspor());
//            my.append("</td><td>");
//            my.append(oneRecordEntity.getCount());
//            my.append("</td><td>");
//            my.append(oneRecordEntity.getPodrForm());
//            my.append("</td><td>");
//            my.append(oneRecordEntity.getPodrCount());
//            my.append("</td><td>");
//            my.append("<a href = \"");
//            my.append("WorkTaskController?action=edit_order&id=");
//            my.append(oneRecordEntity.getIdOneRecord());
//            my.append("\">Редактировать</a>");
//            my.append("</td></tr>\n");
//        }

//        List<TblOneRecordEntity> tblOneRecordEntity = ordersDao.getAll(0,0);


        //        List<TblOneRecordEntity> tblOneRecordEntity = new ArrayList<>();
//        tblOneRecordEntity.addAll(user.getTblCehEntity().getTblOneRecordEntities());

                //(List<TblOneRecordEntity>) user.getTblCehEntity().getTblOneRecordEntities();
//        return my.toString();
    }

    private TblOneRecordEntity reFillTempRecord(TblUserEntity user) {
        TblOneRecordEntity tempRecord = new TblOneRecordEntity();
        tempRecord.setTblCehEntity(user.getTblCehEntity());
        tempRecord.setNariad(0);
        tempRecord.setRaspor(0);
        tempRecord.setCount(0);
        tempRecord.setPodrForm(0);
        tempRecord.setPodrCount(0);
        tempRecord.setIdOneRecord(-1);

        return tempRecord;
    }
}