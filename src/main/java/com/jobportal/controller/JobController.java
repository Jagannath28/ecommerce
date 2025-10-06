package com.jobportal.controller;

import com.jobportal.model.Job;
import com.jobportal.service.JobService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public List<Job> list() { return jobService.listAll(); }

    @GetMapping("/{id}")
    public Job get(@PathVariable Long id) { return jobService.get(id); }

    @PostMapping
    public Job create(@RequestParam Long recruiterId, @RequestBody Job job) {
        return jobService.create(job, recruiterId);
    }

    @PutMapping("/{id}")
    public Job update(@PathVariable Long id, @RequestBody Job job) {
        return jobService.update(id, job);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { jobService.delete(id); }

    @GetMapping("/search")
    public List<Job> search(@RequestParam(required = false) String title,
                            @RequestParam(required = false) String location,
                            @RequestParam(required = false) String skill) {
        if (title != null) return jobService.searchByTitle(title);
        if (location != null) return jobService.searchByLocation(location);
        if (skill != null) return jobService.searchBySkill(skill);
        return jobService.listAll();
    }
}
