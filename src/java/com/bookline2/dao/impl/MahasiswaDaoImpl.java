/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookline2.dao.impl;

import com.bookline2.dao.MahasiswaDAO;
import com.bookline2.entity.Mahasiswa;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author black
 */
@Repository
@Transactional(readOnly=true, propagation= Propagation.REQUIRED)
public class MahasiswaDaoImpl implements MahasiswaDAO{
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional(readOnly=false)
    public void saveOrUpdate(Mahasiswa mahasiswa) {
        sessionFactory.getCurrentSession().saveOrUpdate(mahasiswa);
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    
    @Override
    @Transactional(readOnly=false)
    public void delete(Mahasiswa mahasiswa) {
        sessionFactory.getCurrentSession().delete(mahasiswa);
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Mahasiswa getNim(String nim) {
        return (Mahasiswa) sessionFactory.getCurrentSession().createQuery("from Mahasiswa where nim = :nim").setParameter("NIM", nim).uniqueResult();
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Mahasiswa> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Mahasiswa").list();
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
