package com.suneratech.tracfone.ktstatus.controller.test;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.suneratech.tracfone.ktstatus.entity.KTDomainEntity;
import com.suneratech.tracfone.ktstatus.entity.KTStatusEntity;
import com.suneratech.tracfone.ktstatus.entity.KTStatusKeyEntity;
import com.suneratech.tracfone.ktstatus.service.TracfoneKTStatusService;

@WebMvcTest
public class TracfoneKTStatusControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TracfoneKTStatusService tracfoneKTStatusService;

	private static ObjectMapper mapper = new ObjectMapper();

	
	@Test
	public void testGetAllKTS() throws Exception {
		List<KTDomainEntity> ktDomainEntities = new ArrayList<>();
		KTDomainEntity ktStatusDomain = new KTDomainEntity(1, "domain", null);
		ktDomainEntities.add(ktStatusDomain);
		Mockito.when(tracfoneKTStatusService.getAllKTS()).thenReturn(ktDomainEntities);
		mockMvc.perform(get("/api/v1/tracfone/kt/ktDomain")).andExpect(status().isOk())
				.andExpect(jsonPath("$", Matchers.hasSize(1)))
				.andExpect(jsonPath("$[0].ktName", Matchers.equalTo("domain")));
	}

	@Test
	public void testCheckKTStatus() throws Exception {
		List<KTStatusEntity> ktStatusEntities = new ArrayList<>();
		KTDomainEntity ktStatusDomain1 = new KTDomainEntity(1, "domain", null);
		KTStatusKeyEntity ktStatusKeyEntity = new KTStatusKeyEntity(ktStatusDomain1, "Asma");
		KTStatusEntity ktStatusEntity = new KTStatusEntity(ktStatusKeyEntity, true, "Sindhu");
		ktStatusEntities.add(ktStatusEntity);
		Mockito.when(tracfoneKTStatusService.checkDomainKTStatus("Asma", "domain")).thenReturn(true);
		mockMvc.perform(get("/api/v1/tracfone/kt/ktStatus/Asma/domain")).andExpect(status().isOk());
	}

	@Test
	public void testaddKTDomain() throws Exception {
		KTDomainEntity ktStatusDomain = new KTDomainEntity(1, "domain", null);
		Mockito.when(tracfoneKTStatusService.addKTDomain(ArgumentMatchers.any())).thenReturn(ktStatusDomain);
		String json = mapper.writeValueAsString(ktStatusDomain);
		mockMvc.perform(post("/api/v1/tracfone/kt/ktDomain").contentType(MediaType.APPLICATION_JSON)
				.characterEncoding("utf-8").content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.ktID", Matchers.equalTo(1)))
				.andExpect(jsonPath("$.ktName", Matchers.equalTo("domain")));
	}

	@Test
	public void testUpdateKTStatus() throws Exception {
		KTDomainEntity ktStatusDomain1 = new KTDomainEntity(1, "domain", null);
		KTStatusKeyEntity ktStatusKeyEntity = new KTStatusKeyEntity(ktStatusDomain1, "Asma");
		KTStatusEntity ktStatusEntity = new KTStatusEntity(ktStatusKeyEntity, true, "Sindhu");
		Mockito.when(tracfoneKTStatusService.updateKTStatus(ArgumentMatchers.any())).thenReturn(true);
		String json = mapper.writeValueAsString(ktStatusEntity);
		mockMvc.perform(post("/api/v1/tracfone/kt/ktStatus").contentType(MediaType.APPLICATION_JSON)
				.characterEncoding("utf-8").content(json).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
}
