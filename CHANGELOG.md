# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

---

## [0.1.0] - 2026-06-25

### Added

- **Ctrl Sprint** — Hold the configured sprint key (default: Left Control) while moving
  forward to sprint, exactly like modern Minecraft. Sprint stops when the key or the
  forward key is released. Sprinting is suppressed while a screen (inventory, chat, etc.)
  is open and while the player is sneaking.
- Config file (`rorys-utilities.cfg`) with two options:
  - `enableCtrlSprint` — enable or disable the feature entirely (default: `true`).
  - `sprintKey` — LWJGL key code for the sprint key (default: `29`, LCONTROL).
