package com.Rohit.Controller;

import com.Rohit.Model.Job;
import com.Rohit.Model.Type;
import com.Rohit.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class JobController {
    @Autowired
    JobService jobService;

    @GetMapping("jobs")
    public List<Job> getJobs(){
        return jobService.getJobs();
    }
    @PostMapping("jobPost")
    public String addJob(@RequestBody Job job){
        return jobService.getJob(job);
    }
    @DeleteMapping("job/id/{id}")
    public String delJob(@PathVariable Long id){
        return jobService.delJob(id);
    }

    //adding list of jobs

    @PostMapping("stocks/list")
    public String addJobs(@RequestBody List<Job> jobs) {
        return  jobService.addAllJobs(jobs);
    }
    //using Custome finders for getting jobs which salary is lessThanEqual and type should be "?";
    @GetMapping("jobs/type/lessOrEqual/salary")
    public List<Job> getJobBelowSalary(@RequestParam Type type, @RequestParam double salary){
        return jobService.getJobsBelowSalary(type,salary);
    }

    //custome Query Writer for updating salary using id

    @PutMapping("job/id/{id}/salary/{salary}")
    public String updateJob(@RequestParam Long id,@RequestParam Double salary){
        return jobService.updateJob(id,salary);
    }
    //for deleting a job
    @DeleteMapping("job")
    public String delJobById(@RequestParam Long id){
        return jobService.deleteJob(id);
    }

}
