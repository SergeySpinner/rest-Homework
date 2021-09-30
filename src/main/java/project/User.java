package project;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@ToString
@Getter
@Table(name = "users")
public class User {
    @Id
    private Integer id;

    @Column(name = "username")
    private String userName;

    @Column(name = "role")
    private String role;

    @Column(name = "mailcontact")
    private String mailContact;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;
}
