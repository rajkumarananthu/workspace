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

  ![Von-Neumann Architecture](../images/von_neumann-arch.png)

  - Von-Neumann architecure is also called stored-program concept because the program to execute is stored in the memory and the instructions are brought to the processor for execution. And before bringing the instruction to the processor that program/process must be stored in the memory.
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
  - Memory Unit:
    - Two types:
      - Primary or Main memory: stores the active instructions and data for program being executed on the processor.
      - Secondary memory: used as a backup and stores all active and inactive programs and data, typically as files.
    - The processor only has direct access to the primary memory.
    - In general memory is implemented as hierarchy to provide faster access at affordable cost. L1 Cache <- L2 Cache <- L3 Cache <- Primary memory <- Secondary Memory.
  - Input Unit: Used to feed data to the computer system from the external environment.
  - Output Unit: Used to send the result of some computation to the outside world.

-------------------------------------------------------------------------------

### Basic Operation of a Computer

- Each operation is carried in the computer in terms of instructions.
- There are special purpose registers and general purpose registers. General purpose registers are used to store the intermediate values or a final result of an operation. Special purpose registers have a specific purpose and can't be used for genral result storing.
- Memory is considered as an array of storage locations (can be bytes or words) each having a unique address.
- A program refers to a set of instructions that are required to carry out a specific task.
- Special Purpose Registers:
  - For interfacing between processor and primary memory are:
    1. Memory Address Register(MAR): Holds the address of the memory location to be accessed.(either for instruction read, or for data read or for data write).
    2. Memory Data Register(MBR): Holds the data that is being written into memory, or will receive the data being read out of memory.

  ![MAR and MDR](../images/mar_mdr.png)

    - To summarize:
      - To read data from Memory:
        1. Place the address in MAR from where the read is to happen.
        2. Issue the READ control signal.
        3. Data is loaded to data bus and thus to MDR.
      - To write data to memory:
        1. Place the address in MAR to where the write is to happen.
        2. Data to be written is loaded to MDR.
        3. Issue the WRITE control signal.
  - For keeping track of program/instructions are:
    1. Program Counter(PC): Holds the memory address of the next instruction to be executed. This is automatically incremented to point to the next instruction when an instruction is being executed.
    2. Instruction Register(IR): Temporarily holds an instruction that has been fetched fro memory. This instruction is decoded to find out the instruction type and also contains information about the location of the data.
- Example instruction execution:
  1. ADD R1, LOCA --> Need to add the contents of memory location of LOCA and the contents of GPR R1 and store back the result in GPR R1.
     - Symbolically: R1 <- R1 + Mem[LOCA]
     - Assumptions: The instruction is stored in memory location 1000, the initial value of R1 is 50 and LOCA is 5000.
     - Execution:
       - Contents of PC is transferred to MAR. * --> MAR <- PC *
       - READ request is issued to memory unit.
       - The instruction is fetched to MDR. * --> MDR <- Mem[MAR] *
       - Content of MDR is transferred to IR. * --> IR <- MDR * 
       - PC is incremented to point to next instruction. * --> PC <- PC + 4 * (4 because iof word size in 32 bit machine)
       - The instruction is decoded by CU.
       - LOCA is transferred to MAR. * --> MAR <- IR[Operand] *
       - READ request is issued to Memory Unit.
       - The data is transferred to MDR. * --> MDR <- Mem[MAR] *
       - The content of MDR is added to R1. * --> R1 <- R1 + MDR *
     - The actual micro-operations that took place are:
       ```
       MAR <- PC
       MDR <- Mem[MAR]
       IR <- MDR
       PC <- PC + 4
       MAR <- IR[Operand]
       MDR <- Mem[MAR]
       R1 <- R1 + MDR
       ```
  2. ADD R1, R2 --> Need to add the contents of GPR R1 and GPR R2 and store the result back in GPR R1. 
     - Symbolically: R1 <- R1 + R2
     - Assumption: Instruction is stored in memory location 1500, initial value of R1 is 50 and R2 is 200.
     - Execution:
       - Contents of PC is transferred to MAR. * --> MAR <- PC *
       - READ request is issued to memory unit.
       - The instruction is fetched to MDR. * --> MDR <- Mem[MAR] *
       - Content of MDR is transferred to IR. * --> IR <- MDR * 
       - PC is incremented to point to next instruction. * --> PC <- PC + 4 * (4 because iof word size in 32 bit machine)
       - The instruction is decoded by CU.
       - R2 is added to R1, * --> R1 <- R1 + R2 *
     - The actual micro-operations are:
       ```
       MAR <- PC
       MDR <- Mem[MAR]
       IR <- MDR
       PC <- PC + 4
       R1 <- R1 + R2
       ```
