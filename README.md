# System Charlie

Prerequisites

- https://github.com/jvalentino/sys-alpha-bravo

This is an example system that it used to demonstrate different architectural approaches as they relate to scalability. Its core functions are the following:

- The system shall allow a user to add documents
- The system shall version documents
- The system shall allow a user to download a document

This specification implementation uses a load balancer to support multiple concurrent instances.

## Previous System

![01](https://github.com/jvalentino/clothes-closet-wiki/raw/main/wiki/step-2.png)

## Current System

**Multi-Backend (Rating: a hundred)**

Now to tackle the fact that we need more servers (and instances) to handle user load, we start adding more servers to run more backend instances. The result though is that we need a way to direct traffier to the appropriate instance based on load, which is where we get Load Balancers. A consequence though of using a load balancer with in-memory sessions though, is that only the instance which handles the initial user authentication has knowledge of that session, so that user is tied to that instance.

[![01](https://github.com/jvalentino/clothes-closet-wiki/raw/main/wiki/step-3.png)](https://github.com/jvalentino/clothes-closet-wiki/blob/main/wiki/step-3.png)

Pros

- Backend and Database independent, allowing us have different optimized servers.
- Multple backends allows us to handle more load from users.

Cons

- No separation between front-end and backend.
- Incentivizes a snowflake architecture by having to fine tune the server hardware differently.
- Session is maintained in server-memory, thus limiting the number of concurrent users.
- You are paying for that second instance even when you don't need it.
- The more data that goes into the database, the slower it performs.
- The database is now a prime bottlekneck.
- Core reliance on RDMS limits upper scalability.

# Architecture

