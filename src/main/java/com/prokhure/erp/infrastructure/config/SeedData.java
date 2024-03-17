package com.prokhure.erp.infrastructure.config;

import com.prokhure.erp.infrastructure.dto.BankSeedDto;
import com.prokhure.erp.infrastructure.entity.users.Bank;
import com.prokhure.erp.infrastructure.repository.users.BankRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SeedData implements CommandLineRunner {
    private final BankRepository bankRepository;
    public SeedData(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @Override
    public void run(String... args) {
        BankSeedDto bankSeedDto = new BankSeedDto();
        // Insert seed data here
        List<Bank> banks = bankSeedDto.bankSeed()
                .stream().map(x -> new Bank(x.getBankName(),x.getBankCode()))
                .toList();
        bankRepository.saveAll(banks);
    }

}
