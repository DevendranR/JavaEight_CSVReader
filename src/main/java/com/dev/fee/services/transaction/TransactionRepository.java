package com.dev.fee.services.transaction;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dev.fee.bean.TransactionBean;

@Repository
public interface TransactionRepository  extends CrudRepository<TransactionBean, String>{
	
}
