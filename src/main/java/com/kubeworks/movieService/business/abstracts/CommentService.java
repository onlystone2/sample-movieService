package com.kubeworks.movieService.business.abstracts;

import com.kubeworks.movieService.common.dtos.UserCommentCreatedEventDto;
import com.kubeworks.movieService.entity.Comment;
import com.kubeworks.movieService.entity.dto.CommentRequestDto;
import com.kubeworks.movieService.entity.dto.DeleteCommentRequestDto;

import java.util.List;

public interface CommentService {

    List<Comment> getCommentsByMovieId(int movieId, int pageNo, int pageSize);

    void deleteComment(DeleteCommentRequestDto deleteCommentRequestDto);

    Comment addComment(CommentRequestDto commentRequestDto);

    int getNumberOfCommentsByMovieId(int movieId);

    void addUserComment(UserCommentCreatedEventDto userCommentCreatedEventDto);
}
