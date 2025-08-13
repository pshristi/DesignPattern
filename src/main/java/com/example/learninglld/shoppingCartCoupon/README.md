# Decorator Pattern with Shopping Cart and Coupons

## Overview
The Decorator Pattern is a structural design pattern that allows behavior to be added to individual objects, either statically or dynamically, without affecting the behavior of other objects from the same class. It is used to extend or alter the functionality of objects at runtime by wrapping them in an object of a decorator class.

## Key Concepts
- **Component**: An interface or abstract class defining the methods that will be implemented by concrete components and decorators.
- **Concrete Component**: A class implementing the component interface, to which additional responsibilities can be attached.
- **Decorator**: An abstract class that implements the component interface and contains a reference to a component.
- **Concrete Decorator**: A class extending the decorator class and adding functionality to the component.

## When to Use
- When you want to add responsibilities to objects dynamically and transparently, without affecting other objects
- When extension by subclassing is impractical or impossible
- When you want to add functionality to individual objects without affecting others of the same class
- When you want to avoid class explosion from many feature combinations

## Implementation in This Package

This package demonstrates the Decorator pattern using a shopping cart system with coupon discounts:

### Components

1. **Product.java**: The component interface defining methods for all products and decorators.
   ```java
   public interface Product {
       float getPrice();
       ProductType getType();
   }
   ```

2. **ProductType.java**: An enum defining the types of products available.
   ```java
   public enum ProductType {
       FURNITURE,
       ELECTRONICS,
       CLOTHING;
   }
   ```

3. **Item1.java** and **Item2.java**: Concrete components implementing the Product interface.
   ```java
   public class Item1 implements Product {
       String name;
       ProductType type;
       float price;
       
       public Item1(String name, float price) {
           this.name = name;
           this.price = price;
           this.type = ProductType.FURNITURE;
       }
       
       public float getPrice() {
           return this.price;
       }
       
       public ProductType getType() {
           return this.type;
       }
   }
   ```

4. **CouponDecorator.java**: The abstract decorator class implementing the Product interface.
   ```java
   public abstract class CouponDecorator implements Product {
   }
   ```

5. **PercentageCoupon.java**: A concrete decorator that applies a percentage-based discount.
   ```java
   public class PercentageCoupon extends CouponDecorator {
       Product product;
       Integer percentage;
       
       PercentageCoupon(Product product, Integer percentage) {
           this.product = product;
           this.percentage = percentage;
       }
       
       @Override
       public float getPrice() {
           return this.product.getPrice() * (1 - percentage / 100.0f);
       }
       
       @Override
       public ProductType getType() {
           return this.product.getType();
       }
   }
   ```

6. **TypeCoupon.java**: A concrete decorator that applies a discount only to certain product types.
   ```java
   public class TypeCoupon extends CouponDecorator {
       static List<ProductType> EligibleTypes = Arrays.asList(
               ProductType.CLOTHING, ProductType.FURNITURE
       );
       Integer percentage;
       Product product;
       
       TypeCoupon(Product product, Integer percentage) {
           this.product = product;
           this.percentage = percentage;
       }
       
       @Override
       public float getPrice() {
           if(EligibleTypes.contains(product.getType())) {
               return product.getPrice() * (1 - percentage/100f);
           }
           return product.getPrice();
       }
       
       @Override
       public ProductType getType() {
           return this.product.getType();
       }
   }
   ```

7. **ShoppingCart.java**: A class that manages products and applies coupon decorators.
   ```java
   public class ShoppingCart {
       List<Product> products;
       
       ShoppingCart() {
           this.products = new ArrayList<>();
       }
       
       public void addProduct(Product product) {
           Product productWithCoupon = new TypeCoupon(new PercentageCoupon(product, 10), 5);
           products.add(productWithCoupon);
       }
       
       public float getTotalPrice() {
           float totalPrice = 0;
           for(Product product : products) {
               totalPrice += product.getPrice();
           }
           return totalPrice;
       }
   }
   ```

8. **UseShoppingCartWithCoupons.java**: A client class demonstrating how to use the shopping cart with coupons.
   ```java
   public class UseShoppingCartWithCoupons {
       public static void useShoppingCartWithCoupon() {
           Product item1 = new Item1("Sofa", 8000);
           Product item2 = new Item2("Earphone", 2000);
           
           ShoppingCart shoppingCart = new ShoppingCart();
           shoppingCart.addProduct(item1);
           shoppingCart.addProduct(item2);
           
           System.out.println("Total bill value is" + shoppingCart.getTotalPrice());
       }
   }
   ```

## How It Works
1. The client creates Product objects (Item1 and Item2).
2. The client adds these products to the ShoppingCart.
3. When a product is added to the cart, the ShoppingCart wraps it with coupon decorators:
   - First with a PercentageCoupon that applies a 10% discount
   - Then with a TypeCoupon that applies an additional 5% discount if the product is of an eligible type
4. When the client calls getTotalPrice(), the cart calculates the total by summing the prices of all products, which now include the applied discounts.

## Benefits of the Decorator Pattern
1. **Open/Closed Principle**: You can extend a class's behavior without modifying it.
2. **Single Responsibility Principle**: You can divide functionality into classes with unique areas of concern.
3. **Flexibility**: You can add or remove responsibilities from an object at runtime.
4. **Composability**: You can combine multiple decorators to produce complex behaviors.

## Drawbacks of the Decorator Pattern
1. **Complexity**: A design with many decorators can be hard to understand and maintain.
2. **Instantiation**: The client needs to know about the concrete component and decorators.
3. **Identity Issues**: Decorators are not identical to the components they wrap, which can cause issues with identity-based operations.

## Comparison with Other Patterns
- **Adapter**: Adapters change the interface of an existing object, while decorators enhance an object without changing its interface.
- **Composite**: Composites and decorators often work together. Decorators are like composites with only one component.
- **Strategy**: Strategies let you change the guts of an object, while decorators change the skin.
- **Proxy**: Proxies control access to an object, while decorators add responsibilities to an object.

## Real-World Applications
- GUI component libraries
- Stream I/O classes in Java
- Web service layers
- Middleware in web frameworks
- Caching systems
