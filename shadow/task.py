import enum;

# TaskType enum - enumerates all types of tasks that Shadow can perform
class TaskType(enum.Enum):
    ShoppingList  = 1;
    Reminder      = 2;
    BlockCalender = 3;
    TakeNotes     = 4;
    TodoList      = 5;


# Task class - captures the tasks and their types which Shadow can perform
class Task:
    def __init__(self):
        pass;
    def run(self):
        pass;

