/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moodcalendar;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {
    
    @Autowired
    UserRepository repo;
    
    @GetMapping("/register")
    public String Register(Model model){
        
        model.addAttribute("user", new User());
        
        return "Register";
    }
    
    @PostMapping("/register")
    public String RegisterVerify(@ModelAttribute User user){
        try{
        List<User> list = repo.findByUsername(user.username);
        if (list == null || list.isEmpty()){
            repo.save(new User(user.username,user.password));
            System.out.println("User Saved");
            return "RegisterVerify";
        } else {
            return "UserExists";
        }
        }
        catch(Exception e){
            e.printStackTrace();
        return "WeirdError";
        }
    }
    
}
