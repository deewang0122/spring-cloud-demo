package com.dee.basekit.util;

import org.springframework.beans.BeanUtils;

import java.util.Collections;
import java.util.List;

public class ObjectUtils {

    public static String toJson(Object obj) {
        throw new UnsupportedOperationException("todo...");
    }


    public static <K, V> V copyObject(K source, V target) {
        BeanUtils.copyProperties(source, target);
        return target;
    }

    public static <K, V> List<V> copyObject(List<K> sourceList, Class<V> targetClass) {
        List<V> targetList = Collections.emptyList();
        sourceList.stream().forEach(source -> {
            try {
                targetList.add(copyObject(source, targetClass.getDeclaredConstructor().newInstance()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return targetList;
    }
}
