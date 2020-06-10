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
- 
#### ArgumentParser.add\_argument() method
- `add_argument(name or flags...[,action][,nargs][,const][,default][,type][,choice][,required][,help][,metavar][,dest])`
