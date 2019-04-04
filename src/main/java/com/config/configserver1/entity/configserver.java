package com.config.configserver1.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "config_server")
public class configserver {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String akey;
    private String avalue;
    private String application;
    private String aprofile;
    private String label;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) { this.id = id; }

    public String getAkey() {
        return akey;
    }
    public void setAkey(String akey) { this.akey = akey; }

    public String getAvalue() {
        return avalue;
    }
    public void setAvalue(String avalue) {
        this.avalue = avalue;
    }

    public String getApplication() {
        return application;
    }
    public void setApplication(String application) {
        this.application = application;
    }

    public String getAprofile() { return aprofile; }
    public void setAprofile(String aprofile) {
        this.aprofile = aprofile;
    }

    public String getlabel() {
        return label;
    }
    public void setlabel(String label) {
        this.label = label;
    }
}
