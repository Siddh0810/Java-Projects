package com.java.spring_boot_rest.controller;

import com.java.spring_boot_rest.model.JobPost;
import com.java.spring_boot_rest.service.JobService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
public class JobController {

    @Autowired
    private JobService service;

//    @ResponseBody
    @GetMapping("jobPosts")
    public List<JobPost> getAllJobs(){
        return service.getJobs();
    }

    @PostMapping("jobPost")
    public JobPost savePost(@RequestBody JobPost post){
        return service.saveJobPost(post);
    }

    @GetMapping("jobPost/{postId}")
    public ResponseEntity<JobPost> getJobPost(@PathVariable int postId){
        JobPost post = service.getJob(postId);

        if(post.getPostId() > 0) {
            return new ResponseEntity<>(post, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("jobPost")
    public JobPost updatePost(@RequestBody JobPost post){
        return service.updateJobPost(post);
    }

    @DeleteMapping("jobPost/{postId}")
    public String deleteJobPost(@PathVariable int postId){
        service.deleteJobPost(postId);
        return "Deleted";
    }

    @GetMapping("jobPost/name/{postProfile}")
    public ResponseEntity<List<JobPost>> jobPostByName(@PathVariable String postProfile){
        return new ResponseEntity<>(service.getJobPostByName(postProfile), HttpStatus.ACCEPTED);
    }

    @PostMapping("jobPost/image")
    public ResponseEntity<?> jobPostImage(@RequestPart JobPost jobPost, @RequestPart MultipartFile image){
        JobPost savedPost = null;
        try {
            savedPost = service.saveImage(jobPost,image);
            return new ResponseEntity<>(savedPost,HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("jobPost/{postId}/image")
    public ResponseEntity<byte[]> getJobPostImage(@PathVariable int postId){
        JobPost post = service.getJob(postId);

        if(post.getPostId() > 0) {
            return new ResponseEntity<>(post.getImageData(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
