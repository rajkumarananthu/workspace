# Learning Python

### Introduction
##### Genral
- Two versions Python2 and Python3, most of the concepts apply to both the versions.
- Python3 differs from Python2 in some critical syntax changes, mostly related to printing and IO.
- Have an extension *.py*, '#' denotes the single line comment
- Dynamically typed language, it means that a single variable can be bound to different data possible different types
  during the program execution.
- An assignment operator creates an asscoiation between name and value (Unlike C/C++ in  which variables are statically
  typed, that means, we need to declare a variable and its type before its usage, and this declaration is used to
  allocate storage).
- The statement terminator is a new line, we can use a semicolon ';' on the other hand to separate statements.
- Python is a strictly indentated language, you need to maintain the indentaion with spaces, these indentation is used
  to define the blocks of code:
  ``` print "START OF WHILE LOOP.\n";
      while (a) :
          print "Hello World.\n";  # the block of while starts from here
          a--;                     # and end here  
      print "END OF WHILE LOOP.\n" # ending of block is by reducing the block indendation, if you see.
  ```
- Writing complex code may some time lead to long line of code, in such case to increase readability we can use '\\' to 
  tell the interpreter that the statement continues in next line. In such cases the normal indentation rules doesn't
  apply to the statments.
##### Conditionals
- The conditional construct takes the following format:
  ```
  if a < b:
      print "a is less than b.\n";
  elif a == b:
      print "a is equal to b.\n";
  else:
      print "a is greater than b.\n";
  ```
- We can omit the `else if` statement from the above or add much more to check more conditions. Whereas the `else` is
  optional to an `if` and for an `if` there is atmost one `else`.
- In case of nested `if` conditionals, the `else` to an `if` is identified through indentation.
- Boolean value in Python have the form `True` and `False` (T and F are capital)
- `in` operator in Python lets us to traverse over objects such as string, list or dictionary. Some times the same can
  be used to check whether a value is contained in other object. Like
  `if 'spam' in s: ...`
