package com.mustafa.assign2.beans;  

/**
 * @author Mustafa Udegadhwala
 * @version 1
 * @description This is the Doctor class where  we are storing the getter and setter methods for Doctor variables.
 */

//Doctor class
public class Doctor {  
//Declaring Variables
private int id;  
private String name;  
private float salary;  
private String designation;  
  
//Declaring Getter and Setter Methods
public int getId() {  
    return id;  
}  
public void setId(int id) {  
    this.id = id;  
}  
public String getName() {  
    return name;  
}  
public void setName(String name) {  
    this.name = name;  
}  
public float getSalary() {  
    return salary;  
}  
public void setSalary(float salary) {  
    this.salary = salary;  
}  
public String getDesignation() {  
    return designation;  
}  
public void setDesignation(String designation) {  
    this.designation = designation;  
}  
  
}  