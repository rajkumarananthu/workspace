#ifndef SHADOW_TASK_HPP
#define SHADOW_TASK_HPP

enum eTaskType {
    ShoppinList = 1,
    Reminder    = 2,
    BlockCalender = 3,
    TakeNotes   = 4,
    TodoList    = 5
};

class cTask {
    public:
    cTask();
    void run();
};
#endif
