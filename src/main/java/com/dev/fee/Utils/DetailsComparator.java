package com.dev.fee.Utils;

import java.util.Comparator;

import com.dev.fee.bean.TransactionBean;

public class DetailsComparator implements Comparator<TransactionBean>{

	@Override
	public int compare(TransactionBean o1, TransactionBean o2) {
		
		int flag = o1.getClientId().compareTo(o2.getClientId());
		if(flag == 0){
			flag = o1.getTransactionType().compareTo(o2.getTransactionType());
			if(flag == 0){
				flag = o1.getTransactionDate().compareTo(o2.getTransactionDate());
				if(flag == 0){
					flag = o1.getPriorityFlag().compareTo(o2.getPriorityFlag());
				}
			}
		}
		return flag;
	}


		
}
