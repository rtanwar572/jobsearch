package com.Rohit.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name = "jobs")
@Data
public class Job {
    @Id
    @NotNull(message = "id of the job should not be null")
    private Long jobId;
    @NotEmpty
    private String jobTitle;
    @Size(min = 10,max = 1000,message = "size should be 10 to 1000 letters !!")
    private String jobDesc;
    @NotBlank
    private String jobLoc;
    @Min(20000)
    private Double jobSalary;
    @Email(message = "Invalid Email address !! ")
    private String companyEmail;
    @NotEmpty
    private String companyName;
    private String employerName;
    @Enumerated(EnumType.STRING)
    private Type jobType;
    private LocalDateTime creationTime;
//
//    [
//    {
//        "jobId": 1,
//            "jobTitle": "software engineer",
//            "jobDesc": "we are hiring for software engineer",
//            "jobLoc": "khan market new delhi",
//            "jobSalary": 21000,
//            "companyEmail": "example@gmail.com",
//            "companyName": "It solutions",
//            "employerName": "Deepak kalal",
//            "jobType": "IT",
//            "creationTime": "2022-09-24T14:50:24.558Z"
//    },
//    {
//        "jobId": 2,
//            "jobTitle": "junior software engineer",
//            "jobDesc": "we are hiring for junior software engineer",
//            "jobLoc": "New delhi,Near chandni chowk",
//            "jobSalary": 22000,
//            "companyEmail": "exampure@gmail.com",
//            "companyName": "Examlpur",
//            "employerName": "kajal kalal",
//            "jobType": "IT",
//            "creationTime": "2021-09-24T14:50:24.558Z"
//    },
//    {
//        "jobId": 3,
//            "jobTitle": "Hr Recruiter",
//            "jobDesc": "we are hiring for human resource executer",
//            "jobLoc": "gurugram sec 23",
//            "jobSalary": 25000,
//            "companyEmail": "godaddy@gmail.com",
//            "companyName": "crtical solutions",
//            "employerName": "aman jadhav",
//            "jobType": "HR",
//            "creationTime": "2023-09-24T14:50:24.558Z"
//    }
//]
}
