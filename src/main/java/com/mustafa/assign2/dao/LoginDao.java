package com.mustafa.assign2.dao; 
/**
 * @author Mustafa Udegadhwala
 * @version 1
 * @description This is the LoginDao class where  we are storing all the database queries.
 */
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;  
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;

import com.mustafa.assign2.beans.Login;  
  
public class LoginDao {  
JdbcTemplate template;  
  
public void setTemplate(JdbcTemplate template) {  
    this.template = template;  
}  
public int save(Login p){  
    String sql="insert into Login(name,userid,password) values('"+p.getName()+"','"+p.getUserId()+"','"+p.getPassword()+"')";  
    return template.update(sql);  
}  
public int update(Login p){  
    String sql="update Login set name='"+p.getName()+"', userid='"+p.getUserId()+"',password='"+p.getPassword()+"' where id="+p.getId()+"";  
    return template.update(sql);  
}  
public int delete(int id){  
    String sql="delete from Login where id="+id+"";  
    return template.update(sql);  
}  
public Login getloginById(int id){  
    String sql="select * from Login where id=?";  
    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Login>(Login.class));  
}  
public List<Login> getlogins(){  
    return template.query("select * from Login",new RowMapper<Login>(){  
        public Login mapRow(ResultSet rs, int row) throws SQLException {  
            Login e=new Login();  
            e.setId(rs.getInt(1));  
            e.setName(rs.getString(2));  
            e.setUserId(rs.getString(3));  
            e.setPassword(rs.getString(4));  
            return e;  
        }  
    });  
}  
}  