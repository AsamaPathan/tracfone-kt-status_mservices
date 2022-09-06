package com.suneratech.tracfone.ktstatus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.suneratech.tracfone.ktstatus.entity.KTStatusEntity;

public interface KTStatusRepository extends CrudRepository<KTStatusEntity, Integer>{
	@Query("select ktStatusEntity from KTStatusEntity ktStatusEntity where ktStatusEntity.ktStatusKeyEntity.userId = :userId  "
			+ "and ktStatusEntity.ktStatusKeyEntity.ktDomainEntity.ktName = :ktType")
	List<KTStatusEntity> findStatus(String userId, String ktType);
}
