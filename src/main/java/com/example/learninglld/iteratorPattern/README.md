# Iterator Pattern

## Overview
The Iterator Pattern is a behavioral design pattern that provides a way to access the elements of an aggregate object sequentially without exposing its underlying representation. It separates the traversal of a collection from the collection itself.

## Key Concepts
- **Iterator**: An interface that defines methods for traversing a collection (e.g., `hasNext()`, `next()`).
- **Concrete Iterator**: A class that implements the Iterator interface and keeps track of the current position in the traversal.
- **Aggregate**: An interface that defines a method for creating an Iterator object.
- **Concrete Aggregate**: A class that implements the Aggregate interface and returns an instance of the appropriate Concrete Iterator.

## When to Use
- When you want to access a collection's contents without exposing its internal structure
- When you want to support multiple traversal methods for a collection
- When you want to provide a uniform interface for traversing different collection types

## Implementation in This Package

### Components
1. **Book.java**: A simple data class representing a book with a name and price.
   ```java
   @Data
   @AllArgsConstructor
   public class Book {
       String name;
       Integer price;
   }
   ```

2. **BookIterator.java**: A concrete iterator that implements the Java `Iterator` interface to traverse a list of books.
   ```java
   public class BookIterator implements Iterator {
       List<Book> books = new ArrayList<Book>();
       Integer current;

       public BookIterator(List<Book> books) {
           this.books = books;
           current = 0;
       }

       @Override
       public boolean hasNext() {
           if(current < books.size()) {
               return true;
           }
           return false;
       }

       @Override
       public Book next() {
           if(this.hasNext()) {
               return books.get(current++);
           }
           return null;
       }
   }
   ```

3. **Library.java**: A concrete aggregate that maintains a collection of books and provides a method to create an iterator.
   ```java
   public class Library {
       List<Book> books = new ArrayList<Book>();

       public void addBook(Book book) {
           this.books.add(book);
       }

       public Iterator createIterator() {
           return new BookIterator(this.books);
       }
   }
   ```

4. **UseIterator.java**: A client class that demonstrates how to use the Iterator pattern.
   ```java
   public static void useIterator() {
       Book book1 = new Book("Book1", 100);
       Book book2 = new Book("Book2", 250);
       Book book3 = new Book("Book3", 175);
       Book book4 = new Book("Book4", 345);

       Library library = new Library();
       library.addBook(book1);
       library.addBook(book2);
       library.addBook(book3);
       library.addBook(book4);

       Iterator iterator = library.createIterator();
       if(iterator.hasNext()) {
           Book next = (Book) iterator.next();
           System.out.println(next.getName());
       }
   }
   ```

## How It Works
1. The client creates a Library object and adds several Book objects to it.
2. The client calls the Library's `createIterator()` method to get an iterator for the collection.
3. The Library creates and returns a BookIterator initialized with its collection of books.
4. The client uses the iterator's `hasNext()` method to check if there are more elements and the `next()` method to retrieve the next element.
5. The BookIterator keeps track of the current position in the collection and provides access to the elements without exposing the collection's internal structure.

## Benefits of the Iterator Pattern
1. **Single Responsibility Principle**: Separates the traversal algorithm from the collection's structure.
2. **Open/Closed Principle**: New types of collections and iterators can be added without changing existing code.
3. **Simplified Client Code**: Clients don't need to know the internal structure of the collection.
4. **Multiple Traversals**: Allows multiple traversals of the same collection simultaneously.
5. **Pause and Resume**: Traversal can be paused and resumed as needed.

## Drawbacks of the Iterator Pattern
1. **Overhead**: Adds additional classes and complexity to the codebase.
2. **Limited Functionality**: Some specialized traversal operations might be difficult to implement using a generic iterator.
3. **State Management**: Iterators must maintain state, which can be problematic in concurrent environments.

## Comparison with Other Patterns
- **Composite**: Iterator is often used with Composite to traverse tree structures.
- **Factory Method**: The `createIterator()` method is a factory method that creates the appropriate iterator.
- **Memento**: Can be used with Iterator to capture and restore the state of an iteration.
- **Visitor**: Both patterns are used to traverse a collection, but Visitor applies operations to elements while Iterator just accesses them.

## Real-World Applications
- Java Collections Framework (java.util.Iterator)
- Database cursors
- File system traversal
- Web crawlers
- UI component hierarchies
