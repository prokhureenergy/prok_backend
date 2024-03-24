package com.prokhure.erp.infrastructure.config;

import com.prokhure.erp.domain.ports.spi.CategoryPesistencePort;
import com.prokhure.erp.domain.ports.spi.UserTrackerPersistencePort;
import com.prokhure.erp.infrastructure.adapter.CategorySqlService;
import com.prokhure.erp.infrastructure.adapter.UserSqlTracker;
import com.prokhure.erp.infrastructure.mapper.CategoryMapper;
import com.prokhure.erp.infrastructure.mapper.UserRegAuthDto;
import com.prokhure.erp.infrastructure.repository.products.CategoryRepository;
import com.prokhure.erp.infrastructure.repository.users.*;
import com.prokhure.erp.infrastructure.repository.views.UsersViewRepository;
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
    public CategoryMapper categoryMapper() {
        return new CategoryMapper();
    }

    @Bean
    public UserTrackerPersistencePort userTrackerPersistencePort(
            AuthenticationRepository authenticationRepository, RoleRepository roleRepository,
            AddressRepository addressRepository, PermissionRepository permissionRepository,
            UserRepository userRepository,
            DocumentRepository documentRepository, BusinessUserRepository businessUserRepository,
            BankRepository bankRepository, UserBankDetailRepository userBankDetailRepository,
            TokenRepository tokenRepository, UsersViewRepository UsersViewRepository, UserRegAuthDto dtoMapper) {
        return new UserSqlTracker(authenticationRepository,roleRepository,
                addressRepository,permissionRepository,userRepository,
                documentRepository, businessUserRepository,bankRepository,
                userBankDetailRepository,tokenRepository,UsersViewRepository,
                dtoMapper);
    }

    @Bean
    public CategoryPesistencePort categoryPesistencePort(CategoryRepository categoryRepository,
                                                         CategoryMapper categoryMapper) {
        return new CategorySqlService(categoryRepository,categoryMapper);
    }
}
