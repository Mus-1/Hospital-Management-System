package com.mustafa.assign2.controllers;  
/**
 * @author Mustafa Udegadhwala
 * @version 1
 * @description This is the LoginController class where  we are doing all the mapping.
 */
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;

import com.mustafa.assign2.beans.Login;
import com.mustafa.assign2.dao.LoginDao;  
@Controller  
public class LoginController {  
    @Autowired  
    LoginDao dao2;//will inject dao from xml file  
      
    /*It displays a form to input data, here "command" is a reserved request attribute 
     *which is used to display object data into form 
     */  
    @RequestMapping("/loginForm")  
    public String showform(Model m){  
    	m.addAttribute("command", new Login());
    	return "loginForm"; 
    }  
    /*It saves object into database. The @ModelAttribute puts request data 
     *  into model object. You need to mention RequestMethod.POST method  
     *  because default request is GET*/  
    @RequestMapping(value="/SaveLogin",method = RequestMethod.POST)  
    public String save(@ModelAttribute("Login") Login emp){  
        dao2.save(emp);  
        return "redirect:/viewLogin";//will redirect to viewLogin request mapping  
    }  
    /* It provides list of logins in model object */  
    @RequestMapping("/viewLogin")  
    public String viewLogin(Model m){  
        List<Login> list=dao2.getlogins();  
        m.addAttribute("list",list);
        return "viewLogin";  
    }  
    /* It displays object data into form for the given id.  
     * The @PathVariable puts URL data into variable.*/  
    @RequestMapping(value="/editLogin/{id}")  
    public String edit(@PathVariable int id, Model m){  
        Login emp=dao2.getloginById(id);  
        m.addAttribute("command",emp);
        return "logineditform";  
    }  
    /* It updates model object. */  
    @RequestMapping(value="/EditSaveLogin",method = RequestMethod.POST)  
    public String editsave(@ModelAttribute("Login") Login emp){  
        dao2.update(emp);  
        return "redirect:/viewLogin";  
    }  
    /* It deletes record for the given id in URL and redirects to /viewLogin */  
    @RequestMapping(value="/deleteLogin/{id}",method = RequestMethod.GET)  
    public String delete(@PathVariable int id){  
        dao2.delete(id);  
        return "redirect:/viewLogin";  
    }   
}  