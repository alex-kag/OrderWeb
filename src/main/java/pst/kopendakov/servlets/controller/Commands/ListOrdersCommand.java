package pst.kopendakov.servlets.controller.Commands;


import pst.kopendakov.dbService.dao.impl.CehDaoImpl;
import pst.kopendakov.dbService.dao.impl.OrdersDaoImpl;
import pst.kopendakov.dbService.dao.impl.UserDaoImpl;
import pst.kopendakov.dbService.hibernate.models.TblCehEntity;
import pst.kopendakov.dbService.hibernate.models.TblOneRecordEntity;
import pst.kopendakov.dbService.hibernate.models.TblUserEntity;
import pst.kopendakov.servlets.controller.ActionCommand;
import pst.kopendakov.servlets.controller.PageURL;
import pst.kopendakov.servlets.model.RecordLevel2;
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

        if (role == UserRole.user){
            strReturn = PageURL.LIST_ORDER_USER;
            BuildOrderSingleTable(user,req);
        }else
        {
            strReturn = PageURL.LIST_ORDER_BOSS;

            BuildOrderBossTable(user,req);
        }



        req.setAttribute("orderTableRows", strAttribute);
        return strReturn;
    }

    //генерация полной таблицы
    private void BuildOrderBossTable(TblUserEntity user, HttpServletRequest req)  throws IOException {
        OrdersDaoImpl ordersDao = new OrdersDaoImpl(TblOneRecordEntity.class);
        Date firstDate = new Date(new java.util.Date().getTime());
        List<TblOneRecordEntity> tblOneRecordEntity = ordersDao.getBossAll(firstDate);

        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        Calendar cal = Calendar.getInstance();

        ArrayList<TblOneRecordEntity> recordLevel1 = new ArrayList<>();
//        ArrayList<RecordLevel2>




    }

    //генерация списка для одного единственного пользователя
    private void BuildOrderSingleTable(TblUserEntity user, HttpServletRequest req) throws IOException {

        OrdersDaoImpl ordersDao = new OrdersDaoImpl(TblOneRecordEntity.class);

        //эта дикая конструкция получает текущее время
////        java.util.Date jutilDate = new java.util.Date();
////        java.sql.Date jsqlDate = new Date(new java.util.Date().getTime());

        //текущая дата (на самом деле надо брать около нее, а не точно нее)
        Date firstDate = new Date(new java.util.Date().getTime());

        List<TblOneRecordEntity> tblOneRecordEntity = ordersDao.getOneCehAll(firstDate, user.getTblCehEntity());

        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        Calendar cal = Calendar.getInstance();

        ArrayList<TblOneRecordEntity> recordEntities = new ArrayList<>();

        recordEntities.add(tblOneRecordEntity.get(0));

        TblOneRecordEntity tempRecord = reFillTempRecord(user);


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