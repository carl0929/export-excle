package com.hhawking.excel.demo.entity;


import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

  private static final long serialVersionUID = -7667731907035360603L;
  private String id;
  private String phone;
  private String name;
  private String passWord;
  private Date registrationDate;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getPassWord() {
    return passWord;
  }

  public void setPassWord(String passWord) {
    this.passWord = passWord;
  }


  public Date getRegistrationDate() {
    return registrationDate;
  }

  public void setRegistrationDate(Date registrationDate) {
    this.registrationDate = registrationDate;
  }

}
