package projeto.azure.jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class AzureSpringCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(AzureSpringCloudApplication.class, args);
	}

  @Bean
  public BCryptPasswordEncoder bCryptPasswordEncoder(){
    return new BCryptPasswordEncoder();
  }

}
