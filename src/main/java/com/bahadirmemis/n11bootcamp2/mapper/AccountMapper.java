package com.bahadirmemis.n11bootcamp2.mapper;

import com.bahadirmemis.n11bootcamp2.dto.AccountDTO;
import com.bahadirmemis.n11bootcamp2.entity.Account;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @author bahadirmemis
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccountMapper {

  AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

  AccountDTO convertToAccountDTO(Account account);

  List<AccountDTO> convertToAccountDTOs(List<Account> accounts);

}
