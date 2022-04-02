#ifndef _TERRAIN_H
#define _TERRAIN_H
#include<iostream>
#include<vector>
#include <memory>
#include <iostream>

// represent co-ordinates of a point in 2D graph
typedef struct _loc {
    int x;
    int y;
    bool operator==(const _loc& rhs) const {
        return ((x == rhs.x) && (y == rhs.y));
    }
}Loc;

// represent each cell in a 2D graph
class TerrainEntry {
    private:
        Loc location;
        int joules;
        bool robot;
        bool destination;
    public:
        TerrainEntry(int x, int y, char j) {
            if (j == 'R') {
                robot = true;
                destination = false;
                joules = 0;
            } else if (j == 'D') {
                robot = false;
                destination = true;
                joules = 0;
            } else {
                robot = false;
                destination = false;
                joules = j - '0';
            }
            location.x = x;
            location.y = y;
        }
        ~TerrainEntry() {}
        int energy() const { return joules; }
        int getX() const { return location.x; }
        int getY() const { return location.y; }
        void print() const { std::cout << "<(" << location.x << ", " << location.y << ")," << joules << ">"; }
        bool isRobot() const { return robot; }
        bool isDestination() const { return destination; }
        bool operator==(const TerrainEntry& te) const { return ((location == te.location) && (joules == te.joules)); }
};

// represent the whole terrain
class Terrain {
    private:
        std::vector<std::vector<std::shared_ptr<TerrainEntry>>> T;
        std::shared_ptr<TerrainEntry> Robot;
        std::shared_ptr<TerrainEntry> Destination;
    public:
        Terrain(std::string ip_file);
        ~Terrain() {
            for (auto i : T) {
                i.clear();
            }
        }
        std::shared_ptr<TerrainEntry> getLeft(std::shared_ptr<TerrainEntry> t) const;
        std::shared_ptr<TerrainEntry> getRight(std::shared_ptr<TerrainEntry> t) const;
        std::shared_ptr<TerrainEntry> getUp(std::shared_ptr<TerrainEntry> t) const;
        std::shared_ptr<TerrainEntry> getDown(std::shared_ptr<TerrainEntry> t) const;
        std::shared_ptr<TerrainEntry> getRobotEntry() const;
        std::shared_ptr<TerrainEntry> getDestinationEntry() const;
        bool isAdjToDestination(std::shared_ptr<TerrainEntry> te) const;
        void print() const;
};

#endif
