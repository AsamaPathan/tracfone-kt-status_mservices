package com.suneratech.tracfone.ktstatus.service;

import java.util.List;

import com.suneratech.tracfone.ktstatus.entity.KTDomainEntity;
import com.suneratech.tracfone.ktstatus.entity.KTStatusEntity;

public interface TracfoneKTStatusService {
	
	public KTDomainEntity addKTDomain(KTDomainEntity ktDomainEntity) throws Exception;
	public List<KTDomainEntity> getAllKTS() throws Exception;
	public Boolean checkDomainKTStatus(String userId, String ktType) throws Exception;
	public Boolean updateKTStatus(KTStatusEntity ktStatusEntity)throws Exception;
}
