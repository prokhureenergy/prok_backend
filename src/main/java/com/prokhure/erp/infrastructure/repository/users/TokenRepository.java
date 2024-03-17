package com.prokhure.erp.infrastructure.repository.users;

import com.prokhure.erp.infrastructure.entity.users.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {
    @Query(value = "SELECT t FROM Token t WHERE t.token = :token AND t.used = false AND t.expirationTime > :currentDateTime",
    countQuery = "SELECT COUNT(t) FROM Token t WHERE t.token = :token AND t.used = false AND t.expirationTime > :currentDateTime")
    Token findTokenActive(@Param("token") String token, @Param("currentDateTime") LocalDateTime currentDateTime);

    @Query(value = "SELECT t FROM Token t WHERE t.token = :token AND t.partyId = :partyId AND t.used = false AND t.expirationTime > :currentDateTime",
    countQuery = "SELECT COUNT(t) FROM Token t WHERE t.token = :token AND t.partyId = :partyId AND t.used = false AND t.expirationTime > :currentDateTime")
    Token findTokenCurrentActive(@Param("token") String token, @Param("partyId") String partyId,
                                 @Param("currentDateTime") LocalDateTime currentDateTime);

    @Query(value = "SELECT t FROM Token t WHERE  t.partyId = :partyId AND t.used = false",
            countQuery = "SELECT t FROM Token t WHERE  t.partyId = :partyId AND t.used = false")
    List<Token> findTokenByPartyIdAndActive(@Param("partyId") String partyId);
}
