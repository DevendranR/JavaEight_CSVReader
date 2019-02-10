package com.dev.fee.api;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dev.fee.fileReaders.CSVReader;
import com.dev.fee.fileReaders.Readers;
import com.dev.fee.services.transaction.TransactionService;

@RestController
public class TransactionReaderApi {
	private static final Logger LOGGER = Logger.getLogger(TransactionReaderApi.class);
	@Autowired
	TransactionService service;
	private static Map<String,Object> listOfClasses = new HashMap<>();
	static{
		populateClassesMap();
	}
	private static void populateClassesMap() {
		listOfClasses.put("csv", CSVReader.getInstance());
		//Assuming Classes for other file format is included
	}
	@RequestMapping(value="/readTransaction/{inputFileLocation}", method=RequestMethod.GET)
	public String readTransaction(@PathVariable("inputFileLocation") String inputFileLocation){
		try {
			inputFileLocation = "C://Users//deven//Documents//sampleData.csv";
			String extension = FilenameUtils.getExtension(inputFileLocation);
			
			//Logic may change based on type of file formats
			Readers classTobeCalled = (Readers) listOfClasses.get(extension);
			classTobeCalled.readAndCalculateFee(inputFileLocation,service);
			return "Transaction details has been saved";
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage());
			return e.getMessage();
		}
		
		
	}

	
}
