/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookline2.controller;

import com.bookline2.dao.MahasiswaDAO;
import com.bookline2.entity.Mahasiswa;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author black
 */
@Controller
public class MahasiswaController {
    
    @Autowired
    private MahasiswaDAO mahasiswaDao;
    
    @RequestMapping(value={"/addMahasiswa","/editMahasiswa"},method=RequestMethod.GET)
    private ModelMap getMahasiswa(@RequestParam(value="nim", required=false)String nim)
    {
        Mahasiswa mahasiswa;
        if(nim == null){
            mahasiswa = new Mahasiswa();
        }else{
             mahasiswa = mahasiswaDao.getNim(nim);
        }
        return new ModelMap(mahasiswa);
    }
    
    @RequestMapping(value="/addMahasiswa", method= RequestMethod.POST)
    private String saveMahasiswa(@ModelAttribute @Valid Mahasiswa mahasiswa, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return "addMahasiwa";
        }
        mahasiswaDao.saveOrUpdate(mahasiswa);
        return "redirect:listMahasiswa";
    }
    
    @RequestMapping(value="/listMahasiswa", method= RequestMethod.GET)
    private List<Mahasiswa> getAll(@ModelAttribute Mahasiswa mahasiswa)
    {
        return mahasiswaDao.getAll();
    }
    
    @RequestMapping(value="/deleteMahasiswa", method= RequestMethod.GET)
    private String deleteMahasiswa(@ModelAttribute Mahasiswa mahasiswa)
    {
        mahasiswaDao.delete(mahasiswa);
        return "redirect:listMahasiswa";
    }
    
    @RequestMapping(value="/editMahasiswa", method= RequestMethod.POST)
    private String editMahasiswa(@ModelAttribute @Valid Mahasiswa mahasiswa, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return "editMahasiswa";
        }
        mahasiswaDao.saveOrUpdate(mahasiswa);
        return "redirect:listMahasiswa";
    }
    
}
