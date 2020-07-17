# Database Management Systems

## P1 FOUNDATIONS
#### 1. Overview
####



### Overview
- **Database:** A collection of data, typically describing the activities of an organization
- **DBMS:** A software designed to assist in maintaining and utilize large collections of data.
- **Advantages of DBMS:**
  - Data Indepenedance: Application programs need not be exposed with the details of data represenataion and storage.
  - Efficient Data Access: Uses very sophisticated techniques to store and retrieve data efficiently.
  - Data Integrity and Security: It has integrity constratints that are enforced when data is accessed through  DBMS.
  - Data Administration: 
  - Concurrent Access and Crash Recovery:
  - Reduced Application Development time:
- **Data model:** A collection of high-level data description constructs that hide many low level storage details.
  - Example : Relational Data model
- **Semantic Data Model:** A more abstract high level data model that makes the task of initial description of data in an enterprise easily.
  - Example: ER Model
- **The Relational Model:**
  - Central data description construct is a *Relation*, which is a set of records.
  - Note: A description of data in terms of data model is called schema.
  - A schema in relational model specify name of the field (attribute), type of each field
  - **Integrity Constraints:** Conditions that the records in a relation must satisfy.
- **Levels of Abstratction in DBMS:**
  - **Conceptual:** Describes the data stored in terms of data model of DBMS. In RDBMS, conceptual schema describes all the relations stored in DBMS. The choice of relations and the choice of fields for each is not obvious and the process of arriving at a good conceptual schema is called *conceptual database design*. Example: Relations
  - **Physical Schema:** Specifies additional storage details, summarizes how the relations in conceptual schema are stored in storage devices. Example: Indexing, unsorted file records etc.,
  - **External Schema:** Usually in terms of data model of DBMS but allows customization based on the end user. For a given database there is only one conceptual and only one physical schema. But there may be many external schemas. Example: Views.
- **Queries:**
- **Transaction Management:**
  - When several users access a database concurrently, the DBMS must carefully order their requests to avoid conflicts.
  - DBMS must protect users from the effects of system failures  like crashes, power failures etc.,
  - Should provide the facility of concurrent execution of any user transactioni.
- **DBMS Architecture:**
  - Please refer to the Figure1, in the same GIT Repo.

### ER Model
- ER model allows us to describe the real-world data in terms of objects and thier relationships and is widely used to develop initial database design.
- ER diagrams are used in conceptual database design to move from more inforaml description of user requirement to what can be implemented in a DBMS.
- **Database design Process:**
  - Requirement Analysis: 
  - Conceptual Database Design:
  - Logical Database Design:
  - Schema Refinement
  - Physical Database Design
  - Application and Security Design