# Design Patterns - Code in C++

#### CLEAN CODE
No duplicate code, no magic numbers, no bloated code/classes.
Easier to read, Cheaper to maintain, well tested, well documented.

What is refactoring?
Refactoring is restructuring the existing code without changing the behaviour. This is to improve
the design. In short to achieve a clean code.

When to refactor?
Refactoring can be done in following situations:
- Rule Of Three:
    1. For the first time, get it done.
    2. Doing something similar for second time, try not to repeat it.
    3. Doing something similar for third time, go for REFACTORING.
- When adding a new feature.
- When fixing a bug.
- During a Code Review.

Checklist for Refactoring:
- The code should become cleaner.
- No new functionality should be added during refactoring.
- Existing test must pass after refactoring.

#### DESIGN PATTERNS
Design patterns are conceptual solutions to typical/common problems in a software design. These can
be used as a blueprint, and can be customized to fit your particular design.

Design patterns are generally classified into three types:
- Creational -> Object creation patterns. Factory, Abstract Factory, Builder, Prototype, Singleton.
- Structural -> Organizing different classes or objects. Adapter, Bridge, Composite, Decorator,
  Facade, FlyWeight, Proxy.
- Behavioural -> Common communication patterns. Chain Of Responsibility, Command, Iterator, Mediator,
  Memento, Observer, State, Strategy, Template Method, Visitor, Subscriber.

## Factory Pattern
- Creational Design Pattern. Also known as virtual constructor method.

## Singleton Pattern
## Observer Pattern
## Subscriber Pattern
