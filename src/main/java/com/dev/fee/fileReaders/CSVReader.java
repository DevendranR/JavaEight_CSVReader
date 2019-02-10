package com.dev.fee.fileReaders;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.dev.fee.Utils.DateConverter;
import com.dev.fee.bean.TransactionBean;
import com.dev.fee.services.transaction.TransactionService;


public class CSVReader implements Readers{
	private CSVReader(){
		
	}
	public static Readers getInstance() {
		return new CSVReader();
	}
	@Override
	public String readAndCalculateFee(String inputFileLocation, TransactionService service) throws Exception{

		 Stream<String> readString = Files.lines(Paths.get(inputFileLocation));
		 List<TransactionBean> val = readString.map(p->p.split(",")).map(p->
												{
													TransactionBean t = new TransactionBean();
													t.setExternalTransactionId(p[0]);
													t.setClientId(p[1]);
													t.setSecurityId(p[2]);
													t.setTransactionType(p[3]);
													t.setTransactionDate(DateConverter.convertStringToDate(p[4]));
													t.setMarketValue(Double.parseDouble(p[5]));
													t.setPriorityFlag(p[6].charAt(0));
													return t;
												}).collect(Collectors.toList());

			readString.close();
			service.processTransactions(val);

		return null;
		
		
	}
	
}
