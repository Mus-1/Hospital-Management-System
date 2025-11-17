package com.mustafa.assign2.dao;  
/**
 * @author Mustafa Udegadhwala
 * @version 1
 * @description This is the PatientDao class where  we are storing all the database queries.
 */
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;  
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;

import com.mustafa.assign2.beans.Doctor;
import com.mustafa.assign2.beans.Patient;  
  
public class PatientDao {  
JdbcTemplate template;  
  
public void setTemplate(JdbcTemplate template) {  
    this.template = template;  
}  
public int save(Patient p){  
    String sql="insert into patient(name,age) values('"+p.getName()+"','"+p.getAge()+"')";  
    return template.update(sql);  
}  
public int update(Patient p){  
    String sql="update patient set name='"+p.getName()+"',age='"+p.getAge()+"' where id="+p.getId()+"";  
    return template.update(sql);  
}  
public int delete(int id){  
    String sql="delete from patient where id="+id+"";  
    return template.update(sql);  
}  
public Patient getPatientById(int id){  
    String sql="select * from patient where id=?";  
    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Patient>(Patient.class));  
}  
public List<Patient> getPatients(){  
    return template.query("select * from patient",new RowMapper<Patient>(){  
        public Patient mapRow(ResultSet rs, int row) throws SQLException {  
            Patient e=new Patient();  
            e.setId(rs.getInt(1));  
            e.setName(rs.getString(2));  
            e.setAge(rs.getString(3));  
            return e;  
        }  
    });  
}  
}  