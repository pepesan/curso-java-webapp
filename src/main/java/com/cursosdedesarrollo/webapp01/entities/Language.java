package com.cursosdedesarrollo.webapp01.entities;

import lombok.Data;

@Data
public class Language {
    private Integer languageId;
    private String name;
    private String lastUpdate;

    public Language(){
        languageId = 0 ;
        name = "";
        lastUpdate = "";
    }
    public String toJson(){
        return "{\"id\":"+languageId+",\"name\":\""+name+"\",\"lastUpdate\":\""+lastUpdate+"\"}";
    }
}
