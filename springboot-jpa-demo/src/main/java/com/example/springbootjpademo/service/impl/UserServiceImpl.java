package com.example.springbootjpademo.service.impl;

import com.example.springbootjpademo.common.base.BaseCRUDServiceImpl;
import com.example.springbootjpademo.common.utils.DateUtil;
import com.example.springbootjpademo.common.utils.PathUtil;
import com.example.springbootjpademo.entity.GradeEntity;
import com.example.springbootjpademo.entity.UserEntity;
import com.example.springbootjpademo.repository.UserRepository;
import com.example.springbootjpademo.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author sh on 2019/5/25 21:08
 * @version ideaIU-2018.2.3.win_home
 */
@Service
public class UserServiceImpl extends BaseCRUDServiceImpl<UserEntity,String> implements UserService {
    @Resource
    UserRepository userRepository;
    @Resource
    GradeServiceImpl gradeService;

    public UserEntity get() {

        UserEntity userEntity = userRepository.findOne("4028b8816a795079016a7950c6480000");
        String a = DateUtil.getNowDateFormat();

        if (StringUtils.isEmpty(a)) {
            return null;
        }
        String b = PathUtil.getTmpPath();
        if (StringUtils.isEmpty(b)) {

            return null;
        }
        GradeEntity gradeEntity = gradeService.getGradeEntity();

        if (gradeEntity == null) {
            return null;
        }
        return userEntity;
    }
}
