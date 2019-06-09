package com.example.springbootjpademo.repository;


import com.example.springbootjpademo.entity.GradeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author sh on 2019/5/25 21:05
 * @version ideaIU-2018.2.3.win_home
 */
public interface GradeRepository extends JpaRepository<GradeEntity,String> {
}
