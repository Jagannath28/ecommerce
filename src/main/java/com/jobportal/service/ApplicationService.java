package com.jobportal.service;

import com.jobportal.model.*;
import com.jobportal.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ApplicationService {
    private final ApplicationRepository appRepo;
    private final JobRepository jobRepo;
    private final UserRepository userRepo;

    public ApplicationService(ApplicationRepository appRepo, JobRepository jobRepo, UserRepository userRepo) {
        this.appRepo = appRepo; this.jobRepo = jobRepo; this.userRepo = userRepo;
    }

    public Application apply(Long jobId, Long userId, String resumeUrl, String cover) {
        Job job = jobRepo.findById(jobId).orElseThrow();
        User u = userRepo.findById(userId).orElseThrow();
        Application app = Application.builder()
                .job(job)
                .applicant(u)
                .resumeUrl(resumeUrl)
                .coverLetter(cover)
                .appliedAt(LocalDateTime.now())
                .status("APPLIED")
                .build();
        return appRepo.save(app);
    }

    public List<Application> applicationsByApplicant(Long applicantId) {
        return appRepo.findByApplicantId(applicantId);
    }

    public List<Application> applicationsByJob(Long jobId) {
        return appRepo.findByJobId(jobId);
    }
}
