# Data Structures

#### CONTENTS
1. [Introduction](data_structures.md#Introduction) 
2. [Data Structuring - Case Study](data_structures.md#Data-Structuring)

-------------------------------------------------------------------------------
### Introduction

- The issue at hand in most computer tasks is PROBLEM SOLVING. So our aim is to understand how to solve the problem on a computer efficiently.
- Example: find the max out of n numbers:
  - Mathematical approach 1:
    ```
    Let L = {t1, t2, t3, ... tn}
    We find the max asumming L = {t1}
    Now we use the above and find the max for L = {t1,t2}
    Using the above solution, we finf the max for L = {t1,t2,t3}
    ..
    ..
    ..
    Repeating this till tn will give the max of L = {t1, t2, t3, ... tn}
    ```
  - Mathematic Approach 2: we can decompose the problem
    ```
    Let L = {t1, t2, t3, ... tn}
    MAX(L) {
        split L into 2 disjoint non-empty sets L1 & L2
        MAX1 = MAX(L1)
        MAX2 = MAX(L2)
        if MAX1 > MAX2 then MAX = MAX1 else MAX = MAX2
        Print MAX
    }
    ```
- Based on the above examples, the broad steps in problem solving methodology will be as follows:
  1. Initial solution generation. (Decomposition of the problem)(Solution in your own mind)
     - contains a set of actual potential programs
  2. Initial solution refinement.
     - To decide which is the best we consider efficiency(time, space).
   - Note: Now with initial solution in hand, there are certain techniques which are standards. We come across terms lik Algorithm Design and Data Structuring.
  3. Final Solution. (In Vehicle Language)
- After deciding the final solution with the above steps, now we come to the part of programming the solution.
- A high level programming language provide the features like:
  - Data strcuturing: Data types, operations on them. Data procedure encapsulation. Dynamic data structuring.
  - Algorithmic expression: Control constructs, functions(recursive and non-recursive).

- Note: The Calling in C Programming Language is CALL BY VALUE.
  - There are three different paradigms for function calling: 1. CALL BY VALUE, 2. CALL BY VALUE RESULT, 3. CALL BY REFERENCE.

-------------------------------------------------------------------------------

### Data Structuring
