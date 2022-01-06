# workspace
problems (logical and mathematical) solved

### prob1 description:
In this for a given array of elements we calculate
sum = sigma ((arr[i] + arr[j] + arr[k])/(arr[i] * arr[j] * arr[k]))

where 0<= i < j < k <= n-1 and n is the size of the array

### prob2 desription:

takes a string and if the string is palindrome we print "yes" along with even or odd based on whether it is odd palindrome or even palindrome
and we print "no" if it is not palindrome

### prob3 description:

takes a list and sort the list using bubble sort in python

### prob4

implements des algorithm in python

### prob5

DUPLICATION - 
consider a binary strind s with an initial value "0". we expand s by performing the following steps:
1-create a string t where t[i] is compliment of s[i]
2-append t to s
3-repeat 1 and 2 until s length exceeds 1000

given q queries in the form of zero-based index,x,solve each query by printing the charecter at index x in s on a new line


### prob6

s_key is the original key with which a combination of key is selected from a list of keys[] to open the lock with the integer on it as l_key
merging is done as follows

s_key = s_key * key selected from list


if a key matching to l_key is obtained then the lock opens
each key is selected for one sec and selected key is merged with the original s_key until it gets matched  to l_key
we print no of secs taken to find the key to open the lock 
if not found we print -1


### prob7

inverse list:
There are many ways to order a list of integers from 
1 to n. For example, if n=3, the list could be : [312].

But there is a special way to create another list from the given list of integers. In this list, position of integer 
i is thei−th number in the given list. So following this rule, the given list will be written as: 
[231]. This list is called inverse list. Now there exists some list whose inverse list is identical. For example, inverse list of 
[123] is same as given list. Given a list of integers you have to determine whether the list is inverse or not.

### prob8
print a staircase of #
given a number(integer) n, print the stair case.
example for n =3
       #
      ##
     ###

### prob9
get the min max sum : given 'm' integers and an integer n we have to print the maximum sum of n integers from this set and minimum sum of n integers from this set. provided m >=n.

### [Non-divisible-subset](non_divisible_subset.cpp)
Given a set of distinct integers S, print the size of a maximal subset S' of S where the sum of any 2 numbers in S' is not evenly divisible by k.
Input: n-size of S, array values of S, k
