# Computer Builder Pattern

## Description

This project demonstrates the Builder Design Pattern using a Computer configuration system.

The Computer class contains required and optional parameters. The Builder Pattern makes it easier to create different Computer configurations without using a constructor with many parameters.

## Project Structure

```text
src/
├── Computer.java
├── ComputerDirector.java
├── Main.java
└── PowerSupply.java

test/
└── java/
    └── ComputerBuilderTest.java

docs/
└── builder-uml.png

README.md
report.md
```
## Design Pattern

The project uses the Builder Design Pattern.

### Main Components

- **Computer** — the final Product.
- **Computer.Builder** — builds and validates Computer objects.
- **ComputerDirector** — creates predefined Computer configurations.
- **PowerSupply** — supporting object used by Computer.

## Preset Configurations

The Director provides three predefined configurations:

- **Basic PC** — Intel Core i5, 8 GB RAM, 512 GB storage, Wi-Fi, Windows 11, Air Cooling.
- **Gaming PC** — Intel Core i7, 32 GB RAM, 1000 GB storage, RTX 4070, Wi-Fi, Bluetooth, Liquid Cooling, RGB.
- **Workstation PC** — Intel Core i9, 64 GB RAM, 2000 GB storage, RTX 4080, Wi-Fi, Bluetooth, Windows 11 Pro, Liquid Cooling.

## Preset Configurations

The Director provides three predefined configurations:

- **Basic PC** — Intel Core i5, 8 GB RAM, 512 GB storage, Wi-Fi, Windows 11, Air Cooling.
- **Gaming PC** — Intel Core i7, 32 GB RAM, 1000 GB storage, RTX 4070, Wi-Fi, Bluetooth, Liquid Cooling, RGB.
- **Workstation PC** — Intel Core i9, 64 GB RAM, 2000 GB storage, RTX 4080, Wi-Fi, Bluetooth, Windows 11 Pro, Liquid Cooling.

## Validation

The Builder validates the Computer configuration before creating the final object.

The following validation rules are implemented:

- Computer name cannot be empty.
- RAM must be greater than 0.
- Storage must be greater than 0.
- RGB lighting requires a GPU.
- Liquid Cooling requires at least 16 GB of RAM.

Validation is organized into separate methods:

- `validateRequiredFields()`
- `validatePositiveValues()`
- `validateDependencies()`

## Testing

The project uses JUnit 5 for automated testing.

The tests cover:

- Valid Gaming PC creation.
- Valid Basic PC creation.
- Valid Workstation PC creation.
- Empty Computer name validation.
- Zero RAM validation.
- RGB without GPU validation.
- Liquid Cooling with exactly 16 GB of RAM.
- Liquid Cooling with 15 GB of RAM.
- RGB with a provided GPU.
- Builder reuse and Product independence.

All tests pass successfully.

## UML

The UML class diagram represents the main classes and their relationships.

The diagram includes:

- `Computer`
- `Computer.Builder`
- `ComputerDirector`
- `PowerSupply`

The UML diagram is stored in:

`docs/builder-uml.png`

## How to Run

1. Open the project in IntelliJ IDEA.
2. Make sure Java and JUnit 5 are configured.
3. Run the `Main` class to create the predefined Computer configurations.
4. Run `ComputerBuilderTest` to execute the automated tests.

The program creates three predefined configurations:

- Basic PC
- Gaming PC
- Workstation PC