##### Strings
- Strings in Python are defined/constructed using single(''), double(") or triple(''') quotes. Speciality about triple
  quotes is that, they are useful when the string literal span over multiple lines.
- String can be accessed using index operator as `s[i]`, we also have slicing operator `s[i:j]`, this gets the substring
  of s from i to j (including i and excluding j). If i is omitted it indicates start of string, if j is omitted it
  represents end of string.
- Strings are concatanated using `+`
- Type casting operator are like `int()` `float()`.
- Non-string values can be converted to strings using `str()`, `repr()`, and `format()`.
- `split()` method splits the string into a list of fields based on the delimiter provided.
##### Lists
- Lists are a sequence of arbitrary object, we can create a list using square brackets '[' and ']'.
  ` names = ['one', 'two', 'three'];`
- We can append more items to list using `append()` method. Otherwise we can use `insert()` method to insert an item at
  specified position.
- We can access the list items using indexing operator `names[i]`, similarly we can use slicing of the list `names[i:j]`
- `+` is used to conctatenate 2 lists.
- Lists can contain any type of object, it can be another list also.
- Lists are similar to arrays/vectors of C/C++, except that arrays/vectors are homogeneous data holders (same data).
- `import` is used to import a Python module to other Python file. Different ways to use `import`:
  `import <module_name>` or `from <module_name> import <name>` or `import <module_name> as <other_name>` or 
  `from <module_name> import *`
- There are some special constructs called 'comprehensions'. We will get to know about this more in detail later.
  Example: `l = [float(a) for a in other_list];`
- Some example of built-in functions of python are `min()` or `max()`.
##### Tuples
- This are to pack a collection of values into a single object. We create a tuple by enclosing the values in paranthesis
- We can use all the ways of accessing list to tuples also.
- But generally, we unpack the tuple by assigning the tuple to a comma separated values, like:
  `name,age = details;`
- A tuple is not mutable as list, i.e., we cannot add more elements like we do for lists.
- Thus tuples are viewed as a single object having several parts rather than a collection of objects.
- We can traverse/iterate over a tuple as follows:
  ```
  for name,age in details:
     print "Name : %s, Age: %d" %(name, age);
  ```
##### Sets
- Used to contain an unordered collection of objects, to create a set we use `set()` function.
- Unlike lists or tuples, sets are unordered and cannot be accessed by index.
- It will not alliw duplicates, and has a collection of operations Union, intersection, difference, symmetric difference.
- New items can be added to set using `add()`(for single item) or `update()` (for multiple data items).
- An item can be removed using `remove()` method.
##### Dictionaries
- An associative array or a hash table containing objects indexed by keys.
- Dictionaries can be created using flower braces '{' and '}'.
- To access dictionaries we use key-indexing.
- You can use Python objects, including numbers and tuples. Where are lists /dictionaries cannot be used as keys, because
  their content can change.
- `del` statement is used to delete an element of the dictionary.
- To get the list of keys used the a dictionary we can use `list()`.
##### Iterations/Loops
- `for n in range():` -> range(start, end[,step]) - it will generate a list of numbers from start till end at steps of
  step value. `range()` create a fully populated list of numbers.
- For extremely large range of numbers we `xrange()` - xrange computes the values on demand when lookups are requested.
- In Python3 `xrange()` is renamed as `range()`.
##### Functions
- We use the keyword `def` to create a function. Example:
  ```
  def divide(a,b):
      q = a//b; # truncating division
      r = a - q*b;
      return (q,r);
  ```
- For calling a function we use the function name along with the parameters for arguments.
- For defining default arguments for variables, we use assigment operator: `def divide(a,b=1)`.
- We can also invoke function by using keyword arguments and supplying the arguments in arbitrary order.
  *Q - Does this mean the following declaration is valid? `def divide(a=1,b):`??*
- We use global statement to modify the global variables inside a function.
##### Generators
- A function using the keyword `yield` is called as generator. Calling a generator function creates an object that
  produces a sequence of results through successive calls to `next()` function.
- The `next()` makes a generator run until it reaches an `yeild` statement. At the yeild statemnet the value passed is
  returned by next(), and function suspends the execution. When the next call to `next()` is made it resumes the
  execution from the statement after the `yeild` statement.
##### Coroutines
- Generally a function operate on a set of input arguments. We can a write a function that operates as a task and can
  operate on the sequence of inputs sent to it. These are called Coroutines.
- This can be created by using and `yield` statement and `send()` method.
- A coroutine will be suspended until an input is send to the coroutine, using the `send()` function.
- In this case we catch the input send using a special statement as `(yeild)` - this gives the sequence of input sent
  using `send()` function.
- Similar to Generators, the processing continues until a `yeild` statement is encountered.
##### Objects & Classes
- All values used in Python are objects - which consist of data and methods that perform various kind of operations
  involving that data.
- To list the available methods on an object we can `dir()` function on that object.
- `class` keyword is used to define new user define data types of objects. Example:
  `class A(object):` - the paranthesis are used to specify the inheritance. `object` is the root class for all Python types.
- `self` is a keyword used to represent the object that is being accessed. (like `this` in C++)
- Methods in a class are defined/declared using `def` keyword. And first argument of every method is `self` the object
  itself.
- Methods with leading and trailing '\_\_' are special methods like `\_\_init\_\_` which is used to initialize the object.
- There are different kinds of methods like static methods etc., we define such methods using something called decorators.
  ex: `@staticmethod`
##### Exceptions
- If an error occurs in your program, an exception is raised and the program is terminated with a trace-back message.
- Instead of terminating a program when an exception occurs, you can catch that and handle it using `try:` and `except:`
  blocks.
- To create an exception, we use `raise` statement.
##### Modules
- Breaking a program/project into several files to increase readability and maintainability is a general practice.
- Python allows to define all the definitions in one file and use them as module by using `import` statement in other
  files.
- `import` statement is like `namespace` in C++. This will create a new namespace and to access the contents of the module
  we will place the module name before the content that we are accessing. Example
  ```
  import div;
  q,r = div.divide(a,b);
  ```
- We can import a module as a different name using the `as` keyword like `import something as someotherthing;`.
- We can load specific things from a module using `from` and `import` statemnts like this:
  `from <something> import <something>`

### Some More Introduction
##### Line Structure and Indentation
- Statement terminator is a new line. Long lines can span multiple lines using line continuation character(\).
- Strict indentation is used to denoted blocks of code like function bodies, if-else statement, loops etc.,
- If the block is only of single line, we can place them in a single line without line continuation character.
- To denote empty block we use `pass` statement.
- We can place more than on statement in a single line using ';'
- `#` is used to declare comments
##### Identifiers and Keywords
- Identifier is a name used to identify functions, variables, methods, classes etc.,. Identifiers must always start with
  a non-numeric character and can contain letters, numbers, and '\_'.
- Python is a case-sensitive language.
- Reserved words are:
  ```
  and as assert break class continue def del elif else except exec finally for from global if import in is lambda nolocal
  not or pass print raise return try while withe yeild
  ```
- Identifiers startin and ending with '\_\_' have special meaning.
##### Numeric Literals
- Four types:
  1) Booleans
  2) Integers
  3) Floating point numbers
  4) Complex number
##### Strings
- Are used to specify a sequence of characters by enclosing them in single or double or triple quotes.
- There is a strict requirement to start and end the string with same type of quote.
- Triple quoted string can span over multiple line whereas single and double quoted strings are not allowed to.
- Escape sequences are used along with backslash '\' characeter.
- Python2 treats strings as byte oriented character, so it doesn't represent international characters and Unicode.
  To interpret a string as a unicode the string must be prefixed with a 'u' like `u"Jalape\u00f1o"`.
##### Containers
- Values enlcosed in [...] lists, (...) tuples, {...} dictonaries are a collection of objects.
##### Documentation Strings
- We can define the documentation of a module, class or a function by writing a string as the first statement of the
  respective code like:
  ```
  def fact(n):
      ''' This function is to calculate the factorial of a integer''' # this works are a documentation for the function
      if n < 1:
          return 1;
      else:
          return n * fact(n-1);
  ```
