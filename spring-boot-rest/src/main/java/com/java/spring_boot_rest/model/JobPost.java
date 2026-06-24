package com.java.spring_boot_rest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class JobPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;
    private String postProfile;
    private String postDesc;
    private int reqExperience;
    private String imageName;
    private String imageType;
    @Lob
    private byte[] imageData;

    public JobPost(int id) {
        this.postId = id;
    }

}
