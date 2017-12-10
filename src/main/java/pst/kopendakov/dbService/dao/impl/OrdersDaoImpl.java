package pst.kopendakov.dbService.dao.impl;

import pst.kopendakov.dbService.dao.abstractClasses.AbstractDao;
import pst.kopendakov.dbService.hibernate.models.TblCehEntity;
import pst.kopendakov.dbService.hibernate.models.TblOneRecordEntity;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

public class OrdersDaoImpl extends AbstractDao<TblOneRecordEntity>{

    private EntityManager entityManager = null;

    public OrdersDaoImpl(Class<TblOneRecordEntity> type){
        super(TblOneRecordEntity.class);
        entityManager = getEntityManager();
    }

    public List<TblOneRecordEntity> getOneCehAll(Date data, TblCehEntity tblCehEntity) throws IOException {
        List<TblOneRecordEntity> result = entityManager.createQuery(
                "SELECT o from TblOneRecordEntity o " +
                        "WHERE o.tblCehEntity = :ceh " +
                        "order by o.dateRec desc " )
                .setParameter("ceh",tblCehEntity)
                .getResultList();

        return result;
    }

    public List<TblOneRecordEntity> getBossAll(Date data ) throws IOException {
        List<TblOneRecordEntity> result = entityManager.createQuery(
                "SELECT o from TblOneRecordEntity o " +
                        "WHERE o.tblCehEntity = :ceh " +
                        "order by o.dateRec desc " +
                        ", o.tblCehEntity.idCeh asc")
                .getResultList();

        return result;
    }
}
