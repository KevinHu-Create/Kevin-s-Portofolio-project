# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Calendar Versioning](https://calver.org/) of
the following form: YYYY.0M.0D.

## 2025.02.19

### Added
- Designed a `<taskManager>` component
- Designed a `<HomeController>` component
- Designed a `<inventoryManager>` component
- Completed brainstorming for three components
- InventoryManagerKernel interface
- implement InventoryManager's kernel method and some secondary method
-Designed a proof of concept for InventoryManager component

### Changed
- Updated project documentation to reflect new design choices

### Removed
- Deleted project template content in `CHANGELOG.md`
## 2025.03.03

### Added
- Created `InventoryManagerInterface` as an enhanced interface extending `InventoryManagerKernel`.
- Added method contracts and documentation for `InventoryManagerInterface`.

### Updated
- Modified `InventoryManager` to implement `InventoryManagerInterface` instead of `InventoryManagerKernel`.
- Ensured all methods from `InventoryManagerInterface` are properly implemented in `InventoryManager`.

### Fixed
- Resolved potential naming conflict between `InventoryManager` class and `InventoryManagerInterface`.

## 2025.03.25

### Added

- Created abstract class `InventoryManagerSecondary` to implement all secondary methods using only kernel methods.
- Implemented `clearInventory()`, `isStockLow(String)`, and `restock(String, int)` in the abstract class.
- Implemented `toString()` for formatted inventory display.
- Added OSU CSE Components.jar to lib in order to avoid add all standard method to components by hand
### Updated

- Added `getAllItems()` to `InventoryManagerKernel` interface.
- Implemented `getAllItems()` in `InventoryManagerImpl` to support iteration from secondary methods.
- Implemented `clear()` and `transferFrom()` in `InventoryManagerImpl` to satisfy `Standard<InventoryManager>` contract from inherited interface.
- Removed redundant `newInstance()` declaration from `InventoryManager` interface since it is inherited from `Standard<T>`.

## 2025.04.08

### Added

- Implemented kernel component `InventoryManager1L` extending `InventoryManagerSecondary`
- Chose `Map<String, Integer>` as internal representation to model inventory state
- Provided `Convention` and `Correspondence` in file header to define valid states and abstraction

### Implemented

- All kernel methods: `addItem`, `removeItem`, `hasItem`, `getItemCount`, and `getAllItems`
- All `Standard` methods: `newInstance`, `clear`, and `transferFrom`
- Included full Javadoc for all methods, following design-by-contract style

## 2025.04.18

### Added
- Completed full JUnit test suite for `InventoryManager` component (kernel and secondary methods)
- Created two usage demos: `InventoryAppDemo1.java` (basic operations) and `InventoryRestocker.java` (auto-restocking)

### Updated
- Finalized kernel implementation in `InventoryManager1L`
- Updated class-level Javadoc for representation, convention, and correspondence
- Polished code for consistency with OSU CSE component discipline

### Notes
- Because I noticed that we haven't set the launch.jason so from what I learned it will not add components.jar to the defualt classpath, therefore I'm afraid the the running button could not be used. To run the demo applications, please compile and run using the following:

```bash
# Compile and run InventoryAppDemo1
javac -cp "lib/components.jar:src" -d bin src/InventoryAppDemo1.java
java -cp "lib/components.jar:bin" InventoryAppDemo1

# Compile and run InventoryRestocker
javac -cp "lib/components.jar:src" -d bin src/InventoryRestocker.java
java -cp "lib/components.jar:bin" InventoryRestocker
