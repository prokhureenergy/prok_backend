package com.prokhure.erp.infrastructure.config;

import com.prokhure.erp.domain.ports.spi.UserTrackerPersistencePort;
import com.prokhure.erp.infrastructure.adapter.UserSqlTracker;
import com.prokhure.erp.infrastructure.mapper.UserRegAuthDto;
import com.prokhure.erp.infrastructure.repository.users.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserServiceConfig {
//    private final PartyServiceProperties partyServiceProperties;
//
//    public RefundsConfig(PartyServiceProperties partyServiceProperties) {
//        this.partyServiceProperties = partyServiceProperties;
//    }
//
//    @Bean
//    public PartyServiceAdapter partyServiceAdapter(
//            DownStreamServiceClient internalDownStreamServiceClient) {
//        return new PartyServiceAdapterImpl(internalDownStreamServiceClient, partyServiceProperties);
//    }

    @Bean
    public UserRegAuthDto userRegAuthDto() {
        return new UserRegAuthDto();
    }

    @Bean
    public UserTrackerPersistencePort userTrackerPersistencePort(
            AuthenticationRepository authenticationRepository, RoleRepository roleRepository,
            AddressRepository addressRepository, PermissionRepository permissionRepository,
            CompanyRepository companyRepository, UserRepository userRepository,
            DocumentRepository documentRepository, VendorRepository vendorRepository,
            BankRepository bankRepository, UserBankDetailRepository userBankDetailRepository,
            TokenRepository tokenRepository, UserRegAuthDto dtoMapper) {
        return new UserSqlTracker(authenticationRepository,roleRepository,
                addressRepository,permissionRepository,companyRepository,userRepository,
                documentRepository,vendorRepository,bankRepository,
                userBankDetailRepository,tokenRepository,
                dtoMapper);
    }
}
