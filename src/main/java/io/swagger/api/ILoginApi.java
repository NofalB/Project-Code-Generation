/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.19).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.Body1;
import io.swagger.model.InlineResponse2002;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CookieValue;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-05-21T18:10:30.703Z[GMT]")
@Api(value = "login", description = "the login API")
public interface ILoginApi {

    @ApiOperation(value = "login", nickname = "loginUser", notes = "login give you an access by sending you bearerToken", response = InlineResponse2002.class, authorizations = {
            @Authorization(value = "bearerAuth")}, tags = {"Users",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Bearer token", response = InlineResponse2002.class)})
    @RequestMapping(value = "/login",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<InlineResponse2002> loginUser(@ApiParam(value = "") @Valid @RequestBody Body1 body
    );

}
