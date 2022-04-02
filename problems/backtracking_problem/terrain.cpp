#include "terrain.h"

#include <fstream>

Terrain::Terrain(std::string ip_file) {
    std::ifstream input;
    input.open(ip_file);
    if (!input) return; // not handling the error check because assuming the file will exist
    char joule;
    char delim = ',';
    int i = 0;
    int j = 0;

    while(!input.eof()) {
        std::vector<std::shared_ptr<TerrainEntry>> row;
        j = 0;
        do {
            input >> joule;
            input >> delim;
            if (delim != ',') { input.unget(); delim = '\n'; }
            std::shared_ptr<TerrainEntry> t = std::make_shared<TerrainEntry>(j, i, joule);
            row.push_back(t);
            if (t->isRobot()) { Robot = t; }
            if (t->isDestination()) { Destination = t;}
            j++;
        } while((delim != '\n') && (!input.eof()));
        i++;
        T.push_back(row);
        row.clear();
    }

    input.close();
}

std::shared_ptr<TerrainEntry> Terrain::getLeft(std::shared_ptr<TerrainEntry> t) const {
    if ((t->getX() - 1) >= 0) {
        return T[t->getY()][t->getX() - 1];
    } 
    return nullptr;
}

std::shared_ptr<TerrainEntry> Terrain::getRight(std::shared_ptr<TerrainEntry> t) const {
    if ((t->getX() + 1) <= (T[0].size() - 1)) {
        return T[t->getY()][t->getX() + 1];
    } 
    return nullptr;
}

std::shared_ptr<TerrainEntry> Terrain::getUp(std::shared_ptr<TerrainEntry> t) const {
    if ((t->getY() - 1) >= 0) {
        return T[t->getY() - 1][t->getX()];
    } 
    return nullptr;
}

std::shared_ptr<TerrainEntry> Terrain::getDown(std::shared_ptr<TerrainEntry> t) const {
    if ((t->getY() + 1) <= (T[0].size() - 1)) {
        return T[t->getY() + 1][t->getX()];
    } 
    return nullptr;
}
std::shared_ptr<TerrainEntry> Terrain::getRobotEntry() const {
    return Robot;
}
std::shared_ptr<TerrainEntry> Terrain::getDestinationEntry() const {
    return Destination;
}
bool Terrain::isAdjToDestination(std::shared_ptr<TerrainEntry> t) const {
    std::shared_ptr<TerrainEntry> temp = getLeft(t);
    if (temp && temp->isDestination()) return true;
    temp = getRight(t);
    if (temp && temp->isDestination()) return true;
    temp = getUp(t);
    if (temp && temp->isDestination()) return true;
    temp = getDown(t);
    if (temp && temp->isDestination()) return true;

    return false;
}
void Terrain::print() const {
    for (auto i : T) {
        for (auto j : i) {
            j->print();
            std::cout << " ";
        }
        std::cout << "\n";
    }
}
