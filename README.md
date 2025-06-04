# ⏳ TIMELY — Time-Limited Access Link Generator

> *One link. One shot. One moment in time.*

## ✨ What is TIMELY?

**TIMELY** is not just a backend tool — it’s your **digital gatekeeper**.

Whether you’re sharing a private document, giving limited-time access to an internal service, or creating temporary event invitations — **TIMELY makes sure the door closes exactly when you want it to.**

Built with **Java**, **Spring Boot**, and **MongoDB**, it generates unique, self-expiring URLs you can trust — with seconds-to-days level precision.

🔗 **Live Demo:** [https://timely.raniasmit.me](https://timely.raniasmit.me)

---

## 🧠 Why TIMELY?

Forget about lingering links and stale URLs. TIMELY is designed for moments that **shouldn’t last forever**.

- 🔐 **Secure by Default** – Each link comes with a one-time-use token and a precise TTL.
- 🕒 **Time-Aware** – You choose how long the door stays open: 10 seconds, 10 minutes, 10 days.
- 🧾 **Track Everything** – Every request, expiration, and access attempt is tracked in the database.
- ⚙️ **Developer-Friendly** – RESTful API with clean Swagger documentation, ready to integrate.
- 🧊 **Minimalist Frontend** – Just enough UI to get the job done without distractions.

> 🧩 Think of it like a temporary bridge — TIMELY builds it, walks them across, then burns it behind them.

---

## 🔧 Tech Stack

| Layer       | Tool                   |
|-------------|------------------------|
| Backend     | Java 17, Spring Boot   |
| Database    | MongoDB                |
| API Docs    | Swagger UI             |
| Build Tool  | Maven                  |
| UI          | Static HTML + CSS + JS |

---

## ⚙️ Features at a Glance

- ✅ Time-limited access URLs
- ✅ One-time or reusable token modes (configurable)
- ✅ Expiry configurable per request
- ✅ REST API: create, validate, revoke
- ✅ Automatic redirection or error page on expiry
- ✅ Clean, auditable MongoDB-backed storage

---

## 🔒 Example Use Cases

- Temporarily share internal dashboards or dev environments
- Send event invites with access expiry
- Give short-lived access to paid or confidential content
- Share files that *must* self-destruct after download

---

## 📦 Installation & Setup

```bash
# Clone the repository
git clone https://github.com/RaniAsmit/Timely.git
cd Timely

# Run the Spring Boot application
./mvnw spring-boot:run
