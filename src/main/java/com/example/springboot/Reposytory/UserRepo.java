package com.example.springboot.Reposytory;

import com.example.springboot.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
}
