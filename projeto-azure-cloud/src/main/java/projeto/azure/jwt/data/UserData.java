package projeto.azure.jwt.data;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class UserData implements Serializable {
  
  private String userName;
  private String password;


}