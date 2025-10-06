# Job Portal Backend (Spring Boot)

## Overview
Features:
- MySQL persistence
- User signup/login with roles: JOB_SEEKER, RECRUITER, ADMIN
- Job posting CRUD (Recruiters)
- Job application system (apply & view)
- Job search (title, location, skills)
- JWT authentication
- Postman collection included

## Run
1. Create MySQL DB `jobdb` and update `application.yml` credentials.
2. Build: `mvn clean package`
3. Run: `mvn spring-boot:run` or run main class from IDE.
4. Import `postman_collection.json` to test endpoints.
