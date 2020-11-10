package com.dc.starter.pds;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * springboot集成mybatis的多数据源基本入口
 */
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = DataSourceAutoConfiguration.class)})
@Configuration
public class DataSourceConfig {

    /**
     * 创建数据源(数据源的名称：方法名可以取为XXXDataSource(),XXX为数据库名称,该名称也就是数据源的名称)
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.read1")
    public DataSource readDataSource() {
        return new DruidDataSource();
    }

    /**
     * 创建数据源
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.write1")
    public DataSource writeDataSource() {
        return new DruidDataSource();
    }

    @Bean("dataSource-durid")
    @Primary
    public DataSource dataSource(@Qualifier("readDataSource") DataSource readDataSource,
                                 @Qualifier("writeDataSource") DataSource writeDataSource) {
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DatabaseType.READ_1, readDataSource);
        targetDataSources.put(DatabaseType.WRITE_1, writeDataSource);
        DynamicDataSource dataSource = new DynamicDataSource();
        // 该方法是AbstractRoutingDataSource的方法
        dataSource.setTargetDataSources(targetDataSources);
        // 默认的datasource设置为myTestDbDataSource
        dataSource.setDefaultTargetDataSource(readDataSource);
        return dataSource;
    }

    /**
     * 配置事务管理器
     * @param dataSource
     * @return
     */
    @Bean
    public DataSourceTransactionManager transactionManager(@Qualifier("dataSource-durid") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * 配置事务的切面
     * @param dataSource
     * @return
     */
    @Bean
    public Advisor txAdviceAdvisor(@Qualifier("dataSource-durid")DataSource dataSource) {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* com.jzy.***.service..*.*(..))");
        return new DefaultPointcutAdvisor(pointcut, txAdvice(dataSource));
    }

    /**
     * 配置事务的传播特性
     * @param dataSource
     * @return
     */
    @Bean
    public TransactionInterceptor txAdvice(@Qualifier("dataSource-durid")DataSource dataSource) {
        DefaultTransactionAttribute txAttr_REQUIRED = new DefaultTransactionAttribute();
        txAttr_REQUIRED.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        DefaultTransactionAttribute txAttr_REQUIRED_READONLY = new DefaultTransactionAttribute();
        txAttr_REQUIRED_READONLY.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        txAttr_REQUIRED_READONLY.setReadOnly(true);

        NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();

        source.addTransactionalMethod("insert*", txAttr_REQUIRED);
        source.addTransactionalMethod("save*", txAttr_REQUIRED);
        source.addTransactionalMethod("add*", txAttr_REQUIRED);

        source.addTransactionalMethod("update*", txAttr_REQUIRED);
        source.addTransactionalMethod("run*", txAttr_REQUIRED);
        source.addTransactionalMethod("exec*", txAttr_REQUIRED);
        source.addTransactionalMethod("set*", txAttr_REQUIRED);

        source.addTransactionalMethod("delete*", txAttr_REQUIRED);
        source.addTransactionalMethod("remove*", txAttr_REQUIRED);

        source.addTransactionalMethod("get*", txAttr_REQUIRED_READONLY);
        source.addTransactionalMethod("select*", txAttr_REQUIRED_READONLY);
        source.addTransactionalMethod("query*", txAttr_REQUIRED_READONLY);
        source.addTransactionalMethod("find*", txAttr_REQUIRED_READONLY);
        source.addTransactionalMethod("count*", txAttr_REQUIRED_READONLY);
        source.addTransactionalMethod("is*", txAttr_REQUIRED_READONLY);

        return new TransactionInterceptor(transactionManager(dataSource), source);
    }


}
