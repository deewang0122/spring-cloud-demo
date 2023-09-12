package com.dee.system.repository;

import com.dee.system.domain.Account;
import com.dee.system.global.BaseGlobalRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends BaseGlobalRepository<Account>, JpaRepository<Account, String> {
    Account findByAccount(String account);
}
