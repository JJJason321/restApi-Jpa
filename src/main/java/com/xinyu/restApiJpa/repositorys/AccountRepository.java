package com.xinyu.restApiJpa.repositorys;

import com.xinyu.restApiJpa.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long>{
}
