/*Descrioption:  An interesting num is such a number, which is divisible by a number P and each digit of the number must be in a defined set of digits Z.
The program outputs the number of interesting numbers in a defined interval<L,R> for a given P and Z*/


#include<iostream>
#include<set>
#include<iterator>

using namespace std;

bool intrstngNumber(long P,long num,set<long> Z);
bool any_equals(long num,set<long> Z);

int main()
{
	long P,L,R,z,a,int_num_count = 0;
	set<long> Z;
	
	cin>>P>>L>>R>>z;
	for ( long i =0 ;i<z;i++)
	{
		cin>>a;
		Z.insert(a);
	}
	for(long i = L ; i <= R ; i++)
	{
		if(intrstngNumber(P,i,Z))
			int_num_count++ ;
	}
	cout<<int_num_count;
	return 0;
}

bool intrstngNumber(long P,long num,set<long> Z)
{
	if(num%P == 0)
	{
		long k = num;
		while(k!=0)
		{
			int div = k%10;
			if(any_equals(div,Z))
				return true;
			k = k/10;
		}
		return false;
	}
	else
		return false;
}

bool any_equals(long num,set<long> Z)
{	
	set<long> :: iterator itr;
	for(itr = Z.begin();itr!=Z.end();++itr)
	{
		if(*itr == num)
			return true;
	}
	return false;
	
}
