package com.jobportal.controller;

import com.jobportal.model.Application;
import com.jobportal.service.ApplicationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    private final ApplicationService svc;

    public ApplicationController(ApplicationService svc) { this.svc = svc; }

    @PostMapping("/apply")
    public Application apply(@RequestParam Long jobId, @RequestParam Long userId,
                             @RequestParam String resumeUrl, @RequestParam(required = false) String cover) {
        return svc.apply(jobId, userId, resumeUrl, cover);
    }

    @GetMapping("/by-applicant/{applicantId}")
    public List<Application> byApplicant(@PathVariable Long applicantId) {
        return svc.applicationsByApplicant(applicantId);
    }

    @GetMapping("/by-job/{jobId}")
    public List<Application> byJob(@PathVariable Long jobId) {
        return svc.applicationsByJob(jobId);
    }
}
