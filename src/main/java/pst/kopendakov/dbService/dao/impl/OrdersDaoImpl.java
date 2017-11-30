package pst.kopendakov.dbService.dao.impl;

import pst.kopendakov.dbService.dao.AbstractDao;
import pst.kopendakov.dbService.hibernate.HibernateUtilFactory;
import pst.kopendakov.dbService.hibernate.models.TblCehEntity;
import pst.kopendakov.dbService.hibernate.models.TblOneRecordEntity;
import pst.kopendakov.dbService.hibernate.models.TblUserEntity;

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

//    public List<TblOneRecordEntity> getAll(int offcet, int limit) throws IOException {
//        List<TblOneRecordEntity> result = entityManager.createQuery(
//                "from TblOneRecordEntity " +
//                        "order by dateRec desc , tblCehEntity.id asc " )
//                .getResultList();
//
//        return result;
//    }

    public List<TblOneRecordEntity> getOneCehAll(Date data, TblCehEntity tblCehEntity) throws IOException {
        List<TblOneRecordEntity> result = entityManager.createQuery(
                "SELECT o from TblOneRecordEntity o " +
                        "WHERE o.tblCehEntity = :ceh " +
                        "order by o.dateRec desc " )
                .setParameter("ceh",tblCehEntity)
                .getResultList();

        return result;
    }

//    public TblOneRecordEntity getOrderById(long orderId){
//        TblOneRecordEntity order = null;
//        order = (TblOneRecordEntity) entityManager.createQuery(
//                "SELECT o from TblOneRecordEntity o " +
//                        "WHERE o.id = :id" )
//                .setParameter("id",orderId)
//                .getSingleResult();
//
//        return order;
//    }

}
