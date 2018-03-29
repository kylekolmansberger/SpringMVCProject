
package moodcalendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LoginController {
    
    @GetMapping("/login")        
    public String LoginForm(Model model){

        model.addAttribute("login", new User());
        
        return "Login";
    }
    
    @PostMapping("/login")
    public String LoginVerify(@ModelAttribute User user){
        
        return "Welcome";
    }
    
    
}
