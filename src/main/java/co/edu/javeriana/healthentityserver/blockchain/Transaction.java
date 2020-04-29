package co.edu.javeriana.healthentityserver.blockchain;

import java.sql.Timestamp;

import co.edu.javeriana.healthentityserver.enums.OperationEnum;
import co.edu.javeriana.healthentityserver.enums.ResourceTypeEnum;
import co.edu.javeriana.healthentityserver.enums.RoleEnum;

public class Transaction {
	
	private String institution;
	private OperationEnum operation;
	private String recipient;
	private RoleEnum recipient_role;
	private String resource_integrity;
	private String resource_path;
	private ResourceTypeEnum source_type;
	private String sender;
	private RoleEnum sender_role;
	private Timestamp timestamp;
	
	
	
	public Transaction(String institution, OperationEnum operation, String recipient, RoleEnum recipientRole,
			String resourceIntegrity, String resourcePath, ResourceTypeEnum resourceType, String sender,
			RoleEnum senderRole, Timestamp timestamp) {
		super();
		this.institution = institution;
		this.operation = operation;
		this.recipient = recipient;
		this.recipient_role = recipientRole;
		this.resource_integrity = resourceIntegrity;
		this.resource_path = resourcePath;
		this.source_type = resourceType;
		this.sender = sender;
		this.sender_role = senderRole;
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
	public RoleEnum getRecipient_role() {
		return recipient_role;
	}
	public void setRecipientRole(RoleEnum recipientRole) {
		this.recipient_role = recipientRole;
	}
	public String getResource_integrity() {
		return resource_integrity;
	}
	public void setResourceIntegrity(String resourceIntegrity) {
		this.resource_integrity = resourceIntegrity;
	}
	public String getResource_path() {
		return resource_path;
	}
	public void setResourcePath(String resourcePath) {
		this.resource_path = resourcePath;
	}
	public ResourceTypeEnum getResource_type() {
		return source_type;
	}
	public void setResourceType(ResourceTypeEnum resourceType) {
		this.source_type = resourceType;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public RoleEnum getSender_role() {
		return sender_role;
	}
	public void setSenderRole(RoleEnum senderRole) {
		this.sender_role = senderRole;
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
				+ ", recipientRole=" + recipient_role + ", resourceIntegrity=" + resource_integrity + ", resourcePath="
				+ resource_path + ", resourceType=" + source_type + ", sender=" + sender + ", senderRole=" + sender_role
				+ ", timestamp=" + timestamp + "]";
	}
	
	
	
}


