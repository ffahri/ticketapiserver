package com.webischia.apiserver.Controllers;

import com.webischia.apiserver.Repositories.UserRepository;
import com.webischia.apiserver.Services.UserService;
import com.webischia.apiserver.api.v1.model.UserDTO;
import com.webischia.apiserver.api.v1.model.UserListDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping({"/api/v1/users/","/api/v1/users"})
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }



    @PreAuthorize("hasAuthority('Admin')")
    @GetMapping
    public ResponseEntity<UserListDTO> getAllUsers()
    {
            return new ResponseEntity<UserListDTO>(new UserListDTO(userService.getAllUsers()), HttpStatus.OK);
    }
    @PreAuthorize("hasAuthority('Admin')")
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable int id)
    {
        return new ResponseEntity<UserDTO>(userService.getUserById(id), HttpStatus.OK);
    }

}
