package com.bank.scops.backend.controller;

import com.bank.scops.backend.BankScopBackendApplication;
import com.bank.scops.backend.model.bff.AccountBffResume;
import com.bank.scops.backend.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {BankScopBackendApplication.class})
public class AccountControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private AccountController controller;

    @Mock
    private AccountService accountServiceMock;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        List<AccountBffResume> accountBffResumeList = new ArrayList<>();
        when(accountServiceMock.retrieveAccountBffResume()).thenReturn(accountBffResumeList);
    }

    @Test
    public void account() throws Exception {
        mockMvc.perform(get("/account")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}