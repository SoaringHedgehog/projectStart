package entity;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    String login;
    String passwordHash; // TODO String?
    RoleType roleType;

}