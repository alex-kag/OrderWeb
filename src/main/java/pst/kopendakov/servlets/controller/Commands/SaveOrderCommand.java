package pst.kopendakov.servlets.controller.Commands;

import pst.kopendakov.dbService.dao.impl.OrdersDaoImpl;
import pst.kopendakov.dbService.dao.impl.UserDaoImpl;
import pst.kopendakov.dbService.hibernate.models.TblOneRecordEntity;
import pst.kopendakov.dbService.hibernate.models.TblUserEntity;
import pst.kopendakov.servlets.controller.PageURL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SaveOrderCommand implements pst.kopendakov.servlets.controller.ActionCommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        UserDaoImpl userDao = new UserDaoImpl(TblUserEntity.class);
        HttpSession session = req.getSession(false);

        long userId = (long) session.getAttribute("user_id");

        TblUserEntity user =  userDao.getById(userId);




        String strId = req.getParameter("id");

        String dateRec = req.getParameter("dateRec");
        String nariad = req.getParameter("nariad");
        String raspor = req.getParameter("raspor");
        String count = req.getParameter("count");
        String podrForm = req.getParameter("podrForm");
        String podrCount = req.getParameter("podrCount");

        OrdersDaoImpl ordersDao = new OrdersDaoImpl(TblOneRecordEntity.class);
        TblOneRecordEntity tblOneRecord = null;

        if (!strId.equalsIgnoreCase("-1")){
            try {
                long id = Long.parseLong(strId);
                tblOneRecord = ordersDao.getById(id);
            }
            catch (Exception e){
            }
        }else{
            tblOneRecord = new TblOneRecordEntity();
        }


        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");



        java.util.Date uDate = null;
        java.sql.Date sDate = null;

        try {
            uDate =format.parse(dateRec);
            sDate = new Date(uDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }


//        tblOneRecord.setDateRec(new Date(dateRec));
        tblOneRecord.setDateRec(sDate);

        tblOneRecord.setNariad(Integer.parseInt(nariad));
        tblOneRecord.setRaspor(Integer.parseInt(raspor));
        tblOneRecord.setCount(Integer.parseInt(count));
        tblOneRecord.setPodrForm(Integer.parseInt(podrForm));
        tblOneRecord.setPodrCount(Integer.parseInt(podrCount));
        tblOneRecord.setTblCehEntity(user.getTblCehEntity());

        //именно такой формат мы получаем на входе из формы
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        String dateInString = "17-01-2013";


        if (!strId.equalsIgnoreCase("-1")){
            ordersDao.update(tblOneRecord);
        }else{
            ordersDao.insert(tblOneRecord);
        }

        return PageURL.LIST_ORDER_ACTION;


//
//        try {
//            java.util.Date da = formatter.parse(dateInString);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

//        Date da = new Date(new java.util.Date().getTime();
//                TblOneRecordEntity oneRecordEntity = new TblOneRecordEntity();
//        oneRecordEntity.setDateRec(new Date(dateRec));

//        return null;
    }
}
