package databaseconn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;

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

  @Temporal(TemporalType.DATE)
  @Column(name="data_criacao", nullable = false)
  private Date date;

  public Client(){}
  
  public Client(String name, String email) {
    setName(name);
    setEmail(email);
    setEnable(false);
    setDate(
      Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant())
    );

    setDate(
      Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant())
    );
  }

  public Client(String name, String email, Boolean enable) {
    setName(name);
    setEmail(email);
    setEnable(enable);
    setDate(
      Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant())
    );
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