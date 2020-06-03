package kz.almat.swaggerpractice.rest;

import kz.almat.swaggerpractice.model.Post;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Almat on 03.06.2020
 */

@RestController
@RequestMapping("/")
public class PostRest {

    private List<Post> posts = new ArrayList<>();

    public PostRest(){
        posts.add(new Post(1, "aaa"));
        posts.add(new Post(2, "sss"));
        posts.add(new Post(3, "ddd"));
    }

    @GetMapping
    public List<Post> all() {
        return posts;
    }

    @GetMapping("{id}")
    public Optional<Post> getById(@PathVariable Integer id) {
        return posts.stream().filter(post -> post.getId() == id).findFirst();
    }

    @PostMapping
    public void add(@RequestBody Post post) {
        posts.add(post);
    }

    @PutMapping("{id}")
    public void update(@PathVariable Integer id,
                       @RequestBody Post post) {
        posts.stream()
                .filter(post1 -> post1.getId() == id).findFirst()
                    .ifPresent(post1 -> post1.setText(post.getText()));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        posts.stream()
                .filter(post -> post.getId() == id).findFirst()
                .ifPresent(post -> posts.remove(post));
    }

}