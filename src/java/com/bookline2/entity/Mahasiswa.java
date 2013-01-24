/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookline2.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author black
 */
@Entity
public class Mahasiswa {
    
    @Id
    @NotEmpty
    private String nim;
    
    @Length(max=50)
    @NotEmpty
    private String nama;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date tanggal_lahir;
    
    @NotEmpty
    private String jurusan;
    
    @NotEmpty
    @Email
    private String email;
    
    @NotEmpty
    private String alamat;
    
    public Date getTanggal_lahir(){
        return tanggal_lahir;
    }
    
    public void setTanggal_lahir(Date tanggal_lahir)
    {
        this.tanggal_lahir = tanggal_lahir;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public String getAlamat()
    {
        return alamat;
    }
    
    public void setAlamat(String alamat)
    {
        this.alamat = alamat;
    }
    
    public String getNim()
    {
        return nim;
    }
    
    public void setNim(String nim)
    {
        this.nim = nim;
    }
    
    public String getJurusan()
    {
        return jurusan;
    }
    
    public void setJurusan(String jurusan)
    {
        this.jurusan = jurusan;
    }
    
    public String getNama()
    {
        return nama;
    }
    
    public void setNama(String nama)
    {
        this.nama = nama;
    }
}
