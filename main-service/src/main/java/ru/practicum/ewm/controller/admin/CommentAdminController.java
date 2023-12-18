package ru.practicum.ewm.controller.admin;

import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.ewm.model.Comment;
import ru.practicum.ewm.service.CommentService;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(path = "/admin/comments")
public class CommentAdminController {
    private final CommentService commentService;

    @DeleteMapping("/{commentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComment(@PathVariable Long commentId) {
        log.info("DELETE запрос на удаление комментария id = {} ", commentId);
        commentService.deleteCommentByAdmin(commentId);
    }

    @GetMapping("/search")
    public List<Comment> searchComments(@RequestParam(name = "text") String text,
                                        @RequestParam(value = "from", defaultValue = "0") Integer from,
                                        @RequestParam(value = "size", defaultValue = "10") Integer size) {
        log.info("GET Запрос на поиск комментариев c текстом = {}", text);
        return commentService.search(text, from, size);
    }
}