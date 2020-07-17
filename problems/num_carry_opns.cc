/*Description: a pair of nums are taken and we calculate the number of carry operations needed to add those two numbers. we store the given numbers as a pair in vector container*/


#include<iostream>
#include<string>
#include<iterator>
#include<vector>
#include<algorithm>
#include<map>

using namespace std;

int main()
{
	int f,s,n;
	cin>>n;
	vector< pair<int,int> > nums;
	vector< pair<int,int> > :: iterator itr;
	for(int i=0;i<n;i++)
	{
		pair<int,int> p;
		cin>>f>>s;
		p.first = f;
		p.second = s;
		nums.push_back(p);
	}
	int carries[n],i=0;
	for(itr = nums.begin();itr!=nums.end();++itr)
	{
		carries[i] = 0;	
		int a,b;
		a = itr->first;
		b = itr->second;
		while(a!=0 && b!=0)
		{
			if((a%10) + (b%10) >= 10)
				carries[i]++;
			a = a /10;
			b = b/10;
		}
		i++;
	}
	for(int j=0;j<n;j++)
	{	
		if(carries[j] == 0)
			cout<<"No carry operation\n";
		else if (carries[j] == 1)
			cout<<"1 carry ooperation\n";
		else
			cout<<carries[j]<<" carry operations\n";
	}
	return 0;
}
