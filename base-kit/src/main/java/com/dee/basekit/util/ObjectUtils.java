package com.dee.basekit.util;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dee.basekit.mvc.ITreeModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Object 工具类
 *
 * @author Dee
 */
public class ObjectUtils {
    /**
     * Object 转Json 字符串
     *
     * @param obj Object对象
     * @return string
     */
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

    @SuppressWarnings("CallToPrintStackTrace")
    public static <K, V> List<V> copyObject(List<K> sourceList, Class<V> targetClass) {
        List<V> targetList = new java.util.ArrayList<>(Collections.emptyList());
        sourceList.forEach(source -> {
            try {
                targetList.add(copyObject(source, targetClass.getDeclaredConstructor().newInstance()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        return targetList;
    }

    public static <K, V> IPage<V> copyObject(IPage<K> page, Class<V> targetClass) {
        IPage<V> page1 = copyObject(page, new Page<>());
        List<V> targetList = new java.util.ArrayList<>(Collections.emptyList());
        page.getRecords().forEach(source -> {
            try {
                targetList.add(copyObject(source, targetClass.getDeclaredConstructor().newInstance()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        page1.setRecords(targetList);
        return page1;
    }

    public static <T extends ITreeModel<T>> List<T> listToTree(List<T> listNode, String parentId) {
        return listNode.stream()
                .filter(parent -> parent.getParentId().equals(parentId))
                .peek(child -> {
                    child.setChildren(listToTree(listNode, child.getParentId()));
                }).collect(Collectors.toList());
    }

    public static <T extends ITreeModel<T>> List<T> convertListToTree(List<T> nodeList) {
        Map<String, T> nodeMap = new HashMap<>();
        List<T> treeList = new ArrayList<>();

        for (T node : nodeList) {
            nodeMap.put(node.getId(), node);
        }

        for (T node : nodeList) {
            T parent = nodeMap.get(node.getParentId());
            if (parent != null) {
                if (parent.getChildren() == null) {
                    parent.setChildren(new ArrayList<>());
                }
                parent.getChildren().add(node);
            } else {
                treeList.add(node);
            }
        }
        return treeList;
    }

    }
