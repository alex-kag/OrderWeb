package pst.kopendakov.dbService.dao.impl;

import pst.kopendakov.dbService.dao.AbstractDao;
import pst.kopendakov.dbService.hibernate.models.TblUserEntity;

import javax.persistence.EntityManager;

public class UserDaoImpl extends AbstractDao<TblUserEntity>{

    private EntityManager entityManager = null;

    public UserDaoImpl(Class<TblUserEntity> type){
        super(type);
    }

}
