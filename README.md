 The Crimsmon - Personal Blog

A personal blog with two sections:

- Guest section - (public, no login): Home page listing published
  articles, and an Article page showing one article's full content
  and publication date.
- Admin section - (JWT-protected): Dashboard listing all articles
  with edit/delete, an Add Article page, and an Edit Article page.

 Stack
- Backend: Java, Spring Boot, Spring Security, Spring Data JPA,
  PostgreSQL, JWT.


1. Set up PostgreSQL

Create a database (defaults assume `personal_blog` on localhost:5432):

sql
CREATE DATABASE personal_blog;

Tables are created automatically on first run (`spring.jpa.hibernate.ddl-auto=update`).

2. Configure and run the backend


All config is environment-variable driven — see
`backend/src/main/resources/application.properties` for defaults.

bash
cd backend

export DB_NAME=personal_blog
export DB_USERNAME=postgres
export DB_PASSWORD=your postgres password
export JWT_SECRET=replace with a long random string at least 32 chars
export ADMIN_USERNAME=admin
export ADMIN_PASSWORD=choose password


mvn spring-boot:run


On first startup, if no admin user exists yet, one is created automatically
from `ADMIN_USERNAME` / `ADMIN_PASSWORD`. The server listens on
`http://localhost:8080` by default (override with `SERVER_PORT`).


 API summary

| Method | Path                       | Auth       | Purpose                        |
|--------|----------------------------|------------|---------------------------------|
| GET    | /api/articles              | Public     | List published articles         |
| GET    | /api/articles/{id}         | Public     | Get one article                 |
| POST   | /api/auth/login             | Public     | Log in, returns a JWT           |
| GET    | /api/admin/articles         | JWT        | List articles (admin view)      |
| POST   | /api/admin/articles         | JWT        | Create an article               |
| PUT    | /api/admin/articles/{id}    | JWT        | Update an article               |
| DELETE | /api/admin/articles/{id}    | JWT        | Delete an article               |

Send the JWT as `Authorization: Bearer <token>` on admin requests on POSTMAN.

