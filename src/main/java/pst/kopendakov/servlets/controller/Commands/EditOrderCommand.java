package pst.kopendakov.servlets.controller.Commands;

import pst.kopendakov.dbService.dao.impl.OrdersDaoImpl;
import pst.kopendakov.dbService.hibernate.models.TblOneRecordEntity;
import pst.kopendakov.servlets.controller.PageURL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;


public class EditOrderCommand implements pst.kopendakov.servlets.controller.ActionCommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String ret ="";

//        String button = req.getParameter("button");
//
//        String dateRec = req.getParameter("dateRec");
//        String nariad = req.getParameter("nariad");
//        String raspor = req.getParameter("raspor");
//        String count = req.getParameter("count");
//        String podrForm = req.getParameter("podrForm");
//        String podrCount = req.getParameter("podrCount");

//        Надо получить завтрашнее число.

//        Calendar cal = Calendar.getInstance();
//        cal.add(Calendar.DATE,1);
//        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
//        String str = sdf.format(cal.getTime());
//        Date newDate = new Date(cal.getTime().getTime());


        //именно такой формат мы получаем на входе из формы
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        String dateInString = "17-01-2013";

//        TblOneRecordEntity tblOneRecord= new TblOneRecordEntity();
//        tblOneRecord.setDateRec(newDate);


        OrdersDaoImpl ordersDao = new OrdersDaoImpl(TblOneRecordEntity.class);
        String strId = req.getParameter("id");
        if (!strId.isEmpty()){
            try {
                long id = Long.parseLong(strId);
                TblOneRecordEntity tblOneRecord = ordersDao.getById(id);
                req.setAttribute("tblOneRecord",tblOneRecord);
                ret = PageURL.EDIT_ORDERRECORD;

            }
            catch (Exception e){
                ret = PageURL.LIST_ORDER_ACTION;
            }
        }

//        try {
//            java.util.Date da = formatter.parse(dateInString);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

//        Date da = new Date(new java.util.Date().getTime();
//                TblOneRecordEntity oneRecordEntity = new TblOneRecordEntity();
//        oneRecordEntity.setDateRec(new Date(dateRec));

        return ret;
    }
}
