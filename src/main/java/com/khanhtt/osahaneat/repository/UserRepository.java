package com.khanhtt.osahaneat.repository;

import com.khanhtt.osahaneat.entity.Users;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
  List<Users> findByUserNameAndPassword(String username, String password);
}
