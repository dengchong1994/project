package com.dc.starter.pds;

/**
 * 保存一个线程安全的DatabaseType容器
 */
public class DatabaseContextHolder {

    private static final ThreadLocal<DatabaseType> contextHolder = new ThreadLocal<>();

    /**
     * 设置动态数据源
     * @param type
     */
    public static void setDatabaseType(DatabaseType type){
        contextHolder.set(type);
    }

    /**
     * 获取动态数据源
     * @return
     */
    public static DatabaseType getDatabaseType(){
        return contextHolder.get();
    }

    /**
     * 清除数据源的key，防止线程再次进来获取之前的数据源
     */
    public static void clearDataSourceKey() {
        contextHolder.remove();
    }

}
