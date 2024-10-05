package com.hzx.ZZZ笔试;

import java.util.ArrayList;
import java.util.List;

public class Transform {


    private static final String[] FOUR_CORNERS = {"3234", "0589", "1129", "6670"};

    public static void main(String[] args) {
        String message = "We live at 3234058911296670,not at 0589323411296670.";
        List<Integer> positions = findFourCorner(message);
        positions.sort(Integer::compareTo);
        System.out.println(positions);
    }

    private static List<Integer> findFourCorner(String message) {
        List<Integer> result = new ArrayList<>();
        int pre = 0;
        for (int i = 0; i < message.length() - 3; i++) {
            for (String corner : FOUR_CORNERS) {
                if (message.startsWith(corner, i)) {
                    if (i - pre != 4){
                        result.add(i);
                    }
                    pre = i;
                }
            }
        }
        return result;
    }
}



