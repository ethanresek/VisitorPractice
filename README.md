# Visitor Pattern
Notes from _Design Patterns_ and _Head First Design Patterns_

## Applicability/Uses

- When a codebase contains many classes of objects with different interfaces, and
you want to apply the same operation on all objects regardless of their concrete classes.
- Many unrelated operations need to be performed on the objects without filling the classes
these operations.
- When classes defining objects rarely change, but you want to define new operations over the
structure. This is to avoid breaking the Open/Closed principle by modifying the interfaces 
after they have been made. This is good when the classes rarely change because if element
classes are changed, then all visitors must be updated.
- Centralize related operations so they are not scattered throughout object classes.
- Useful for stable object structures with many different behaviors being added over time.
- Visitor allows you to visit objects across a structure **regardless of object type** (unlike
the iterator pattern).
- Visitors accumulate state and allow for information to be accumulated across all the visited
objects.
- Can break encapsulation (should not be used to operate on sensitive data as that data will be
exposed)

## Implementation details

- Visitor depends on **double-dispatch**. This means that method calls are resolved based on
the runtime types of two objects, not just one. Consider the following code:

`
interface Visitor {
void visit(Circle c);
void visit(Square s);
}

interface Shape {
void accept(Visitor v);
}
`

`
class Circle implements Shape {
void accept(Visitor v) {
v.visit(this);
}
}
`

In the following case:

`
Shape shape = new Circle();
Visitor visitor = new AreaCalculator();
shape.accept(visitor);
`

shape.accept() uses Circle, the runtime type of Shape and Circle.accept() uses
AreaCalculator, the runtime type of Visitor.

- Three options for traversing the object structure: the object structure, the visitor, or a
separate iterator
  - Putting the traversal algo in the visitor will require duplicating the code in each concrete
  visitor implementation, but it will allow for complex traversals that depend on the results of
  the completed operations
- 