# Learning Python

### Introduction
###### Genral
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
- Writing complex code may some time lead to long line of code, in such case to increase readability we can use '\' to 
  tell the interpreter that the statement continues in next line. In such cases the normal indentation rules doesn't
  apply to the statments.
###### Conditionals
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
###### Strings
- Strings in Python are defined/constructed using single(''), double(") or triple(''') quotes. Speciality about triple
  quotes is that, they are useful when the string literal span over multiple lines.
- String can be accessed using index operator as `s[i]`, we also have slicing operator `s[i:j]`, this gets the substring
  of s from i to j (including i and excluding j). If i is omitted it indicates start of string, if j is omitted it
  represents end of string.
- Strings are concatanated using `+`
- Type casting operator are like `int()` `float()`.
- Non-string values can be converted to strings using `str()`, `repr()`, and `format()`.
###### Lists
- Lists are a sequence of arbitrary object, we can create a list using square brackets '[' and ']'.
  ` names = ['one', 'two', 'three'];`
- We can append more items to list using `append()` method. Otherwise we can use `insert()` method to insert an item at
  specified position.
- We can access the list items using indexing operator `names[i]`, similarly we can use slicing of the list `names[i:j]`
- `+` is used to conctatenate 2 lists.
- Lists can contain any type of object, it can be another list also.
- Lists are similar to arrays/vectors of C/C++, except that arrays/vectors are homogeneous data holders (same data).