### Types and Objects 
- Everything in Python is an object.
- An object has an identity(a memory address basically), a type(also known as its class), a value.
- An object is also some times referred as an *instanc* of a particular class.
- If the object's value can be modified it is called *mutable* and if it can't be modified it is called *immutable*.
- An object is characterized by methods and attributes. Attributes are values associated with object, methods are
  functions that perform some sore of operation on the attributes.
##### Object Identity and Type
- `id()` returns identity of the object as an integer. `is` operator can be used to compare identity of 2 objects.
- `type()` returns the type of an object. Type comparision also can be done `is` operator.
- `isinstance(object,type)` checks whether the given object is of a given type.
##### Reference Counting and Garbage Collection
- All objects in Python are reference counted. Reference count is incremented each time it is assigned to a new name, or
  added to a container.
- We can get the reference count of an object using `sys.getregcount()`.
- When an object reference count becomes zero, it is garbage collected. In some specific cases a circular dependency may
  exist for an object, in such cases Python intepreter uses a cycle detector to detect objects in circulare dependency 
  and are not in use and garbage collect them.
- We can explicitly destroy the object using `del` statement.
- Each time an object is destroyed, the objects reference count is decreased to zero and memory is freed.
##### Reference and Copies
- `a=b` has different output based on the type of a and b.
- If they are immutable objects such as strings and numbers, a copy is created.
- If they are mutable objects, they are not copied, a new name is mapped to the existing memory location.
- The later one may have some side effects, if a and b are mutable and they are assigned using `a=b;`, and if a change
  done to a will effect b also.
- There are 2 types of copies - shallow copy and deep copy.
- A shallow copy creates a new object but populates it with references to items in original object.
- A deep copy creates a new object and recursively copies all the items in the original object.
- No buit-in function to deep copy, but we can use `copy.deepcopy()`.
##### First Class Objects
- In Python all objects are *first-class*, that means all the objects that are named have equal status.
- It also means that objects that are named can be treated as data.
- example:
  ```
  items = {};
  item["func"] = abs; # abs() function
  item["mod"] = math;  # math module
  ```
- Now we can use the following statement to calculate the absolute value of a number.
  `item["func"](-45)`
- This allows us to write a compact and flexible code in python.
##### Built-in Types
- Built-in types are as follows
###### None Type
- The 'None' type denotes the null object, that is object with no value.
- `None` has not attributes and evaluates to `False` in case of boolean expressions.
###### Numeric Types
- There are five numeric types Booleans, integers, long integers, floating point numbers, complex numbers.
- Except for complex numbers all others are signed. All the numeric types are immutable.
- Booleans are represented using two value `True` mapped to 1 and `False` mapped tp 0.
###### Sequence Types
- Ordered set of objects indexed using non-negative integers. These include lists, strings, tuples.
- Strings -> sequence of characters, lists, tuples -> sequences of arbitrary Python objects.
- Strings and tuples are immutable, lists allow insertion, deletion and subtitutio of elements.
- All sequences support iteration.
  ```
  Operations and methods common to all sequences
  - s[i] ------------------------ Returns element i of the sequence
  - s[i:j] ---------------------- Returns a slice of the sequence
  - s[i:j:stride] --------------- Returns an extended slice
  - len(s) ---------------------- Number of elements in s
  - min(s) ---------------------- Minimum value in s
  - max(s) ---------------------- Maximum value in s
  - sum(s[, initial]) ----------- Sum of items in s
  - all(s) ---------------------- Checks whether all the items in s are True
  - any(s) ---------------------- Checks whether any of the items in s is False

  Operations Applicable to Mutable sequences
  - s[i] = v -------------------- Item assignment
  - s[i:j] = t ------------------ slice assignment
  - s[i:j:stride] = t ----------- Extended slice assignment
  - del s[i] -------------------- Item deletion
  - del s[i:j] ------------------ Slice deletion
  - del s[i:j:stride] ----------- Extended slice deletion
  ```
###### Lists
```
- list(s) ----------------------- Converts s into list, if s is already list,
				  a new list which is shallow copy of s is constructed
- s.append(x) ------------------- Append a new element x to end of s
- s.extend(x) ------------------- Append a new list t to end of s
- s.count(x) -------------------- Counts the occurances of x in s
- s.index(x[,start[,stop]]) ----- Returns the smallest i where s[i]==x, optional start and stop indicates the
				  starting and ending position where to search
- s.insert(i,x) ----------------- inserts x at index i
- s.pop([i]) -------------------- returns the element i and removes it from the list. If i is ommitted, the last element is returned
- s. remove(x) ------------------ Searches for x and removes it from s
- s.reverse() ------------------- Reverses the items of s in place
- s.sort([key[,reverse]]) ------- Sorts items of s in place. *key* is the function. *reverse* is flag that sorts the list in reverse
                                  order. 
```
###### Strings
- 
