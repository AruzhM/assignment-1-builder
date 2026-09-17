# Assignment 1 – Builder Pattern

## 1. Problem Description

The goal of this assignment is to implement the Builder Design Pattern for creating Computer objects.

A Computer contains several required and optional properties such as CPU, RAM, storage, GPU, Wi-Fi, Bluetooth, operating system, cooling type, RGB lighting, and power supply.

The main problem is that a Computer can have many optional parameters. Creating it using a constructor with many parameters makes the code difficult to read, maintain, and modify.

---

## 2. Individual Variant

My individual variant is a Computer configuration system.

The main product is the `Computer` class. It can be configured with different optional components and features.

The project also contains a `PowerSupply` value object, a `Computer.Builder` for step-by-step construction, and a `ComputerDirector` for predefined configurations.

---

## 3. Initial Constructor-Based Solution

Initially, the Computer object was created using a constructor with many parameters:

```java
Computer computer = new Computer(
        "Game PC",
        "Intel Core i7",
        32,
        1000,
        "RTX 4070",
        true,
        true,
        "Windows 11",
        "Liquid Cooling",
        true,
        powerSupply
);
```
This approach works, but it has several problems.

The constructor contains many parameters, including several boolean values and optional properties. It is difficult to understand which value belongs to which property.

For example:

true, true, "Windows 11", "Liquid Cooling", true

is not very readable without looking at the constructor definition.
---
## 4. Identified Design Problems

The constructor-based approach has several problems:

- Too many constructor parameters.
- Difficult to read and understand object creation.
- Optional parameters are mixed with required parameters.
- Boolean parameters can be confusing.
- Adding new optional properties would make the constructor even larger.
- Different Computer configurations require different combinations of parameters.
---
## 5. Builder Solution

The Builder Pattern was introduced to solve these problems.

Required parameters are passed to the Builder constructor:

```java
Computer computer = new Computer.Builder(
        "Gaming PC",
        "Intel Core i7",
        32,
        1000
)
```
Optional properties are configured using readable methods:
```java
.gpu("RTX 4070")
.enableWifi()
.enableBluetooth()
.enableRgb()
.coolingType("Liquid Cooling")
.build();
```
The build() method validates the configuration and creates the final Computer object.

---
## 6. Builder Participants
   Product

Computer is the Product. It represents the final object.

Builder

Computer.Builder is the Builder. It stores configuration values, provides methods for optional properties, validates the configuration, and creates the Computer object.

Director

ComputerDirector is the Director. It provides predefined configurations:

Basic PC
Gaming PC
Workstation PC
Supporting Object

PowerSupply is a supporting value object used by Computer.


---
## 7. Validation Rules

The Builder validates the configuration before creating the Computer.

The implemented rules are:

Computer name cannot be empty.
RAM must be greater than 0.
Storage must be greater than 0.
RGB requires a GPU.
Liquid Cooling requires at least 16 GB of RAM.

The validation logic is separated into:

validateRequiredFields()
validatePositiveValues()
validateDependencies()

This makes the validation code easier to maintain.

---
## 8. Preset Configurations

The ComputerDirector provides three predefined configurations.

Basic PC
Intel Core i5
8 GB RAM
512 GB storage
Wi-Fi
Windows 11
Air Cooling
Gaming PC
Intel Core i7
32 GB RAM
1000 GB storage
RTX 4070
Wi-Fi
Bluetooth
Windows 11
Liquid Cooling
RGB
Workstation PC
Intel Core i9
64 GB RAM
2000 GB storage
RTX 4080
Wi-Fi
Bluetooth
Windows 11 Pro
Liquid Cooling
---
## 9. UML Diagram

The UML class diagram represents the actual implementation.

The main classes are:

Computer
Computer.Builder
ComputerDirector
PowerSupply

The diagram is stored in:

docs/builder-uml.png

ComputerDirector uses Computer.Builder to create predefined Computer objects.

---
## 10. Clean Code: Before → After
    Before

The initial solution used a constructor with many parameters:

```java

new Computer(
    name,
    cpu,
    ram,
    storage,
    gpu,
    wifiEnable,
    bluetoothEnable,
    operatingSystem,
    coolingType,
    rgbEnable,
    powerSupply
);

```
This makes object creation difficult to read.

After

The Builder provides a more readable construction style:

```java
new Computer.Builder(
"Gaming PC",
"Intel Core i7",
32,
1000
)
.gpu("RTX 4070")
.enableWifi()
.enableBluetooth()
.operatingSystem("Windows 11")
.coolingType("Liquid Cooling")
.enableRgb()
.powerSupply(powerSupply)
.build();
```
The optional features are clearly visible.

## 11. Design Decision and Rejected Alternative

The Builder Pattern was selected because the Computer object contains multiple optional properties.

The constructor-based approach was rejected because it becomes difficult to read and maintain when the number of parameters increases.

Another alternative would be using multiple overloaded constructors. However, this would lead to many constructors and would still be difficult to maintain.

The Builder Pattern provides a flexible and readable solution.

## 12. Automated Testing

Automated tests were implemented using JUnit 5.

The tests cover:

- 3 valid construction scenarios;
- 3 invalid construction scenarios;
- 2 boundary cases;
- 1 individual validation constraint;
- 1 Builder reuse and Product independence test.

The tests verify the actual behavior of the program using `assertEquals`, `assertTrue`, `assertFalse`, and `assertThrows`.

All automated tests pass successfully.

## 13. Sample Program Output

The program successfully creates three predefined Computer configurations.

```text
Basic PC created!
Gaming PC created!
Workstation PC created!

Process finished with exit code 0
```
## 14. GitHub Repository

GitHub repository:
https://github.com/AruzhM/assignment-1-builder

## Conclusion

The Builder Pattern makes the Computer construction process more readable, flexible, and maintainable.

Required parameters are provided through the Builder constructor, while optional parameters are configured step by step using builder methods.

The Builder also performs validation before creating the final Computer object, which helps prevent invalid configurations.

The ComputerDirector provides reusable predefined configurations for Basic PC, Gaming PC, and Workstation PC.

JUnit 5 tests were used to verify valid configurations, invalid configurations, boundary cases, and Builder behavior.

Overall, the Builder Pattern is a suitable solution for constructing a Computer object with many optional parameters.


