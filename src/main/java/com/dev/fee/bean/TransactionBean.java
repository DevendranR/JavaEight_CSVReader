package com.dev.fee.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TransactionBean {
	@Id
	private String externalTransactionId;
	private String clientId;
	private String securityId;
	private String transactionType;
	private Date transactionDate;
	private Double marketValue;
	private Character priorityFlag;
	private Double processingFee;
	public String getExternalTransactionId() {
		return externalTransactionId;
	}
	public void setExternalTransactionId(String externalTransactionId) {
		this.externalTransactionId = externalTransactionId;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getSecurityId() {
		return securityId;
	}
	public void setSecurityId(String securityId) {
		this.securityId = securityId;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public Double getMarketValue() {
		return marketValue;
	}
	public void setMarketValue(Double marketValue) {
		this.marketValue = marketValue;
	}
	public Character getPriorityFlag() {
		return priorityFlag;
	}
	public void setPriorityFlag(Character priorityFlag) {
		this.priorityFlag = priorityFlag;
	}
	public Double getProcessingFee() {
		return processingFee;
	}
	public void setProcessingFee(Double processingFee) {
		this.processingFee = processingFee;
	}
	@Override
	public String toString() {
		return "Transaction [externalTransactionId=" + externalTransactionId
				+ ", clientId=" + clientId + ", securityId=" + securityId
				+ ", transactionType=" + transactionType + ", transactionDate="
				+ transactionDate + ", marketValue=" + marketValue
				+ ", priorityFlag=" + priorityFlag + ", processingFee="
				+ processingFee + "]";
	}
	
	
}
