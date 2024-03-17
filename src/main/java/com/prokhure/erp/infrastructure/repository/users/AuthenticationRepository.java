package com.prokhure.erp.infrastructure.repository.users;

import com.prokhure.erp.infrastructure.entity.users.Authentication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthenticationRepository extends JpaRepository<Authentication, Long> {
    @Query(value = "SELECT a FROM Authentication a WHERE a.email = :email AND a.userRole = :userRole",
    countQuery = "SELECT COUNT(a) FROM Authentication a WHERE a.email = :email AND a.userRole = :userRole")
    Optional<Authentication> findAuthenticationByEmailAndCustomerType(@Param("email")String email, @Param("userRole") String userRole);

    @Query(value = "SELECT a FROM Authentication a WHERE a.userUuid = :userUuid",
    countQuery = "SELECT COUNT(a) FROM Authentication a WHERE a.userUuid = :userUuid")
    Optional<Authentication> findAuthenticationByUserId(@Param("userUuid") String userUuid);

    @Query(value = "SELECT a FROM Authentication a WHERE a.email = :email",
            countQuery = "SELECT COUNT(a) FROM Authentication a WHERE a.email = :email")
    Optional<Authentication> findAuthenticationByEmail(@Param("email")String email);
}
