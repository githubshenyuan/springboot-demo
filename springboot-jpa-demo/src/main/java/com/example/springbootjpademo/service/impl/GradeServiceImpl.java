package com.example.springbootjpademo.service.impl;

import com.example.springbootjpademo.common.base.BaseCRUDServiceImpl;
import com.example.springbootjpademo.entity.GradeEntity;
import com.example.springbootjpademo.service.GradeService;
import org.springframework.stereotype.Service;

/**
 * @author sh on 2019/6/8 5:56
 * @version ideaIU-2018.2.3.win_home
 */
@Service
public class GradeServiceImpl extends BaseCRUDServiceImpl<GradeEntity,String> implements GradeService{

    public GradeEntity getGradeEntity() {
        return new GradeEntity();
    }
}
