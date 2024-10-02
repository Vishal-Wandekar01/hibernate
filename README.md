Basics Commonly used Hibernate Annotations

@Entity – use to mark any class as Entity.
@Table – use to change the table details.
@Id- use to mark column as id(primary key).
@GeneratedValue- hibernate will automatically generate values for that using an internal sequence. Therefore we don’t have to set it manually.
@Column-Can be used to specify column mappings. For example, to change the column name in the associated table in database.
 @Transient-This tells hibernate not to save this field.
@Temporal- @Temporal over a date field tells hibernate the format in which the date needs to be saved
@Lob-@Lob tells hibernate that this is a large object, not a simple object.
@OneToOne ,  @OneToMany ,  @ManyToOne, @JoinColumn etc.


Session get() Method
Return Value: If the object is not found, the get method returns null.
Database Query: It hits the database immediately when called and retrieves the values.
Proxy Creation: This does not create a proxy object. Fetches the real object from the database.
Performance: It might be slightly slower compared to load as it fetches the data right away.
Use Case: Use this when you're not sure whether the object exists or not, as it won't throw an exception if the object is not found.

Session load() Method
Return Value: If the object is not found, it will throw an ObjectNotFoundException.
Database Query: It doesn't hit the database immediately. Instead, it returns a proxy object, and the database is queried only when the properties of that object are accessed.
Proxy Creation: Creates a proxy object for the associated entity, providing a form of lazy initialization.
Performance: It might be faster if the object's properties are never accessed, as it avoids unnecessary database hits.
Use Case: Use this when you're certain the object exists, and you want to take advantage of lazy loading.
