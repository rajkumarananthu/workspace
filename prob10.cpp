// Problem description: Tell the rank
// We use Dense ranking system - if 2 users has equal scores, both of them are assigned same rank
// input: 2 arrays -> 1st = scores of indvidual players who participated in game, 2nd = scores of the user 'raj' for m games
// Output: for each game, we need to determine the rank of the user 'raj'
// Assumption: The scores of individual players are given in descending order


#include<iostream>

int main () {
    // getting/scanning the input
    int num_of_players;
    std::cin >> num_of_players;
    int scores[num_of_players];
    for (auto i = 0; i < num_of_players; ++i) {
        std::cin >> scores[i];
    }
    int m;
    std::cin >> m;
    int raj_scores[m];
    for (auto i = 0; i < m; ++i) {
        std::cin >> raj_scores[i];
    }

    // determining the ranks of individual users
    int ranks[num_of_players];
    ranks[0] = 1; // as per the assumption first user is always rank 1
    for (auto i = 1; i < num_of_players; ++i) {
        if (scores[i] == scores[i-1]) // if same scores same rank
            ranks[i] = ranks [i-1];
        else // else scores[i] < scores[i-1], the case scores[i] > scores[i-1] is not possible as per the assumption
            ranks[i] = ranks[i-1] + 1;
    }

    // determining the ranks of 'raj'
    int raj_ranks[m]; // storing the ranks temporarily, not necessary
    for (auto i = 0; i < m; ++i) {
        if ((raj_scores[i] > scores[0]) || (raj_scores[i] == scores[0]))  {
            raj_ranks[i] = 1;
            std::cout << raj_ranks[i] << "\n";
            continue;
        }
        for (auto j = 0; j < num_of_players; ++j) {
            if (raj_scores[i] < scores[j]) {
                if (j == num_of_players - 1) {
                    raj_ranks[i] = ranks[j] + 1;
                    break;
                }
                continue;
            } else {
                raj_ranks[i] = ranks[j];
                break;
            }
        }
        std::cout << raj_ranks[i] << "\n";
    }
}


