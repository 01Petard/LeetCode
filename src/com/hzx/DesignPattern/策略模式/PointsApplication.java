package com.hzx.DesignPattern.策略模式;


import com.hzx.DesignPattern.策略模式.config.PointsStrategyConfig;
import com.hzx.DesignPattern.策略模式.constants.PointsSuitScenesEnum;
import com.hzx.DesignPattern.策略模式.service.PointsService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PointsApplication {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PointsStrategyConfig.class);
        PointsService pointsService = context.getBean(PointsService.class);
        context.close();

        // 添加积分
        pointsService.addPoints(1L, 100, PointsSuitScenesEnum.BOOK_TEST);
        pointsService.addPoints(2L, 200, PointsSuitScenesEnum.LEVEL_FIGHT);

        pointsService.subtractPoints(1L, 100, PointsSuitScenesEnum.BOOK_TEST);
        pointsService.subtractPoints(2L, 200, PointsSuitScenesEnum.LEVEL_FIGHT);


    }
}
