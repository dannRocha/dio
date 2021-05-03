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
import java.math.BigInteger;



@Entity
@Table(name="cliente_transacoes")
public class Transaction {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;

  @Column(name="banco_numero", nullable = false)
  private Integer bankNumber;

  @Column(name="conta_corrente_numero", nullable = false)
  private Long ccNumber;

  @Column(name="conta_corrente_digito", nullable = false)
  private Short ccDigit;

  @Column(name="cliente_numero", nullable = false)
  private Long clientNumber;

  @Column(name="tipo_transacao_id", nullable = false)
  private Short typeTransaction;

  @Column(name="valor", nullable = false)
  private BigInteger value;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name="data_criacao", nullable = false)
  private Date createAt;

  public Long getId() {
    return id;
  }

  public Integer getBankNumber() {
    return bankNumber;
  }

  public Long getCCNumber() {
    return ccNumber;
  }

  public Short getCCDigit() {
    return ccDigit;
  }

  public Long getClientNumber() {
    return clientNumber;
  }

  public Short getTypeTransaction() {
    return typeTransaction;
  }

  public BigInteger getValue() {
    return value;
  }

  public Date getCreateAt() {
    return createAt;
  }


  public void setBankNumber(Integer bankNumber) {
    this.bankNumber = bankNumber;
  }

  public void setCCNumber(Long ccNumber) {
    this.ccNumber = ccNumber;
  }

  public void setCCDigit(Short ccDigit) {
    this.ccDigit = ccDigit;
  }

  public void setClientNumber(Long clientNumber) {
    this.clientNumber = clientNumber;
  }

  public void setTypeTransaction(Short typeTransaction) {
    this.typeTransaction = typeTransaction;
  }

  public void setValue(BigInteger value) {
    this.value = value;
  }

  public void setCreateAt(Date createAt) {
    this.createAt = createAt;
  }

}
