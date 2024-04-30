package faceweb.demo2.Controller;

import faceweb.demo2.Domain.JoinForm;
import faceweb.demo2.Service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    private final UserService userService;

    public MainController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home_user(Model model){
        String id= SecurityContextHolder.getContext().getAuthentication().getName();
        if(id=="anonymousUser")
            id=null;
        model.addAttribute("username", id);
        return "user/home";
    }

    @GetMapping("/user/face")
    public String user_face(){return "user/simulate";}

    @GetMapping("/board")
    public String board(){
        return "user/board";
    }

    @GetMapping("/login")
    public String loginPage(){
        return "user/login";
    }

    @GetMapping("/join")
    public String join(){
        return "user/join";
    }

    @GetMapping("/join-tac")
    public String join_tac(){
        System.out.println("join-tac");
        return "/user/join-tac";
    }

    @PostMapping("/signup") // 경로 변경
    public String signUp(@ModelAttribute("joinForm") JoinForm joinForm) {
        userService.joinProcess(joinForm);
        return "redirect:/login";
    }

    @PostMapping("/login") // 경로 변경
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password, Model model) {
        // 로그인 로직 처리
        return "redirect:/";
    }
}
