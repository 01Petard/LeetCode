package com.hzx.DesignPattern.责任链模式.handler;

// 具体处理者类
public class ErrorLogHandler extends LogHandler {
    @Override
    public void handleLog(String level, String message) {
        if ("error".equalsIgnoreCase(level)) {
            System.out.println("[ERROR] " + message);
        }
    }
}