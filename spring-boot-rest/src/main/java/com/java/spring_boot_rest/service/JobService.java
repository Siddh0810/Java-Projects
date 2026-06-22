package com.java.spring_boot_rest.service;

import com.java.spring_boot_rest.model.JobPost;
import com.java.spring_boot_rest.repo.JobRepo;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class JobService {



    @Autowired
    private JobRepo repo;

    public List<JobPost> getJobs(){
        return repo.findAll();
    }

    public JobPost saveJobPost(JobPost post)
    {
        return repo.save(post);
    }

    public JobPost getJob(int postId) {
           return repo.findById(postId).orElse(new JobPost(-1));
    }

    public JobPost updateJobPost(JobPost post){
        return repo.save(post);
    }

    public void deleteJobPost(int postId) {
        repo.deleteById(postId);
    }

    public List<JobPost> getJobPostByName(String postProfile) {
//        return repo.findByName(postProfile);    // Also can be used to fetch by JPQL
        System.out.println(repo.findByReqExperienceGreaterThan(2));
        System.out.println(repo.findByPostProfileContainingOrPostDescContaining("java","Machine"));
        return repo.findByPostProfileContaining(postProfile);

    }

    public JobPost saveImage(JobPost jobPost, MultipartFile image) throws IOException {
        jobPost.setImageName(image.getOriginalFilename());
        jobPost.setImageType(image.getContentType());
        jobPost.setImageData(image.getBytes());
        return repo.save(jobPost);
    }
}
