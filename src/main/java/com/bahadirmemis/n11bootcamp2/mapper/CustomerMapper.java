package com.bahadirmemis.n11bootcamp2.mapper;

import com.bahadirmemis.n11bootcamp2.dto.CustomerDTO;
import com.bahadirmemis.n11bootcamp2.entity.Customer;
import com.bahadirmemis.n11bootcamp2.request.CustomerSaveRequest;
import com.bahadirmemis.n11bootcamp2.request.CustomerUpdateRequest;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @author bahadirmemis
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {

  CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

  @Mapping(target = "status", constant = "PASSIVE")
  @Mapping(target = "name", source = "nameXXX")
  Customer convertToCustomer(CustomerSaveRequest request);

  CustomerDTO convertToCustomerDTO(Customer customer);

  List<CustomerDTO> convertToCustomerDTOs(List<Customer> customers);

  @Mapping(target = "id", ignore = true)
  void updateCustomerFields(@MappingTarget Customer customer, CustomerUpdateRequest request);
}
