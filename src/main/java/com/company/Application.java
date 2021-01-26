package com.company;

public class Application {

    private String appName;
    private String appUUID;
    private int appId;
    private int categoryId;

    public Application() {
    }

    public Application(String appName, int appId, int categoryId, String appUUID) {
        this.appName = appName;
        this.appUUID = appUUID;
        this.appId = appId;
        this.categoryId = categoryId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppUUID() {
        return appUUID;
    }

    public void setAppUUID(String appUUID) {
        this.appUUID = appUUID;
    }

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
