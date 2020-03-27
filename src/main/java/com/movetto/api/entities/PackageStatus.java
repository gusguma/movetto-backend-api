package com.movetto.api.entities;

public enum PackageStatus {
    PREPARED, COLLECTED, TRANSIT, DETAINED, SHIPPED, DELETED;

    public String packageStatusName(){
        return "PACKAGE_STATUS_" + this.toString();
    }
}
