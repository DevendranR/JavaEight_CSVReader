package com.dev.fee.api;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dev.fee.Utils.DetailsComparator;
import com.dev.fee.bean.TransactionBean;
import com.dev.fee.services.transaction.ReportGeneratorService;

@RestController
public class ReportGeneratorApi {
	private static final Logger LOGGER = Logger.getLogger(ReportGeneratorApi.class);
	@Autowired
	ReportGeneratorService generatorService;
	@RequestMapping(value="/transactionReport", method=RequestMethod.GET)
	public @ResponseBody List<TransactionBean> generateReport(){
		try {
			List<TransactionBean> report = Lists.newArrayList(generatorService.generateReport());
			Collections.sort(report, new DetailsComparator());
			report.stream().forEach(r -> System.out.println(r.toString()));
			return report;
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
}
