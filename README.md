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

### Problemes with Refelection
The usage of Java reflections in `GenericReflectionCompileSafeEnum` looks like a good idea in the first place, but in practice, it introduces many problems.
That's because of the reflection exceptions that could occur at runtime.

It is much easier to implement the switch-case method manually and write a simple test for this code. How such a test could look like could be found in `CompileSafeEnumTest` and in `GenericCompileSafeEnumTest`.
