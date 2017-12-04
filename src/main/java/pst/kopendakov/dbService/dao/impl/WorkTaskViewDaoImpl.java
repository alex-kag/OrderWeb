package pst.kopendakov.dbService.dao.impl;


import pst.kopendakov.dbService.dao.abstractClasses.AbstractDao;
import pst.kopendakov.servlets.model.WorkTaskView;

import java.io.IOException;
import java.util.List;

/**
 * Created by proton2 on 03.06.2017.
 */
public class WorkTaskViewDaoImpl extends AbstractDao<WorkTaskView> {

    private static WorkTaskViewDaoImpl crudDAO;

    private WorkTaskViewDaoImpl(Class<WorkTaskView> type) {
        super(type);
    }

    public static synchronized WorkTaskViewDaoImpl getInstance() {
        if (crudDAO == null) {
            crudDAO = new WorkTaskViewDaoImpl(WorkTaskView.class);
        }
        return crudDAO;
    }

    public List<WorkTaskView> getListById(Long itemId) throws IOException {
//        String getListById = SqlXmlReader.getQuerryStr(getType().getSimpleName(), "getUserWorkTasks");
        List<WorkTaskView> result = null;
//        try (Connection conn = getDataSource().getConnection();
//             PreparedStatement ps = conn.prepareStatement(getListById, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);) {
//            ps.setLong(1, itemId);
//            ResultSet rs = ps.executeQuery();
//
//            ResultSetMapper<WorkTaskView> resultSetMapper = new ResultSetMapper<>();
//            result = resultSetMapper.mapRersultSetToList(rs, WorkTaskView.class);
//            rs.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new IOException(e.getMessage());
//        }

        return result;
    }
}
