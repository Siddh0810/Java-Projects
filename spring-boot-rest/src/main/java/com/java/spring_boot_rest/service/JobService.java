package com.java.spring_boot_rest.service;

import com.java.spring_boot_rest.model.JobPost;
import com.java.spring_boot_rest.repo.JobRepo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {



    @Autowired
    private JobRepo repo;

    public List<JobPost> getJobs(){
        return repo.getAllJobs();
    }

    public JobPost saveJobPost(JobPost post)
    {
        return repo.saveJobPost(post);
    }

    public JobPost getJob(int postId) {
        return repo.getJob(postId);
    }

    public JobPost updateJobPost(JobPost post){
        return repo.updateJobPost(post);
    }
}
