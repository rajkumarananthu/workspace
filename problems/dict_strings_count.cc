/*Description: Takes t number of strings and sort them in ascending order and count the number of occurences of each duplicate string*/


#include<iostream>
#include<string>
#include<iterator>
#include<vector>
#include<algorithm>
#include<map>

using namespace std;

int main()
{
	int t;	
	vector<string>	stringarray;
	map<string,int> result;
	map<string,int> :: iterator itr;
	cin>>t;
	for(int i=0;i<t;i++)
	{
		string str; 
		cin>>str;
		stringarray.push_back(str);
	}
	sort(stringarray.begin(),stringarray.end());
	string str = stringarray[0];
	int count = 0;	
	for(int i=0;i<t;i++)
	{
		if(str == stringarray[i])
			count++;
		else
		{
			result.insert(pair<string,int>(str,count));
			str = stringarray[i];
			count = 1;
		}		
	}
	result.insert(pair<string,int>(str,count));
	for(itr = result.begin();itr!=result.end();++itr)
	{
		cout<<itr->first<<" "<<itr->second<<"\n";
	}
	return 0;
}
