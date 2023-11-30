package com.example.Midterm_Java.Repository;

import com.example.Midterm_Java.Models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    @Query(value = "select * from Account a Where a.accountname = :accountname and a.password = :password", nativeQuery = true)
    Account findUser(@Param("accountname") String accountname, @Param("password") String password);

}
