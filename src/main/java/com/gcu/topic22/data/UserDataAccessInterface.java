package com.gcu.topic22.data;

public interface UserDataAccessInterface <T>{
    public T findByUsername(String username);
}
