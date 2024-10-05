package com.hzx.DesignPattern.策略模式.service;

import com.hzx.DesignPattern.策略模式.constants.PointsSuitScenesEnum;
import com.hzx.DesignPattern.策略模式.reslove.IPointsStrategy;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class PointsService implements IPointsService, ApplicationContextAware {

    private final Map<PointsSuitScenesEnum, IPointsStrategy> map = new ConcurrentHashMap<>();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, IPointsStrategy> tempMap = applicationContext.getBeansOfType(IPointsStrategy.class);
        tempMap.forEach((k, v) -> {
            map.put(v.getPointsSuitScene(), v);
            System.out.println(k + " " + v);
        });
    }

    @Override
    public void addPoints(Long userId, int points, PointsSuitScenesEnum scene) {
        IPointsStrategy strategy = map.get(scene);
        if (strategy == null) {
            System.err.println("No strategy found for scene: " + scene);
        }
        strategy.operaPoints(userId.toString(), points, 1);
    }

    @Override
    public void subtractPoints(Long userId, int points, PointsSuitScenesEnum scene) {
        IPointsStrategy strategy = map.get(scene);
        if (strategy == null) {
            System.err.println("No strategy found for scene: " + scene);
        }
        strategy.operaPoints(userId.toString(), points,0);
    }
}
