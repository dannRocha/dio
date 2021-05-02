package databaseconn.entity;

import java.time.LocalDate;


public class Client {
  private String name;
  private String email; 
  private Boolean enable;
  private LocalDate date;

  public Client() {}
  public Client(String name, String email, Boolean enable, LocalDate date) {
    setName(name);
    setEmail(email);
    setEnable(enable);
    setDate(date);
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public Boolean getEnable() {
    return enable;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setEnable(Boolean enable) {
    this.enable = enable;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }
}