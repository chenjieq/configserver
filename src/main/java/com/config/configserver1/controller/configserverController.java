package com.config.configserver1.controller;


import com.config.configserver1.ResponseBody.ResponseResult;
import com.config.configserver1.ResponseBody.RestResultGenerator;
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
    ResponseResult<Iterable<configserver>> getAllConfigservers() {
        // This returns a JSON or XML with the users
        Iterable<configserver> configs = ConfigserverService.findAll();
        if(configs == null) return RestResultGenerator.genResult(configs,"没有数据！");

        return RestResultGenerator.genResult(configs,"成功！");
        //return ConfigserverService.findAll();
    }


    @GetMapping (value = "get/{id}")
    public ResponseResult<configserver> findConfigById(@PathVariable("id") Integer id){

        configserver config= ConfigserverService.findById(id);
        if(config == null) return RestResultGenerator.genResult(config,"没有数据！");
        return RestResultGenerator.genResult(config,"成功！");

    }

    @GetMapping (value = "get/akey")
    public ResponseResult<Iterable<configserver>> findConfigByAkey(@RequestParam String akey){///@PathVariable
        Iterable<configserver> configs = ConfigserverService.findByAkey(akey);

        if(!configs.iterator().hasNext()) return RestResultGenerator.genResult(configs,"没有数据！");

        return RestResultGenerator.genResult(configs,"成功！");
    }

    @GetMapping (value = "get/avalue")
    public ResponseResult<Iterable<configserver>> findConfigByAvalue(@RequestParam String avalue){

        Iterable<configserver> configs = ConfigserverService.findByAvalue(avalue);

        if(!configs.iterator().hasNext()) return RestResultGenerator.genResult(configs,"没有数据！");

        return RestResultGenerator.genResult(configs,"成功！");
      //  return ConfigserverService.findByAvalue(avalue);
    }

    @GetMapping (value = "get/application")
    public ResponseResult<Iterable<configserver>> findConfigByApplication(@RequestParam String application){
        Iterable<configserver> configs = ConfigserverService.findByApplication(application);
        if(!configs.iterator().hasNext()) return RestResultGenerator.genResult(configs,"没有数据！");
        return RestResultGenerator.genResult(configs,"成功！");
       // return ConfigserverService.findByApplication(application);
    }

    @GetMapping (value = "get/aprofile")
    public ResponseResult<Iterable<configserver>> findConfigByAprofile(@RequestParam String aprofile){
        Iterable<configserver> configs = ConfigserverService.findByAprofile(aprofile);
        if(!configs.iterator().hasNext()) return RestResultGenerator.genResult(configs,"没有数据！");
        return RestResultGenerator.genResult(configs,"成功！");
       // return ConfigserverService.findByAprofile(aprofile);
    }

    @GetMapping (value = "get/label")
    public ResponseResult<Iterable<configserver>> findConfigByLabel(@RequestParam String label){
        Iterable<configserver> configs = ConfigserverService.findByLabel(label);
        if(!configs.iterator().hasNext()) return RestResultGenerator.genResult(configs,"没有数据！");
        return RestResultGenerator.genResult(configs,"成功！");
        //return ConfigserverService.findByLabel(label);
    }

    @GetMapping (value = "get/APL")
    public ResponseResult<Iterable<configserver>> findConfigByAPL(@RequestParam String app, @RequestParam String pro, @RequestParam String label){
        Iterable<configserver> configs = ConfigserverService.findByAPL(app,pro,label);
        if(!configs.iterator().hasNext()) return RestResultGenerator.genResult(configs,"没有数据！");
        return RestResultGenerator.genResult(configs,"成功！");
        //return ConfigserverService.findByAPL(app, pro, label);
    }

    @PostMapping(value = "/add")
    public ResponseResult<configserver> configAdd(@RequestBody configserver config){
        return ConfigserverService.configAdd(config);

    }
//
//    @PostMapping(value = "/add")
//    public String configAdd(@RequestBody Iterable<configserver> config){
//        return ConfigserverService.configAdd1(config);
//
//    }

    @PutMapping(value = "/update")
    public ResponseResult<configserver> configUpdate(@RequestBody configserver config){
       return ConfigserverService.update(config);

    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseResult<configserver> deleteById(@PathVariable("id") Integer id) {

            return ConfigserverService.deleteById(id);


    }

    @DeleteMapping(value = "delete/akey")
    public ResponseResult<configserver> deleteByAkey(@RequestParam String akey) {

        return ConfigserverService.deleteByAkey(akey);


    }

    @DeleteMapping(value = "delete/avalue")
    public ResponseResult<configserver> deleteByAvalue(@RequestParam String avalue) {

        return ConfigserverService.deleteByAvalue(avalue);


    }

    @DeleteMapping(value = "delete/application")
    public ResponseResult<configserver> deleteByApplication(@RequestParam String app) {

        return ConfigserverService.deleteByApplication(app);


    }

    @DeleteMapping(value = "delete/aprofile")
    public ResponseResult<configserver> deleteByAprofile(@RequestParam String aprofile) {

        return ConfigserverService.deleteByAprofile(aprofile);


    }

    @DeleteMapping(value = "delete/label")
    public ResponseResult<configserver> deleteByLabel(@RequestParam String label) {

        return ConfigserverService.deleteByLabel(label);


    }



}
