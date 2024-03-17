package com.prokhure.erp.infrastructure.repository.users;

import com.prokhure.erp.infrastructure.entity.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT a FROM User a WHERE a.userUuid = :userUuid",
            countQuery = "SELECT COUNT(a) FROM User a WHERE a.userUuid = :userUuid")
    Optional<User> findUserByUserId(@Param("userUuid")String userUuid);
}
