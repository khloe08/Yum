package com.recipe.Yum.Service;

import com.recipe.Yum.domain.User;
import com.recipe.Yum.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class UserServiceTest {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;
    @Autowired
    EntityManager em;

    @Test
    public void newJoin() throws Exception{

        //given
        User user = new User();
        user.setName("kim");

        //when
        Long savedId = userService.join(user);

        //then
        em.flush();
        assertEquals(user, userRepository.findOne(savedId));

    }




}