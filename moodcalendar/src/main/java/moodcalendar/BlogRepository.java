/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moodcalendar;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BlogRepository extends CrudRepository<BlogEntry, Long> {

    List<BlogEntry> findByDate(String date);
    List<BlogEntry> findByMood(String mood);
}