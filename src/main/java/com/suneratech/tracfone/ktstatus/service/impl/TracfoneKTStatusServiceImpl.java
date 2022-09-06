package com.suneratech.tracfone.ktstatus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suneratech.tracfone.ktstatus.entity.KTDomainEntity;
import com.suneratech.tracfone.ktstatus.entity.KTStatusEntity;
import com.suneratech.tracfone.ktstatus.repository.KTDomainRepository;
import com.suneratech.tracfone.ktstatus.repository.KTStatusRepository;
import com.suneratech.tracfone.ktstatus.service.TracfoneKTStatusService;

@Service
public class TracfoneKTStatusServiceImpl implements TracfoneKTStatusService {
	
	@Autowired
	KTDomainRepository ktDomainRepository;
	
	
	@Autowired KTStatusRepository ktStatusRepository;
	 
	
	public KTDomainEntity addKTDomain(KTDomainEntity ktDomainEntity) {
		KTDomainEntity ktDomainEntityResp = ktDomainRepository.save(ktDomainEntity);
		return ktDomainEntityResp;
	}
	
	public List<KTDomainEntity> getAllKTS(){
		List<KTDomainEntity> ktDomainEntities = (List<KTDomainEntity>) ktDomainRepository.findAll();
		return ktDomainEntities;
	}
	
	@Override public Boolean checkDomainKTStatus(String userId, String ktType) throws Exception { 
		List<KTStatusEntity> ktStatusEntities = ktStatusRepository.findStatus(userId, ktType);
		if(ktStatusEntities != null && ktStatusEntities.get(0) != null && ktStatusEntities.get(0).getKtStatus())
			return true; 
		else 
			return false;
	}
	 

	
	@Override
	public Boolean updateKTStatus(KTStatusEntity ktStatusEntity) throws Exception {
		Boolean status = false;
		KTStatusEntity ktStatusEntityResp = ktStatusRepository.save(ktStatusEntity);
		if (ktStatusEntityResp != null)
			status = true;
		return status;
	}
	 

}
