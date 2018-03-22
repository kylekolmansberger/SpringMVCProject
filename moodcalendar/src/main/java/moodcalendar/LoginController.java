
package moodcalendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LoginController {
    
    @GetMapping("/")
    public String LoginForm(){
        
        
        
        return "Login";
    }
    
    @PostMapping("/")
    public String LoginVerify(@ModelAttribute Login login){
        
        
        return "boom";
    }
    
    
}
