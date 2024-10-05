# Hibernate Basics

## Commonly Used Hibernate Annotations

- **`@Entity`**  
  Marks a class as an entity.

- **`@Table`**  
  Used to customize table details.

- **`@Id`**  
  Marks a column as the primary key.

- **`@GeneratedValue`**  
  Indicates that Hibernate will automatically generate values for the primary key.

- **`@Column`**  
  Specifies column mappings, such as changing the column name in the associated database table.

- **`@Transient`**  
  Instructs Hibernate not to save this field.

- **`@Temporal`**  
  Defines the format for saving date fields.

- **`@Lob`**  
  Indicates that the field is a large object, not a simple object.

- **Relationship Annotations**  
  - **`@OneToOne`**
  - **`@OneToMany`**
  - **`@ManyToOne`**
  - **`@JoinColumn`**

## Session Methods

### `Session.get()` Method

- **Return Value:** Returns `null` if the object is not found.
- **Database Query:** Hits the database immediately upon calling.
- **Proxy Creation:** Does not create a proxy object; fetches the real object.
- **Performance:** Slightly slower due to immediate data fetching.
- **Use Case:** Ideal when uncertain if the object exists, as it won’t throw an exception if not found.

### `Session.load()` Method

- **Return Value:** Throws `ObjectNotFoundException` if the object is not found.
- **Database Query:** Returns a proxy object; database is queried only when properties are accessed.
- **Proxy Creation:** Creates a proxy object for lazy initialization.
- **Performance:** Potentially faster if properties are never accessed.
- **Use Case:** Use when certain the object exists, to leverage lazy loading.

## Embeddable Annotations

### `@Embeddable` and `@Embedded` Annotations

The `@Embeddable` and `@Embedded` annotations are used to map an object's properties to columns in a database table, allowing properties of one class to be included as a value type in another class.

- **`@Embeddable`**  
  Marks a class as embeddable.

- **`@Embedded`**  
  Marks a field in a class as being an embeddable object.

By using these annotations, Hibernate can persist properties of the embeddable class within the containing class without creating a separate table.

### Benefits of Using `@Embeddable` and `@Embedded`

- **Code Reusability:** Reuse embeddable classes in multiple entities.
- **Normalization:** Reduces the number of tables, improving performance.
- **Data Integrity:** Maintains the relationship between the embeddable and containing class.
- **Simplicity:** Reduces the number of classes and tables required for data mapping.
- **Better Data Modeling:** Encapsulates properties within another object for intuitive structures.
- **Ease of Maintenance:** Simplifies codebase management.
- **Flexibility:** Supports complex data modeling and can be used across multiple entities.
- **Readability:** Enhances code readability and self-explanatory design.
- **Performance:** Reduces joins required to fetch data.
- **Business Logic:** Encapsulates business logic within the embeddable class.

## Example Code

@Embeddable
public class Address { 
    private String street; 
    private String city; 
    private String state; 
    private String zip; 
    // getters and setters 
}

@Entity
public class Employee { 
	@Id
	private int id; 
	private String name; 
	@Embedded
	private Address address; 
	// getters and setters 
}

## OneToOne Mapping
One to one represents that a single entity is associated with a single instance of the other entity. An instance of a source entity can be at most mapped to one instance of the target entity. We have a lot of examples around us that demonstrate this one-to-one mapping.

One person has one passport, a passport is associated with a single person.
Leopards have unique spots, a pattern of spots is associated with a single leopard.
We have one college ID, a college ID is uniquely associated with a person.
You can find more day-to-day life examples if you observe. In database management systems one-to-one mapping is of two types-

One-to-one unidirectional
One-to-one bidirectional

## One-to-one unidirectional
In this type of mapping one entity has a property or a column that references to a property or a column in the target entity.

## One-to-one bidirectional
Until now the relationship was unidirectional i.e. we could access StudentGfgDetail from the Student entity but not vice-versa, but why would we want to have a bidirectional relationship, and what is the problem with a unidirectional relationship?


Problem:


If we somehow just delete the StudentGfgDetail entity and leave the Student entity as it is then the Student entity will have a foreign key that refers to a non-existing object which introduces the problem of dangling foreign key which is, of course, a bad practice. The option to delete the Student entity when the StudentGfgDetail entity is deleted depends on the design of the database, we might want to keep the Student entity as a record of users who left the community or just delete it. Luckily we can achieve both of the things mentioned above without modifying our database and just with the help of Hibernate, just modify StudentGfgDetail.java

## one to many Mapping

Hibernate one to many mapping is made between two entities where the first entity can have a relation with multiple instances of the second entity but the second can be associated with only one instance of the first entity. It is a 1 to N relationship.

For example, in any company, an employee can register for multiple bank accounts but one bank account will be associated with one and only one employee.


## Many-to-One Mapping
A many-to-one relationship is where one entity contains values that refer to another entity (a column or set of columns) that has unique values. In relational databases, these many-to-one relationships are often enforced by foreign key/primary key relationships, and the relationships typically are between fact and dimension tables and between levels in a hierarchy
