# Architecture

Rory's Utilities is structured in horizontal layers. Each layer has one responsibility and depends only on layers below it.

---

## Layer Map

```
┌─────────────────────────────────────┐
│          RorysUtilities.java        │  ← Forge entry point. Wires everything together.
└──────────────────┬──────────────────┘
                   │
       ┌───────────┼───────────┐
       ▼           ▼           ▼
  ModConfig   KeyBindings  SprintHandler  ← Config, input declaration, event bridge
                                │
                                ▼
                          CtrlSprint      ← Pure feature logic. No Forge coupling.
```

---

## Packages

| Package | Purpose |
|---|---|
| `com.rorysmod.utilities` | Entry point only. No logic. |
| `com.rorysmod.utilities.config` | Reads and exposes config values via Forge `Configuration`. |
| `com.rorysmod.utilities.keybind` | Declares `KeyBinding` objects registered in Options > Controls. |
| `com.rorysmod.utilities.handler` | Forge tick/event handlers. Reads input, calls feature classes. |
| `com.rorysmod.utilities.feature` | One class per feature. Stateless logic only. |

---

## Design Decisions

### Why separate `CtrlSprint` from `SprintHandler`?

`SprintHandler` is a Forge `ITickHandler`. It has to know about `TickType`, `Minecraft`, and LWJGL key state. If the sprint logic lived inside it, it would be impossible to unit test or reason about independently.

`CtrlSprint.tick(player, sprintKeyDown, movingForward)` takes three primitives. No Forge, no LWJGL. Every input is explicit.

### Why is `ModConfig` not a singleton?

Singletons with static mutable state are hard to test and can cause subtle order-of-initialisation bugs in the Forge lifecycle. `ModConfig` is created by the entry point during `preInit` and injected into anything that needs it. One instance, no static fields.

### Why store the sprint key as an integer in the config, not a string like "LCONTROL"?

LWJGL key codes are integers at runtime. Storing the integer avoids a parsing step and a map lookup on every tick. The comment in the config file documents what key each common code corresponds to.

---

## Adding a New Feature

1. Create `src/main/java/com/rorysmod/utilities/feature/MyFeature.java` — pure logic, no Forge.
2. Create `src/main/java/com/rorysmod/utilities/handler/MyFeatureHandler.java` — reads input/events, calls `MyFeature`.
3. Register the handler in `RorysUtilities.init()`.
4. Add any config keys to `ModConfig`.
5. Add a `KeyBinding` to `KeyBindings` if a new key is needed.
