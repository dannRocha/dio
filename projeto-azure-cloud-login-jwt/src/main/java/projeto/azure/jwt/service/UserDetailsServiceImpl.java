package projeto.azure.jwt.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import projeto.azure.jwt.data.UserData;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  
  private final BCryptPasswordEncoder bCryptPasswordEncoder;


  public UserDetailsServiceImpl(BCryptPasswordEncoder bCryptPasswordEncoder) {
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
  }


  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    var user = findUser(username);

    if(user == null) {
      throw new UsernameNotFoundException(username);
    }

    return new User(user.getUserName(), user.getPassword(), Collections.emptyList());
  }


  public List<UserData> listUsers() {
    
    var list = new ArrayList<UserData>();
    list.add(findUser("admin"));
    
    return list;
  }

  
  private UserData findUser(String username) {
    // 
    // Buscar usuario no banco de dados
    // 
    var user = new UserData();

    user.setUserName("admin");
    user.setPassword(bCryptPasswordEncoder.encode("admin"));

    return user;
  }
  
}