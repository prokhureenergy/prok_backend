package com.prokhure.erp.infrastructure.repository.users;

import com.prokhure.erp.infrastructure.entity.users.Authentication;
import com.prokhure.erp.infrastructure.entity.users.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long> {
    @Query(value = "SELECT a FROM Vendor a WHERE a.vendorUuid = :vendorUuid",
            countQuery = "SELECT COUNT(a) FROM Vendor a WHERE a.vendorUuid = :vendorUuid")
    Optional<Vendor> findVendorByUserId(@Param("vendorUuid")String vendorUuid);
}
