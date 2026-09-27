# Payroll Program

A console application that calculates what different kinds of employee earn. I wrote
it in 2021 as a university project while learning Java, mainly as an exercise in
inheritance and abstract classes, and it is here as a record of that work rather than
as an example of how I write code today.

## What it does

You enter how many employees you want to record, then for each one you choose a type
and enter the details. The program prints the pay for every employee and a summary of
which type each one was.

The four types are:

- **Salaried**: earns a fixed weekly salary.
- **Hourly**: earns wage times hours, with extra pay for anything above 40 hours.
- **Commission**: earns a percentage of gross sales.
- **Base plus commission**: earns commission on top of a base salary, with the base
  salary raised by ten per cent.

## How it is built

An abstract `employee` class holds the name and social security number and declares
an abstract `earning()` method. Each of the four types extends it and implements
`earning()` in its own way, and `basepluscommissionemployee` extends
`commissionemployee` rather than the abstract class directly, so it inherits the
commission calculation and adds the base salary on top. That two-level hierarchy was
the point of the exercise.

Plain Java, no external libraries. The project was created in NetBeans, so it builds
with Ant through the included `build.xml`.

## Running it

Open the project in NetBeans and run it, or from the command line:

```
cd payrollexample
ant run
```

## What I would change today

There are three real bugs in here that I would not write now. The overtime
calculation pays the full hours at the normal rate and then adds the overtime hours
again at time and a half, instead of paying 40 hours normally and the rest at the
higher rate. An employee who works exactly 40 hours falls through both branches of
the condition and earns nothing. And `basepluscommissionemployee` passes gross sales
and commission rate to its parent in the wrong order, so the printed output has the
two values swapped, even though the earnings happen to come out right because the two
are multiplied together.

Beyond that: the class names are lowercase, the printing method is called `tostring`
instead of overriding `toString`, the results are collected as formatted strings
rather than as objects, and there are no tests. If I rebuilt it now I would fix the
overtime rule and cover it with tests first, since that is the part where a mistake
actually costs someone money.
