package ru.practicum.ewm.service;

import java.util.List;

import ru.practicum.ewm.dto.ParticipationRequestDto;

public interface RequestService {
    ParticipationRequestDto addNewRequest(Long userId, Long eventId);

    List<ParticipationRequestDto> getRequestsByUserId(Long userId);

    ParticipationRequestDto cancelRequest(Long userId, Long requestId);
}