package com.qyfei;

public interface IRequestInfo {

    String getHost();

    String getClassName();

    String getMethodName();

    String getModule();

    long getTime();
    String getUuid();

    long getResponseTime();

    String getPath();
}
