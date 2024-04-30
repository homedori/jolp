package faceweb.demo2.Controller;

import faceweb.demo2.Domain.JoinForm;
import faceweb.demo2.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public String signUp(JoinForm joinForm){
        userService.joinProcess(joinForm);
        return "redirect:/login";
    }

    @PostMapping("/login") // 경로 변경
    public String login(String username, String password){
        return "redirect:/";
    }
}
