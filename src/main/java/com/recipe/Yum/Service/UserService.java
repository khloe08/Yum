package com.recipe.Yum.Service;


import com.recipe.Yum.domain.User;
import com.recipe.Yum.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor //final있는 필드만 가지고 생성자를 만들어줌.
public class UserService {

    private final UserRepository userRepository;


    //회원 가입
    @Transactional
    public Long join(User user){
        validateDuplicateMember(user);  //중복회원검증
        userRepository.save(user);
        return user.getId();
    }

    private void validateDuplicateMember(User user) {
        //Exception
        List<User> findMembers =userRepository.findByName(user.getName());
        if(!findMembers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }


    //회원 전체 조회
    public List<User> findMembers(){
        return userRepository.findAll();
    }

    public User findOne(Long memberId){
        return userRepository.findOne(memberId);
    }

    @Transactional
    public void update(Long id, String name) {
        User user = userRepository.findOne(id);
        user.setName(name);
    }
}
