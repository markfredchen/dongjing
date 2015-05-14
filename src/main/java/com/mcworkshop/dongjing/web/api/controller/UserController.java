package com.mcworkshop.dongjing.web.api.controller;

import com.mcworkshop.dongjing.domain.User;
import com.mcworkshop.dongjing.exception.ObjectNotFoundException;
import com.mcworkshop.dongjing.service.UserService;
import com.mcworkshop.dongjing.web.api.resource.IdResource;
import com.mcworkshop.dongjing.web.api.resource.MapResource;
import com.mcworkshop.dongjing.web.api.resource.UserResource;
import com.mcworkshop.dongjing.web.api.resource.asm.UserResourceAsm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created by markfredchen on 4/10/15.
 */
@Controller
@RequestMapping(value = "/api/users")
public class UserController {


    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public IdResource createUser(@RequestBody @Valid UserResource userResource) {
        return new IdResource(userService.createUser(userResource.toEntity()));
    }


    @RequestMapping(value = "/{userOID}", method = RequestMethod.PUT)
    @ResponseBody
    public IdResource updateUser(@PathVariable UUID userOID, @RequestBody @Valid UserResource userResource) {
        userResource.setUserOID(userOID.toString());
        return new IdResource(userService.updateUser(userResource.toEntity()));
    }

    @RequestMapping(value = "/check/username/{username}", method = RequestMethod.GET)
    @ResponseBody
    public MapResource checkUsernameUniqueness(@PathVariable String username) {
        return new MapResource("isUnique", userService.getUserByUsername(username) == null);
    }

    @RequestMapping(value = "/{userOID}", method = RequestMethod.GET)
    @ResponseBody
    public UserResource getUser(@PathVariable UUID userOID) {
        User user = userService.getUser(userOID);
        if (user == null) {
            throw new ObjectNotFoundException(User.class, userOID);
        }
        return new UserResourceAsm().toResource(user);
    }

    @RequestMapping(value = "/{userOID}", method = RequestMethod.DELETE)
    @ResponseBody
    public IdResource deleteUser(@PathVariable UUID userOID) {
        userService.deleteUser(userOID);
        return new IdResource(userOID);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<UserResource> getAllUsers() {
        List<User> users = userService.getAllUsers();
        UserResourceAsm userResourceAsm = new UserResourceAsm();
        return users.stream().map(user -> userResourceAsm.toResource(user)).collect(Collectors.toList());
    }

}
