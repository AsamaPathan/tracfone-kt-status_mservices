package com.suneratech.tracfone.ktstatus.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "KT_DOMAIN")
public class KTDomainEntity {
	
	@Id
	@Column(name = "kt_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ktID;
	
	@Column(name = "kt_name")
	private String ktName;
	
	@OneToMany(targetEntity = KTStatusEntity.class, mappedBy ="ktStatusKeyEntity.ktDomainEntity", 
			cascade = CascadeType.ALL, fetch =  FetchType.EAGER)
    private Set<KTStatusEntity> ktStatus;

	public Integer getKtID() {
		return ktID;
	}

	public void setKtID(Integer ktID) {
		this.ktID = ktID;
	}

	public String getKtName() {
		return ktName;
	}

	public void setKtName(String ktName) {
		this.ktName = ktName;
	}

	public Set<KTStatusEntity> getKtStatus() {
		return ktStatus;
	}

	public void setKtStatus(Set<KTStatusEntity> ktStatus) {
		this.ktStatus = ktStatus;
	}

	public KTDomainEntity(Integer ktID, String ktName, Set<KTStatusEntity> ktStatus) {
		super();
		this.ktID = ktID;
		this.ktName = ktName;
		this.ktStatus = ktStatus;
	}
	
	public KTDomainEntity( String ktName, Set<KTStatusEntity> ktStatus) {
		super();
		this.ktName = ktName;
		this.ktStatus = ktStatus;
	}
	
	public KTDomainEntity() {
		//No-Arg Constructor
	}
	
}
