package com.bahadirmemis.n11bootcamp2.mapper;

import com.bahadirmemis.n11bootcamp2.dto.CustomerDTO;
import com.bahadirmemis.n11bootcamp2.entity.Book;
import com.bahadirmemis.n11bootcamp2.entity.BookDTO;
import com.bahadirmemis.n11bootcamp2.entity.Customer;
import com.bahadirmemis.n11bootcamp2.request.CustomerSaveRequest;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @author bahadirmemis
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {

  CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

  @Mapping(target = "state", constant = "PASSIVE")
  @Mapping(target = "name", source = "nameXXX")
  Customer convertToCustomer(CustomerSaveRequest request);

  Book convertToBook(BookDTO bookDTO);

  CustomerDTO convertToCustomerDTO(Customer customer);

  List<CustomerDTO> convertToCustomerDTOs(List<Customer> customers);

}
