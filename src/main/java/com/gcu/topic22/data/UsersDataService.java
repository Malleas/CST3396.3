package com.gcu.topic22.data;

import com.gcu.topic22.data.entity.UserEntity;
import com.gcu.topic22.data.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsersDataService implements UserDataAccessInterface<UserEntity>, DataAccessInterface<UserEntity>{

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<UserEntity> findAll() {
        return null;
    }

    @Override
    public UserEntity findById(String id) {
        return null;
    }

    @Override
    public boolean create(UserEntity userEntity) {
        return false;
    }

    @Override
    public boolean update(UserEntity userEntity) {
        return false;
    }

    @Override
    public boolean delete(UserEntity userEntity) {
        return false;
    }

    @Override
    public UserEntity findByUsername(String username) {
        return usersRepository.findByUsername(username);
    }
}
