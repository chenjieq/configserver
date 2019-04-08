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
     * 根据application查找对象
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
    public String deleteById(int id) {
        if (findById(id) == null)
            return "Error! Record doesn't exist!";
        else
            configserverRepository.delete(findById(id));
        return "delete successfully";
    }


    /**
     * 根据Akey删除对象
     *
     * @param akey
     */

    @Transactional
    public String deleteByAkey(String akey) {
        configserver config = new configserver();

        while (findByApplication(akey).iterator().hasNext()) {
            config = findByApplication(akey).iterator().next();
            deleteById(config.getId());
        }
        return "delete successfully";
    }


    /**
     * 根据Avalue删除对象
     *
     * @param avalue
     */

    @Transactional
    public String deleteByAvalue(String avalue) {
        configserver config = new configserver();

        while (findByApplication(avalue).iterator().hasNext()) {
            config = findByApplication(avalue).iterator().next();
            deleteById(config.getId());
        }
        return "delete successfully";
    }


    /**
     * 根据Application删除对象
     *
     * @param application
     */

    @Transactional
    public String deleteByApplication(String application) {
        configserver config = new configserver();

        while (findByApplication(application).iterator().hasNext()) {
            config = findByApplication(application).iterator().next();
            deleteById(config.getId());
        }
        return "delete successfully";
    }


    /**
     * 根据Aprofile删除对象
     *
     * @param aprofile
     */

    @Transactional
    public String deleteByAprofile(String aprofile) {
        configserver config = new configserver();

        while (findByApplication(aprofile).iterator().hasNext()) {
            config = findByAprofile(aprofile).iterator().next();
            deleteById(config.getId());
        }
        return "delete successfully";
    }


    /**
     * 根据Label删除对象
     *
     * @param label
     */

    @Transactional
    public String deleteByLabel(String label) {
        configserver config = new configserver();

        while (findByLabel(label).iterator().hasNext()) {
            config = findByLabel(label).iterator().next();
            return deleteById(config.getId());
        }
        return "delete successfully";
    }


    /**
     * 修改数据
     *
     * @param config
     */

    @Transactional
    public configserver update(configserver config) {

        //根据id找到需要更新的对象, json体里id 信息是必须的。
        configserver config1 = findById(config.getId());
        if (findById(config.getId()) == null)
            configAdd(config);
        else if (!config.getAkey().isEmpty())
            config1.setAkey(config.getAkey());
        if (!config.getAvalue().isEmpty())
            config1.setAvalue(config.getAvalue());
        if (!config.getApplication().isEmpty())
            config1.setApplication(config.getApplication());
        if (!config.getAprofile().isEmpty())
            config1.setAprofile(config.getAprofile());
        if (!config.getlabel().isEmpty())
            config1.setlabel(config.getlabel());

        return save(config1);

    }


    /**
     * 添加数据
     *
     * @param config
     */
    @Transactional
    //todo: 1.add需要保证所有项都不为空； 2.add 中id 只能自动生成且保证唯一性，不能手动添加。3.支持多条增加
    public configserver configAdd(configserver config) {
        configserver config1 = new configserver();
        if(config.getId()!= null) return null;
        if (configserverRepository.findByAkeyAndApplicationAndAprofileAndLabel
                (config.getAkey(), config.getApplication(), config.getAprofile(), config.getlabel()).getId() == null) {
            if (!config.getAkey().isEmpty())
                config1.setAkey(config.getAkey());
            if (!config.getAvalue().isEmpty())
                config1.setAvalue(config.getAvalue());
            if (!config.getApplication().isEmpty())
                config1.setApplication(config.getApplication());
            if (!config.getAprofile().isEmpty())
                config1.setAprofile(config.getAprofile());
            if (!config.getlabel().isEmpty())
                config1.setlabel(config.getlabel());
        }
        return save(config1);
    }


    /**
     * 添加数据
     */
    @Transactional
    //todo: 1.add需要保证所有项都不为空； 2.add 中id 只能自动生成且保证唯一性，不能手动添加。3.支持多条增加
    public String configAdd(Iterable<configserver> config) {
        configserver config1 = new configserver();
        while (config.iterator().hasNext()) {
            config1 = config.iterator().next();
            configAdd(config1);
        }

        return "Add Successfully!";

    }

}