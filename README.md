# 🥊 Blind Battles – Anonymous Competitive Programming Platform (v1)

Blind Battles is an **anonymous, battle-based competitive programming platform** designed to evaluate **pure problem-solving skill** without identity bias.  
It is built as an **enterprise-style backend system** using Spring Boot, JWT security, Docker-based code execution, and a clean domain-driven model.

This repository represents **Version 1 (v1)** — a fully functional, end-to-end backend capable of authenticating users, accepting submissions, securely executing code, and returning verdicts.

---

## 📌 Project Vision

> **Skill over identity. Logic over labels. Fairness over familiarity.**

Traditional competitive platforms expose user identity, reputation, and ranking — introducing bias and psychological pressure.  
**Blind Battles removes identity from competition**, allowing students to compete **only on code quality, correctness, and efficiency**.

This project is built with:
- **Academic evaluation**
- **Placement readiness**
- **Scalable industry deployment**
in mind.

---

## 🎯 Core Objectives

- Enable **anonymous coding battles**
- Ensure **secure and isolated code execution**
- Evaluate submissions fairly using **Docker sandboxing**
- Support **multi-level elimination battles**
- Track submissions, verdicts, and performance metrics
- Provide a **production-ready backend architecture**

---

## 🧠 What is a “Battle”?

A **Battle** is a competitive coding event conducted by an **Organizer**.

- Students participate anonymously
- Battles progress through **levels**
- Each level assigns problems of increasing difficulty
- Students compete in **pairs**
- Winners advance, losers are eliminated
- Final level produces a single winner

> In v1, battle progression logic is stubbed but the **foundation is fully implemented**.

---

## 🧩 Current Feature Set (v1)

### ✅ Authentication & Security
- JWT-based authentication
- Stateless API security
- Role-aware tokens (`STUDENT`, `ORGANIZER`, `ADMIN`)
- Password hashing using BCrypt

### ✅ User Roles
- **Student** – participates in battles, submits code
- **Organizer** – creates and manages battles
- **Admin** – system-level control (future scope)

### ✅ Problem Management
- Centralized problem repository
- Problems mapped to **difficulty levels**
- Difficulty enums: **LEAST → LOW → EASY → MEDIUM → HARD → COMPLEX → PRO**


### ✅ Submission System
- Authenticated submission endpoint
- Source code stored for audit & history
- Language-aware execution (JAVA v1)
- Verdicts automatically determined

### ✅ Docker-Based Judge Engine
- Each submission runs inside an **isolated Docker container**
- CPU, memory, and time limits enforced
- Containers destroyed after execution
- No network access inside container

### ✅ Verdict System
|       Exit Code    |           Verdict           |
|--------------------|-----------------------------|
| 0                  |       AC (Accepted)         |
| 1                  |       WA (Wrong Answer)     |
| 124                |   TLE (Time Limit Exceeded) |
| 137                | MLE (Memory Limit Exceeded) |
| else               |       RE (Runtime Error)    |

### ✅ Persistence Layer
- PostgreSQL database
- JPA/Hibernate ORM
- Audit-friendly schema

---

---

## 🧪 End-to-End Flow (Submission)

1. Student logs in → receives JWT
2. Student submits code with JWT
3. JWT filter authenticates request
4. Submission stored in DB
5. Code written to sandbox directory
6. Docker container spins up
7. Code compiled & executed
8. Verdict calculated
9. Result stored & returned

✔ **Fully working in v1**
```

Client (Postman / Frontend)
        |
        |  HTTP Request (JSON + JWT)
        v
Spring Boot DispatcherServlet
        |
        v
Spring Security Filter Chain
        |
        |── JwtAuthenticationFilter
        |       ├─ Extract Authorization header
        |       ├─ Validate JWT
        |       ├─ Populate SecurityContext
        |       └─ Continue / Reject
        |
        v
REST Controller Layer
        |
        v
Service Layer
        |
        |── Business Validation
        |── Database Persistence
        |── Judge Orchestration
        |
        v
Docker Judge Engine
        |
        |── Compile
        |── Execute
        |── Enforce limits
        |
        v
Result Mapping Layer
        |
        v
PostgreSQL Database
        |
        v
HTTP Response to Client

```
---

## 🛠️ Tech Stack

### Backend
- Java 21
- Spring Boot 4.x
- Spring Security
- Spring Data JPA

### Security
- JWT (JSON Web Tokens)
- BCrypt password hashing
- Stateless authentication

### Database
- PostgreSQL

### Code Execution
- Docker
- Linux-based sandbox
- Resource-limited containers

### Tooling
- STS / Eclipse
- Postman
- pgAdmin
- Maven

---

## 🧱 Database Tables (v1)

- `students`
- `organizers`
- `battles`
- `problems`
- `submissions`

Each table is designed with **future extensibility** in mind.

---

## 🚧 Known Limitations (v1)

These are **intentional**, not design flaws:

- Only **JAVA** supported (Python/C++ planned)
- Battle progression logic is stubbed
- Static test cases (dynamic test loading planned)
- No frontend yet (API-first design)
- No plagiarism detection yet

---

## 🔮 Future Roadmap (v2+)

- Dynamic battle progression engine
- Multi-language execution (Python, C++)
- Plagiarism detection (AST + token analysis)
- Live leaderboards (anonymous)
- Admin dashboard
- Recruiter analytics view
- Distributed judge workers
- Cloud deployment (Kubernetes)

---

## 🏁 Current Status

✅ **Blind Battles v1 is COMPLETE and FUNCTIONAL**

- Authentication works
- JWT security works
- Submissions execute correctly
- Docker judge is operational
- Verdicts are accurate

> The system is now ready for **feature expansion**, not rewrites.

---

## 🤝 Contribution & Usage

This repository is currently:
- Used as a reference for upcomming versions.
- Structured for future team development
- Built with clean separation of concerns

---

## 📜 License

Academic / Educational Use  
(Production licensing is applicable)
---

> **Blind Battles v1 proves the architecture.  
> v2 will prove the scale.**