- Bus Architecture:
  - Communication path way.
  - The different functional modules must be connected in an organized manner to form and operational system.
  - Bus refers to a group of lines that serve as a connecting path for several devices
  - The simplest way to connect the functional unit is to use the single bus architecture.
    - Only one data transfer allowed in one clock cycle.
    - For multi-bus architecture, parallelism in data transfer is allowed.

    ![Sytem Level Single Bus Architecture](../images/single_bus_arch.png)

    ![System Level Two Bus Architecture](../images/two_bus_arch.png)

- Single Bus Architecture inside the processor:
  - All the above bus architecture are at system level. But we need a bus inside the processor itself, because there are many data transfers from GPRs to ALU and control signal from CU to other units etc.,
  - ALU and registers are all connected via the single bus.
  - This bus is internal to the processor.
  - A typical single bus processor architecture is as follows:

    ![Internal Processor Bus](../images/internal_processor_bus.png)

- Multi-Bus Architecture inside the processor:
  
-------------------------------------------------------------------------------

### Memory Addressing and Languages

- Overview of Memory Organization:
  - One of the most important subsystems of a computer that determines the overall performance.
  - An array of storage locations each having a unique address. And each storage location holds a fixed amount of information.
  - A memory sytem with M locations and N bits per location is referred to as * M x N * memory.
  - Bit : 1 bit, Nibble: 4 bits, Byte: 8 bits, Word: no unique length.
- Organization of Memory:
  - Memory is often byte organized(each byte have a unique address).
  - Multiple bytes can be accessed by an instruction. An instruction can span over multiple bytes.
  - For higher data transfer rate, memory is often organized such that multiple bytes can be read or written simultaneously to speed up the processor and memory speed gap.
  - There is vast gap between the speed of processor and primary memory, to fill these speed gap we have various solutions proposed like using Cache memory, memory interleaving etc.,
  - If there are n bits in the address, then we can point to maximum of 2^n memory locations.
  - Examples:
    - memory: 64MB, byte-addressable. how many address bits are needed?
      - 64MB = 2^6 * 2^20 bytes = 2 ^ 26 Bytes => 26 address bits.
    - memory: 1GB, word size: 32 bits, word-addressable. how many address bits are needed?
      - 1GB = 2^30 Bytes, word size = 32 bits = 4 Bytes => address bits -> 2^30 / 2^2 = 2^28 Words => 28 address bits.
- Byte Ordering Conventions:
  - Many data items require multiple bytes for storage. And different computers use different data ordering conventions.
    - Low-Order Byte first -> Little endian machines
      - The least significant byte is stored at lower address(first) followed by most significant byte.
      - Examples: Intel machines, DEC alpha etc.,
    - High-Order Byte first -> Big endian machines
      - The most significant byte is stored at lower address(first) followed by least significant byte.
      - Examples: IBM's 370 mainframes, Motorola micro processors
- Memory Access by Instructions:
  - The program instructions and data are stored in memory.
  - In von-neumann architecture both of them are stored in same memory.
  - In Harvard architecture they are stored in different memories.
  - For execution two basic operations are required:
    1. Load: the contents of a specified memory location is read into a processor register. LOAD R1, 2000
    2. Store: the contents of the processor register is written into a specified memory location. STORE 2020, R3
- Example:
  ```
  -> Compute S = (A + B) - (C - D)
  --------------------------------------
  LOAD R1, A
  LOAD R2, B
  ADD R3, R1, R2 // R3 = R1 + R2
  LOAD R1, C
  LOAD R2, D
  SUB R4, R1, R2 // R4 = R1 - R2
  SUB R3, R3, R3 // R3 = R3 - R4
  STORE S, R3
  --------------------------------------
  ```

- Machine Language:
  - native to a processor, executed directly by hardware
  - instructions consist of binary codes 1's, 0's
- Assembly Language:
  - low level symbolic version of machine language, forms one to one correspodance with machine language.(mnemonics)
  - psuedo-instructions are used that are much more readable and easy to use.
- High-Level language:
  - Programming languages like C, C++, Java etc.,
  - More readable and easy for humans to learn/read/write.

- Assemblers and Compilers:
  - Anyways assembly language and high level languages are created or defined for increasing the ease of writing computer programs, but these are not understandable to the computer.
  - We need to convert them to machine language which is understood by machine/computer.
  - Assembler: Translates the assembly language to machine language.
  - Compiler: Translates the highlevel language to either a machine language or an assembly language.
- Cross Compiler/Assembler:
  - The compiler/assembler may run on a native machine for which the target code is generated, or can be run on another machine.
  - Example: An 8085-cross assembler is running on a desktop PC(pentium,core etc.) generates 8085 machine code.

-------------------------------------------------------------------------------

### Software and Architecture Types

- A software is a program consists of instructions to perform a specific task.
- Software Types:
  - Application Software: Helps the user to solve a particular user problem. May need a system software for execution.
  - System Software: A collection of programs that helps the users to create, analyze and execute their programs.
    - Examples: Operating systems, compilers and assemblers, linkers and loaders, editors and debuggers.
