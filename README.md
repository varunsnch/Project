The StudentCourse Project has been developed with Springboot RESTAPI Microservice
To run this project simply import project as maven and do maven clean and maven install
Run the springboot project and the project starts on port 8091
The project supports H2-Database and at the time of initializing, it check if the entity tables exist in the H2-Database.
If the Tables does not exist, it creates all the tables along with the Entity-Mappings (One-to-Many, Many-to-Many).
The project has three main mappings : Student, Course, EnrollmentDetails
The Student and Course Entity has one-to-many mapping with EnrollmentDetail
EnrollmentDetail Entity has many-to-one mapping with Student and Course Entity
The reason I chose to create separate(EnrollmentDetail) entity with its own primary key as it gives flexibility to add more attributes to the table EnrollmentDetail Entity for example scores.
The API to add Student Detail info with RequestBody in JSON: 
url: http://localhost:8091/addStudent
{
	"studentName":"alex",
	"coursesEnrolled": [
		{"courseName" : "cs"}
	]
}

The API to delete Student Detail info requires student id: 
url: http://localhost:8091/students/1

The API to get Students Enrolled in Course: 
http://localhost:8091/studentsEnrolled?courseName=sci

The API to get Students not Enrolled in Course: 
http://localhost:8091/studentsNotEnrolled?courseName=math
