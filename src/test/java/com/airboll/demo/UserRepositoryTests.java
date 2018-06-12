package com.airboll.demo;

import java.text.DateFormat;
import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.airboll.demo.domain.User;
import com.airboll.demo.domain.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserRepositoryTests {
  @Autowired
  UserRepository userRepository;

  @Test
  public void test() {
    /*Date date = new Date();
    DateFormat dateFormat = DateFormat.getTimeInstance(DateFormat.LONG);
    String formattedDate = dateFormat.format(date);

    userRepository.save(new User("aa1", "aa@126.com", "aa", "aa123456",
        formattedDate));
    userRepository.save(new User("bb2", "bb@126.com", "bb", "bb123456",
        formattedDate));
    userRepository.save(new User("cc3", "cc@126.com", "cc", "cc123456",
        formattedDate));*/
    Assert.assertEquals(3, userRepository.findAll().size());
    Assert.assertEquals("bb2",
        userRepository.findByUserNameOrEmail("bb", "bb@126.com").getNickName());
    userRepository.delete(userRepository.findByUserName("aa"));
  }
}
