package com.mustafa.assign2.dao;  
/**
 * @author Mustafa Udegadhwala
 * @version 1
 * @description This is the DoctorDao class where  we are storing all the database queries.
 */
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;  
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;

import com.mustafa.assign2.beans.Doctor;  
  
public class DoctorDao {  
JdbcTemplate template;  
  
public void setTemplate(JdbcTemplate template) {  
    this.template = template;  
}  
public int save(Doctor p){  
    String sql="insert into Doctor(name,salary,designation) values('"+p.getName()+"',"+p.getSalary()+",'"+p.getDesignation()+"')";  
    return template.update(sql);  
}  
public int update(Doctor p){  
    String sql="update Doctor set name='"+p.getName()+"', salary="+p.getSalary()+",designation='"+p.getDesignation()+"' where id="+p.getId()+"";  
    return template.update(sql);  
}  
public int delete(int id){  
    String sql="delete from Doctor where id="+id+"";  
    return template.update(sql);  
}  
public Doctor getDoctorById(int id){  
    String sql="select * from Doctor where id=?";  
    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Doctor>(Doctor.class));  
}  
public List<Doctor> getDoctors(){  
    return template.query("select * from Doctor",new RowMapper<Doctor>(){  
        public Doctor mapRow(ResultSet rs, int row) throws SQLException {  
            Doctor e=new Doctor();  
            e.setId(rs.getInt(1));  
            e.setName(rs.getString(2));  
            e.setSalary(rs.getFloat(3));  
            e.setDesignation(rs.getString(4));  
            return e;  
        }  
    });  
}  
}  