package com.dev.fee.services.transaction;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.fee.Utils.DateConverter;
import com.dev.fee.bean.TransactionBean;
@Service
@Transactional
public class ReportGeneratorService {
	@Autowired
	TransactionRepository transactionRepository;
	public Iterable<TransactionBean> generateReport() throws IOException{
		
		Iterable<TransactionBean> transList = transactionRepository.findAll();
		String seperator = "\n";
		String header = "ClientId, Transaction Type, TransactionDate, Priority, ProcessingFee";
/*		String content = "Hello World !!";
		 
		Files.write(Paths.get("c:/output.txt"), content.getBytes())*/;
		/*FileWriter fileWriter = new FileWriter(new File("src/com/dev/fee/resources/FinalData.csv"));
		fileWriter.append(header);
		fileWriter.append(seperator);
		transList.forEach(transaction ->   {
			try {
				String comma = ",";
				fileWriter.append(transaction.getClientId()).append(comma)
				.append(transaction.getTransactionType()).append(comma)
				.append(DateConverter.convertDateToString(transaction.getTransactionDate())).append(comma)
				.append(transaction.getPriorityFlag()).append(comma).append("$"+transaction.getProcessingFee())
				.append(seperator);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		fileWriter.close();
		fileWriter.flush();*/
		
		return transList;
	}
	
}
