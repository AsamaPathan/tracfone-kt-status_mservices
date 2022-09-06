package com.suneratech.tracfone.ktstatus.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "KT_STATUS")
public class KTStatusEntity {

	@EmbeddedId
	private KTStatusKeyEntity ktStatusKeyEntity;
	
	@Column(name = "kt_status")
	private Boolean ktStatus;
	
	@Column(name = "updated_by")
	private String updatedBy;
	
	/*
	 * @Column(name = "updated_timestamp") private Date updatedTS;
	 */
	public KTStatusKeyEntity getKtStatusKeyEntity() {
		return ktStatusKeyEntity;
	}

	public void setKtStatusKeyEntity(KTStatusKeyEntity ktStatusKeyEntity) {
		this.ktStatusKeyEntity = ktStatusKeyEntity;
	}

	public Boolean getKtStatus() {
		return ktStatus;
	}

	public void setKtStatus(Boolean ktStatus) {
		this.ktStatus = ktStatus;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public KTStatusEntity(KTStatusKeyEntity ktStatusKeyEntity, Boolean ktStatus, String updatedBy) {
		super();
		this.ktStatusKeyEntity = ktStatusKeyEntity;
		this.ktStatus = ktStatus;
		this.updatedBy = updatedBy;
	}
	
	public KTStatusEntity() {
		//No-Arg Constructor
	}
	
}
