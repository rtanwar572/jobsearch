package com.Rohit.Repo;

import com.Rohit.Model.Job;
import com.Rohit.Model.Type;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IJobSearch extends CrudRepository<Job,Long> {

    List<Job> findByJobTypeAndJobSalaryLessThanEqual(Type type, double salary);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Job j SET j.jobSalary = :salary WHERE j.jobId = :id")
    void updateJobById(String id, Double salary);


    @Transactional
    @Modifying
    @Query("DELETE FROM Job j WHERE j.jobId = :id")
    void deleteJobById(String id);
}
