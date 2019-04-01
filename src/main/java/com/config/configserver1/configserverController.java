package com.config.configserver1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController    // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class configserverController {
    @Autowired
    private configserverRepository ConfigserverRepository;

    @GetMapping(path="/all")

    public @ResponseBody
    Iterable<configserver> getAllConfigservers() {
        // This returns a JSON or XML with the users
        return ConfigserverRepository.findAll();
    }
}
