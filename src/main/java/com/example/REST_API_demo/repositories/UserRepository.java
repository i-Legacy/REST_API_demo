package com.example.REST_API_demo.repositories;

import com.example.REST_API_demo.models.UserModel;
import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository // No es una clase es una interfaz -> implementa ciertos metodos
public interface UserRepository extends CrudRepository<UserModel, Long> {
  // No need to implement
  public abstract ArrayList<UserModel> findByPriority(Integer priority);
}
