# Enumerate for Java

The Enumerate java class provides a generic method to iterate over an iterable collection, providing access to each element and it's index within the collection. It allows enumeration over a collection similar to the `enumerate()` function in Python.

## Usage

The following pseudo control structure is introduced to enumerate over a collection with minimal complexity when compared to a regular for-each loop:

```java 
Enumerate.over(iterable, (item, i) -> { 
  ... 
});
```

The above example uses a lambda expession to define the task to be performed each iteration.
This also allows for the `item` and `i` parameters to be renamed as required.

This can also be used to iterate over an array as shown in the below example:

```java
String[] arr = ["Zero", "One"]

Enumerate.over(arr, (str, i) -> { 
  System.out.println(i+": "str);
});
```
This would produce the following output:
```
0: Zero
1: One
```

It may also be written using the full interface to demonstrate how this construct works:
```java
List<String> list = new ArrayList<>();
list.add("Zero");
list.add("One");

Enumerate.over(list, new Iteration<String>() {
  @Override
  public void accept(String item, int i) {
    System.out.println(i+": "item);
  }
});
```
