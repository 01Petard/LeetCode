package com.hzx.DesignPattern.责任链模式.handler;

// 抽象处理者类
public abstract class LogHandler {
    protected LogHandler nextHandler;

    public void setNextHandler(LogHandler handler) {
        this.nextHandler = handler;
    }

    public abstract void handleLog(String level, String message);
}
