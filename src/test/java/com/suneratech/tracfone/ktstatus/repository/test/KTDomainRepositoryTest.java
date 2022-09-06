package com.suneratech.tracfone.ktstatus.repository.test;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import com.suneratech.tracfone.ktstatus.entity.KTDomainEntity;
import com.suneratech.tracfone.ktstatus.repository.KTDomainRepository;

@DataJpaTest
public class KTDomainRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	KTDomainRepository ktDomainRepository;
	
	  @Test
	  public void should_find_ktDomain_by_id() {
	    KTDomainEntity ktStatusDomain = new KTDomainEntity("domain", null);
	    entityManager.persist(ktStatusDomain);
	    KTDomainEntity ktStatusDomainResp = ktDomainRepository.findById(ktStatusDomain.getKtID()).get();
	    assertThat(ktStatusDomain).isEqualTo(ktStatusDomainResp);
	  }
	  

	  @Test
	  public void should_find_ktDomain_all() {
	    KTDomainEntity ktStatusDomain1 = new KTDomainEntity("domain", null);
	    entityManager.persist(ktStatusDomain1);
	    KTDomainEntity ktStatusDomain2 = new KTDomainEntity("hr", null);
	    entityManager.persist(ktStatusDomain2);
	    List<KTDomainEntity> ktStatusDomainResp = (List<KTDomainEntity>) ktDomainRepository.findAll();
	    assertThat(ktStatusDomainResp.size()).isEqualTo(2);
	  }
	  
	  @Test
	  public void should_find_ktDomain_all_Neg() {
	    KTDomainEntity ktStatusDomain1 = new KTDomainEntity("domain", null);
	    entityManager.persist(ktStatusDomain1);
	    KTDomainEntity ktStatusDomain2 = new KTDomainEntity("hr", null);
	    entityManager.persist(ktStatusDomain2);
	    List<KTDomainEntity> ktStatusDomainResp = (List<KTDomainEntity>) ktDomainRepository.findAll();
	    assertThat(ktStatusDomainResp.size()).isNotEqualTo(3);
	  }
	
}
