package com.tts.walleyworksblog.controller;

import com.tts.walleyworksblog.model.BlogPost;
import com.tts.walleyworksblog.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller         // @Controller allows utilization Templating in the project and we are using ThymeLeaf as the Template Engine
public class BlogPostController {

    @Autowired       // inject the dependency for the BlogPostRepository  -- finds available instance of BlogPostRepository and utilizes it into our Controller
    private BlogPostRepository blogPostRepository;
    // private static List<BlogPost> post = newArrayList<>();


// this is referencing a template in the 'template' folder and maps it - @GetMapping - maps the path that is referenced
   @GetMapping("/")
   public String index(BlogPost blogPost, Model model) {
       model.addAttribute("posts", blogPostRepository.findAll());
       return "blogpost/index";
   }

   @PostMapping("/blogposts")
    public String addNewBlogPost(BlogPost blogPost, Model model) {
     blogPostRepository.save(blogPost);
     //post.add(blogPost);
     model.addAttribute("title", blogPost.getTitle());
     model.addAttribute("author", blogPost.getAuthor());
     model.addAttribute("blogEntry", blogPost.getBlogEntry());
       return "blogpost/results";
   }

   @GetMapping("/blogposts/new")
    public String newBlog(BlogPost blogPost) {
       return "blogpost/new";
   }


// edit blog post
    @GetMapping("/blogposts/{id}")
    public String editPostById(@PathVariable Long id, BlogPost blogPost, Model model) {
       model.addAttribute("blogPost", blogPostRepository.findById(id).orElseThrow());
       return "blogpost/edit";
    }

    @PostMapping("/blogposts/update/{id}")
    public String updateExistingPost(@PathVariable Long id, BlogPost blogPost, Model model) {
       var actualPost = blogPostRepository.findById(id).orElseThrow();
       actualPost.setTitle(blogPost.getTitle());
       actualPost.setAuthor(blogPost.getAuthor());
       actualPost.setBlogEntry(blogPost.getBlogEntry());
       blogPostRepository.save(actualPost);
       model.addAttribute("blogPost", actualPost);
        return "blogpost/results";
    }


// to delete blog post
    @RequestMapping("blogposts/delete/{id}")
    public String deletePostById(@PathVariable Long id, BlogPost blogPost) {
       blogPostRepository.deleteById(id);
       return "blogpost/delete";
    }
   
}
