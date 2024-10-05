package com.hzx.DesignPattern.策略模式.config;

import com.hzx.DesignPattern.策略模式.reslove.BookTestPointsReslove;
import com.hzx.DesignPattern.策略模式.reslove.LevelFightPointsReslove;
import com.hzx.DesignPattern.策略模式.service.PointsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PointsStrategyConfig {

    @Bean
    public PointsService pointsService() {
        return new PointsService();
    }

    @Bean
    public BookTestPointsReslove scene1PointsStrategy() {
        return new BookTestPointsReslove();
    }

    @Bean
    public LevelFightPointsReslove scene2PointsStrategy() {
        return new LevelFightPointsReslove();
    }

}
