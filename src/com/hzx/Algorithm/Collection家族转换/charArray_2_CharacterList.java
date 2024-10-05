package com.hzx.Algorithm.Collection家族转换;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class charArray_2_CharacterList {
    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'c'};

        // 装箱
        Character[] characterArray = IntStream.range(0, chars.length)
                .mapToObj(i -> chars[i])
                .toArray(Character[]::new);
        // 将数组转换为List
        List<Character> list = Arrays.asList(characterArray);
    }
}
