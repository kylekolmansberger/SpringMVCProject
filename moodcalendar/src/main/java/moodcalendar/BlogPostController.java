/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moodcalendar;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class BlogPostController {
    
    @Autowired
    BlogRepository blogRepo;
    
    //Create Blog Controller
    @GetMapping("/blogentry")
    public String BlogEntry(Model model){
        
        model.addAttribute("blogentry", new BlogEntry());
        
        return "BlogEntry";
    }
    @PostMapping("/blogentry")
    public String BlogConfirm(@ModelAttribute BlogEntry blogentry){
        try{
        blogRepo.save(new BlogEntry(blogentry.date, blogentry.mood, blogentry.blog));
        System.out.println("Blog Saved");
        
        }
        
        catch(Exception e){
            e.printStackTrace();
        return "WeirdError";
        }
        
        
        return "ConfirmBlog";
    }
    
    
    
    //Finding Blog By Date Controller
    @GetMapping("/findblogdate")
    public String FindBlogDate(Model model){
        
        model.addAttribute("findblogdate", new FindBlogDate());
        
        
        return "FindBlogDate";
    }
    @PostMapping("/findblogdate")
    public String DateBlogResults(@ModelAttribute FindBlogDate findblogdate, Model model){
        
        
        model.addAttribute("blogentrys", blogRepo.findByDate(findblogdate.date));
        
        return "DateBlogSearchResults";
    }
    

    //Finding Blog By Mood Controller
    @GetMapping("/findblogmood")
    public String FindBlogMood(Model model){
        
        model.addAttribute("findblogmood", new FindBlogMood());
        
        return "FindBlogMood";
    }
    @PostMapping("/findblogmood")
    public String MoodBlogResults(@ModelAttribute FindBlogMood findblogmood, Model model){
        
        model.addAttribute("blogentrys", blogRepo.findByMood(findblogmood.mood));
        
        return "MoodBlogSearchResults";
    }
   
    
}
