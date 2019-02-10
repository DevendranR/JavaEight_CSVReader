package com.dev.fee.services.transaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.fee.bean.TransactionBean;

@Service
@Transactional
public class TransactionService {
	@Autowired
	TransactionRepository transactionRepository;
	public void processTransactions(List<TransactionBean> transList) throws Exception{
		
		transList.parallelStream().forEach(tr -> {
			transList.parallelStream().filter(itr ->  { return tr.getTransactionDate().compareTo(itr.getTransactionDate())==0
					&&tr.getClientId().equalsIgnoreCase(itr.getClientId())
					&&tr.getSecurityId().equalsIgnoreCase(itr.getSecurityId())
					&&((tr.getTransactionType().equalsIgnoreCase("Buy")&&itr.getTransactionType().equalsIgnoreCase("Sell"))
							||(tr.getTransactionType().equalsIgnoreCase("Sell")&&itr.getTransactionType().equalsIgnoreCase("Buy")));}).forEach(itr ->{
				//do all operation 
				tr.setProcessingFee(10.00);
				itr.setProcessingFee(10.00);
			});
			
			if(tr.getProcessingFee()==null){
				if(tr.getPriorityFlag()=='Y'){
					tr.setProcessingFee(500.00);
				}else{
					if(tr.getTransactionType().equalsIgnoreCase("Sell")||
							tr.getTransactionType().equalsIgnoreCase("Withdraw")){
						tr.setProcessingFee(100.00);
					}else if(tr.getTransactionType().equalsIgnoreCase("Buy")||
							tr.getTransactionType().equalsIgnoreCase("Deposit")){
						tr.setProcessingFee(50.00);
					}
				}
			}
		});
		
		transactionRepository.saveAll(transList);
	}
}
