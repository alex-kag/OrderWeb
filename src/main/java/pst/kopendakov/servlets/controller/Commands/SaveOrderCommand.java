package pst.kopendakov.servlets.controller.Commands;

import pst.kopendakov.dbService.hibernate.models.TblOneRecordEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SaveOrderCommand implements pst.kopendakov.servlets.controller.ActionCommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String button = req.getParameter("button");

        String dateRec = req.getParameter("dateRec");
        String nariad = req.getParameter("nariad");
        String raspor = req.getParameter("raspor");
        String count = req.getParameter("count");
        String podrForm = req.getParameter("podrForm");
        String podrCount = req.getParameter("podrCount");

        //именно такой формат мы получаем на входе из формы
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateInString = "17-01-2013";


        try {
            java.util.Date da = formatter.parse(dateInString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

//        Date da = new Date(new java.util.Date().getTime();
//                TblOneRecordEntity oneRecordEntity = new TblOneRecordEntity();
//        oneRecordEntity.setDateRec(new Date(dateRec));

        return null;
    }
}
