package com.prokhure.erp.infrastructure.repository.users;

import com.prokhure.erp.infrastructure.entity.users.UserBankDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserBankDetailRepository extends JpaRepository<UserBankDetail, Long> {
    @Query(value = "SELECT b FROM UserBankDetail b WHERE b.userUuid = :userUuid",
    countQuery = "SELECT COUNT(b) FROM UserBankDetail b WHERE b.userUuid = :userUuid")
    Optional<List<UserBankDetail>> getAllBankByUserId(@Param("userUuid") String userId);

    @Query(value = "SELECT b FROM UserBankDetail b WHERE b.userBankUuid = :userBankUuid",
    countQuery = "SELECT COUNT(b) FROM UserBankDetail b WHERE b.userBankUuid = :userBankUuid")
    Optional<UserBankDetail> getBankByUserBankId(@Param("userBankUuid") String userBankUuid);
}
