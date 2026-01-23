package com.example.SpringCaching_D33.Repository;

import com.example.SpringCaching_D33.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
