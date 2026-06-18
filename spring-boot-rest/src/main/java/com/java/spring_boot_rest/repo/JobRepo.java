package com.java.spring_boot_rest.repo;

import com.java.spring_boot_rest.model.JobPost;
import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Repository;

@Repository
public class JobRepo {

    private List<JobPost> jobs = new ArrayList<>();

    public List<JobPost> getAllJobs() {
        return jobs;
    }

    public JobPost saveJobPost(JobPost post)
    {
        jobs.add(post);
        return post;
    }

    public JobPost getJob(int postId) {
        try {
            return jobs.get(postId-1);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public JobPost updateJobPost(JobPost post){
        try {
            for(JobPost job : jobs){
                if (job.getPostId() == post.getPostId()){
                    job.setPostDesc(post.getPostDesc());
                    job.setPostTechStack(post.getPostTechStack());
                    job.setReqExperience(post.getReqExperience());
                    job.setPostProfile(post.getPostProfile());
                    return job;
                }
            }
            return null;
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }
}
