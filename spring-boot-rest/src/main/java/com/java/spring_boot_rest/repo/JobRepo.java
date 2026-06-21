package com.java.spring_boot_rest.repo;

import com.java.spring_boot_rest.model.JobPost;
import java.util.List;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepo extends JpaRepository<JobPost,Integer> {

//    @Query("select j from JobPost j where j.postProfile = ?1")
//    List<JobPost> findByName(String postProfile);

    List<JobPost> findByPostProfileContaining(String jobProfile);

    List<JobPost> findByReqExperienceGreaterThan(int experience);

    List<JobPost> findByPostProfileContainingOrPostDescContaining(String jobProfile, String description);
}
