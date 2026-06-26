# Installing Rory's Utilities

---

## Requirements

- Minecraft **1.2.5**
- **Minecraft Forge 3.4.9.171** installed (via Prism Launcher or a manual profile)
- Java 8

---

## Installation (Prism Launcher — recommended)

1. Open **Prism Launcher** and select your Minecraft 1.2.5 + Forge 3.4.9.171 instance.
2. Click **Edit** → **Mods** → **Add File**.
3. Select `rorys-utilities-0.1.0.jar`.
4. Click **Launch**. The mod loads automatically.

---

## Installation (manual)

1. Locate your `.minecraft` folder:
   - **Windows:** `%APPDATA%\.minecraft`
   - **macOS:** `~/Library/Application Support/minecraft`
   - **Linux:** `~/.minecraft`

2. Open the `mods/` folder inside it. Create it if it does not exist.

3. Drop `rorys-utilities-0.1.0.jar` into `mods/`.

4. Launch Minecraft with the Forge 3.4.9.171 profile.

---

## Why the `mods/` folder and not `minecraft.jar`?

Minecraft Forge 3.4.9.171 is a full mod loader. It patches Minecraft on startup and scans the `mods/` folder for jars to load. You do **not** need to patch `minecraft.jar` directly. Doing so would conflict with Forge's own patches and break other mods.

---

## Configuration

On first launch, a config file is created at:

```
.minecraft/config/rorys-utilities.cfg
```

Open it with any text editor to change settings:

```properties
# Sprint settings
enableCtrlSprint=true
sprintKey=29
```

`sprintKey` is an LWJGL key code. Common values:

| Key | Code |
|---|---|
| Left Control | 29 |
| Left Alt | 56 |
| Left Shift | 42 |
| Caps Lock | 58 |
| R | 19 |

---

## Uninstalling

Remove `rorys-utilities-0.1.0.jar` from the `mods/` folder. No other files need to be removed (the config file in `config/` is harmless to leave).
