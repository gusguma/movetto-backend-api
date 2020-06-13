package com.movetto.api.entities;

public enum TransactionStatus {

    PASSED, FAILED, DELETED, CREATED;

    public String packageStatusName(){
        return "PACKAGE_STATUS_" + this.toString();
    }
}
