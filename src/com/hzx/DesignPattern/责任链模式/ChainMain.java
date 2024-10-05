package com.hzx.DesignPattern.责任链模式;


import com.hzx.DesignPattern.责任链模式.handler.*;

// 客户端代码
public class ChainMain {
    public static void main(String[] args) {
        LogHandler debugHandler = new DebugLogHandler();
        LogHandler infoHandler = new InfoLogHandler();
        LogHandler warningHandler = new WarningLogHandler();
        LogHandler errorHandler = new ErrorLogHandler();

        debugHandler.setNextHandler(infoHandler);
        infoHandler.setNextHandler(warningHandler);
        warningHandler.setNextHandler(errorHandler);

        debugHandler.handleLog("DEBUG", "This is a debug message.");
        debugHandler.handleLog("INFO", "This is an info message.");
        debugHandler.handleLog("WARNING", "This is a warning message.");
        debugHandler.handleLog("ERROR", "This is an error message.");
    }
}