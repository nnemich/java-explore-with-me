package ru.practicum.ewm.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.practicum.ewm.model.Category;
import ru.practicum.ewm.model.Event;

public interface EventRepository extends JpaRepository<Event, Long>, JpaSpecificationExecutor<Event> {

    Optional<Event> findByInitiatorIdAndId(Long userId, Long eventId);

    List<Event> findByCategory(Category category);

    List<Event> findAllByIdIn(List<Long> ids);
}