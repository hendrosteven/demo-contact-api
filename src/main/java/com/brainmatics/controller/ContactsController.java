/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainmatics.controller;

import com.brainmatics.entity.ContactPerson;
import com.brainmatics.repo.ContactRepo;
import com.brainmatics.utility.SearchForm;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Hendro Steven
 */
@RestController
@RequestMapping("/contact")
@Transactional
public class ContactsController {

    @Autowired
    private ContactRepo repo;

    @RequestMapping(method = RequestMethod.POST)
    public ContactPerson save(@RequestBody ContactPerson contact) {
        return repo.save(contact);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public boolean delete(@PathVariable("id") String id) {
        repo.delete(id);
        return true;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ContactPerson getById(@PathVariable("id") String id) {
        return repo.findOne(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<ContactPerson> getAll() {
        return repo.findAllContact();
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<ContactPerson> findByName(@RequestBody SearchForm searchForm) {
        return repo.findByFirstName("%" + searchForm.getSearchKey() + "%");
    }
}
