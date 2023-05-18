package exercise.controller;

import exercise.ResourceNotFoundException;
import exercise.model.Comment;
import exercise.model.Post;
import exercise.repository.CommentRepository;
import exercise.repository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/posts")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    // BEGIN
    @GetMapping(path = "/{postId}/comments")
    public Iterable<Comment> getAllCommentsFromPost(@PathVariable long postId) {
        return commentRepository.findAllByPostId(postId);
    }

    @GetMapping(path = "/{postId}/comments/{commentId}")
    public Comment getCommentFromPostById(@PathVariable long postId, @PathVariable long commentId) {
        return commentRepository.findAllByIdAndPostId(commentId, postId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment not found"));
    }

    @PostMapping(path = "/{postId}/comments")
    public Comment createNewComment(@PathVariable long postId, @RequestBody Comment comment) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post not found"));
        comment.setPost(post);
        return commentRepository.save(comment);
    }

    @PatchMapping(path = "/{postId}/comments/{commentId}")
    public Comment updateCommentByIdAndByPostId(@PathVariable long postId, @PathVariable long commentId,
                                     @RequestBody Comment updatedComment) {
        Comment commentToBeUpdated = commentRepository.findAllByIdAndPostId(commentId, postId).orElseThrow(() ->
                new ResourceNotFoundException("Comment not found"));
        commentToBeUpdated.setContent(updatedComment.getContent());
        return commentRepository.save(commentToBeUpdated);
    }

    @DeleteMapping(path = "/{postId}/comments/{commentId}")
    public void deleteCommentByIdAndByPostId(@PathVariable long postId, @PathVariable long commentId) {
        Comment commentToBeDeleted = commentRepository.findAllByIdAndPostId(commentId, postId).orElseThrow(() ->
                new ResourceNotFoundException("Comment not found"));
        commentRepository.delete(commentToBeDeleted);
    }
    // END
}
