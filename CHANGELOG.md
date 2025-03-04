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