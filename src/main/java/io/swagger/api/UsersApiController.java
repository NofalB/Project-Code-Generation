package io.swagger.api;

import io.swagger.model.AccountObject;
import io.swagger.model.Body;
import io.swagger.model.ExtendedUser;
import io.swagger.model.UserResults;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-05-17T12:46:50.867Z[GMT]")
@Controller
public class UsersApiController implements UsersApi {

    private static final Logger log = LoggerFactory.getLogger(UsersApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public UsersApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<AccountObject> createUser(@ApiParam(value = "the userid of the user who owns these accounts",required=true) @PathVariable("userId") String userId
,@ApiParam(value = "The account to create."  )  @Valid @RequestBody Body body
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<AccountObject>(objectMapper.readValue("{\n  \"owner\" : {\n    \"userId\" : 6,\n    \"username\" : \"username\"\n  },\n  \"amount\" : 0,\n  \"IBAN\" : \"IBAN\",\n  \"transactionLimit\" : 1.4658129805029452,\n  \"type\" : \"Checking\",\n  \"status\" : \"Active\"\n}", AccountObject.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<AccountObject>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<AccountObject>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteUser(@ApiParam(value = "",required=true) @PathVariable("userid") Integer userid
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ExtendedUser> editUser(@ApiParam(value = "",required=true) @PathVariable("userid") Integer userid
,@ApiParam(value = ""  )  @Valid @RequestBody ExtendedUser body
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ExtendedUser>(objectMapper.readValue("\"\"", ExtendedUser.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ExtendedUser>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ExtendedUser>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<AccountObject>> getAccountsByUserId(@ApiParam(value = "the user who ownes these accounts",required=true) @PathVariable("userId") String userId
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<AccountObject>>(objectMapper.readValue("[ {\n  \"owner\" : {\n    \"userId\" : 6,\n    \"username\" : \"username\"\n  },\n  \"amount\" : 0,\n  \"IBAN\" : \"IBAN\",\n  \"transactionLimit\" : 1.4658129805029452,\n  \"type\" : \"Checking\",\n  \"status\" : \"Active\"\n}, {\n  \"owner\" : {\n    \"userId\" : 6,\n    \"username\" : \"username\"\n  },\n  \"amount\" : 0,\n  \"IBAN\" : \"IBAN\",\n  \"transactionLimit\" : 1.4658129805029452,\n  \"type\" : \"Checking\",\n  \"status\" : \"Active\"\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<AccountObject>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<AccountObject>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<UserResults> getAllUsers(@ApiParam(value = "Limit the number of users to display.", defaultValue = "20") @Valid @RequestParam(value = "limit", required = false, defaultValue="20") Integer limit
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<UserResults>(objectMapper.readValue("[ {\n  \"userId\" : 6,\n  \"username\" : \"username\"\n}, {\n  \"userId\" : 6,\n  \"username\" : \"username\"\n} ]", UserResults.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<UserResults>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<UserResults>(HttpStatus.NOT_IMPLEMENTED);
    }

}
