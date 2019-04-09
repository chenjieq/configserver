package com.config.configserver1.service;

import com.config.configserver1.ResponseBody.ResponseResult;
import com.config.configserver1.ResponseBody.RestResultGenerator;
import com.config.configserver1.dao.configserverRepository;
import com.config.configserver1.entity.configserver;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class configServerService {
    @Resource
    private configserverRepository configserverRepository;

    /**
     * save,update ,delete 方法需要绑定事务. 使用@Transactional进行事务的绑定.
     *
     * @param config 保存对象
     */
    @Transactional
    public configserver save(configserver config) {
        return configserverRepository.save(config);
    }

    /**
     * 查询数据
     *
     * @return
     */
    public Iterable<configserver> findAll() {
        return configserverRepository.findAll();
    }


    /**
     * 根据id查找对象
     *
     * @param id
     */
    @Transactional
    public configserver findById(int id) {
        return configserverRepository.findById(id).orElse(null);  //如果不存在，返回为空
    }

    @Transactional
    public Iterable<configserver> findByAPL(String app, String pro, String label) {

        return configserverRepository.findByApplicationAndAprofileAndLabel(app, pro, label);
    }


    /**
     * 根据avalue查找对象
     *
     * @param avalue
     */
    @Transactional
    public Iterable<configserver> findByAvalue(String avalue) {
        return configserverRepository.findByAvalue(avalue);
    }


    /**
     * 根据key查找对象
     *
     * @param akey
     */
    @Transactional
    public Iterable<configserver> findByAkey(String akey) {
        return configserverRepository.findByAkey(akey);
    }


    /**
     * 根据application查找对象
     *
     * @param application
     */
    @Transactional
    public Iterable<configserver> findByApplication(String application) {
        return configserverRepository.findByApplication(application);
    }


    /**
     * 根据aprofile查找对象
     *
     * @param aprofile
     */
    @Transactional
    public Iterable<configserver> findByAprofile(String aprofile) {
        return configserverRepository.findByAprofile(aprofile);
    }


    /**
     * 根据label查找对象
     *
     * @param label
     */
    @Transactional
    public Iterable<configserver> findByLabel(String label) {
        return configserverRepository.findByLabel(label);  //如果不存在，返回为空
    }


    /**
     * 根据id删除对象
     *
     * @param id
     */

    @Transactional
    public ResponseResult<configserver> deleteById(int id) {
        if (findById(id) == null)
            return RestResultGenerator.genErrorResult("配置信息不存在！");
           // return "Error! Record doesn't exist!";

            configserverRepository.delete(findById(id));
        return RestResultGenerator.genResult(null,"delete successfully");
    }


    /**
     * 根据Akey删除对象
     *
     * @param akey
     */

    @Transactional
    public ResponseResult<configserver> deleteByAkey(String akey) {
        configserver config;
        if(!findByAkey(akey).iterator().hasNext())
            return RestResultGenerator.genErrorResult("配置信息不存在！");
           // return "Error! Record doesn't exist!";
        while (findByAkey(akey).iterator().hasNext()) {
            config = findByAkey(akey).iterator().next();
            deleteById(config.getId());
        }
        return RestResultGenerator.genResult(null,"delete successfully");
        //return "delete successfully";
    }


    /**
     * 根据Avalue删除对象
     *
     * @param avalue
     */

    @Transactional
    public ResponseResult<configserver> deleteByAvalue(String avalue) {
        configserver config;
         if(!findByAvalue(avalue).iterator().hasNext())
             return RestResultGenerator.genErrorResult("配置信息不存在！");
        while (findByAvalue(avalue).iterator().hasNext()) {
            config = findByAvalue(avalue).iterator().next();
            deleteById(config.getId());
        }
        return RestResultGenerator.genResult(null,"delete successfully");
        // return "delete successfully";
    }


    /**
     * 根据Application删除对象
     *
     * @param application
     */

    @Transactional
    public ResponseResult<configserver> deleteByApplication(String application) {
        configserver config;
        if(!findByApplication(application).iterator().hasNext())
            return RestResultGenerator.genErrorResult("配置信息不存在！");
        while (findByApplication(application).iterator().hasNext()) {
            config = findByApplication(application).iterator().next();
            deleteById(config.getId());
        }
        return RestResultGenerator.genResult(null,"delete successfully");
        // return "delete successfully";
    }


    /**
     * 根据Aprofile删除对象
     *
     * @param aprofile
     */

    @Transactional
    public ResponseResult<configserver>deleteByAprofile(String aprofile) {
        configserver config;
        if(!findByAprofile(aprofile).iterator().hasNext())
            return RestResultGenerator.genErrorResult("配置信息不存在！");
        while (findByAprofile(aprofile).iterator().hasNext()) {
            config = findByAprofile(aprofile).iterator().next();
            deleteById(config.getId());
        }
        //return "delete successfully";
        return RestResultGenerator.genResult(null,"delete successfully");
    }


    /**
     * 根据Label删除对象
     *
     * @param label
     */

    @Transactional
    public ResponseResult<configserver> deleteByLabel(String label) {
        configserver config;
        if(!findByLabel(label).iterator().hasNext())
            return RestResultGenerator.genErrorResult("配置信息不存在！");
        while (findByLabel(label).iterator().hasNext()) {
            config = findByLabel(label).iterator().next();
            deleteById(config.getId());
        }
        //return "delete successfully";
        return RestResultGenerator.genResult(null,"delete successfully");
    }


    /**
     * 修改数据
     *
     * @param config
     */

    @Transactional
    public ResponseResult<configserver> update(configserver config) {

        //根据id找到需要更新的对象, json体里id 信息是必须的。
        if(config.getId() == null) return RestResultGenerator.genErrorResult("必须提供id信息！");
        configserver config1 = findById(config.getId());
        if (config1!=null){
            if (config.getAkey() != null)
                config1.setAkey(config.getAkey());
            if (config.getAvalue()!= null)
                config1.setAvalue(config.getAvalue());
            if (config.getApplication()!= null)
                config1.setApplication(config.getApplication());
            if (config.getAprofile()!= null)
                config1.setAprofile(config.getAprofile());
            if (config.getlabel()!= null)
                config1.setlabel(config.getlabel());
        }
        else return RestResultGenerator.genErrorResult("该配置信息不存在，请选择添加操作！");

         //   configAdd(config);


        save(config1);
        return RestResultGenerator.genResult(config1,"更新成功！");

    }


    /**
     * 添加数据
     *
     * @param config
     */
    @Transactional
    //todo: 1.add需要保证所有项都不为空； 2.add 中id 只能自动生成且保证唯一性，不能手动添加。3.支持多条增加
    public ResponseResult<configserver> configAdd(configserver config) {
      configserver config1 = new configserver();
        if(config.getId()!= null) return RestResultGenerator.genErrorResult("不能手动提供id");
        if (configserverRepository.findByAkeyAndApplicationAndAprofileAndLabel
                (config.getAkey(), config.getApplication(), config.getAprofile(), config.getlabel()) == null) {
            if (config.getAkey() != null)
                config1.setAkey(config.getAkey());
            else return RestResultGenerator.genErrorResult("akey值不能为空！");
            if (config.getAvalue() !=null)
                config1.setAvalue(config.getAvalue());
            else return RestResultGenerator.genErrorResult("avalue值不能为空！");
            if (config.getApplication() !=null)
                config1.setApplication(config.getApplication());
            else return RestResultGenerator.genErrorResult("application值不能为空！");
            if (config.getAprofile()!=null)
                config1.setAprofile(config.getAprofile());
            else return RestResultGenerator.genErrorResult("aprofile值不能为空！");
            if (config.getlabel()!=null)
                config1.setlabel(config.getlabel());
            else return RestResultGenerator.genErrorResult("label值不能为空！");
        } else return RestResultGenerator.genErrorResult("该配置信息已存在，请选择更新操作！");
        save(config1);
        return RestResultGenerator.genResult(config1,"添加成功！");
    }


    /**
     * 添加数据
     */
    @Transactional
    //todo: 1.add需要保证所有项都不为空； 2.add 中id 只能自动生成且保证唯一性，不能手动添加。3.支持多条增加
    public String configAdd1(Iterable<configserver> config) {
        configserver config1;
        while (config.iterator().hasNext()) {
            config1 = config.iterator().next();
            configAdd(config1);
        }

        return "Add Successfully!";

    }

}