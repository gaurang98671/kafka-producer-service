package com.kafkaproducer.kafkaproducerservice.models;

class Users {
    private String user_id;
    private String user_name;
    private String user_job;

    public Users(String user_id, String user_name, String user_job)
    {
        this.user_id= user_id;
        this.user_name= user_name;
        this.user_job= user_job;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getUser_job() {
        return user_job;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setUser_job(String user_job) {
        this.user_job = user_job;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

}