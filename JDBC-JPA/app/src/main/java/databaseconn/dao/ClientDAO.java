package databaseconn.dao;

import databaseconn.entity.Client;
import databaseconn.ConnectionFactory;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.*;



public class ClientDAO {

  public List<Client> listAll() {
    List<Client> clients = new ArrayList<>();

    try(Connection conn = ConnectionFactory.getConnection()) {

      String query = "SELECT nome, email, ativo, data_criacao FROM cliente";

      PreparedStatement stmt = conn.prepareStatement(query);

      ResultSet result = stmt.executeQuery();
      
      while(result.next()) {
        clients.add(new Client(
          result.getString("nome"),
          result.getString("email"),
          result.getBoolean("ativo"), 
          result.getDate("data_criacao").toLocalDate()
        ));
      }
    }
    catch(SQLException e) {
      e.printStackTrace();
    }

    return clients;
  }


  public Client findById(Integer id) {
    
    Client client = null;
    
    try(Connection conn = ConnectionFactory.getConnection()) {

      String query = "SELECT nome, email, ativo, data_criacao FROM cliente WHERE numero = ?";

      PreparedStatement stmt = conn.prepareStatement(query);
      stmt.setInt(1, id);

      ResultSet result = stmt.executeQuery();
      
      if(result.next()) {
        client = new Client(
          result.getString("nome"),
          result.getString("email"),
          result.getBoolean("ativo"), 
          result.getDate("data_criacao").toLocalDate()
        );  
      }
      
    }
    catch(SQLException e) {
      e.printStackTrace();
    }

    return client;
  }


  public boolean insertOne(Client client) {
    Boolean state =  false;

    try(Connection conn = ConnectionFactory.getConnection()) {

      String query = "INSERT INTO cliente (nome, email) VALUES (?, ?)";


      PreparedStatement stmt = conn.prepareStatement(query);
      
      stmt.setString(1, client.getName());
      stmt.setString(2, client.getEmail());

      stmt.executeUpdate();

      state = true;
      
    }
    catch(SQLException e) {
      e.printStackTrace();
    }

    return state;
  }


  public boolean deleteOne(Integer id) {
    Boolean state =  false;

    try(Connection conn = ConnectionFactory.getConnection()) {

      String query = "DELETE FROM cliente WHERE numero = ?";

      PreparedStatement stmt = conn.prepareStatement(query);
      
      stmt.setInt(1, id);
      stmt.executeUpdate();

      state = true;
      
    }
    catch(SQLException e) {
      e.printStackTrace();
    }

    return state;
  }


  public boolean updateOne(Integer id, Client client) {    
    Boolean state =  false;

    try(Connection conn = ConnectionFactory.getConnection()) {

      String query = "UPDATE cliente SET nome = ?, email = ? WHERE numero = ?";

      PreparedStatement stmt = conn.prepareStatement(query);
      stmt.setString(1, client.getName());
      stmt.setString(2, client.getEmail());
      stmt.setInt(3, id);
      
      stmt.executeUpdate();

      state = true;
      
    }
    catch(SQLException e) {
      e.printStackTrace();
    }

    return state;
  }

  public static void showTable(List<Client>  clients) {
    
    if(clients.isEmpty()) {
      return;
    }

    Integer maxColumName = clients.get(0).getName().length();
    Integer maxColumEmail = clients.get(0).getEmail().length();
    Integer maxColumDate = clients.get(0).getDate().toString().length();

    for(var client : clients) {
      maxColumName = Math.max(client.getName().length(), maxColumName);
      maxColumEmail = Math.max(client.getEmail().length(), maxColumEmail);
    }


    System.out.println(
      String.format("|%sName%s|%sEmail%s|Enable|%screate_at%s|", 
        " ".repeat(maxColumName / 2), " ".repeat(maxColumName / 2),
        " ".repeat(maxColumEmail / 2), " ".repeat(maxColumEmail / 2),
        " ".repeat(maxColumDate / 3), " ".repeat(maxColumDate / 4))
    );

    for(var client : clients) {
      
      String name = client.getName();
      String email = client.getEmail();
      Boolean enable = client.getEnable();
      LocalDate date  = client.getDate();

      Integer paddingName = maxColumName - name.length();
      Integer paddingEmail = maxColumEmail - email.length();

      StringBuilder line = new StringBuilder();

      System.out.println(String.format("| %s %s | %s %s  |%s|  %s  |", 
        name, " ".repeat(paddingName), email, " ".repeat(paddingEmail),
        (enable) ? " true " : "false ", date.toString()) 
      );
    }

    System.out.println(String.format("\n ROW: %d", clients.size()));
  }
}