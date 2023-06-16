package com.poc.example.repository;

import com.poc.example.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

    @Query(value = "select * from account a where a.type= ?1", nativeQuery=true)
    List<Account> activeAccount(@Param("type") String type);

    List<Account> getByCardCodeAndName(String cardCode, String name);
}
