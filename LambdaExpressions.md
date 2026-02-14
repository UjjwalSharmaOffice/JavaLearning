# Lambda Expressions
Implemented from java 1.8 onwards

## Main Objective

- to bring functional programming features in java since its already a OOP
- To improve the code optimisation/to have the concise code


# What is lambda Expressions?
it is an anonymous function - doesnt have the name, return type, no return value.

normal method

```java
public void m1(){
    System.out.println("Welcome");
}

//how we can write this with the help of lambda expressions, remove method name, access modifer and the return type

()->{
    sout("Welcome");
        }
        
//        or
()-> sout("Welcome");


//no need for curly braises in the single line functions
```

```java
public void m2(int a, int b){
    System.out.println(a+b);
}
```

```java
(int a, int b)->{ // no need to specify the type of the variable as well
    System.out.println(a+b)
        }
        
//        or
```

```java
(a,b)->sout(a+b);
```
### When we need to return some value

```java
public void m3 (int a){
    return a*a;
    
}


//in lambda if you want to avoid the return statement, don't use the curly brases as well remove them
```

```java
(a) -> a*a;
(a) ->{
    return a*a;
        }
        
//or
```

```java
a->a*a;
```

### Some Functional Interfaces
![img.png](img.png)

## syntax

````java


interface cab{
    public void runCab();
//    static method
    public static void info(){ // this is the piece of the information that is common for all implementations
        System.out.println("Welcome to ola cabs");
    }
}



````


## Why default methods

imagine you have an interface that is used by 100 different classes. If I want to add a new feature to that interface, normally I would break all 100 classes because they would all be forced to implement the new method immediately.

Default methods solve this by providing a 'backup plan' or a default implementation. This allows me to update the interface with new features without breaking the existing code. The classes can choose to override the new feature if they want to, but if they don't, they just use the default version and keep working. It’s primarily about Backward Compatibility.

## Why static methods are allowed


Static methods are allowed because they act as **Universal Tools** or **Helpers** that belong to the Interface itself, not to any specific object.

* **The Logic:** Normal methods (abstract) act on a specific object (e.g., `myCar.drive()`). Static methods do **not** need an object; they work independently (e.g., `Car.checkEngineRules()`).
* **Why it works in Functional Interfaces:** Because static methods already have a body (implementation) and don't rely on the abstract method, they **do not count** towards the "One Abstract Method" limit. They essentially sit on the sidelines as helper tools.
* **The Benefit:** They let us keep "helper code" inside the interface, preventing the need for creating separate utility classes.

**Analogy:**
Think of an **ATM Interface**:
* **Abstract Method:** `withdrawCash()` -> This is abstract because it depends on the specific card you insert.
* **Static Method:** `isBankServerOnline()` -> This is static because it is a universal fact. You don't need to insert a specific card to check if the server is up; the ATM (Interface) can tell you that directly.

## Using lamba expressions to work with the functional interfaces 

```java
interface cab{
    public void bookCab();
}
```
```java
class ola implements bookCab{
    @Override
    public void bookCab(){
        System.out.println("Booked Ola Cabs");
    }
}

class main{
    public static void main(String[] args) {
        cab c = new ola();
        c.bookCab; // Booked ola cabs
    }
}
```

````java
// this entire class implementation can be 

class main{
    public static void main(String[] args) {
        cab c = ()-> System.out.println("Booked Ola Cabs");
        c.bookCab();
        
    }
}
````

![img_1.png](img_1.png)

### Returning the element using the lambda Expression

![img_2.png](img_2.png)


# pre-defined functional interface in java

![img_3.png](img_3.png)

these are the pre-defined functions we can use in our java program, to use the lamba expressions when not given already

## 1. Predicate
![img_4.png](img_4.png)

- contains the `Test` abstract method that returns a boolean value
- used when we have conditional checks in the code
- takes one parameter and returns boolean
- we can also pass the objects to a predicate interface and perform the operations over it

**Usage**

```java
// template of the predcate interface given in the java -> java.util.Function

interface Predicate<T>{
    public boolean test(T t);
}
```
```java
public class Pred{
    public static void main(String[] args) {
        Predicate<Integer> p = i->(i>10);
        
//        or
//        Predicate <Integer> p =i->i>10;
        System.out.println(10); // returns false;
        System.out.println(11); //returns true;
    }
}
```

````java
// usage with objects

import javax.sql.rowset.Predicate;

class Employee {
    String name;
    int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Main {
    public static void main(String[] args) {
        Employee ep = new Employee("Ujjwal", 19);
        Predicate p = e->(e.age>18);
        
        if(p(ep)){
            System.out.println("Person is more than 18 year of age");
        }
        
//        same thing can also be implemented using the arrayList of the Employee Objects
    }
}


````

## Joining Multiple Lambda Expressions

![img_5.png](img_5.png)


we can use, `and`,  `or` and `negate`

```java
import javax.sql.rowset.Predicate;

class main {
    static void main(String[] args) {
        int arr[] = {1, 24, 5, 5, 34, 3, 43, 4, 3, 412, 4233};

        Predicate<Integer> p1 = x->x>10;
        Predicate<Integer> p2 = x->x%2;
        
        for(Integer i : arr){
//            if(p1.test(n) && p2.test(n)){
            if(p1.and(p2).test(n)){
                System.out.println("Both Conditions Passed");
            }
            
//            negating using the test method
            if(p1.negate().test(n)){
                System.out.println("Negated the method");
            }
        }
    }
}
```
## 2. Function interface
 - this is used when we want some other value other than boolean to what we were getting with predicate
 - when we wanna have some operation and return the value
```java
// template of the function interface

interface Function<T,R>{ // contains type and the return type
    public R apply(T t); // apply method is there with will take the argument and return something
    
}
```

## Implementation

![img_6.png](img_6.png)

```java
import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(1);
        arr.add(3);
        
        Function<Integer, Integer> f = x->x*x;
        
        for(Integer i : arr){
            System.out.println(f.apply(i)); // this will print squares
        }
    }
}
```

just like how we did it in the predicate, we can also pass the objects 

## Function Chaining
2 methods are available in function
1. andThen()
2. compose()

if i wanna do the square of a number and perform the cube operation on the resultant we will be using the andThen method with our Function

**example**

```java
class Main{
    public static void main(String[] args) {
        
        Function <Integer, Integer> f1 = x->x*x;
        Function <Integer, Integer> f2 = x->x*x*x;

        System.out.println(f1.andThen(f2).apply(20)); // 640 ans
        
//        compose is just the reverse order of the andThen, first the f2 will execute and then f1 will execute

        System.out.println(f2.compose(f1).apply(20));
        
    }
}
```


![img_7.png](img_7.png)

## 3. Consumer
- Contains a accept method
- just accept the value of anytype and perform some operations, doesn't returns anything


```java
interface Consumer<T>{
    public void accept(T t);
}
```

Example of a consumer

```java
class Main{
    public static void main(String[] args) {
        Consumer<String> c = x-> System.out.println(x);
        
        c.accept("Ujjwal Sharma");
    }
    
    
}
```

**Again it can also be used with objects to print some specific values and all**

**can be chained with `andThen`**


## 4. Supplier
has a get message, 

```java
interface Supplier{
    public T accept();
}
```


```java
class Main{
    public static void main(String[] args) {
        Supplier<Integer> a = x->10; //returns 10
    }
}
```