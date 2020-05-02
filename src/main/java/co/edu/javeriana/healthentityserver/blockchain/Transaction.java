package co.edu.javeriana.healthentityserver.blockchain;

import java.sql.Timestamp;

import co.edu.javeriana.healthentityserver.enums.OperationEnum;
import co.edu.javeriana.healthentityserver.enums.ResourceTypeEnum;
import co.edu.javeriana.healthentityserver.enums.RoleEnum;

public class Transaction {
	
	private String institution;
	private OperationEnum operation;
	private String recipient;
	private String recipientRole;
	private String resourceIntegrity;
	private String resourcePath;
	private ResourceTypeEnum sourceType;
	private String sender;
	private String senderRole;
	private Timestamp timestamp;
	
	
	
	public Transaction(String institution, OperationEnum operation, String recipient, String recipientRole,
			String resourceIntegrity, String resourcePath, ResourceTypeEnum resourceType, String sender,
			String senderRole, Timestamp timestamp) {
		super();
		this.institution = institution;
		this.operation = operation;
		this.recipient = recipient;
		this.recipientRole = recipientRole;
		this.resourceIntegrity = resourceIntegrity;
		this.resourcePath = resourcePath;
		this.sourceType = resourceType;
		this.sender = sender;
		this.senderRole = senderRole;
		this.timestamp = timestamp;
	}
	
	public Transaction() {
		super();
	}
	
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
	public String getRecipientRole() {
		return recipientRole;
	}
	public void setRecipientRole(String recipientRole) {
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
		return sourceType;
	}
	public void setResourceType(ResourceTypeEnum resourceType) {
		this.sourceType = resourceType;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getSenderRole() {
		return senderRole;
	}
	public void setSenderRole(String senderRole) {
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
				+ resourcePath + ", resourceType=" + sourceType + ", sender=" + sender + ", senderRole=" + senderRole
				+ ", timestamp=" + timestamp + "]";
	}
	
	
	
}


