/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moodcalendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BlogEntry {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long id;
    
    String mood;
    String date;
    String blogEntry;
    
    protected BlogEntry(){}
    
    public BlogEntry(String date, String mood, String blogEntry){
        this.date = date;
        this.mood = mood;
        this.blogEntry = blogEntry;
    }
    

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    
    public String getBlogEntry() {
        return blogEntry;
    }
    public void setBlogEntry(String blogEntry) {
        this.blogEntry = blogEntry;
    }

    public String getMood() {
        return mood;
    }
    public void setMood(String mood) {
        this.mood = mood;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @Override
    public String toString(){
        
        return String.format("%s\n %s\n %s", date, mood, blogEntry);       
    }
    
    public String moodToString(){
        
        return String.format("%s",mood);
    }
    
}
