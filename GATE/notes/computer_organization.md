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

### Number Representation

- Decimal number system:
  - 10 digits, 0 to 9.
  - Every digit position has a weight which is a power of 10.
  - Base or radix is 10.
- Binary Number system:
  - 2 digits, 0,1
  - Every digit position has a weight of 2.
  - Base or radix is 2.
- Hexadecimal Number System:
  - 0 to 9 and A to F(with decmimal equivalent 10 to 15)
  - Every digit position has a weight of 16.
  - Base or radix is 16.

- A hexadecimal number is represented using a suffix 'H' or using a prefix '0x'.
  - Example: ADDI R1,2AH // add a hexadecimal number 2A to the contents of register R1.
- Unsigned Binary numbers:
  - for an n bit binary number we have 2^n distinct combinations.
- Signed Integer representation: many of the numerical data items are signed that is either positive or negative, so in that case how should we represent signed data?
  - Three possible approaches:
    - Sign-magnitude representation:
      - For an n bit number, the MSB represent the sign of the number and the remaining n-1 bits represent the magnitude of the number.
      - So for an n bit number the decimal values that we can represent range from -(2^(n-1) - 1) to +(2^(n-1) - 1)
      - For n = 4 the possible values are as follows:
        ```
	 0000 -> +0	1000 -> -0
	 0001 -> +1	1001 -> -1
	 0010 -> +2	1010 -> -2
	 0011 -> +3	1011 -> -3
	 0100 -> +4	1100 -> -4
	 0101 -> +5	1101 -> -5
	 0110 -> +6	1110 -> -6
	 0111 -> +7	1111 -> -7
	```
      - The disadvantage here is that zero has 2 representations i.e., 0000,1000.
    - One's complement representation
      - Positive numbers are represented exactly as in sign-magnitude form, negative numbers are represented using 1's complement form.
      - To compute a 1's complement, complement every bit of the number 0->1 and 1->0.
      - MSB will indicate the sign 0: Positive, 1: Negative.
        ```
	 0000 -> +0	1111 -> -0
	 0001 -> +1	1110 -> -1
	 0010 -> +2	1101 -> -2
	 0011 -> +3	1100 -> -3
	 0100 -> +4	1011 -> -4
	 0101 -> +5	1010 -> -5
	 0110 -> +6	1001 -> -6
	 0111 -> +7	1000 -> -7
	```
      - The disadvantage here is that zero has 2 representations i.e., 0000,1111.
      - Range of numbers is same as Sign-magnitude: -(2^(n-1) - 1) to +(2^(n-1) - 1)
      - The advantage of 1's complement is that subtraction can be done using addition, this can lead to substantial saving in circuitry.
    - Two's complement representation:
      - Positive numbers are represented exactly as in sign-magnitude form, negative numbers are represented using 2's complement form.
      - To compute 2's complement, first compute 1's complement and then add 1 to the resulting number.
      - MSB will indicate the sign 0: Positive, 1: Negative.
        ```
	 0000 -> +0	
	 0001 -> +1	1111 -> -1
	 0010 -> +2	1110 -> -2
	 0011 -> +3	1101 -> -3
	 0100 -> +4	1100 -> -4
	 0101 -> +5	1011 -> -5
	 0110 -> +6	1010 -> -6
	 0111 -> +7	1001 -> -7
			1000 -> -8
	```
      - The range is:-(2^(n-1)) to +(2^(n-1) - 1)
      - Advantages are: Single zero representation. Subtraction can be done using addition.
      - Almost all computers today use 2's complement representation for storing negative numbers.
      - Other feature of 2's complement: is that, 
	- it is a weighted representaion with the MSB having a weight of -2^(n-1).
	- The sign bit can be copied as many times as required in the beginning to extend the size of the number, this is called sign extention.
	- Shift left by k positions with zero padding multiplies the number by 2^k.
   	- Shift right by k posistion with sign bit padding divides the number by 2^k.

-------------------------------------------------------------------------------

### Instruction Format and Addressing Modes:

- An instruction is the way we tell the computer what to do.
- An instruction consists of two parts:
  - Operation Code or OpCode:
    - Specifies the operation to be performed by the instruction.
    - There are various of instructions like data transfer, arithmetic and logical, control, I/O and special machine control.
  - Operand(s):
    - Specifies the source and destination of the operation.
    - Source can be specified by an immediate data, by naming a register or specifying the address of memory. Similarly destination can be specified by a register or memory address.
    - Examples:
      - ADD R1,R2 -> opcode: ADD - to perform add on 2 register values, source: R1,R2, destination: R1.
      - ADD R1,LOCA -> 
      - ADDI R1, #10 ->
  - Number of Operands varies from intstruction to instruction. Also for specifying an operand there are various addressing modes.
- Addressing Modes: The way which we specify the operands for the instruction.
  - Immediate Addressing mode, Direct Addressing mode, Indirect Addressing mode, Relative Addressing mode, Indexed addressing and many more....
