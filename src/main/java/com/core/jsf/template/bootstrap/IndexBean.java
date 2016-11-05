/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.jsf.template.bootstrap;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author gonza
 */
@ManagedBean(name="index")
@ViewScoped
public class IndexBean implements Serializable{
    
    private List<String> names;
    private String windowContent; 
    private List<String> resultSearch;

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public String getWindowContent() {
        return windowContent;
    }

    public void setWindowContent(String windowContent) {
        this.windowContent = windowContent;
    }

    public List<String> getResultSearch() {
        return resultSearch;
    }

    public void setResultSearch(List<String> resultSearch) {
        this.resultSearch = resultSearch;
    }
    
    @PostConstruct
    public void init(){
        this.names = new ArrayList<>();
        this.resultSearch = new ArrayList<>();
        this.windowContent = "Main";
        this.loadNames();
    }
    
    /*
    This method is only for example,
    here I load varous names to dasplay in search box
    */
    private void loadNames(){
        this.names.add("Gonzalo");
        this.names.add("Jon");
        this.names.add("Rocky");
        this.names.add("Obama");
        this.names.add("Trump");
        this.names.add("Michael Jordan");
        this.names.add("Abraham Lincoln");
        this.names.add("Bashar Al Assad");
        this.names.add("Nelson Mandela");
        this.names.add("Sergei Brin");
        this.names.add("Larry Page");
        this.names.add("Thomas Edison");
        this.names.add("Nicola Tesla");
        this.names.add("Ben Gurion");
    }
    
    public void searchName(String name){
        if (name != null && !name.isEmpty()) {
            this.resultSearch = new ArrayList<>();
            for(String n : this.names){
                if (n.contains(name)) {
                    this.resultSearch.add(n);
                }
            }
            this.windowContent = "search";
            RequestContext.getCurrentInstance().update("content-form");
        }
    }
    
    public void window(String name){
        this.windowContent = name;
        RequestContext.getCurrentInstance().update("content-form");
    }
}
