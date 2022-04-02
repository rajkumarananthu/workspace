#include "solution.h"
#include "terrain.h"

#include <iostream>
#include <algorithm>

void SolutionEntry::print() const {
    for (auto i : path) {
        i->print();
    }
    std::cout << "\n";
}

int SolutionEntry::sum() const {
    int result = 0;
    for (auto i : path) {
        result += i->energy();
    }
    return result;
}

int SolutionEntry::size() const {
    return path.size();
}

std::shared_ptr<TerrainEntry> SolutionEntry::last() {
    return path.back();
}

bool SolutionEntry::exists(std::shared_ptr<TerrainEntry> te) const {
    for (auto i : path) {
        if (*i == *te) return true;
    }
    return false;
}

Solution *Solution::s = nullptr;

// consider<Pos>: Pos = Left, Right, Up, Down
// if after considering the respective Pos entry,
// if it is a solution, save the solution, backtrack to find other solutions
void Solution::considerLeft(SolutionEntry& e) {
    std::shared_ptr<TerrainEntry> left = terrain->getLeft(e.last());
    if (!left) return; // there is no left
    if (!canInclude(e, left)) return;
    if (isASolution(e, left)) { save(e, left); return; }
    DEBUG(left, "considering: ");
    e.push(left); // push the left entry to solution
    consider(e);
    e.pop(); // pop the left entry pushed above
    DEBUG(left, "removing: ");
}

void Solution::considerRight(SolutionEntry& e) {
    std::shared_ptr<TerrainEntry> right = terrain->getRight(e.last());
    if (!right) return; // there is no right
    if (!canInclude(e, right)) return;
    if (isASolution(e, right)) { save(e, right); return; }
    DEBUG(right, "considering: ");
    e.push(right); // push the right entry to solution
    consider(e);
    e.pop(); // pop the right entry pushed above
    DEBUG(right, "removing: ");
}

void Solution::considerUp(SolutionEntry& e) {
    std::shared_ptr<TerrainEntry> up = terrain->getUp(e.last());
    if (!up) return; // there is no up
    if (!canInclude(e, up)) return;
    if (isASolution(e, up)) { save(e, up); return; }
    DEBUG(up, "considering: ");
    e.push(up); // push the up entry to solution
    consider(e);
    e.pop(); // pop the up entry pushed above
    DEBUG(up, "removing: ");
}

void Solution::considerDown(SolutionEntry& e) {
    std::shared_ptr<TerrainEntry> down = terrain->getDown(e.last());
    if (!down) return; // there is no down
    if (!canInclude(e, down)) return;
    if (isASolution(e, down)) { save(e, down); return; }
    DEBUG(down, "considering: ");
    e.push(down); // push the down entry to solution
    consider(e);
    e.pop(); // pop the down entry pushed above
    DEBUG(down, "removing: ");
}

void Solution::consider(SolutionEntry& e) {
    considerLeft(e);
    considerRight(e);
    considerUp(e);
    considerDown(e);
}

void Solution::start() {
    SolutionEntry entry;
    entry.push(terrain->getRobotEntry());
    consider(entry);
    entry.pop();
}

void Solution::printSolutions() {
    for(auto i : solutions) {
        i->print();
    }
}

void Solution::printSolution() {
    std::shared_ptr<SolutionEntry> bestSolution = *(solutions.begin());
    int s = bestSolution->size();
    for (auto i : solutions) {
        if (i->size() < s) {
            s = i->size();
            bestSolution = i;
        }
    }
    bestSolution->print();
}
