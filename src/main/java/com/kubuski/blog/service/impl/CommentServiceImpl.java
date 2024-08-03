package com.kubuski.blog.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.kubuski.blog.dto.CommentDto;
import com.kubuski.blog.entity.Comment;
import com.kubuski.blog.entity.Post;
import com.kubuski.blog.exception.BlogAPIException;
import com.kubuski.blog.exception.ResourceNotFoundException;
import com.kubuski.blog.repository.CommentRepository;
import com.kubuski.blog.repository.PostRepository;
import com.kubuski.blog.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private PostRepository postRepository;
    private ModelMapper mapper;

    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository, ModelMapper mapper) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.mapper = mapper;
    }

    @Override
    public CommentDto createComment(Long postId, CommentDto commentDto) {
        Comment comment = mapToEntity(commentDto);

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));

        comment.setPost(post);

        Comment newComment = commentRepository.save(comment);

        return mapToDto(newComment);
    }

    @Override
    public List<CommentDto> getCommentsByPostId(Long postId) {
        List<Comment> comments = commentRepository.findByPostId(postId);

        return comments.stream().map(comment -> mapToDto(comment)).collect(Collectors.toList());
    }

    @Override
    public CommentDto getCommentById(Long postId, Long commentId) {
        Comment comment = validateCommentBelongsToPost(postId, commentId);

        return mapToDto(comment);
    }

    @Override
    public CommentDto updateComment(Long postId, Long commentId, CommentDto commentDto) {
        Comment comment = validateCommentBelongsToPost(postId, commentId);

        comment.setName(commentDto.getName());
        comment.setEmail(commentDto.getEmail());
        comment.setBody(commentDto.getBody());

        Comment updatedComment = commentRepository.save(comment);

        return mapToDto(updatedComment);
    }

    @Override
    public void deleteComment(Long postId, Long commentId) {
        Comment comment = validateCommentBelongsToPost(postId, commentId);

        commentRepository.delete(comment);
    }

    private Comment validateCommentBelongsToPost(Long postId, Long commentId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));

        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "id", commentId));

        if (!comment.getPost().getId().equals(post.getId())) {
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Comment does not belong to post");
        }

        return comment;
    }

    private CommentDto mapToDto(Comment comment) {
        CommentDto commentDto = mapper.map(comment, CommentDto.class);

        return commentDto;
    }

    private Comment mapToEntity(CommentDto commentDto) {
        Comment comment = mapper.map(commentDto, Comment.class);

        return comment;
    }

}
