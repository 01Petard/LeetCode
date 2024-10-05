package com.hzx.DesignPattern.策略模式.reslove;

import com.hzx.DesignPattern.策略模式.constants.PointsSuitScenesEnum;

public class LevelFightPointsReslove implements IPointsStrategy {


    @Override
    public PointsSuitScenesEnum getPointsSuitScene() {
        return PointsSuitScenesEnum.LEVEL_FIGHT;
    }

    @Override
    public void operaPoints(String userId, int points, int operateType) {
        if (operateType == 1) {
            System.out.println("阅读闯关加分:userId=" + userId + " points=" + points);
        } else if (operateType == 0) {
            System.out.println("阅读闯关扣分:userId=" + userId + " points=" + points);
        }
    }
}
