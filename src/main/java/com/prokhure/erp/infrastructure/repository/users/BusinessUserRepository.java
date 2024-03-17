package com.prokhure.erp.infrastructure.repository.users;

import com.prokhure.erp.infrastructure.entity.users.BusinessUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BusinessUserRepository extends JpaRepository<BusinessUser, Long> {
    @Query(value = "SELECT a FROM BusinessUser a WHERE a.userUuid = :userUuid",
            countQuery = "SELECT COUNT(a) FROM BusinessUser a WHERE a.userUuid = :userUuid")
    Optional<BusinessUser> findBusinessUserByUserId(@Param("userUuid")String userUuid);
}
