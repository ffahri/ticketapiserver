package com.webischia.apiserver.Services;

import com.webischia.apiserver.Domains.User;
import com.webischia.apiserver.Repositories.UserRepository;
import com.webischia.apiserver.api.v1.mapper.UserMapper;
import com.webischia.apiserver.api.v1.model.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void register(UserDTO user) {
        User usernew = new User();
        usernew.setAccessLevel(userRepository.findById(1).get().getAccessLevel());
        usernew.setEmail(user.getEmail());
        usernew.setName(user.getSurname());
        usernew.setUsername(user.getName());
        usernew.setPassword(user.getPassword());
        userRepository.save(usernew);
    }

    @Override
    public List<User> getAllUsers() {
        //List<User> user = userRepository.findAll();
        return userRepository.findAll().stream().collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(int id) {
        return userMapper.userToUserDTO(userRepository.findById(id).get());
    }

    @Override
    public void registere(UserDTO user) {
        User usernew = new User();
        usernew.setAccessLevel(userRepository.findById(2).get().getAccessLevel());
        usernew.setEmail(user.getEmail());
        usernew.setName(user.getSurname());
        usernew.setUsername(user.getName());
        usernew.setPassword(user.getPassword());
        userRepository.save(usernew);
    }
}
