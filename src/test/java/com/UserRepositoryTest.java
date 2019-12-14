package com;

import com.dao.UserRepository;
import com.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: data
 * @Date: 2019-12-14 10:39
 * @Author: code1990
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Resource
    private UserRepository userRepository;

    @Test
    public void test(){
        Date data = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = dateFormat.format(data);

        userRepository.save(new User("aa","aa123456","aa@126.com","aa",formattedDate));
        userRepository.save(new User("bb","bb123456","bb@126.com","bb",formattedDate));
        userRepository.save(new User("cc","cc123456","cc@126.com","cc",formattedDate));

        Assert.assertEquals(3,userRepository.findAll().size());
        Assert.assertEquals("bb",userRepository.findByUserNameOrEmail("bb","bb@126.com").getNickName());
        userRepository.delete(userRepository.findByUserName("aa"));
    }

    @Test
    public void testFindALL(){
        int page = 1;
        int size = 1;
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = PageRequest.of(page,size,sort);
        Page<User> all = userRepository.findALL(pageable);
        Assert.assertEquals(1,all.getContent().size());
        Assert.assertEquals(2,all.getTotalPages());
    }

    @Test
    public void testFindByNickName(){
        int page = 0;
        int size = 1;
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = PageRequest.of(page,size,sort);
        Page<User> all = userRepository.findByNickName("bb",pageable);
        Assert.assertEquals(1,all.getContent().size());
        Assert.assertEquals(1,all.getTotalPages());
    }

}
