package com.example.sangeetlearner;

public class UserModelForFireBase {

    String db_name,db_userId,db_password,db_deviceId;

    public UserModelForFireBase(String db_name, String db_userId, String db_password, String db_deviceId) {
        this.db_name = db_name;
        this.db_userId = db_userId;
        this.db_password = db_password;
        this.db_deviceId = db_deviceId;
    }

    public String getDb_name() {
        return db_name;
    }

    public void setDb_name(String db_name) {
        this.db_name = db_name;
    }

    public String getDb_userId() {
        return db_userId;
    }

    public void setDb_userId(String db_userId) {
        this.db_userId = db_userId;
    }

    public String getDb_password() {
        return db_password;
    }

    public void setDb_password(String db_password) {
        this.db_password = db_password;
    }

    public String getDb_deviceId() {
        return db_deviceId;
    }

    public void setDb_deviceId(String db_deviceId) {
        this.db_deviceId = db_deviceId;
    }


}
