# Rory's Utilities

A lightweight quality-of-life mod for **Minecraft 1.2.5** with **Minecraft Forge 3.4.9.171**.

---

## Features

### v0.1.0

- **Ctrl Sprint** — Hold Left Control (or your configured key) while moving forward to sprint, exactly like modern Minecraft. No double-tapping required.

---

## Requirements

| Dependency | Version |
|---|---|
| Minecraft | 1.2.5 |
| Minecraft Forge | 3.4.9.171 |
| Java | 8 |

---

## Installation

1. Install **Minecraft Forge 3.4.9.171** for Minecraft 1.2.5.
2. Drop `rorys-utilities-0.1.0.jar` into your `mods/` folder.
3. Launch Minecraft.

Full instructions: [docs/INSTALL.md](docs/INSTALL.md)

---

## Build Instructions

See [docs/BUILD.md](docs/BUILD.md) for a step-by-step guide using the legacy MCP/Forge toolchain.

---

## Configuration

On first launch a config file is created at `.minecraft/config/rorys-utilities.cfg`:

```properties
# Enable or disable Ctrl Sprint entirely.
enableCtrlSprint=true

# LWJGL key code for the sprint key. 29 = Left Control.
sprintKey=29
```

---

## Folder Structure

```
rorys-utilities/
├── src/main/java/com/rorysmod/utilities/
│   ├── RorysUtilities.java          ← Forge entry point
│   ├── config/ModConfig.java        ← Configuration
│   ├── keybind/KeyBindings.java     ← Key declarations
│   ├── handler/SprintHandler.java   ← Tick event bridge
│   └── feature/CtrlSprint.java      ← Sprint logic
├── docs/
│   ├── ARCHITECTURE.md
│   ├── BUILD.md
│   ├── INSTALL.md
│   └── ROADMAP.md
├── .gitignore
├── CHANGELOG.md
├── CONTRIBUTING.md
├── LICENSE
└── README.md
```

---

## Roadmap

See [docs/ROADMAP.md](docs/ROADMAP.md).

Planned:
- Custom in-game keybind configuration
- Additional quality-of-life utilities
- In-game config GUI
- Rory's ecosystem integration

---

## Screenshots

*Screenshots will be added after the first public release.*

---

## Versioning

This project follows [Semantic Versioning](https://semver.org/):

- **MAJOR** — breaking change or complete redesign
- **MINOR** — new feature, backward compatible
- **PATCH** — bug fix, no new feature

Current version: **v0.1.0**

---

## License

[MIT](LICENSE) © Rory's Mods

---

## Contributing

See [CONTRIBUTING.md](CONTRIBUTING.md).