- Note: A fixed size instruction makes the decoding easier.

- Addressing Modes: They specify the mechanism by which the operand data is located.
  - Some ISA's are quite complex and support many addressing modes, where as load store architecture are usually simple and support limited number of addressing modes.
  - Immediate Addressing mode:
    - operand is part of the instruction itself. 
    - No memory reference to access the operand.
    - Fast but provide a limited range.(as limited number of bits for operand in the instruction) 
    - Example: ADD #25 -> ACC = ACC + 25, ADD R1,R2,42 -> R1 = R2 + 42
  - Direct Addressing mode:
    - The instruction contains a field that holds the memory address of the operand.
    - Single memory access is required to access the operand.
    - Example: ADD R1, 20A6H -> R1 = R1 + Mem[20A6H]
    - No additional calculations to determine operand address. Limited Address Space(as number of bits for address in the instruction)

      ![Direct Addressng Mode](../images/direct_addr_mode.png)

  - Indirect Address Mode:
    - Instruction contains a field that holds the memory address which in turn holds the memory address of the operand.
    - Two memory access required to fetch the operand. Slower but can access larger address space.
    - Example: ADD R1, (20A4H) -> R1 = R1 + Mem[Mem[20A4H]]

      ![Indirect Addressing Mode](../images/indirect_addr_mode.png)

  - Register addressing:
    - The operand is held in a register and the register is specified in the instruction.
    - Limited number of bits required as limited number of registers, provides faster execution.
    - Example: ADD R1,R2,R3 -> R1 = R2 + R3

      ![Register Addressing Mode]

  - Register Indirect Addressing Mode:
    - The instruction specifies the register and the register holds the memory address where the operand is stored.
    - Can access large address space, one memory access
    - Example: ADD R1,(R5)  -> R1 = R1 + Mem[R5]

      ![Register Indirect Addressing Mode]

  - Relative Addressing Mode:(PC Relative)
    - The instruction specifies an offset displacement, which is added to the PC to the effective address of the operand.
    - Limited as the number of bits to specify the displacement is limited.

      ![Relative Addressing Mode]

  - Indexed Addressing Mode:
    - Either a SPR or a GPR is used as index register. The instruction specifies the offset of displacement, which is added to this register to get the effective address of the operand.
    - Example: LOAD R1, 1050(R3)  -> R1 = Mem[1050+R3] : 1050 is the offset and the index is in R3.
    - Offset give the starting address of the array, and the index register value specifies the array element to be used. Can be used to sequentially access an array.

      ![Indexed Addressing Mode]

  - Stack Addressing Mode:
    - Operand is implicitly on top of the stack.
    - Used in earlier zero addressing instructions.
    - Processors have a SPR called SP- stack pointer that keeps track of top of the stack in memory.
    - PUSH, POP, CALL, RET instructions automatically update this SP.


  - Others:
    - Base addressing Mode: Have SPR called base registers/segment register. All final Operands addresses are generated by adding the address to the base register contents. Allows easy movement of code and data segment.
    - Autoincrement/Autodecrement Mode: First introduced in PDP-11 computer system. The register holding the operand address is automatically incremented or decremented after accessing the operand.

-------------------------------------------------------------------------------

### CISC and RISC Architecture

- Features of Complex Instruction Set Computer - CISC(More traditional approach)
  - Complex instruction set.
  - Large number of addressing modes.
  - Special Purpose Registers and Flags.
  - Variable length instructions/Complex instruction encoding.
  - Ease of mapping high level language statements to machine instructions.
  - Instruction decoding/control unit design is more complex.
  - Pipeline implementation is quite complex.
  - Examples: IMB 360/370, VAX-11/780, Intel x86,Pentium
- Features of Reduced Instruction Set Computer - RISC
  - Widely used among many manufacturers today - also called as load-store architecture.
  - Simple architecture for the sake of efficient pipelining.
  - Simple instruction set with very few addressing modes.
  - Large number of GPRs and very few SPRs.
  - Instruction length and encoding is uniform - easy for instruction decoding.
  - Compiler assisted scheduling of pipelining for improved performance.
  - Example: CDC 6600, MIPS family, SPARC, ARM microcontroller family.
- Note:
  - The only CISC instruction set that survived through generation is x86 architecture - this is because of back-compatibility.
  - Sufficient hardware resources are available today to translate from CISC to RISC internally.
  - RISC based computers use compilers to translate into RISC instructions.
  - CISC based computers use hardware to translate into RISC instructions.

- Comparision between CISC and RISC: (VAX 8700 vs MPIS M2000)
  - MIPS required execution of about twice the number of instrcutions as compared to VAX.
  - Cycles Per Instruction CPI for VAX is around 6 times larger than that of MIPS.
  - Hence, MIPS has three the performace of VAX.
  - Also much less hardware is required for MIPS as compared to VAX.

