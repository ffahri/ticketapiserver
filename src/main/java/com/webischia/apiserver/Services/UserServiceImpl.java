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
        User usernew = userMapper.userDTOToUser(user);
        userRepository.save(usernew);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::userToUserDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(int id) {
        return userMapper.userToUserDTO(userRepository.findById(id).get());
    }
}
