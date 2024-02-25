package com.bahadirmemis.n11bootcamp2.mapper;

import com.bahadirmemis.n11bootcamp2.dto.SendBatchMailRequestDTO;
import com.bahadirmemis.n11bootcamp2.request.SendBatchMailsRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @author bahadirmemis
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MailMapper {

  MailMapper INSTANCE = Mappers.getMapper(MailMapper.class);

  SendBatchMailRequestDTO convertToSendBatchMailRequestDTO(SendBatchMailsRequest request);
}
