package com.jobportal.service;

import com.jobportal.model.Job;
import com.jobportal.model.User;
import com.jobportal.repository.JobRepository;
import com.jobportal.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class JobService {
    private final JobRepository jobRepo;
    private final UserRepository userRepo;

    public JobService(JobRepository jobRepo, UserRepository userRepo) {
        this.jobRepo = jobRepo;
        this.userRepo = userRepo;
    }

    public Job create(Job job, Long recruiterId) {
        User r = userRepo.findById(recruiterId).orElseThrow();
        job.setPostedAt(LocalDateTime.now());
        job.setPostedBy(r);
        return jobRepo.save(job);
    }

    public Job update(Long id, Job job) {
        Job ex = jobRepo.findById(id).orElseThrow();
        ex.setTitle(job.getTitle());
        ex.setDescription(job.getDescription());
        ex.setLocation(job.getLocation());
        ex.setSkills(job.getSkills());
        ex.setSalary(job.getSalary());
        return jobRepo.save(ex);
    }

    public void delete(Long id) { jobRepo.deleteById(id); }

    public Job get(Long id) { return jobRepo.findById(id).orElseThrow(); }

    public List<Job> searchByTitle(String title) { return jobRepo.findByTitleContainingIgnoreCase(title); }
    public List<Job> searchByLocation(String location) { return jobRepo.findByLocationContainingIgnoreCase(location); }
    public List<Job> searchBySkill(String skill) { return jobRepo.findBySkillsContainingIgnoreCase(skill); }
    public List<Job> listAll() { return jobRepo.findAll(); }
}
