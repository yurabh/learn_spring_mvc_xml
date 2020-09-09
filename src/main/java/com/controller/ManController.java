package com.controller;

import com.domain.Man;
import com.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("man")
public class ManController {

    private CrudService<Man> crudService;

    @Autowired
    public ManController(CrudService<Man> crudService) {
        this.crudService = crudService;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public @ResponseBody
    Man save(@RequestBody Man man) {
        crudService.save(man);
        return man;
    }

    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Man getById(@PathVariable int id) {
        return crudService.findById(id);
    }


    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public @ResponseBody
    void update(@RequestBody Man man) {
        crudService.update(man);
    }

    @RequestMapping(value = "/delete{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    void delete(@PathVariable("id") int id) {
        crudService.deleteById(id);
    }
}
