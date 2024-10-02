**Basics Commonly used Hibernate Annotations**

@Entity – use to mark any class as Entity.
@Table – use to change the table details.
@Id- use to mark column as id(primary key).
@GeneratedValue- hibernate will automatically generate values for that using an internal sequence. Therefore we don’t have to set it manually.
@Column-Can be used to specify column mappings. For example, to change the column name in the associated table in database.
 @Transient-This tells hibernate not to save this field.
@Temporal- @Temporal over a date field tells hibernate the format in which the date needs to be saved
@Lob-@Lob tells hibernate that this is a large object, not a simple object.
@OneToOne ,  @OneToMany ,  @ManyToOne, @JoinColumn etc.


**Session get() Method**
Return Value: If the object is not found, the get method returns null.
Database Query: It hits the database immediately when called and retrieves the values.
Proxy Creation: This does not create a proxy object. Fetches the real object from the database.
Performance: It might be slightly slower compared to load as it fetches the data right away.
Use Case: Use this when you're not sure whether the object exists or not, as it won't throw an exception if the object is not found.

**Session load() Method**
Return Value: If the object is not found, it will throw an ObjectNotFoundException.
Database Query: It doesn't hit the database immediately. Instead, it returns a proxy object, and the database is queried only when the properties of that object are accessed.
Proxy Creation: Creates a proxy object for the associated entity, providing a form of lazy initialization.
Performance: It might be faster if the object's properties are never accessed, as it avoids unnecessary database hits.
Use Case: Use this when you're certain the object exists, and you want to take advantage of lazy loading.

**@Embeddable Annotation**
The @Embeddable and @Embedded annotations in Hibernate are used to map an object’s properties to columns in a database table. These annotations are used in combination to allow the properties of one class to be included as a value type in another class and then be persisted in the database as part of the containing class.

**Overview**
The @Embeddable annotation is used to mark a class as being embeddable, meaning its properties can be included in another class as a value type. The class marked with @Embeddable is called the embeddable class.
The @Embedded annotation is used to mark a field in a class as being an embeddable object, and it is used in the class that contains the embeddable object.
By using these annotations, Hibernate can automatically persist the properties of the embeddable class within the containing class to the database table, without the need to create a separate table for the embeddable class.
Using @Embeddable and @Embedded annotations in Hibernate allows for better data modeling, code reusability, normalization, and better performance. The annotations also allow to encapsulation of the business logic within the embeddable class.


**Benefits**
The main benefits of using the @Embeddable and @Embedded annotations in Hibernate are:

Code Reusability: You can reuse the embeddable class in multiple entities, avoiding duplication of code.
Normalization: It helps in normalizing the database by reducing the number of tables, which in turn improves the performance.
Data Integrity: It ensures data integrity by maintaining the relationship between the embeddable and the containing class.
Simplicity: It simplifies the development process by reducing the number of classes and tables required to map the data.
Better Data Modelling: It allows for better data modeling by allowing you to encapsulate the properties of an object within another object, making the data structure more intuitive and easy to understand.
Ease of maintenance: it makes the maintenance of the codebase more manageable and easy.
Flexibility: The embeddable classes can be used in multiple entities, and it also supports complex data modeling with the use of @Embedded and @AttributeOverrides.
Readability: The use of @Embeddable and @Embedded annotations makes the code more readable and self-explanatory.
Performance: it improves the performance of the application by reducing the number of joins required to fetch the data.
Business logic: It allows to encapsulation of the business logic within the embeddable class, making it more manageable and easy to understand.

**@Embeddable**
public class Address { 
    private String street; 
    private String city; 
    private String state; 
    private String zip; 
    // getters and setters 
}

**@Entity**
public class Employee { 
    @Id
    private int id; 
    private String name; 
   **@Embedded**
    private Address address; 
    // getters and setters 
}
