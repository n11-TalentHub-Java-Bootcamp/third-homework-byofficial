package com.burakyildiz.springboot.mapper;

import com.burakyildiz.springboot.dto.UserDto;
import com.burakyildiz.springboot.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "id", target = "_id")
    List<UserDto> convertAllUserListToUserDtoList(List<User> userList);

    @Mapping(source = "phoneNumber", target = "phoneNumber")
    @Mapping(source = "email", target = "email")
    User convertUserDtoToUser(UserDto userDto);

    @Mapping(source = "phoneNumber", target = "phoneNumber")
    @Mapping(source = "email", target = "email")
    UserDto convertUserToUserDto(User user);


}
