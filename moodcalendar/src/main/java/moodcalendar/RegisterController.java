/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moodcalendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {
    
    @GetMapping("/register")
    public String Register(Model model){
        
        model.addAttribute("register", new Register());
        
        return "Register";
    }
    
    @PostMapping("/register")
    public String RegisterVerify(@ModelAttribute Register user){
        
        return "Login";
    }
    
}
