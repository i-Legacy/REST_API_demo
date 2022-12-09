package com.example.REST_API_demo.controllers;

import com.example.REST_API_demo.models.UserModel;
import com.example.REST_API_demo.services.UserService;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping
  public ArrayList<UserModel> getUsers() {
    return userService.getUsers();
  }

  @PostMapping
  public UserModel addUser(@RequestBody UserModel user) {
    // @RequestBody annotation maps the HttpRequest
    // body to a transfer or domain object,
    return this.userService.addUser(user);
  }

  @GetMapping(path = "/{id}") // Ejemplo http://localhost:8080/1
  public Optional<UserModel> getUserById(@PathVariable("id") Long ID) {
    return this.userService.getById(ID);
  }

  @GetMapping("/query")
  // Ejemplo http://localhost:8080/user/query?priority=5
  public ArrayList<UserModel> getUserByPriority(
    @RequestParam("priority") Integer priority
  ) {
    return this.userService.getByPriority(priority);
  }

  @DeleteMapping(path = "/{id}")
  public String deleteById(@PathVariable("id") Long id) {
    boolean ok = this.userService.deleteUser(id);
    if (ok) {
      return "Se elimino el usuario con id " + id;
    } else {
      return "No se pudo eliminar el usuario con id " + id;
    }
  }
}
