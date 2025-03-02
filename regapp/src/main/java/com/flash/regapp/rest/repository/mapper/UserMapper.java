package com.flash.regapp.rest.repository.mapper;

import com.flash.regapp.rest.repository.dto.UserDto;
import com.flash.regapp.rest.repository.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toUser(UserDto userDto);

    default User toUserFromDto(UserDto userDto){
        User user = toUser(userDto);
        user.setPasswordResetCode(userDto.passwordResetCode);
        return user;
    }
}
