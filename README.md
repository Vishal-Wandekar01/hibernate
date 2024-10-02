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
