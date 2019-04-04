package com.config.configserver1.controller;


import com.config.configserver1.dao.configserverRepository;
import com.config.configserver1.entity.configserver;
import com.config.configserver1.service.configServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@RefreshScope
@RestController    // This means that this class is a Controller
@RequestMapping(path="/configserver") // This means URL's start with /demo (after Application path)
public class configserverController {
    @Autowired
    //private configserverRepository ConfigserverRepository;
    private configServerService ConfigserverService;

    @GetMapping(path="/all")
    public @ResponseBody
    Iterable<configserver> getAllConfigservers() {
        // This returns a JSON or XML with the users
        return ConfigserverService.findAll();
    }


    @GetMapping (value = "get/{id}")
    public configserver findConfigById(@PathVariable("id") Integer id){
        return ConfigserverService.findById(id);
    }

    @GetMapping (value = "get/APL")
    public Iterable<configserver> findConfigByAPL(@RequestParam String app, @RequestParam String pro, @RequestParam String label){
        return ConfigserverService.findByAPL(app, pro, label);
    }

    @PostMapping(value = "/add")
    public configserver configAdd(@RequestBody configserver config){
      return ConfigserverService.configAdd(config);

    }

    @PutMapping(value = "/update")
    public configserver configUpdate(@RequestBody configserver config){
       return ConfigserverService.update(config);

    }

    @DeleteMapping(value = "/delete/{id}")
    public String configDelete(@PathVariable("id") Integer id) {

            return ConfigserverService.deleteById(id);


    }




}
