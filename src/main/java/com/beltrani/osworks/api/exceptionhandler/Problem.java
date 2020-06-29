package com.beltrani.osworks.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;

public class Problem {
    
    private Integer status;
    private LocalDateTime dataHora; 
    private String title;
    private List<Field> fields;

    public static class Field {
        private String name; 
        private String message;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Field(String name, String message) {
            this.name = name;
            this.message = message;
        }

        
    }
    
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }
    
}