# crud-employee-system
Simple **CRUD** application that allows you to manage employees though UI.
Project was built using these technologies:
+ **Java Spring Boot**
+ **React/TypeScript/CSS**
+ **PostgreSQL**
## Versions
+ No **auth version** where you can manage employees though **in-memeory variant** (Progress lost upon application restart)
+ **Auth version** where you can manage employees though **Database variant**.
## Installation
You will need Docker for this installation 
1. Download repository `git clone https://github.com/janisruduks/crud-employee-system`
2. cd into `/crud-employee-system/src/main/frontend`
3. run `npm install` folldowed by `npm run dev` it will start front end
5. Create a Docker container for the PostgreSQL database: `docker run --name some-postgres -p 5432:5432 -e POSTGRES_PASSWORD=password -d postgres` Note: You can modify the provided fields but remember to update the corresponding Spring application properties.
6. Finally, run the Spring Boot application using your preferred method (e.g., IDE or command line).
## Key features
- **Save Employee:** Add a new employee to the system.
- **Delete Employee:** Remove an employee from the system.
- **View All Employees:** Display a list of all employees.
- **View Employee by ID:** Retrieve and display detailed information about a specific employee.
- **(TODO) Edit Existing Employee:** Update the details of an existing employee.
