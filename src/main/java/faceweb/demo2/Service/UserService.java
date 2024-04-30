package faceweb.demo2.Service;

import faceweb.demo2.DTO.UserDTO;
import faceweb.demo2.Domain.JoinForm;
import faceweb.demo2.Entity.UserEntity;
import faceweb.demo2.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired

    private final UserRepository userRepository; // jpa, MySQL dependency 추가
    public void save(UserDTO userDTO) {
        // request -> DTO -> Entity -> Repository에서 save
        UserEntity userEntity = UserEntity.toUserEntity(userDTO);
        userRepository.save(userEntity);
        //Repository의 save메서드 호출 (조건. entity객체를 넘겨줘야 함)
    }

    public boolean joinProcess(JoinForm joinForm) {

        boolean isUser=userRepository.existsByUsername(joinForm.getUsername());
        if(isUser){
            return false;
        }
        //추가적으로 SQL 인젝션 등에 대비한 입력값 필터링이 동작 작성 필요

        UserEntity data = new UserEntity();

        data.setUsername(joinForm.getUsername());
        //String password=bCryptPasswordEncoder.encode(joinForm.getPassword());
        String password=joinForm.getPassword();
        data.setPassword(password);
        data.setEmail(joinForm.getEmail());
        data.setGender(joinForm.getGender());
        data.setName(joinForm.getName());

        userRepository.save(data);
        return true;
    }
}