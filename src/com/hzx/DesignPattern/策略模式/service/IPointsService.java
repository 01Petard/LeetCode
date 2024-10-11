package com.hzx.DesignPattern.策略模式.service;

import com.hzx.DesignPattern.策略模式.constants.PointsSuitScenesEnum;

public interface IPointsService {

    void addPoints(Long userId, int points, PointsSuitScenesEnum scene) throws Exception;

    void subtractPoints(Long userId, int points, PointsSuitScenesEnum scene) throws Exception;
}
