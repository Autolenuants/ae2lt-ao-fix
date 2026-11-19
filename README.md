# AE2LT AO Fix

A lightweight client-side Mixin fix mod for Minecraft 1.21.1 (NeoForge) that restores Smooth Lighting / Ambient Occlusion (AO) on `ae2lt:connected_texture` blocks and slabs from **AE2 Lightning Tech** when playing with **Sodium + Iris Shaders**.

## Cause & Fix

`CtmFaceGeometry.quad(...)` builds `BakedQuad`s via `QuadBakingVertexConsumer` without calling `setHasAmbientOcclusion(true)`, leaving `hasAmbientOcclusion()` as `false`. Sodium's per-quad lighting pipeline checks `quad.hasAmbientOcclusion()` and falls back to flat lighting.

This mod injects into `CtmFaceGeometry#quad` at `RETURN` using a `@Pseudo` Mixin and sets `hasAmbientOcclusion = true` on the returned `BakedQuad`.

## Installation

1. Download `ae2lt-ao-fix-*.jar` from **Releases** or **Actions** artifacts.
2. Drop it into your Minecraft `mods/` folder (client-side only; safe to keep even if `ae2lt` is absent or updated).

## Building

```bash
./gradlew build
```

The compiled JAR is output to `build/libs/`.
