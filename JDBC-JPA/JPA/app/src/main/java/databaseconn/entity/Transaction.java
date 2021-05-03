package databaseconn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.sql.Date;


@Entity
@Table(name="cliente_transacoes")
public class Transaction {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer id;

  @Column(name="banco_numero", nullable = false)
  private Integer bankNumber;

  @Column(name="conta_corrente_numero", nullable = false)
  private Integer ccNumber;

  @Column(name="conta_corrente_digito", nullable = false)
  private Integer ccDigit;

  @Column(name="cliente_numero", nullable = false)
  private Integer clientNumber;

  @Column(name="tipo_transacao_id", nullable = false)
  private Integer typeTransaction;

  @Column(name="valor", nullable = false)
  private Double value;

  @Column(name="data_criacao", nullable = false)
  private Date createAt;

  public Integer getId() {
    return id;
  }

  public Integer getBankNumber() {
    return bankNumber;
  }

  public Integer getCCNumber() {
    return ccNumber;
  }

  public Integer getCCDigit() {
    return ccDigit;
  }

  public Integer getClientNumber() {
    return clientNumber;
  }

  public Integer getTypeTransaction() {
    return typeTransaction;
  }

  public Double getValue() {
    return value;
  }

  public Date getCreateAt() {
    return createAt;
  }


  public void setBankNumber(Integer bankNumber) {
    this.bankNumber = bankNumber;
  }

  public void setCCNumber(Integer ccNumber) {
    this.ccNumber = ccNumber;
  }

  public void setCCDigit(Integer ccDigit) {
    this.ccDigit = ccDigit;
  }

  public void setClientNumber(Integer clientNumber) {
    this.clientNumber = clientNumber;
  }

  public void setTypeTransaction(Integer typeTransaction) {
    this.typeTransaction = typeTransaction;
  }

  public void setValue(Double value) {
    this.value = value;
  }

  public void setCreateAt(Date createAt) {
    this.createAt = createAt;
  }

}
