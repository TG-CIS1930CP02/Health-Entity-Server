package co.edu.javeriana.healthentityserver.blockchain;

import java.sql.Timestamp;

import co.edu.javeriana.healthentityserver.enums.OperationEnum;
import co.edu.javeriana.healthentityserver.enums.ResourceTypeEnum;
import co.edu.javeriana.healthentityserver.enums.RoleEnum;

public class Transaction {
	
	private String institution;
	private OperationEnum operation;
	private String recipient;
	private RoleEnum recipientRole;
	private String resourceIntegrity;
	private String resourcePath;
	private ResourceTypeEnum resourceType;
	private String sender;
	private RoleEnum senderRole;
	private Timestamp timestamp;
	
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	public OperationEnum getOperation() {
		return operation;
	}
	public void setOperation(OperationEnum operation) {
		this.operation = operation;
	}
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public RoleEnum getRecipientRole() {
		return recipientRole;
	}
	public void setRecipientRole(RoleEnum recipientRole) {
		this.recipientRole = recipientRole;
	}
	public String getResourceIntegrity() {
		return resourceIntegrity;
	}
	public void setResourceIntegrity(String resourceIntegrity) {
		this.resourceIntegrity = resourceIntegrity;
	}
	public String getResourcePath() {
		return resourcePath;
	}
	public void setResourcePath(String resourcePath) {
		this.resourcePath = resourcePath;
	}
	public ResourceTypeEnum getResourceType() {
		return resourceType;
	}
	public void setResourceType(ResourceTypeEnum resourceType) {
		this.resourceType = resourceType;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public RoleEnum getSenderRole() {
		return senderRole;
	}
	public void setSenderRole(RoleEnum senderRole) {
		this.senderRole = senderRole;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "Transaction [institution=" + institution + ", operation=" + operation + ", recipient=" + recipient
				+ ", recipientRole=" + recipientRole + ", resourceIntegrity=" + resourceIntegrity + ", resourcePath="
				+ resourcePath + ", resourceType=" + resourceType + ", sender=" + sender + ", senderRole=" + senderRole
				+ ", timestamp=" + timestamp + "]";
	}
	
	
	
}


