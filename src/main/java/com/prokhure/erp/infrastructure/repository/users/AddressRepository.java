package com.prokhure.erp.infrastructure.repository.users;

import com.prokhure.erp.infrastructure.entity.users.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {

}
