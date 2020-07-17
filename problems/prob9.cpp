#include <iostream>
#include <vector>
#include <algorithm>

std::pair<long int, long int> minMax (std::vector<long int> &vecOfNumbers, long int &n) {
	long int minSum = 0, maxSum = 0;
	std::sort (vecOfNumbers.begin(), vecOfNumbers.end());
	if (n > vecOfNumbers.size()) {
		std::cerr <<"Invalid N value\n";
		return std::make_pair(0,0);
	}
	for (auto i = 0; i < n; ++i) {
		std::cout <<vecOfNumbers[i];
		minSum = minSum + vecOfNumbers[i]; 
	}
	size_t size = vecOfNumbers.size();
	for (auto i = 0; i <= n; ++i) {
		maxSum = maxSum + vecOfNumbers[size - i]; 
	}
	return std::make_pair(minSum, maxSum);
}

int main () {
	long int m,n;
	std::cout <<"Enter number of integers in the set:(M) ";
	std::cin >> m;
	std::cout <<"Enter number of integers from the set to calculate the sum:(N) ";
	std::cin >> n;
	std::vector <long int> vecOfNumbers;

	for (auto i = 0; i < m; ++i) {
		long int temp;
		std::cin >> temp;
		vecOfNumbers.push_back (temp);
	}
	std::pair<long int, long int> result = minMax (vecOfNumbers, n);
	std::cout <<"The result is : "<<result.first << " "<< result.second<<"\n";
}
