package pst.kopendakov.dbService.dao.impl;

import pst.kopendakov.dbService.dao.abstractClasses.AbstractDao;
import pst.kopendakov.dbService.hibernate.models.TblCehEntity;

import javax.persistence.EntityManager;

public class CehDaoImpl  extends AbstractDao<TblCehEntity> {

    private EntityManager entityManager = null;

    public CehDaoImpl(Class<TblCehEntity> type){
        super(TblCehEntity.class);
    }

}
