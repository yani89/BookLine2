/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookline2.dao;

import com.bookline2.entity.Mahasiswa;
import java.util.List;

/**
 *
 * @author black
 */
public interface MahasiswaDAO {
    
    void saveOrUpdate(Mahasiswa mahasiswa);
    
    void delete(Mahasiswa mahasiswa);
    
    Mahasiswa getNim(String nim);
    
    List<Mahasiswa> getAll();
}
