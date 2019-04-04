package com.config.configserver1.service;

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
     * @param config
     * 保存对象
     */
    @Transactional
    public configserver save(configserver config){
        return configserverRepository.save(config);
    }

    /**
     * 查询数据
     *
     * @return
     */
    public Iterable<configserver> findAll(){
        return configserverRepository.findAll();
    }


    /**
     * 根据id查找对象
     *
     * @param id
     */
    @Transactional
    public configserver findById(int id){
        return configserverRepository.findById(id).orElse(null);  //如果不存在，返回为空
    }

    @Transactional
    public Iterable<configserver> findByAPL(String app, String pro, String label){

        return configserverRepository.findByApplicationAndAprofileAndLabel(app,pro,label);
    }
    /**
     * 根据id删除对象
     *
     * @param id
     */

    //todo: 对象为空的情况
    @Transactional
    public String deleteById(int id){
        configserverRepository.delete(findById(id));
        return "delete successfully";
    }



    /**
     * 修改数据
     *
     * @param config
     */
//todo: 1.对象为空的情况； 2.只更新部分信息的情况
    @Transactional
    public configserver update(configserver config){

        //根据id找到需要更新的对象, json体里id 信息是必须的。
        configserver config1 = findById(config.getId());

        config1.setAkey(config.getAkey());
        config1.setAvalue(config.getAvalue());
        config1.setApplication(config.getApplication());
        config1.setAprofile(config.getAprofile());
        config1.setlabel(config.getlabel());

        return save(config1);

    }

    /**
     * 添加数据
     *
     * @param config
     */
    //todo: 1.add需要保证所有项都不为空； 2.add 中id 只能自动生成且保证唯一性，不能手动添加。
    public configserver configAdd(configserver config){
        configserver config1 = new configserver();
        config1.setAkey(config.getAkey());
        config1.setAvalue(config.getAvalue());
        config1.setApplication(config.getApplication());
        config1.setAprofile(config.getAprofile());
        config1.setlabel(config.getlabel());

        return save(config1);

    }
}
