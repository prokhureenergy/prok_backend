package com.prokhure.erp.infrastructure.repository.users;

import com.prokhure.erp.infrastructure.entity.users.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {
    @Query(value = "SELECT b FROM Bank b WHERE b.bankUUID = :bankUUID",
            countQuery = "SELECT COUNT(b) FROM Bank b WHERE b.bankUUID = :bankUUID")
    Optional<Bank> findBankByBankUuid(@Param("bankUUID") String bankUUID);
}
