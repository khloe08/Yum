package com.recipe.Yum.repository;

import com.recipe.Yum.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    @Rollback(value = false)
    public void save() {
        //given
        User user = new User();
        user.setName("kim");

        Long savedId = userRepository.save(user);
        User findUser = userRepository.findOne(savedId);

        assertThat(findUser.getId()).isEqualTo(user.getId());


    }

    @Test
    void findOne() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findByName() {
    }
}