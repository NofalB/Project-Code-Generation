package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.model.Role;
import io.swagger.model.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TransactionsApiControllerTest {

    @Autowired
    private MockMvc mvc;

    private String token;
    private MockedUser loginMockedUser;
    private Transaction transaction;
    private String senderIban;
    private String receiverIban;
    private ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    public void loginToGetToken()throws Exception{
        //here we are performing login to get a token to pass it for authorization
        loginMockedUser= new MockedUser("username_1","password_1");
        MvcResult result =
                this.mvc
                        .perform(post("/login")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(this.mapper.writeValueAsString(loginMockedUser)))
                        .andReturn();

        String content = result.getResponse().getContentAsString();
        String[] responseParts=content.split("\"tokenValue\":\"");
        String t = responseParts[1];
        String[] clearTheToken=responseParts[1].split("\"");
        token= "Bearer "+clearTheToken[0];

        // getting the accounts of specific user to test the transaction on them.
        MvcResult accountResults= this.mvc
                                        .perform(get("/users/{userid}/accounts","2")
                                        .header("Authorization",token))
                                    .andReturn();
        String userAccounts = accountResults.getResponse().getContentAsString();
        try {
            String[] dividedAccountResponse = userAccounts.split("iban\":\"");
            senderIban = dividedAccountResponse[1].split("\",\"amount")[0];
            receiverIban=dividedAccountResponse[2].split("\",\"amount")[0];
        }
        catch (Exception ex){
            System.out.println(String.format("Something went wrong reading the account object: %s",ex.getMessage() ));
        }


    }

    @Test
    public void creatingTransactionReturns200Response() throws Exception{
        transaction = new Transaction(senderIban,receiverIban,"username_2",10.0, Role.EMPLOYEE);
        this.mvc
                .perform(post("/transactions")
                        .header("Authorization",token)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(this.mapper.writeValueAsString(transaction)))
                .andExpect(status().isOk());
    }
    @Test
    public void gettingTransactionsByIbanReturn200Status()throws Exception{
        this.mvc
                .perform(get("/transactions?IBAN={iban}",senderIban)
                        .header("Authorization",token))
                .andExpect(status().isOk());
    }
}