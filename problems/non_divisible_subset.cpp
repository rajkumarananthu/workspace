#include <bits/stdc++.h>
#include <cmath>

bool isNonDivisibleSet(int k, std::vector<int> s) {
    int count = s.size();
    for (int i = 0; i < count; ++i) {
        for (int j = i + 1; j < count; ++j) {
            if ((s[i] + s[j]) % k == 0) return false;
        }
    }
    return true;
}

int nonDivisibleSubset(int k, vector<int> s) {
    int count = s.size();
    long permutations = std::pow(2, count);
    // checking for actual set
    if (isNonDivisibleSet(k,s)) return s.size();
    // checking for all proper subsets
    int max_size = 0;
    for (int i = permutations - 1; i > 0; --i) {
        std::vector<int> s_inst;
        for (int j = 0; j < count; ++j) {
            if (i & (1 << j)) {
                s_inst.push_back(s[j]);
            }
        }
        if (isNonDivisibleSet(k, s_inst))  {
            if (max_size < s_inst.size()) max_size = s_inst.size();
        }
    }

    return max_size;
}


