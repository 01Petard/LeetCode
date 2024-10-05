package com.hzx.DesignPattern.策略模式.constants;

public enum PointsSuitScenesEnum {
    BOOK_TEST("书籍测试", 1),
    LEVEL_FIGHT("阅读闯关", 2);

    private final String sceneName;
    private final int sceneId;

    PointsSuitScenesEnum(String sceneName, int sceneId) {
        this.sceneName = sceneName;
        this.sceneId = sceneId;
    }

    public void printInfo() {
        System.out.println("sceneName: " + sceneName);
        System.out.println("sceneId: " + sceneId);

    }

}