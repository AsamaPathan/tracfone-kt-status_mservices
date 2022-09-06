package com.suneratech.tracfone.ktstatus.repository.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.suneratech.tracfone.ktstatus.entity.KTDomainEntity;
import com.suneratech.tracfone.ktstatus.entity.KTStatusEntity;
import com.suneratech.tracfone.ktstatus.entity.KTStatusKeyEntity;
import com.suneratech.tracfone.ktstatus.repository.KTStatusRepository;

@DataJpaTest
public class KTStatusRepositoryTest {
	
	@Autowired
	TestEntityManager entityManager;
	
	@Autowired
	KTStatusRepository ktStatusRepository;
	

	  @Test
	  public void should_add_ktStatus() {
	    KTDomainEntity ktStatusDomain1 = new KTDomainEntity("domain", null);
	    entityManager.persist(ktStatusDomain1);
	    KTStatusKeyEntity ktStatusKeyEntity = new KTStatusKeyEntity(ktStatusDomain1, "Asma");
	    KTStatusEntity ktStatusEntity = new KTStatusEntity(ktStatusKeyEntity, true, "Sindhu"); 
	    entityManager.persist(ktStatusEntity);
	     List<KTStatusEntity> ktStatusEntities = (List<KTStatusEntity>) ktStatusRepository.findAll();
	     assertThat(ktStatusEntities.get(0).getKtStatus()).isEqualTo(true);
	  }
	  
	  @Test
	  public void findStatus_test_case() {
		  KTDomainEntity ktStatusDomain1 = new KTDomainEntity("domain", null);
		  entityManager.persist(ktStatusDomain1);
		  KTStatusKeyEntity ktStatusKeyEntity = new KTStatusKeyEntity(ktStatusDomain1, "Asma");
		  KTStatusEntity ktStatusEntity = new KTStatusEntity(ktStatusKeyEntity, true, "Sindhu"); 
		  entityManager.persist(ktStatusEntity);
		  List<KTStatusEntity> ktStatusEntity2 = ktStatusRepository.findStatus("Asma", "domain");
		  assertThat(ktStatusEntity2.get(0).getKtStatus()).isEqualTo(true);
	  }
	  
	  @Test
	  public void findStatus_test_case_negative() {
		  KTDomainEntity ktStatusDomain1 = new KTDomainEntity("domain", null);
		  entityManager.persist(ktStatusDomain1);
		  KTStatusKeyEntity ktStatusKeyEntity = new KTStatusKeyEntity(ktStatusDomain1, "Asma");
		  KTStatusEntity ktStatusEntity = new KTStatusEntity(ktStatusKeyEntity, true, "Sindhu"); 
		  entityManager.persist(ktStatusEntity);
		  List<KTStatusEntity> ktStatusEntity2 = ktStatusRepository.findStatus("Asma", "domain");
		  assertThat(ktStatusEntity2.get(0).getUpdatedBy()).isNotEqualTo("test");
	  }
	

}
