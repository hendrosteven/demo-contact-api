/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainmatics.repo;

import com.brainmatics.entity.ContactPerson;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Hendro Steven
 */
public interface ContactRepo extends JpaRepository<ContactPerson, String> {

    @Query("SELECT c FROM ContactPerson c")
    public List<ContactPerson> findAllContact();
    
    @Query("SELECT c FROM ContactPerson c WHERE LOWER(c.fullName) LIKE LOWER(:name)")
    public List<ContactPerson> findByFirstName(@Param("name") String name);

}
