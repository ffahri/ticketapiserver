package com.webischia.apiserver.Controllers;

import com.webischia.apiserver.Services.UserService;
import com.webischia.apiserver.api.v1.model.TicketDTO;
import com.webischia.apiserver.api.v1.model.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/api/register/","/api/register"})
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    //@PostMapping("/create")
    @PutMapping("/create")
    public ResponseEntity<UserDTO> register(@RequestBody UserDTO userDTO)
    {
        userService.register(userDTO);

        return new ResponseEntity<UserDTO>(userDTO, HttpStatus.CREATED);

    }
}
