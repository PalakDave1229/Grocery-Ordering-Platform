package com.grocery.userservice.mapper;

import com.grocery.userservice.dto.request.UsersRequest;
import com.grocery.userservice.dto.response.UsersResponse;
import com.grocery.userservice.model.Users;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface UsersMapper {

    Users mapToUser(UsersRequest usersRequest);

    UsersResponse mapToUserResponse(Users users);

    List<UsersResponse> mapToUserResponseList(List<Users> users);
}
