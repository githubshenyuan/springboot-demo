package com.example.springbootjpademo.common.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * @author sh 2019/3/22 13:42
 * @version ideaIU-2018.2.5.win
 */
@NoRepositoryBean
public interface BaseJpaRepository <T, ID extends Serializable> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {
}
