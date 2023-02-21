package com.manage.user.mapper;

import com.manage.user.model.dto.UserDTO;
import com.manage.user.model.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    /**
     * UserDto to User mapper method
     * @param userDto
     * @return User
     */
    User userDtoToUser(UserDTO userDto);

    /**
     * User to USerDto mapper method
     * @param user
     * @return UserDto
     */
    UserDTO userToUserDto(User user);
}
