package com.mustafa.assign2.controllers;   
/**
 * @author Mustafa Udegadhwala
 * @version 1
 * @description This is the PatientController class where  we are doing all the mapping.
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
import com.mustafa.assign2.beans.Patient;
import com.mustafa.assign2.dao.DoctorDao;
import com.mustafa.assign2.dao.PatientDao;  
@Controller  
public class PatientController {  
    @Autowired  
    PatientDao dao3;//will inject dao from xml file  
      
    /*It displays a form to input data, here "command" is a reserved request attribute 
     *which is used to display object data into form 
     */  
    @RequestMapping("/patientform")  
    public String showform(Model m){  
    	m.addAttribute("command", new Patient());
    	return "patientform"; 
    }  
    /*It saves object into database. The @ModelAttribute puts request data 
     *  into model object. You need to mention RequestMethod.POST method  
     *  because default request is GET*/  
    @RequestMapping(value="/savePatient",method = RequestMethod.POST)  
    public String save(@ModelAttribute("patient") Patient patient){  
        dao3.save(patient);  
        return "redirect:/viewpatient";//will redirect to viewpatient request mapping  
    }  
    /* It provides list of employees in model object */  
    @RequestMapping("/viewpatient")  
    public String viewpatient(Model m){  
        List<Patient> list=dao3.getPatients();  
        m.addAttribute("list",list);
        return "viewpatient";  
    }  
    /* It displays object data into form for the given id.  
     * The @PathVariable puts URL data into variable.*/  
    @RequestMapping(value="/editpatient/{id}")  
    public String edit(@PathVariable int id, Model m){  
        Patient patient=dao3.getPatientById(id);  
        m.addAttribute("command",patient);
        return "patienteditform";  
    }  
    /* It updates model object. */  
    @RequestMapping(value="/editsavePatient",method = RequestMethod.POST)  
    public String editsave(@ModelAttribute("patient") Patient patient){  
        dao3.update(patient);  
        return "redirect:/viewpatient";  
    }  
    /* It deletes record for the given id in URL and redirects to /viepatient */  
    @RequestMapping(value="/deletepatient/{id}",method = RequestMethod.GET)  
    public String delete(@PathVariable int id){  
        dao3.delete(id);  
        return "redirect:/viewpatient";  
    }   
}  