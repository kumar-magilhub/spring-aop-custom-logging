package com.customerauditlogging.controller;

import com.customerauditlogging.dto.UserDto;
import com.customerauditlogging.logging.ActionAnnotation;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {


    @PostMapping("/")
    @ActionAnnotation(typeOfAction = "CREATE", typeOfModule = "USER", comment = "Creating user")
    public Map<String, String> createUser(@RequestBody UserDto userDto) {
        Map<String, String> response = new HashMap<>();
        response.put("Response","Success");
        return response;
    }

    @DeleteMapping("/")
    @ActionAnnotation(typeOfAction = "DELETE", typeOfModule = "USER", comment = "deleting user")
    public Map<String, String> createUser(@RequestParam (value = "userId") String userId,
                                          @RequestParam (value = "staffId") String staffId) {
        Map<String, String> response = new HashMap<>();
        response.put("Response", "Success");
        return response;
    }

    @PutMapping("/")
    @ActionAnnotation(typeOfAction = "UPDATE", typeOfModule = "USER",comment = "updating user")
    public Map<String, String> updateUser(@RequestBody UserDto userDto) {
        Map<String, String> response = new HashMap<>();
        response.put("Response","Success");
        return response;
    }

}
