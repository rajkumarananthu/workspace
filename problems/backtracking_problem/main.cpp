#include "solution.h"
#include "terrain.h"

#include <cstdlib>
#include <string>
#include <cassert>
#include <tuple>

std::tuple<std::string, int> parseOpts(int argc, char **argv) {
    assert(argc == 3); // 0 is the executable, 1 is file name, 2 is initial energy
    return std::make_tuple(std::string(argv[1]), atoi(argv[2]));
}

int main(int argc, char **argv) {
    std::string filename;
    int energyLimit;
    std::tie(filename, energyLimit) = parseOpts(argc, argv);
    std::shared_ptr<const Terrain> t = std::make_shared<const Terrain>(filename);
    DEBUG(t, "Terrain: ");
    Solution *solution = Solution::getSolution(t, energyLimit);
    solution->start();
    solution->printSolution();

    // delete the solution to avoid memory leaks
    Solution::deleteSolution();
    return 0;
}
