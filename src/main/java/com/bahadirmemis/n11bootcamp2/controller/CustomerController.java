package com.bahadirmemis.n11bootcamp2.controller;

import com.bahadirmemis.n11bootcamp2.controller.contract.CustomerControllerContract;
import com.bahadirmemis.n11bootcamp2.dto.CustomerDTO;
import com.bahadirmemis.n11bootcamp2.general.RestResponse;
import com.bahadirmemis.n11bootcamp2.request.CustomerSaveRequest;
import com.bahadirmemis.n11bootcamp2.request.CustomerUpdatePasswordRequest;
import com.bahadirmemis.n11bootcamp2.request.CustomerUpdateRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bahadirmemis
 */
@RestController
@RequestMapping("/api/v1/customers")
@Validated
@Tag(name = "Customer Controller", description = "Customer Management")
public class CustomerController {

  private CustomerControllerContract customerControllerContract;

  public CustomerController(CustomerControllerContract customerControllerContract) {
    this.customerControllerContract = customerControllerContract;
  }

  @GetMapping
  @Operation(summary = "Get all customers", description = "Retrieves all active customers")
  public ResponseEntity<RestResponse<List<CustomerDTO>>> getAllCustomers() {
    List<CustomerDTO> allCustomers = customerControllerContract.getAllCustomers();
    return ResponseEntity.ok(RestResponse.of(allCustomers));
  }

  @GetMapping("/{id}")
  public ResponseEntity<RestResponse<CustomerDTO>> getCustomerById(@PathVariable @Positive Long id) {
    CustomerDTO customerById = customerControllerContract.getCustomerById(id);
    return ResponseEntity.ok(RestResponse.of(customerById));
  }

  @Operation(summary = "Retrieves customer by username")
  @GetMapping("/with-username/{username}")
  public ResponseEntity<RestResponse<CustomerDTO>> getCustomerByUsername(@PathVariable @NotBlank String username) {
    CustomerDTO customerById = customerControllerContract.getCustomerByUsername(username);
    return ResponseEntity.ok(RestResponse.of(customerById));
  }

  @PostMapping
  @Operation(
      description = "Creates new customer",
      summary = "Create",
      requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
          description = "Customers",
          content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(
                      implementation = CustomerSaveRequest.class
                  ),
                  examples = {
                      @ExampleObject(
                          name = "new foreign customer",
                          summary = "Foreign",
                          description = "Complete request with all available " +
                                        "fields for foreign customer",
                          value = "{\n"
                                  + "  \"nameXXX\": \"John\",\n"
                                  + "  \"surname\": \"Smith\",\n"
                                  + "  \"birthDate\": \"2004-03-10\",\n"
                                  + "  \"username\": \"john\",\n"
                                  + "  \"identityNo\": \"90123456788\",\n"
                                  + "  \"password\": \"123\",\n"
                                  + "  \"phoneNumber\": \"5763333873\",\n"
                                  + "  \"email\": \"john@gmail.com\"\n"
                                  + "}"
                      ),
                      @ExampleObject(
                          name = "new customer",
                          summary = "Normal",
                          description = "Complete request with all available fields" ,
                          value = "{\n"
                                  + "  \"nameXXX\": \"bahadır\",\n"
                                  + "  \"surname\": \"memiş\",\n"
                                  + "  \"birthDate\": \"1994-03-10\",\n"
                                  + "  \"username\": \"sbahadirm\",\n"
                                  + "  \"identityNo\": \"20123456788\",\n"
                                  + "  \"password\": \"1233\",\n"
                                  + "  \"phoneNumber\": \"5675786767\",\n"
                                  + "  \"email\": \"bahadir@gmail.com\"\n"
                                  + "}"
                      )
                  }
              )
          }
      )
  )
  public ResponseEntity<RestResponse<CustomerDTO>> saveCustomer(@Valid @RequestBody CustomerSaveRequest request) {
    CustomerDTO customerDTO = customerControllerContract.saveCustomer(request);
    return ResponseEntity.ok(RestResponse.of(customerDTO));
  }

  @DeleteMapping("/{id}")
  public void deleteCustomer(@PathVariable @NotNull Long id) {
    customerControllerContract.deleteCustomer(id);
  }

  ///**
  // * PUT -> api/customers/6478545
  // * @param debugCustomerId
  // * @param customer
  // * @return
  // */
  @PutMapping("/{debugCustomerId}")
  public ResponseEntity<RestResponse<CustomerDTO>> updateCustomer(@PathVariable @NotNull Long debugCustomerId,
                                                                  @Valid @RequestBody CustomerUpdateRequest request) {
    CustomerDTO customerDTO = customerControllerContract.updateCustomer(request);
    return ResponseEntity.ok(RestResponse.of(customerDTO));
  }

  /**
   * http://localhost:8080/ -> baseURL
   * api/customers -> baseURI
   * /1 -> PathVariable
   * ?name=sadık bahadır -> RequestParam
   */
  @PatchMapping("/{id}/password")
  public ResponseEntity<RestResponse<CustomerDTO>> updateCustomerPassword(
      @PathVariable @NotNull Long id,
      @Valid @RequestBody CustomerUpdatePasswordRequest request) {
    CustomerDTO customerDTO = customerControllerContract.updateCustomerPassword(id, request);
    return ResponseEntity.ok(RestResponse.of(customerDTO));
  }
}
