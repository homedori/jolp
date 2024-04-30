package faceweb.demo2.DTO;
import faceweb.demo2.Entity.UserEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserDTO {
    private String username;
    private String password;
    private String name;
    private String email;
    private String gender;

    public static UserDTO toUserDTO(UserEntity userEntity) {
        UserDTO userDTO = new UserDTO();

        userDTO.setUsername(userEntity.getUsername());
        userDTO.setPassword(userEntity.getPassword());
        userDTO.setName(userEntity.getName());
        userDTO.setEmail(userEntity.getEmail());
        userDTO.setGender(userEntity.getGender());

        return userDTO;
    }
}