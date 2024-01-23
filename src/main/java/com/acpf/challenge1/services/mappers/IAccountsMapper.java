package com.acpf.challenge1.services.mappers;

import com.acpf.challenge1.dto.AccountDetailsDto;
import com.acpf.challenge1.model.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValueMappingStrategy;
/**
 * ACPF - Challenge1 Application
 * IAccountsMapper
 * 23/01/2024
 * @author astrojob - Astrid Perdomo
 *
 */
@Mapper(componentModel = "spring",
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface IAccountsMapper {

    @Mapping(target = "_id", source = "dto.accountId")
    Account dtoToAccount(AccountDetailsDto dto);

}
