package com.neoteric.springBootdemo;

import com.neoteric.springBootdemo.model.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository  extends JpaRepository<AccountEntity ,String> {

    @Query("select a from AccountEntity a join fetch a.accountEntityAddressesList ad where a.accountnumber=ad.accountnumber " +
            "and a.accountnumber=:accountnumber and ad.statuscode=:statuscode")
    AccountEntity getAccountEntityStatusJpql(@Param("accountnumber") String accountnumber,@Param("statuscode") Integer statusCode);

    @Query("select a from AccountEntity a inner join a.accountEntityAddressesList ad where  a.accountnumber=ad.accountnumber  and a.accountnumber=:accountnumber"  )
    AccountEntity getAccountEntityJpql(@Param("accountnumber") String accountnumber);
    AccountEntity findByAccountnumber(@Param("accountnumber") String accountnumber);
    AccountEntity findByAccountnumberAndPan(@Param("accountnumber") String accountnumber,
                                            @Param("pan") String pan);

    List<AccountEntity> findByBalanceLessThan(@Param("balance") String balance);

    List<AccountEntity> findByBalanceGreaterThan(@Param("balance") String balance);

    List<AccountEntity> findByBalanceBetween(String lowerRange,String upperRange);
}
