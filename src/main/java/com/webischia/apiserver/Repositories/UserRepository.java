package com.webischia.apiserver.Repositories;

import com.webischia.apiserver.Domains.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findById(int id);
    Optional<User> findByUsername(String name);
    Optional<User> findByEmail(String email);
    Optional<User> getAllByAccessLevel(int level);
}
