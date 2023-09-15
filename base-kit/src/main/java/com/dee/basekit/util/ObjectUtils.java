package com.dee.basekit.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;

import java.util.Collections;
import java.util.List;

public class ObjectUtils {

    public static String toJson(Object obj) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


    public static <K, V> V copyObject(K source, V target) {
        BeanUtils.copyProperties(source, target);
        return target;
    }

    public static <K, V> List<V> copyObject(List<K> sourceList, Class<V> targetClass) {
        List<V> targetList = Collections.emptyList();
        sourceList.forEach(source -> {
            try {
                targetList.add(copyObject(source, targetClass.getDeclaredConstructor().newInstance()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        return targetList;
    }
}
