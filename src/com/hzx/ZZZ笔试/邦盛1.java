package com.hzx.ZZZ笔试;

import java.util.ArrayList;
import java.util.List;

public class 邦盛1 {
    public static void main(String[] args) {
        // 测试案例
        System.out.println(formatDuration(62)); // "1 minute and 2 seconds"
        System.out.println(formatDuration(3662)); // "1 hour, 1 minute and 2 seconds"
        System.out.println(formatDuration(0)); // "now"
    }

    public static String formatDuration(int seconds) {
        if (seconds == 0) return "now";

        int[] units = {31536000, 86400, 3600, 60, 1}; // 年、天、小时、分钟、秒
        String[] names = {"year", "day", "hour", "minute", "second"};
        StringBuilder result = new StringBuilder();
        List<String> parts = new ArrayList<>();

        for (int i = 0; i < units.length; i++) {
            long value = seconds / units[i];
            if (value > 0) {
                seconds -= value * units[i];
                parts.add(value + " " + names[i] + (value > 1 ? "s" : ""));
            }
        }

        if (parts.size() > 1) {
            for (int i = 0; i < parts.size(); i++) {
                if (i == parts.size() - 1) {
                    result.append("and ").append(parts.get(i));
                } else if (i == parts.size() - 2) {
                    result.append(parts.get(i)).append(" ");
                } else {
                    result.append(parts.get(i)).append(", ");
                }
            }
        } else if (parts.size() == 1) {
            result.append(parts.get(0));
        }

        return result.toString();
    }
}
