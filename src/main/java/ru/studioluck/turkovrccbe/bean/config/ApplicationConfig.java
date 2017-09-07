package ru.studioluck.turkovrccbe.bean.config;

public class ApplicationConfig {

    private int port = 5645;
    private int threadsCount = 100;

    public int getThreadsCount() {
        return threadsCount;
    }

    public void setThreadsCount(int threadsCount) {
        this.threadsCount = threadsCount;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
