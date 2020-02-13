# Project Title: RecrumeVEG API

## Project Description and Purpose:

In this Project we used Java Spring to create an Application Programming Interface (API), called the RecrumeVEG API.

RecrumeVEG API is the background system of an online Recruitment Agency Services platform. 

It consists of three subsystems with corresponding functionalities:

1. Central Repository of Applicants, Jobs and Skills
2. Matching Services System
3. Reporting Services

The purpose of the RecrumeVEG API is to perform HTTP calls for each one of the three subsystems described above, 
in order to:

1. Import applicants, job offers, and skills information retrieved from the existing files. 
 
2. Provide registration functionalities for new applicants and job offers.

3. Provide management services for skills.

4. Provide search functionalities to the applicants and job offers.

5. Provide Matching Services.
 
6. Provide Reporting Services.


Additionally, in order to ensure the software quality of the implementing product, an error controller was created, 
so that default error pages would not appear to the end-user, but rather the proper pre-defined HTTP code would be 
returned to the end-user per call. 

All functionalities were implemented by using HTTP calls returning information in JSON format.

Finally, a welcoming homepage of the RecrumeVEG Services was created using HTML and CSS, following the MVC pattern, 
as an example of the connection between the back-end Spring Boot RESTful API and the web front-end, which is 
directly visible to the user.

## Operating Environment 

RecrumeVEG API was created using:

- Java 11
- Microsoft SQL Server Express Edition, as underlying database vendor
- Postman and Swagger UI, as third party tools, in order to perform the calls
 
## Running the application locally

In order to run this Spring Boot application on your local machine, you can execute 
the main method in the gr.codehub.RecruMe.VEG.VegApplication class from your IDE.
