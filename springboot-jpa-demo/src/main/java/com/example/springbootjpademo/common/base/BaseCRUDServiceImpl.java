package com.example.springbootjpademo.common.base;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

/**
 * @author sh 2019/3/22 13:41
 * @version ideaIU-2018.2.5.win
 */
public class BaseCRUDServiceImpl<T, ID extends Serializable> implements BaseCRUDService<T, ID>{


    BaseJpaRepository<T,ID> baseJpaRepository;

    public T findOne(ID id) {
        return baseJpaRepository.findOne(id);
    }

    public Iterable<T> findAll(Iterable<ID> ids) {
        return baseJpaRepository.findAll(ids);
    }

    public T save(T t) {
        return baseJpaRepository.save(t);
    }

    public Iterable<T> save(Iterable<T> entities) {
        return baseJpaRepository.save(entities);
    }

    public T update(T t) {
        return baseJpaRepository.save(t);
    }

    public Iterable<T> update(Iterable<T> entities) {
        return baseJpaRepository.save(entities);
    }

    public void delete(ID id) {
        baseJpaRepository.delete(id);
    }

    public void delete(T t) {
        baseJpaRepository.delete(t);
    }

    public void delete(Iterable<? extends T> entities) {
        baseJpaRepository.delete(entities);
    }

    @Override
    public Iterable<T> testSpecificaiton() {

        Specification<T> specification = new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                //root.get("address")表示获取address这个字段名称,like表示执行like查询,%zt%表示值
                Predicate p1 = criteriaBuilder.like(root.get("address"), "%zt%");
                Predicate p2 = criteriaBuilder.greaterThan(root.get("id"), 3);
                //将两个查询条件联合起来之后返回Predicate对象
                return criteriaBuilder.and(p1, p2);
            }
        };
        List<T> stus = baseJpaRepository.findAll(specification);
        return null;
    }

}
