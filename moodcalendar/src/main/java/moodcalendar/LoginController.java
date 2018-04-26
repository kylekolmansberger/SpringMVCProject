
package moodcalendar;

import java.sql.ResultSet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LoginController {
    
    @Autowired
    UserRepository repo;
    
    @GetMapping("/login")        
    public String LoginForm(Model model){

        model.addAttribute("user", new User());
        
        return "Login";
    }
    
    @PostMapping("/login")
    public String LoginVerify(@ModelAttribute User user){
        
        try {
            List<User> list = repo.findByUsername(user.username);
            if(!list.isEmpty()){
                boolean verify = confirmUserPassword(user.username, user.password);
                if (verify == true){
                    return "Homepage";
                }else{
                    return "IncorrectPassword";
                }
            }
            else{
            return "UserNotFound";
            } 
        }
        catch(Exception e){
        e.printStackTrace();
        return "WeirdError";
        }
    }
    
    public boolean confirmUserPassword (String username, String password){
        String userCombo = "";
        for (User user : repo.findByUsername(username)){
                    userCombo = user.toString();
                    System.out.println(userCombo);
        }
        if (userCombo.equals(username + "," + password)){
            return true; 
        }else{
            return false;
        }
        
    }
    
    
}
