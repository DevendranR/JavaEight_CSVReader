package com.dev.fee.fileReaders;

import com.dev.fee.services.transaction.TransactionService;

@FunctionalInterface
public interface Readers {
	public String readAndCalculateFee(String inputFileLocation, TransactionService service) throws Exception;
}
