package com.manage.user.mapper;

import com.manage.user.model.dto.UserDTO;
import com.manage.user.model.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User userDtoToUser(UserDTO userDto);

    UserDTO userToUserDto(User user);
}
