package com.example.demo.domain.blogpost;
import com.example.demo.domain.blogpost.dto.BlogPostDTO;
import com.example.demo.domain.blogpost.dto.BlogPostMapper;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * This is the REST Controller for the BlogPost Model
 *
 * @author Jessica Fürst
 */
@RestController
@RequestMapping(path = "/blog")
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;
    @Autowired
    private BlogPostMapper blogPostMapper;

    /**
     * Return all blogPosts from the database
     *
     * @param pageNum current page
     * @return list of blog posts
     */
    @GetMapping({"", "/feed/{pageNum}"})
    @Operation(
            summary = "Read All BlogPosts",
            description = "Returns all the blog posts inside the database. Can be accessed by anyone"
    )
    public ResponseEntity<List<BlogPostDTO>> getAllBlogPosts(@PathVariable("pageNum") int pageNum) {
        return ResponseEntity.ok().body(blogPostMapper.toDTOs(blogPostService.findAll(PageRequest.of(pageNum, 4,
                Sort.by("id").descending()))));
    }

    /**
     * Return a blog post with the given Id
     *
     * @param id blogPost id from path
     * @return a blogPostDTO
     */
    @GetMapping(path = "detailed-view/{id}")
    @Operation(
            summary = "Read a BlogPost by id",
            description = "Read a blogPostDTO by id. Can be accessed by anyone"
    )
    public ResponseEntity<BlogPostDTO> getBlogPostById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok().body(blogPostMapper.toDTO(blogPostService.findById(id)));
    }

    /**
     * Create a new blog post object in the database
     *
     * @param blogPost blogPostDTO information
     * @return newly created blogPostDTO from database
     */
    @PostMapping(value = "/")
    @PreAuthorize("hasAuthority('BLOG_CREATE')")
    @Operation(
            summary = "Create a new blogPost",
            description = "Create a new blogPost. An authenticated and authorized user is required"
    )
    public ResponseEntity<BlogPostDTO> createBlogPost(@RequestBody @Valid BlogPostDTO blogPost) {
        return ResponseEntity.status(HttpStatus.CREATED).body(blogPostMapper.toDTO(blogPostService.save(blogPostMapper.fromDTO(blogPost))));
    }

    /**
     * Delete a blogPost from given id
     *
     * @param id blogPost id from path
     * @since 1.0
     */
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAuthority('BLOG_DELETE_BY_ID')")
    @Operation(
            summary = "Delete a BlogPost",
            description = "Delete a given BlogPost by its id. An authenticated and authorized user is required"
    )
    public void deleteBlogPost(@PathVariable("id") UUID id) {
        blogPostService.deleteById(id);
    }

    /**
     * update a blogPost with the given id
     *
     * @param id    blogPost id
     * @param blogPost updated blogPostDTO
     */
    @PutMapping("/{blogId}")
    @PreAuthorize("hasAuthority('BLOG_MODIFY_BY_ID')")
    @Operation(
            summary = "Update a BlogPost",
            description = "Update a BlogPost by Id. An authenticated and authorized user is required"
    )
    public ResponseEntity<BlogPostDTO> updateBlogPost(@PathVariable("id") UUID id, @Valid @RequestBody BlogPostDTO blogPost) {
        return ResponseEntity.ok().body(blogPostMapper.toDTO(blogPostService.updateById(id, blogPostMapper.fromDTO(blogPost))));
    }

}