package pst.kopendakov.dbService.dao.impl;

import pst.kopendakov.dbService.dao.Dao;
import pst.kopendakov.dbService.hibernate.HibernateUtilFactory;
import pst.kopendakov.dbService.hibernate.models.TblUserEntity;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.net.SocketPermission;
import java.util.List;

public class UserDaoImpl {

    private EntityManager entityManager = null;

    public UserDaoImpl(){
        entityManager = HibernateUtilFactory.getEntityManager();
    }

    public List<TblUserEntity> getAll(int offcet, int limit) throws IOException {
        List<TblUserEntity> result = entityManager.createQuery(
                "from TblUserEntity " )
                .getResultList();

        return result;
    }

    public TblUserEntity getUserById(long userId){
        TblUserEntity user = null;
        user = (TblUserEntity)entityManager.createQuery(
                "SELECT u from TblUserEntity u " +
                        "WHERE u.id = :id" )
                .setParameter("id",userId)
                .getSingleResult();

        return user;
    }

}
