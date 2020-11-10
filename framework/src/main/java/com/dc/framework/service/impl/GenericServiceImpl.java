package com.dc.framework.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dc.framework.mapper.GenericMapper;
import com.dc.framework.service.GenericService;

public abstract class GenericServiceImpl<M extends GenericMapper<T>, T> extends ServiceImpl<M, T> implements GenericService<T> {



}
