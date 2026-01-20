# PulseForge

PulseForge is a production-style, event-driven backend platform built with Spring Boot.  
It ingests high-volume events, processes them asynchronously, and exposes secure APIs
for querying and recovery.

## Why PulseForge?

This project is designed to mirror real-world backend systems used in large-scale
applications, focusing on:
- Asynchronous processing
- Reliability and retries
- Secure access control
- Observability and debugging

## High-Level Architecture

Client → API → Event Ingestion → Async Processor → Database → Query APIs

## Tech Stack

- Java 17
- Spring Boot
- Spring Web & Spring Data JPA
- PostgreSQL + Flyway
- Spring Security (JWT)
- Spring Actuator

## Project Status

Phase 1 — Core ingestion and authentication (in progress)

## Planned Features

- Event lifecycle management
- Async processing with retries
- Dead-letter handling
- User and admin APIs
- Metrics and structured logging actively
- Working on Security
