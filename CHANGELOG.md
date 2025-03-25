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