package project;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDTO {
    public UserDTO(User user){
        this.id = user.getId();
        this.login = user.getLogin();
        this.mailContact = user.getMailContact();
        this.userName = user.getUserName();
        this.password = user.getPassword();
    }

    private Integer id;

    private String userName;

    private String role;

    private String mailContact;

    private String login;

    private String password;
}
