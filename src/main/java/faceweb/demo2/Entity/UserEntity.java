package faceweb.demo2.Entity;

import faceweb.demo2.DTO.UserDTO;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@Table(name = "users")
public class UserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id // primary key
    private Long user_id;

    @Column(length = 100)
    private String username;

    @Column(length = 100)
    private String password;

    @Column(length = 100)
    private String name;

    @Column(length = 100)
    private String email;

    @Column(length = 100)
    private String gender;

    @Builder
    public static UserEntity toUserEntity(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.username = userDTO.getUsername();
        userEntity.password = userDTO.getPassword();
        userEntity.name = userDTO.getName();
        userEntity.email = userDTO.getEmail();
        userEntity.gender = userDTO.getGender();
        return userEntity;
    }
}
