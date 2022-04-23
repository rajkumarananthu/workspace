# Important Points I learned about C++

### What is the need of references, given we already have pointers, as references are implicit pointers?
- The basic need of adding the concept of references is due to operator overloading.
- As operator overloading cannot be done with pointers as operands(which defeats the whole purpose of overloading overloading and creates ambiguity).
- So this raised the need of references, which acts as implicit pointers.

### What is Rule of Three/ Rule of Zero/ Rule of Five?
**Rule Of Three**: Rule Of Three states that if a class is managing a resource(file/memory/locks etc.,), the class should defining all the following explicitly:
- Destructor to clean up the resource.
- Copy constructor to copy objects during initialization.
- Overloaded assignment operator to assign objects during assignment.

### What is RAII?
- RAII is Resource Acquisition Is Initialization. This basically defines that resource acquisition is done during initialization of the object, and it should be carefully handled.
- Basically RAII is the reason for **Rule Of Three/ Rule Of Zero/ Rule of Five**.

### What is the need for introducing lambdas in C++, as lambdas are nothing different from functions?
### We generally declare lambdas using auto type, but what is its actual type?
### What is a function signature?
### What is the need to introduce rvalue references?
### What is the use of keyword "volatile"?
