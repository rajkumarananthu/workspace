#ifndef SHADOW_LIST_HPP
#define SHADOW_LIST_HPP

#include <vector>
#include <string>

template <typename ListType>
class List {
    private:
    std::vector<ListType&> list;
    public:
    List() {}
    void add(ListType&) {}
};

class ShoppingListEntry {
    private:
    std::string mItemName;
    unsigned int mCount;
    public:
    ShoppingListEntry(std::string itemName, unsigned int count);
};

class TodoListEntry {
    private:
    std::string mTaskName;
    bool mIsDone;
    public:
    TodoListEntry(std::string taskName, bool done);
};

#endif
