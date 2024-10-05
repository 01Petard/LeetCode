package com.hzx.DesignPattern.策略模式.reslove;


import com.hzx.DesignPattern.策略模式.constants.PointsSuitScenesEnum;

public interface IPointsStrategy {


    PointsSuitScenesEnum getPointsSuitScene();

    void operaPoints(String userId, int points, int operateType);

}
