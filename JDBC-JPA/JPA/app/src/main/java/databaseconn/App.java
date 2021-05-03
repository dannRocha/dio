/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package databaseconn;

import databaseconn.entity.Client;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager ;
import javax.persistence.Persistence;

import java.util.Optional;


public class App {

    // Criar o gerenciador de entidades
    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("financas");
    static EntityManager entityManager = entityManagerFactory.createEntityManager();
    
    public static void main(String[] args) {

      persistExample();
      findExample();
      updateExample();
      removeExample();
      
      entityManager.close();
      entityManagerFactory.close();
    }


    public static void persistExample() {

      var client = new Client("Daniel Rocha Rocha", "danielrocharocha@rocha.com.br");

      entityManager.getTransaction().begin();  // Inicia a transação no banco de dados;
      entityManager.persist(client);           // Persiste dados no banco de dados;
      entityManager.getTransaction().commit(); // Concleta a transação no banco de dados;

    }


    public static void findExample() {
      
      // Client client = entityManager.find(Client.class, 502L);
      Optional<Client> optionalClient = Optional.ofNullable(
        entityManager.find(Client.class, 502L)
      );

      if(optionalClient.isEmpty()) return;

      Client client = optionalClient.get();

      System.out.println("---------------------------------------");
      System.out.println("  ID       : " + client.getId());
      System.out.println("  NAME     : " + client.getName());
      System.out.println("  EMAIL    : " + client.getEmail());
      System.out.println("  ENABLE   : " + client.getEnable());
      System.out.println("  CREATE AT: " + client.getCreateAt());
      System.out.println("---------------------------------------");
    }


    public static void updateExample() {

      Optional<Client> optionalClient = Optional.ofNullable(
        entityManager.find(Client.class, 502L)
      );

      if(optionalClient.isEmpty()) return;

      Client client = optionalClient.get();
      
      entityManager.getTransaction().begin();
      client.setName("Daniel Rocha da Silva");
      client.setEmail("danielrochadasilva@drsilva.com");
      entityManager.getTransaction().commit();

    }


    public static void removeExample() { 

      Optional<Client> optionalClient = Optional.ofNullable(
        entityManager.find(Client.class, 502L)
      );

      if(optionalClient.isEmpty()) return;

      Client client = optionalClient.get();
      
      entityManager.getTransaction().begin();
      entityManager.remove(client);
      entityManager.getTransaction().commit();
    }
}
