#ifndef _SOLUTION_H
#define _SOLUTION_H
#include <list>
#include <memory>
#include <iostream>

#include "terrain.h"
#if 0
#define DEBUG(node, string) \
std::cout << string; \
node->print(); \
std::cout << "\n";
#else
#define DEBUG(node, string)
#endif
class SolutionEntry {
    private:
        std::list<std::shared_ptr<TerrainEntry>> path;
    public:
        SolutionEntry() {}
        SolutionEntry(const SolutionEntry& e) : path(e.path.begin(), e.path.end()) {}
        ~SolutionEntry() { path.clear(); }
        void push(std::shared_ptr<TerrainEntry> e) { path.push_back(e); }
        void pop() { path.pop_back(); }
        void clear() { path.clear(); }
        void print() const;
        int sum() const;
        int size() const;
        std::shared_ptr<TerrainEntry> last();
        bool exists(std::shared_ptr<TerrainEntry> te) const;
};

class Solution {
    private:
        std::list<std::shared_ptr<SolutionEntry>> solutions;
        static Solution *s;
        std::shared_ptr<const Terrain> terrain;
        int energyLimit;
        Solution(std::shared_ptr<const Terrain> t, int el) : terrain(t), energyLimit(el) {}
        ~Solution() { solutions.clear(); }
        void save(const SolutionEntry& e, std::shared_ptr<TerrainEntry> te) {
            std::shared_ptr<SolutionEntry> new_entry = std::make_shared<SolutionEntry>(e);
            new_entry->push(te);
            new_entry->push(terrain->getDestinationEntry());
            solutions.push_back(new_entry);
        }
        bool isASolution(const SolutionEntry& e, std::shared_ptr<TerrainEntry> te) {
            // within energy limit and reached the destination => solution
            if ((e.sum() + te->energy() <= energyLimit) && (terrain->isAdjToDestination(te))) { return true; }
            return false;
        }
        bool canInclude(const SolutionEntry& e, std::shared_ptr<TerrainEntry> te) {
            return ((e.sum() + te->energy() <= energyLimit) && (!e.exists(te)));
        }
        void considerLeft(SolutionEntry& e);
        void considerRight(SolutionEntry& e);
        void considerUp(SolutionEntry& e);
        void considerDown(SolutionEntry& e);
        void consider(SolutionEntry& e);
    public:
        static Solution* getSolution(std::shared_ptr<const Terrain> t, int energyLimit) {
            if (!s) {
                s = new Solution(t, energyLimit);
            }
            return s;
        }
        static void deleteSolution() {
            if (s) {
                delete s;
                s = nullptr;
            }
        }
        void start();
        void printSolutions(); // print all the solutions calculated
        void printSolution(); // prints the best solution
};

#endif
