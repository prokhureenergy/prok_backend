package com.prokhure.erp.infrastructure.repository.users;

import com.prokhure.erp.infrastructure.entity.users.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<Document,Long> {
}
