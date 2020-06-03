package kz.almat.swaggerpractice.rest;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import kz.almat.swaggerpractice.model.Post;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author Almat on 03.06.2020
 */

@RestController
@RequestMapping("/api")
public class PostRest {

    private Set<Post> posts = new HashSet<>();

    public PostRest(){
        posts.add(new Post(1, "aaa"));
        posts.add(new Post(2, "sss"));
        posts.add(new Post(3, "ddd"));
    }

    @GetMapping
    public Set<Post> all() {
        return posts;
    }

    @GetMapping("{id}")
    @ApiOperation(value = "Finds Post by ID",
                    notes = "Provide an ID",
                    response = Post.class)
    public Post getById(@ApiParam(value = "ID value of Post", required = true) @PathVariable Integer id) {
        Optional<Post> first = posts.stream().filter(post -> post.getId().equals(id)).findFirst();
        if(first.isPresent()){
            return first.get();
        }else {
            throw new RuntimeException("Post not found!");
        }
    }

    @PostMapping
    public void add(@RequestBody Post post) {
        posts.add(post);
    }

    @PutMapping("{id}")
    public void update(@PathVariable Integer id,
                       @RequestBody Post post) {
        posts.stream()
                .filter(post1 -> post1.getId().equals(id)).findFirst()
                    .ifPresent(post1 -> post1.setText(post.getText()));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        posts.stream()
                .filter(post -> post.getId().equals(id)).findFirst()
                .ifPresent(post -> posts.remove(post));
    }

}