- Conclusion: 
  - Persisting with CISC arch is too costly both in terms of hardware and performance.
  - VAX was replaced by ALPHA(a RISC processor) by Digital Equipment Corporation.
  - CISC architecture based on x86 is different:
    - Because of huge number of installed base, backward compatibility of machine code is very important in commercail point of view. 
    - They have adopted a balenced view: a) user's view is a CISC instruction b) hardware translates every CISC instruction into an equivalent set of RISC instruction internally(I think this is what is called micro programmed control unit) c) an instruction pipeline executes the RISC instructions efficiently.

- Case study: MIPS32 Architecture - A RISC ISA
  - CPU Registers:
    - 32, 32-bit GPRs from R0 to R31.
    - A 32 bit SPR called Program Counter PC:
      1. Points to next instruction in memory to be fetched and executed.
      2. Not directly visible to programmer, effected indirectly with certain instructions like CALL, BRANCH etc.,
    - Pair of 32 bit SPR HI and LO, used to hold the results of multiply, divide and multiply-accumulate instructions.
      - During a multiply operation the HI and LO registers store the product of an integer multiply - HI denotes the high order 32 bits and LO denotes low order 32 bits.
      - During multiply-add or multiply-subtract, the HI and LO registes store the result of the integer multiply-add or multiply-subtract.
      - During a division operation, the HI and LO registers store the quotient in LO and reminder in HI of integer divide.
    - Some common registers missing from MIPS32: all the missing registers can be implemented using GPRs
      - Stack Pointer
      - Index Register
      - Flag Registers: maintains these in GPRs to avoid problems in pipeline implementation.
    - Note: Two GPRs are assigned functions:
      1. R0 is hard-wired to a value 0(zero). So this can be used as the target register for any instructions whose result is to be discarded and as the source register when a value zero is needed.
      2. R31 is used to store the return address when a function call is made. Used by jump-and-link and branch-and-link instructions like JAL, BLTZAL, BGEZAL etc.,. It can also be used as normal register.
    - Examples:
      ```
       LD R4,50(R3)    // R4 = Mem [50 + R3]
       ADD R2, R1, R4  // R2 = R1 + R4
       SD 54(R3), R2   // Mem[54+R3] = R2
  
       ADD R2,R5,R0    // R2 = R5, No move instruction
      ```
    - Some MIPS32 Assembly language conventions:
      - Integer registers of MIPS32 can be accessed using R0...R31 or r0...r31 in an assembly language program.
      - The following conventions are as they are treated by QtSPIM a public domain simulator.
        ```
         Register Name  | Register Number |    Usage
        ------------------------------------------------------------------------------
           $zero        |       R0        |    Constant Zero
        ------------------------------------------------------------------------------
           $at          |       R1        |    Reserved for assembler
        ------------------------------------------------------------------------------
           $v0          |       R2        |    Result of function or for expression
           $v1          |       R3        |    evaluation
        ------------------------------------------------------------------------------
           $a0          |       R4        |    Argument1
           $a1          |       R5        |    Argument2
           $a2          |       R6        |    Argument3
           $a3          |       R7        |    Argument4
        ------------------------------------------------------------------------------
           $t0          |       R8        |    Temporary(not preserved across CALL)
           $t1          |       R9        |    Temporary(not preserved across CALL)
           $t2          |       R10       |    Temporary(not preserved across CALL)
           $t3          |       R11       |    Temporary(not preserved across CALL)
           $t4          |       R12       |    Temporary(not preserved across CALL)
           $t5          |       R13       |    Temporary(not preserved across CALL)
           $t6          |       R14       |    Temporary(not preserved across CALL)
           $t7          |       R15       |    Temporary(not preserved across CALL)
           $t8          |       R24       |    Temporary(not preserved across CALL)
           $t9          |       R25       |    Temporary(not preserved across CALL)
        ------------------------------------------------------------------------------
           $s0          |       R16       |    Temporary(preserved across CALL)
           $s1          |       R17       |    Temporary(preserved across CALL)
           $s2          |       R18       |    Temporary(preserved across CALL)
           $s3          |       R19       |    Temporary(preserved across CALL)
           $s4          |       R20       |    Temporary(preserved across CALL)
           $s5          |       R21       |    Temporary(preserved across CALL)
           $s6          |       R22       |    Temporary(preserved across CALL)
           $s7          |       R23       |    Temporary(preserved across CALL)
        ------------------------------------------------------------------------------
           $gp          |       R28       |    Pointer to global area
           $sp          |       R29       |    Stack Pointer
           $fp          |       R30       |    Frame Pointer
           $ra          |       R31       |    Return address(used by function call)
       -------------------------------------------------------------------------------
           $k0          |       R26       |    Reserved for OS kernal
           $k1          |       R27       |    Reserved for OS kernal
        ```
