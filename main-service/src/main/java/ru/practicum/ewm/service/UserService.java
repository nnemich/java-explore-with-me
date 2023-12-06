package ru.practicum.ewm.service;

import java.util.List;

import ru.practicum.ewm.dto.NewUserRequest;
import ru.practicum.ewm.dto.UserDto;

public interface UserService {
    UserDto addNewUser(NewUserRequest newUserRequest);

    void deleteUser(Long userId);

    List<UserDto> getListUsers(List<Long> ids, Integer from, Integer size);
}