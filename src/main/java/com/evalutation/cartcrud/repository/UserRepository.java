package com.evalutation.cartcrud.repository;

import com.evalutation.cartcrud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long> {
    boolean existsByEmailAndUsername(String email, String username);

    User findByUsername(String username);
}
