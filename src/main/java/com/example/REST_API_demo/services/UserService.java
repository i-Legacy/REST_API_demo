package com.example.REST_API_demo.services;

import com.example.REST_API_demo.models.UserModel;
import com.example.REST_API_demo.repositories.UserRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  UserRepository userRepository;

  public ArrayList<UserModel> getUsers() {
    return (ArrayList<UserModel>) userRepository.findAll();
  }

  /**
   * Ejemplo
   * @param user nombre:Juan email:juan@gmail.com
   * @return id:1 nombre:Juan email:juan@gmail.com
   */
  public UserModel addUser(UserModel user) {
    return userRepository.save(user);
    // Si posteamos con ID incluido, se actualiza un usuario
  }

  public Optional<UserModel> getById(Long id) {
    return userRepository.findById(id);
  }

  public ArrayList<UserModel> getByPriority(Integer priority) {
    return userRepository.findByPriority(priority);
  }

  public boolean deleteUser(Long id) {
    try {
      userRepository.deleteById(id);
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
