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
public class BlogPostController {
    
    @GetMapping("/blogentry")
    public String BlogEntry(Model model){
        
        model.addAttribute("blogentry", new BlogEntry());
        
        return "BlogEntry";
    }
    
    @PostMapping("/blogentry")
    public String BlogConfirm(@ModelAttribute BlogEntry blog){
        
        
        return "ConfirmBlog";
    }
    
    
}
