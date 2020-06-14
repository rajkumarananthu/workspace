# **argparse** module

- Recommended command-line argument parser
- Alternatives are `getopt()` anf `optparse`, but `optparse` is deprecated.

## Brief usage
```
import argparse # imports the argparse module

parser = argparse.ArgumentParse(); # creates the parser
args = parser.parse_args(); # method to parse the sys.argv args
```

- Arguments are added using `add\_argument()` method.
- Arguments are parsed using `parse_args()` method.

##### Positional Arguments
- `parser.add_argument("one")`

##### Optional arguments
- `parser.add_argument("--foo")`

##### Short Options
- `parser.add_argument("-f", "--foo")`

##### Conflicting Options
```
group = parser.add_mutually_exclusive_group();
group.add_argument("-v", "--verbose");
group.add_argument("-q", "--quiet");
```

## API Information

#### ArgumentParser object
- `argparse.ArgumentParser(prog=None,usage=None,description=None, epilog = None, parents=[],
                           formatter_class=argparse.HelpFormatter, prefix_chars='-', fromfile_prefix_chars=None,
                           argument_default = None, conflict_handler=''error', add_help=True, allow_abbrev=True)`
###### prog
- Name of the program, default is 'sys.argv[0]'. This determine how to display the program name in help messages
- To change the default value you can pass other program name through `prog` argument to ArgumentParser.
- The program name can be accessed and available to help messages using `%(prog)s`.

###### usage
- Default usage message is constructed from the arguments it contains, we can override the default using the `usage`
  keyword argument.

###### description
- This argument gives a brief description what does the the program/script works.
- This description is printed in between the command line usage and the help for various options in the help message.
- By default is is line-wrapped. We can change the format of description using formatter\_class argumen to parser.

###### epilog
- This is used to display additional description after the help for various options.
- By default line-wrapped. We can change the format using formatter\_class argument.

###### parents
- Used to share argument between different parser objects, instead of repeating the definitions.
- A list of parent parser objects can be passed.
- The current parser collects all positional and optional actions form them and adds them to the current one.

###### fromatter\_class
- This allows/helps in formatting the description of the program.
- There are four allowed formatter\_classes
  1) - argparse.RawDescriptionHelpFormatter   -->  indicates that description and epilog are already correctly
                                                   formatted and should not be line-wrapped
  2) - argparse.RawTextHelpFormatter          -->  maintains all whitespaces for all sorts of help text, but replaces mutiple
                              			   new lines with a single one. If you want to preserve them, give a space b/w them.
  3) - argparse.ArgumentDefaultsHelpFormatter -->  automatically adds information about the default value of the arguments in help messages.
  4) - argparse.MetavarTypeHelpFormatter      -->  uses the `type` as the display name for arguments values.

###### prefix\_chars
- The default prefix is '-', but to support additional prefix characters we specify them using prefix\_chars.

###### fromfile\_prefix\_chars
- 

###### argument\_default
-

###### allow\_abbrev
- By defalut the ArgumentParser recognizes abbreviations of the long options( specified with --) through `add\_argument()`
  method.
- To disable this we can pass False to allow\_abbrev argument of ArgumentParser.

###### conflict\_handler
- ArgumentParser doen't allow two action to same option string. In such cases, an exception is thrown by ArgumentParser.
- But we may want to override the older argument with the newer one, in such cases we may need to pass conflic\_handler
  'resolve'
- A note to keep in mind, all the option strings must be overriden, in order for the ArgumentParser to remove an action.

###### add\_help
- By default the parser adds the option `-h/--help` to the program.
- We can disable this by passing `False` through add\_help argument to ArgumentParser.
- If the prefix\_chars are specified and there is no '-' in them, the first prefix\_char is used in instead of '-'.

#### ArgumentParser.add\_argument() method
- `add_argument(name or flags...[,action][,nargs][,const][,default][,type][,choice][,required][,help][,metavar][,dest])`

###### name or flags
- Optional arguments can be specified with series of flags and positional arguments are specified with names.
- Optional arguments are prefixed with '-' character (long options are with '--').
- Positional arguments have no prefix, they are just names.

###### action
- This is to tie up an argument with an action. The supplied action are
- `store` - just store the argument value
- `store_const` - Stores the value specified by const key word argument.
- `store_true` and `store_false` - store true or false, if specified just like `store_const`
- `append` - stores a list and appends each argument to the value list. Allows an option to be specified multiple times.
- `append_const` - stores a list and appends the value specified by const keyword argument.
- `count` - counts the number of time a keyword argument occurs
- `help` - help message to be printed for all the options and exits. By default a help action is automatically added.
- `version` - calls and prints the version information and exits.
- `extend` - stores a list and extend each argument value to the list
###### nargs
- Argument Parser objects usually associate one command line option with one action
