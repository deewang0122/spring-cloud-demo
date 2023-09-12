package com.dee.system.repository;

import com.dee.system.domain.Account;
import com.dee.system.domain.User;
import com.dee.system.global.BaseGlobalRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseGlobalRepository<User>, JpaRepository<User, String> {

}
