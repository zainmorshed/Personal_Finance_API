package com.finance.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.finance.entity.Transaction;
import com.finance.entity.Category;
import com.finance.entity.expenseType;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    // Example useful methods — query by Category or Type
    List<Transaction> findByCategory(Category category);
    List<Transaction> findByType(expenseType type);
}


/*
 * findByTransaction is a method
 * because this is an interface we can declare the method and instatiate it later
 * interfaces can declare methods without bodies (that's their nature)
 * BTS: Spring uses proxy classes and reflection to dynamically implement the repository at runtime.
 * 
 * So even though you never define the method body for findByUser(User user), Spring says:

"Oh! This developer wants to find all Transaction objects where the user field equals a given user. I’ll write that query for them."

Because you're using Spring Data JPA, and your method name follows a recognized pattern (like findByUser), you never need to define the body or write the SQL query yourself.



When Spring Boot runs your application, it:

Sees your TransactionRepository interface extends JpaRepository.

Finds the method List<Transaction> findByUser(User user).

Parses the method name (findByUser) and recognizes:

"Ah, this means: SELECT * FROM transactions WHERE user = ?"

Automatically generates the SQL query and the method body at runtime.

Connects it to the database using JPA/Hibernate under the hood.


You're benefiting from "convention over configuration" — meaning if you follow naming conventions (findBy, findAllBy, countBy, etc.), Spring does all the heavy lifting.




An interface is a contract
it says: "if a class wants to use me, it MUST implement all my methods"

✅ Why Use Interfaces?
Enforces consistency:
Any class that implements the interface must define the methods in the interface. This guarantees certain behavior.

Supports flexibility and polymorphism:
Different classes can implement the same interface in different ways. This allows your code to work with abstract types rather than specific classes.

Improves testability and modularity:
You can write code that depends on the interface, not the concrete class — this is powerful for unit testing and swapping implementations.

Used heavily in Spring Framework
For example:

JpaRepository is an interface that Spring Boot provides a default implementation for at runtime.

You just extend the interface and Spring wires up everything else.




Example:

public interface Animal {
    void makeSound(); // no body
}


public class Dog implements Animal {
    public void makeSound() {
        System.out.println("Woof!");
    }
}

public class Cat implements Animal {
    public void makeSound() {
        System.out.println("Meow!");
    }
}

Now if you do:

Animal myAnimal = new Dog();
myAnimal.makeSound();  // Woof!

You didn’t care that it’s a Dog — you just wanted something that implements Animal.


abstract vs interface
✅ 3. Key Differences
Feature	                Abstract Class	                                                    Interface
Method Bodies	        Can have both abstract (no body) and regular methods (with body)	By default: only abstract methods (Java 8+ allows default and static with bodies)
Variables	            Can have instance variables	                                         Only public static final constants
Constructors	        ✅ Yes	                                                            ❌ No
Multiple Inheritance	❌ No (only one abstract class allowed)	                            ✅ Yes (can implement multiple interfaces)
Use Case	            Share code between related classes	                                 Define capabilities to be shared across unrelated classes

🧠 When to Use What?
Use Abstract Class when:	                        Use Interface when:
You want to provide base functionality	            You want to enforce a contract
You need to share code across related classes	    You need flexibility (multiple inheritance)
You expect evolution (add methods later safely)	    You expect a wide range of implementations
 */