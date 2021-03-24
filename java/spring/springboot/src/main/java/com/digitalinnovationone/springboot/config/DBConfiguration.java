package com.digitalinnovationone.springboot.config;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
@ConfigurationProperties("spring.datasource")
@Getter // Adicionar Getters e Setters na classe 'lib: lombok'
@Setter // Adicionar Getters e Setters na classe 'lib: lombok'
public class DBConfiguration {

  private String driverClassName;
  private String url;
  private String username;
  private String password;

  @Profile("dev")
  @Bean // Mostrar no log de incialização do programa
  public String developmentDatabaseConnection() {
    System.out.println("DB conecção para DEV - H2");
    System.out.println(driverClassName);
    System.out.println(url);
    return "DB coneção para DEV - H2 - Teste de instancia";
  }
  @Profile("pro")
  @Bean
  public String ProductionDatabaseConnection() {
    System.out.println("DB conecção para PRODUCAO");
    System.out.println(driverClassName);
    System.out.println(url);
    return "DB coneção para PRODUÇÂO MYSQL- Tes te de instancia";
  }


  public String getDriverClassName() {
    return this.driverClassName;
  }

  public void setDriverClassName(String driverClassName) {
    this.driverClassName = driverClassName;
  }

  public String getUrl() {
    return this.url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  
}
