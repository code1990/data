package com.dao;

import com.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 * @program: data
 * @Date: 2019-12-14 10:39
 * @Author: code1990
 * @Description:
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserNameOrEmail(String userName, String email);

    User findByUserName(String userName);

    /**
     * @return org.springframework.data.domain.Page<com.jpa.springdatajpa.model.User>
     * @Author Smith
     * @Description 自定义Sql查询.(这个本来是HQL的写法, 我的运行不了, 改成了本地的SQL)
     * @Date 10:18 2019/1/24
     * @Param
     **/
    @Query(value = "select * from user", nativeQuery = true)
    Page<User> findALL(Pageable pageable);

    /**
     * @return org.springframework.data.domain.Page<com.jpa.springdatajpa.model.User>
     * @Author Smith
     * @Description 原生SQL的写法,?1表示方法参数中的顺序
     * @Date 10:20 2019/1/24
     * @Param
     **/
    @Query(value = "select * from user where nick_name = ?1", nativeQuery = true)
    Page<User> findByNickName(String nickName, Pageable pageable);

    /**
     * @return int
     * @Author Smith
     * @Description 修改, 添加事务的支持
     * @Date 10:21 2019/1/24
     * @Param
     **/
    @Transactional
    @Modifying
    @Query("update User set userName = ?1 where id = ?2")
    int modifyById(String userName, Long id);

    /**
     * @return void
     * @Author Smith
     * @Description 删除
     * @Date 10:22 2019/1/24
     * @Param
     **/
    @Transactional
    @Modifying
    @Query("delete from User where id = ?1")
    @Override
    void deleteById(Long id);
}