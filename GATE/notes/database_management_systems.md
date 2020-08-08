# Database Management Systems

#### Contents
[INTRODUCTION](database_management_systems.md#INTRODUCTION)
[CONCEPTUAL DESIGN](database_management_systems.md#CONCEPTUAL_DESIGN)


### INTRODUCTION
- **Database:** Collection of inter-related data.
- **DBMS:** Database and Query engine (a set of software tools to access, process and modify the data in database).
- Early Information systems: Data is stored in disk and application programs are written to access the disk via file system.
  ![Early Information Systems](../images/Early_information_systems.png)
- Problems with Early Information systems:
  - Disorganized development which causes data isolation and data redundancy
  - Redundancy => Inconsistency
  - Concurrency => updation of shared data
  - Security
  - Integrity constraints
- Role of DBMS:

  ![Role of a DBMS](../images/Role_of_a_dbms.png)
- Levels of Data Abstraction:
  - Physical Level: How the data is stored physically in the disk. (Implementation level)
  - Conceptual Level: What is the data, what are the fields, how the data is related. (Design Level, admin level)
  - View Level: The conceptual level to a sophisticated user/application developer.
  - User Level: The conceptual level to a naive user(who cannot program anything, just to watch the data).
- **Schema:** The definition of the database, what are the fields, what is the type of each field.
- **Instance:** A particular set of data following a schema is called Instance.
- Components of a database:
  - User's:
    - Data Definition Language. (DDL)
    - Data Manipulation Language. (DML) (Retrieve, Insert, Delete, Update) => Often called Query Language.
      1) Procedural
      2) Non Procedural
      3) Mixed
- DBMS components:

  ![DBMS Components](../images/DBMS_Components.png)
- Role of Database manager: DB manager is very significant part of the DBMS
  - Interface with File manager.
  - Integrity constraint enforcement.
  - Backup and recovery.
  - Concurrecy control.
  - Security.
  - Prevents Data Redundancy and Inconsistency.
- **Data Models:** Tools to conceptually design the database.
  - Entity-Relationship model (Object based model)
  - Relational Model (Record based model)
  - Network Model (Record based model)
  - Hierarchial model (Record based model)
  - Object-Oriented data model (Object based model)
  - Semantic data model (Object based model)
  - Functional data model (Object based model)
- Entity Relationship Model: E-R Model
  - Entities
  - Attributes
  - Relationship
  Example: Library Management

  ![Library Mangement: E-R Model](../images/library_management_er_model.png)
- Relational model:
  - Tables/Relations (Columns: Attributes of ER model)
  Example: Library management

  ![Library Management: Relatonal Model](../images/library_magement_relational_model.png)
- Network Model:
  - Records and Pointers
  Note: Cycles are possible, so it is a graph model

  ![Library Management: Network model](../images/library_management_network_model.png)
- Hierarchial Model:
  - Records and pointers
  Note: Only a tree model, may require duplication
      : Useful when the structure is inherantly tree.

  ![Hospital Management: Hierarchial model](../images/hospital_management_hierarchial_model.png)

### CONCEPTUAL DESIGN
- 
