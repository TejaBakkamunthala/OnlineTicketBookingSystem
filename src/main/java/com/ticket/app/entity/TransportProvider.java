package com.ticket.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transportproviders",schema="otbsystem")
public class TransportProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "provider_id")
    private int providerId;

    @Column(name = "provider_name")
    private String providerName;

    @Column(name = "provider_email")
    private String providerEmail;

    @Column(name = "provider_contact_number")
    private String providerContactNumber;

	public int getProviderId() {
		return providerId;
	}

	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getProviderEmail() {
		return providerEmail;
	}

	public void setProviderEmail(String providerEmail) {
		this.providerEmail = providerEmail;
	}

	public String getProviderContactNumber() {
		return providerContactNumber;
	}

	public void setProviderContactNumber(String providerContactNumber) {
		this.providerContactNumber = providerContactNumber;
	}

	public TransportProvider(int providerId, String providerName, String providerEmail, String providerContactNumber) {
		super();
		this.providerId = providerId;
		this.providerName = providerName;
		this.providerEmail = providerEmail;
		this.providerContactNumber = providerContactNumber;
	}

	public TransportProvider() {
		super();
	}

	@Override
	public String toString() {
		return "TransportProvider [providerId=" + providerId + ", providerName=" + providerName + ", providerEmail="
				+ providerEmail + ", providerContactNumber=" + providerContactNumber + "]";
	}

 
    
}
