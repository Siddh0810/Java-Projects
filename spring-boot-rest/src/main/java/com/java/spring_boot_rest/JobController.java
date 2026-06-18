package com.java.spring_boot_rest;

import com.java.spring_boot_rest.model.JobPost;
import com.java.spring_boot_rest.service.JobService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public JobPost getJobPost(@PathVariable int postId){
        return service.getJob(postId);
    }


    @PutMapping("jobPost")
    public JobPost updatePost(@RequestBody JobPost post){
        return service.updateJobPost(post);
    }
}
