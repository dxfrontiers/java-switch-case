# Compile-time-safe-enum-switch-case statements in Java
An example that demonstrates how to create a compile-time safe switch case with enums in Java.

## About
While most modern programming languages like Scala with its Sealed Traits have some kind of improved Switch-Case-Statements to check if it matches all possibilities of an enum type. We as Java developers only know the problem of incomplete switch-case statements in our applications. Especially when we extend a Java enum in bigger applications, that is often used in multiple switch-case statements distributed over the whole application.
When we remove a value that is still used in a switch-case statement from such an enum, the compiler gives us an error. But that’s not the case for adding one. If we miss extending one single switch-case statement this could lead to strange problems at runtime.

This repository demonstrates a software pattern to replace enum switch-case statements. It gives us a compile-time validation that all enum values are covered in your switch-case replacements.

## The Code

`EnumDemoMain` contains an example code on how to use the different enums.

`NormalEnum` is a traditional Java enum used with a normal switch case statement to demonstrate the problem.

`CompileSafeEnum` is a Java enum with an inner class construct to achieve compile-time safety.

`GenericCompileSafeEnum` extends the inner class construct with Java generics.

`GenericReflectionCompileSafeEnum` replaces the manual implemented switch-method with Java-Reflections. 

### Problemes with the `GenericReflectionCompileSafeEnum`

The usage of Java reflections in `GenericReflectionCompileSafeEnum` looks like a good idea in the first place, but in practice, it introduces many problems.
1. There are exceptions that must be handled.
2. We still need a unit test to check if the method names match the enum names.
3. And more important, we have a major performance overhead.

The performance overhead is a show stopper for such a simple thing as a switch case.
Because of these problems I highly recommend the `CompileSafeEnum` and `GenericCompileSafeEnum` versions.


------
Do you have any questions or suggestions? Get in touch with us:

![digital frontiers](doc/img/logo_250x75.png)

:globe_with_meridians: [https://www.digitalfrontiers.de](https://www.digitalfrontiers.de) \
:email: info@digitalfrontiers.de \
Twitter [@dxfrontiers](https://twitter.com/dxfrontiers)