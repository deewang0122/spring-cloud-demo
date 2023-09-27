package com.dee.basekit.config;

import java.util.HashMap;
import java.util.Map;

public class ContextHolder {

    private ContextHolder() {

    }
    private static final ThreadLocal<Map<String, Object>> sessionStore = InheritableThreadLocal.withInitial(HashMap::new);

    public static void setItem(String key, Object value) {
        sessionStore.get().put(key, value);
    }

    public static Object getItem(String key) {
        return sessionStore.get().get(key);
    }

    public static void clear() {
        sessionStore.remove();
    }
}
