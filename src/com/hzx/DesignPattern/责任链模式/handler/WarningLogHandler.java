package com.hzx.DesignPattern.责任链模式.handler;

// 具体处理者类
public class WarningLogHandler extends LogHandler {
    @Override
    public void handleLog(String level, String message) {
        if ("warning".equalsIgnoreCase(level)) {
            System.out.println("[WARNING] " + message);
        } else if (nextHandler != null) {
            nextHandler.handleLog(level, message);
        }
    }
}

