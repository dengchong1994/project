package com.dc.framework.util;

import org.springframework.cglib.beans.BeanCopier;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CglibBeanCopierUtils {

    private static Map<String, BeanCopier> beanCopierMap = new ConcurrentHashMap<>(64);

    /**
     * 拷贝属性
     * @param source
     * @param target
     */
    public static void copyProperties(Object source, Object target) {
        // 获取拷贝对象
        BeanCopier copier = getBeanCopier(source, target);
        // 属性拷贝
        copier.copy(source, target, null);
    }

    public static BeanCopier getBeanCopier(Object source, Object target) {
        String key = source.toString() + target.toString();
        BeanCopier copier;
        if (!beanCopierMap.containsKey(key)) {
            copier = BeanCopier.create(source.getClass(), target.getClass(), false);
            beanCopierMap.put(key, copier);
        } else {
            copier = beanCopierMap.get(key);
        }
        return copier;
    }

}
