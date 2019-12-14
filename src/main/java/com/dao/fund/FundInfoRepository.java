package com.dao.fund;

import com.entity.User;
import com.entity.fund.FundInfo;
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
public interface FundInfoRepository extends JpaRepository<FundInfo, Long> {

}