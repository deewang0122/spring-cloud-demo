package com.dee.basekit.config;

import java.util.HashMap;
import java.util.Map;

public class HttpContextHolder {

    private HttpContextHolder() {

    }
    private static final ThreadLocal<Map<String, Object>> requestStore = InheritableThreadLocal.withInitial(HashMap::new);

    public static void setItem(String key, Object value) {
        requestStore.get().put(key, value);
    }

    public static Object getItem(String key) {
        return requestStore.get().get(key);
    }

    public static void clear() {
        requestStore.remove();
    }
}
