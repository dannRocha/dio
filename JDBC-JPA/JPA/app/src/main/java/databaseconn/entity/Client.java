package databaseconn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name="cliente")
public class Client {
  
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="numero")
  private Integer id;

  @Column(name="nome", nullable = false)
  private String name;

  @Column
  private String email;

  @Column(name="ativo")
  private Boolean enable;

  @Column(name="data_criacao")
  private Date date;

  public Client(){}
  
  public Client(String name, String email) {
    setName(name);
    setName(email);
  }

  public Client(String name, String email, Boolean enable) {
    setName(name);
    setName(email);
    setEnable(enable);
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

  public Date getDate() {
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

  public void setDate(Date date) {
    this.date = date;
  }
}