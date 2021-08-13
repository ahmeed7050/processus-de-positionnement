package io.redleanServices.positionnement.controller;

import io.redleanServices.positionnement.entity.Role;
import io.redleanServices.positionnement.entity.User;
import io.redleanServices.positionnement.service.RoleServiceImpl;
import io.redleanServices.positionnement.service.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

import javax.annotation.PostConstruct;

@RestController
@PreAuthorize("hasRole('Super_Admin')")
public class UserController {

    @Autowired
    private UserServiceImpl userService;
    
    @Autowired
    private RoleServiceImpl roleService;

    @PostConstruct
    public void initRoleAndUser() {
        userService.initRoleAndUser();
    }

    @PostMapping({"/user/save"})
    public User registerNewUser(@RequestBody User user) {
        return userService.registerNewUser(user);
    }
    @PostMapping({"/role/save"})
    public Role registerNewRole(@RequestBody Role role) {
        return roleService.createNewRole(role);
    }
    @PostMapping("/role/addtouser")
    public ResponseEntity<?>addRoleToUser(@RequestBody RoleToUserForm form) {
        userService.addRoleToUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }
    @GetMapping({"/forAdmin"})
    public String forAdmin(){
        return "This URL is only accessible to the admin";
    }

    @GetMapping({"/forUser"})
    public String forUser(){
        return "This URL is only accessible to the user";
    }
    @GetMapping({"/users/all"})
    public ResponseEntity<List<User>>getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }
}
class RoleToUserForm {
	 private String username;
	    private String roleName;
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getRoleName() {
			return roleName;
		}
		public void setRoleName(String roleName) {
			this.roleName = roleName;
		}
}
