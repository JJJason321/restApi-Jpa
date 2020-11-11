package com.xinyu.restApiJpa.repositorys;

import com.xinyu.restApiJpa.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long>{


    @Query("SELECT a FROM ACCOUNT a WHERE LOWER(a.username) = LOWER(?1)")
    Account findByEmail(String username);

    @Query("SELECT count(a) FROM ACCOUNT a WHERE LOWER(a.username) = LOWER(?1)")
    int countByEmail(String username);
}
