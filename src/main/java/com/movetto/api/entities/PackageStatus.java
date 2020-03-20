package com.movetto.api.entities;

public enum PackageStatus {
    PREPARED(1), COLLECTED(2), TRANSIT(3), DETAINED(4), SHIPPED(5), DELETED(0);
    private int packageStatus;

    private PackageStatus (int packageStatus){
        this.packageStatus = packageStatus;
    }
}
