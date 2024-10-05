package com.hzx.DesignPattern.策略模式.reslove;

import com.hzx.DesignPattern.策略模式.constants.PointsSuitScenesEnum;

public class BookTestPointsReslove implements IPointsStrategy {


    @Override
    public PointsSuitScenesEnum getPointsSuitScene() {
        return PointsSuitScenesEnum.BOOK_TEST;
    }

    @Override
    public void operaPoints(String userId, int points, int operateType) {
        if (operateType == 1) {
            System.out.println("书籍测试加分:userId=" + userId + " points=" + points);
        } else if (operateType == 0) {
            System.out.println("书籍测试减分:userId=" + userId + " points=" + points);
        }
    }

}