- Operating System: A system software which provides and interface between computer hardware and users.
  - Two layers: 
    1. Kernel: low level routines for resource management
    2. Shell: provides an interface for the users to interact with the computer hardware through kernel.
  - All the application software uses the shell to interact with the computer hardware.
  - Collection of routines to control share the computer resources as they execute programs.
  - Different types:
    - Classical Multi-programming systems
    - Modern Time Sharing systems
    - Real time systems
    - Mobile (phone) systems

- Classification of Computer Architecture:
  - Broadly into 2 types:
    1. Von-Neumann Architecture
    2. Harvard Architecture
  - How a computer is different from calculator?
    - Both uses the same circuitry inside (for doing the arithmetic).
    - For a calculator we need to interactively give the sequence of commands, where as for a computer you write a program store it in memory and run it in one go.
    - This is called stored program concept.
- Von-Neumann Architecture:
  - Instructions and data are stored in same memory module.
  - Most flexible and easier to implement and suitable for most of the general purpose processors.
  - Disadvantage: 
    - The processor bus acts as a bottleneck. Can't bring both instruction and data at the same time if needed.
    - All the instructions & data are moved back and forth through pipes.
- Harvard Architecture:
  - Separate memory for program(instructions) and data.
  - Instructions and data access can be done parallelly.
  - Some microcontrollers and pipelines with separate instruction and data caches follow this concept.
  - The processor-memory bottleneck remains.
- Emerging Architectures: Proposal for In-Memory Computing Architecture, where the storage and computation can be done is same functional unit.
  - Memristors(next to transistors) are projected to make this happen.
- Pipeline in Instruction execution:
  - A concept used to speedup the execution of instructions.
  - An overlapped execution of instructions in the processor.
  - Typical stages are : Instruction Fetch, Instruction Decode, ALU Operation (EX), Memory Access, write back result to register file.
-------------------------------------------------------------------------------

### Instruction Set Architecture

- A computer system from an eye of programmer's. Defines the set of instructions that a computer can take.
- ISA serve as an interface between software and hardware, typically consists the info regarding registers, address and data bus etc., and the instruction set.
- Many ISA'a are not for a particular computer archiecture, they survive across generations like Intel x86 series etc.,

- ISA Design issues:
  - Number of explicit operands. Whether 0,1,2 or 3 operands?
  - Location of Operands. Whether in Memory or registers or accumulator?
  - Specification of Operand Location. How to interpret the operand -> Addressing Modes?
  - Sizes of the operand supported.
  - Supported Operation. How many? What kind? 
- Evolution of Instruction Sets:
  1. Accumulator based: (1960's, EDSAC, IBM 1130): These support 1 address instructions, the default operand is a register called ACCUMULATOR.
     ` ADD X --> ACC = ACC + Mem[X]`
  2. Stack Based: (1960-70, Burroughs 5000): These support 0 address instructions. The operands are from a special memory are called STACK.
     `ADD -> TOS = TOS + NEXT`
  3. Memory-Memory Based: (1970-80, IBM 360): Supports 2,3 address instructions.
     `ADD A,B -> Mem[A] = Mem[A] + Mem[B]`
     `ADD A,B,C -> Mem[A] = Mem[B] + Mem[C]`
  4. Register-Memory Based: (1970-Present, Intel x86)
     `LOAD R1, X --> R1 = Mem[X]`
  5. Register-Register based: 1960-Present, MIPS, CDC 6600, SPARC
     `ADD R1,R2,R3 --> R1 = R2 + R3`

  - Example Code sequence of Z = X + Y
    - Stack based:
      ```
       PUSH X
       PUSH Y
       ADD
       POP Z
      ```
    - Accumulator based:
      ```
       LOAD X 	// ACC = Mem[X]
       ADD Y	// ACC = ACC + Mem[Y]
       STORE Z	// Mem[Z] = ACC
      ```
    - Register-Memory based:
      ```
       LOAD R2, X	// R2 = Mem[X]
       ADD R2,Y		// R2 = R2 + Mem[Y]
       STORE Z,R2	// Mem[Z] = R2
      ```
    - Register-Register based:(also called as load store architecture)
      ```
       LOAD R1, X	// R1 = Mem[X]
       LOAD R2, Y	// R2 = Mem[Y]
       ADD R3,R1,R2	// R3 = R1 + R2
       STORE Z,R3 	// Mem[Z] = R3
      ```
- Older architectures have a large number of SPR's where as newer architectures have large number of GPRs. This is because it is easy for compiler to assign some variables to registers, registers are faster than memory, more compact instruction encoding as fewer bits for registers.
- Many processors have 32 or more GPRs.

-------------------------------------------------------------------------------
