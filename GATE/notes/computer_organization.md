# Computer Organization And Architecture

#### CONTENTS
1. [Introduction](computer_organization.md#Introduction) 
2. [Evolution of Computer System](computer_organization.md#Evolution-of-computer-system)


-------------------------------------------------------------------------------
### Introduction

- Computer Organization:
  - Design of the components and functional blocks using which computer systems are built.
  - Analogy: civil engineer's task during building construction(cement, bricks, iron rods and other building materials).
- Computer Architecture:
  - How to integrate the components to build a computer system to achieve a desired level of performance.
  - Analogy: Architect's task during the planning of a building(overall layout, floor plan etc.,)

-------------------------------------------------------------------------------

### Evolution of Computer System
  - A search to automate computing systems has lead to the evolution of Computers to what they are today.
  - Initially they have done mechanical pullies and gears, then they used mechanical relays to calculate computations, then vaccum tubes were developed and then semiconductors are developed.
  - Thus we moved from SMALL SCALL INTEGRATION(SSI) to MSI to LSI to VLSI to ULSI.
  ```
  ________________________________________________________________________________________________
  | Generation      | Main Technology              |  Representative Systems                      |
  -------------------------------------------------------------------------------------------------
  | First (1945-54) | Vaccum tubes, relays         | Machine & assembly language (ENIAC, IBM-701) |
  -------------------------------------------------------------------------------------------------
  | Second(1955-64) | Transistors, memories,       | Batch processing systems, HLL IBM-7090       |
  |                 | IO processers                |                                              |
  -------------------------------------------------------------------------------------------------
  | Third(1965-74)  | SSI and MSI integrated       | Multiprogramming/Time Sharing IBM 360,       |
  |                 | circuits Microprogramming    | Intel 8008                                   |
  -------------------------------------------------------------------------------------------------
  | Fourth(1975-84) | LSI anvd VLSI IC's           | Multiprocessors Intel 8086, 8088             |
  -------------------------------------------------------------------------------------------------
  | Fifth(1984-90)  | VLSI, multiprocessor         | Parallel computing, Intel 486                |
  |                 | on chip                      |                                              |
  -------------------------------------------------------------------------------------------------
  | Sixth(1990-)    | ULSI, scalable architecture, | Massively parallel processors Pentium,       |
  |                 | post CMOS technologies       | SUN ultra workstations                       |
  -------------------------------------------------------------------------------------------------
  ```
- Vaccum tube is a device which controls electric current between electrodes in an evacuated container in a tube.
- Moore's Law:
  - It refers to an observation made by Intel cofounder Gordon Moore in 1965.
  - He noticed that the number of transitors per square inch on IC's has doubled every year since their invention.
  - Moore's law predicts that this trend will continue into the forseeable future. Although the pace has slowed, the number of transistor per square inch has since doubled approximately every 18 months. This is used as a current definition of Moore's law.
- Simplified block diagram of a Computer System:( VON-NEUMANN Architecture, also called stored-program concept)
  == Image for block diagram ==

  - Processor:
    - Also called CPU: Central Processing Unit.
    - Control Unit: Generates the sequence of control signal to carry out the operaitons.
      - The nerve center that senses the states of various functional units and sends control signals to control their states.
      - To perform the operation the CU must generate the signals in a specific sequence.
      - After fetching the instruction form memory, the operation to be performed is decoded(from what we call opcode) by the CU.
    - ALU: Arithemetic Logical Unit, all the calculations happen inside ALU.
      - Contains several registers, general-purpose registers, special-purpose registers, temporary registers.
      - Contains circuitry for logical operations like AND, OR, NOT, SHIFT, COMPARE and arithemetic operations like addition, subtraction, multiplication, division etc.,.
      - During the execution of instruction, the data to be operated on is brought and stored in some register, the desired operation is performed and the result is stored in some register/memory.
      - Instructions are fetched from memory for execution. And each instruction specifies the operation to be performed and on what data it is to be performed.
    - A program refers to a set of instructions that are required to carry out a specific task.
  - Memory Unit:
    - Two types:
      - Primary or Main memory: stores the active instructions and data for program being executed on the processor.
      - Secondary memory: used as a backup and stores all active and inactive programs and data, typically as files.
    - The processor only has direct access to the primary memory.
    - In general memory is implemented as hierarchy to provide faster access at affordable cost. L1 Cache <- L2 Cache <- L3 Cache <- Primary memory <- Secondary Memory.
  - Input Unit: Used to feed data to the computer system from the external environment.
  - Output Unit: Used to send the result of some computation to the outside world.

-------------------------------------------------------------------------------
