package com.suneratech.tracfone.ktstatus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suneratech.tracfone.ktstatus.entity.KTDomainEntity;
import com.suneratech.tracfone.ktstatus.entity.KTStatusEntity;
import com.suneratech.tracfone.ktstatus.service.TracfoneKTStatusService;

@RestController
@RequestMapping(path = "/api/v1/tracfone/kt")
public class TracfoneKTStatusController {
	
	@Autowired
	TracfoneKTStatusService tracfoneKTStatusService;
	
	@PostMapping("/ktDomain")
	public KTDomainEntity addKTDomain(@RequestBody  KTDomainEntity ktDomainEntity) {
		KTDomainEntity ktDomainEntityResp = null;
		try {
			ktDomainEntityResp =  tracfoneKTStatusService.addKTDomain(ktDomainEntity);
		} catch (Exception e) {
			//No-OP
		}
		return ktDomainEntityResp;
	}
	
	@GetMapping("/ktDomain")
	public List<KTDomainEntity> getAllKTS(){
		List<KTDomainEntity> ktDomainEntities;
		try {
			ktDomainEntities = tracfoneKTStatusService.getAllKTS();
		} catch (Exception e) {
			return null;
		}
		return ktDomainEntities;
	}
	
	
	@GetMapping("/ktStatus/{userId}/{ktType}")
	public boolean checkKTStatus(@PathVariable String userId, @PathVariable String ktType){
		Boolean status = false;
		try {
			 status = tracfoneKTStatusService.checkDomainKTStatus(userId, ktType);
		} catch (Exception e) {
			return false;
		}
		return status;
	}
	
	
	@PostMapping("/ktStatus")
	public String updateKTStatus(@RequestBody KTStatusEntity ktStatusEntity) {
		try {
			boolean status = tracfoneKTStatusService.updateKTStatus(ktStatusEntity);
			if (status)
				return "Update KT status Sucessfully";
			else
				return " OOps! Error while updating KT Status.... Try Again";
		} catch (Exception e) {
			return " OOps! Error while updating KT Status.... Try Again";
		}
	}

	
}
