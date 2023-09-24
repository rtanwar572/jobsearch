package com.Rohit.Service;

import com.Rohit.Model.Job;
import com.Rohit.Model.Type;
import com.Rohit.Repo.IJobSearch;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    IJobSearch iJobSearch;

    public String getJob(Job job) {
        iJobSearch.save(job);
        return "Added !!";
    }

    public List<Job> getJobs() {
        return (List<Job>) iJobSearch.findAll();
    }

    public String delJob(Long id) {
        iJobSearch.deleteById(id);
        return "Deleted Successfully !!";
    }


    public String addAllJobs(List<Job> jobs) {
        iJobSearch.saveAll(jobs);
        return jobs.size()+" Were Added!! ";
    }

    public List<Job> getJobsBelowSalary(Type type, double salary) {
        return iJobSearch.findByJobTypeAndJobSalaryLessThanEqual(type,salary);
    }

    @Transactional
    public String updateJob(Long id, Double salary) {
        iJobSearch.updateJobById(id.toString(),salary);
        return "Updated SuccessFully !!";
    }

    @Transactional
    public String deleteJob(Long id) {
        iJobSearch.deleteJobById(id.toString());
        return "Deleted SuccessFully !!";
    }
}
