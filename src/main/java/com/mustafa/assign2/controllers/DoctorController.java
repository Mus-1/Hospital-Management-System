package com.mustafa.assign2.controllers;  
/**
 * @author Mustafa Udegadhwala
 * @version 1
 * @description This is the DoctorController class where  we are doing all the mapping.
 */
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;

import com.mustafa.assign2.beans.Doctor;
import com.mustafa.assign2.dao.DoctorDao;  
@Controller  
public class DoctorController {  
    @Autowired  
    DoctorDao dao;//will inject dao from xml file  
      
    /*It displays a form to input data, here "command" is a reserved request attribute 
     *which is used to display object data into form 
     */  
    @RequestMapping("/doctorform")  
    public String showform(Model m){  
    	m.addAttribute("command", new Doctor());
    	return "doctorform"; 
    }  
    /*It saves object into database. The @ModelAttribute puts request data 
     *  into model object. You need to mention RequestMethod.POST method  
     *  because default request is GET*/  
    @RequestMapping(value="/saveDoctor",method = RequestMethod.POST)  
    public String save(@ModelAttribute("doctor") Doctor doctor){  
        dao.save(doctor);  
        return "redirect:/viewdoctor";//will redirect to viewdoctor request mapping  
    }  
    /* It provides list of employees in model object */  
    @RequestMapping("/viewdoctor")  
    public String viewdoctor(Model m){  
        List<Doctor> list=dao.getDoctors();  
        m.addAttribute("list",list);
        return "viewdoctor";  
    }  
    /* It displays object data into form for the given id.  
     * The @PathVariable puts URL data into variable.*/  
    @RequestMapping(value="/editdoctor/{id}")  
    public String edit(@PathVariable int id, Model m){  
        Doctor doctor=dao.getDoctorById(id);  
        m.addAttribute("command",doctor);
        return "doctoreditform";  
    }  
    /* It updates model object. */  
    @RequestMapping(value="/editsaveDoctor",method = RequestMethod.POST)  
    public String editsave(@ModelAttribute("doctor") Doctor doctor){  
        dao.update(doctor);  
        return "redirect:/viewdoctor";  
    }  
    /* It deletes record for the given id in URL and redirects to /viewdoctor */  
    @RequestMapping(value="/deletedoctor/{id}",method = RequestMethod.GET)  
    public String delete(@PathVariable int id){  
        dao.delete(id);  
        return "redirect:/viewdoctor";  
    }   
}  