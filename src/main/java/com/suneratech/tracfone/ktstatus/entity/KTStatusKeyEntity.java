package com.suneratech.tracfone.ktstatus.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class KTStatusKeyEntity implements Serializable{
	private static final long serialVersionUID = 1L;

	@ManyToOne
    @JoinColumn(name="kt_ID", insertable =  false, updatable = false)
	private KTDomainEntity ktDomainEntity;
	
	@Column(name = "user_id")
	private String userId;


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public KTDomainEntity getKtDomainEntity() {
		return ktDomainEntity;
	}

	public void setKtDomainEntity(KTDomainEntity ktDomainEntity) {
		this.ktDomainEntity = ktDomainEntity;
	}

	public KTStatusKeyEntity(KTDomainEntity ktDomainEntity, String userId) {
		super();
		this.ktDomainEntity = ktDomainEntity;
		this.userId = userId;
	}
	
	public KTStatusKeyEntity() {
		//No-arg constructor
	}

}
