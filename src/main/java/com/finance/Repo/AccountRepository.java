package com.finance.Repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finance.entity.*;
import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
    List<Account> findByUser(User user);
    List<Account> findByUserId(Long userId);
}

/*
 * ^rougjly the sam eas writing this in SQL: SELECT * FROM account WHERE user_id = ?;
 * List<Account> -> you're saying "This will return a list of Account objects"
 * findByUser -> magic mehto dname the spring understands:"Find all rows in the Account table where the user field equals the given user."
 * (User user) → You're passing in a User object (like user123), and Spring uses its id to query the database.
 */