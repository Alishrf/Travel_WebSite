package io.github.alishrf.travel_website.repository;

import io.github.alishrf.travel_website.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
