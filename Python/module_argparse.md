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

#### ArgumentParser.add\_argument() method
- `add_argument(name or flags...[,action][,nargs][,const][,default][,type][,choice][,required][,help][,metavar][,dest])`
