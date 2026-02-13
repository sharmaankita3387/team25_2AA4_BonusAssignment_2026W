# UML to Java Code Generator

## Overview

This project is a proof-of-concept UML-to-Java code generator developed for SFWRENG 2AA4.

The program reads a UML Class Diagram exported from Draw.io (in XML format), parses class definitions (including attributes and methods), and automatically generates corresponding `.java` files.

The goal of this project is to demonstrate model-driven engineering concepts by translating structural UML models into working Java class skeletons.

---

## Features

- Parses Draw.io XML class diagrams
- Extracts:
  - Class names
  - Attributes (with visibility and types)
  - Methods
- Generates valid Java class files
- Creates one `.java` file per UML class
- Outputs method stubs ready for implementation

---

## Requirements

- Java (JDK 8 or higher)
- A UML Class Diagram exported from Draw.io as XML

---

## How to Run 

1. Export your UML Class Diagram from Draw.io as an XML file.
2. Place the XML file inside the `model/` directory.
3. Compile the generator:

## Example

### UML Input (Car Class)

- `- model : String`
- `- make : String`
- `- year : int`
- `- capacity : int`
- `+ move()`

### Generated Output

```java
public class Car {

    private String model;
    private String make;
    private int year;
    private int capacity;

    public void move() {
        // TODO Auto-generated method
    }
}
