package com.dc.framework.controller;

import com.dc.framework.exception.BizException;
import com.dc.framework.model.entity.Result;
import com.dc.framework.model.vo.GenericVo;
import com.dc.framework.util.CglibBeanCopierUtils;

import java.util.ArrayList;
import java.util.List;

public abstract class GenericController {

    /**
     * model转为Vo
     * @param model
     * @param vo
     * @param <T>
     * @return
     */
    protected <T extends GenericVo> T convert(Object model, Class<T> vo) {
        try {
            T t = vo.newInstance();
            CglibBeanCopierUtils.copyProperties(model, t);
            return t;
        } catch (Exception e) {
            throw new BizException("对象转换异常", e);
        }
    }

    /**
     * model转为List<Vo>
     * @param models
     * @param vo
     * @param <T>
     * @return
     */
    protected <T extends GenericVo> List<T> convert(List<? extends Object> models, Class<T> vo) {
        if (models != null && models.size() > 0) {
            // 针对同一类型的集合进行优化，只获取一次对象，减少从Map中遍历的次数，提高效率
            // BeanCopier beanCopier = CglibBeanCopierUtils.getBeanCopier(models.get(0), vo);
            List<T> list = new ArrayList<>();
            for (Object model : models) {
                try {
                    if (model != null) {
                        T t = vo.newInstance();
                        CglibBeanCopierUtils.copyProperties(model, t);
                        list.add(t);
                    }
                } catch (Exception e) {
                    throw new BizException("对象转换异常", e);
                }
            }
            return list;
        }
        return null;
    }

}
