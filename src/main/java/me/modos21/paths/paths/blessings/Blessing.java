package me.modos21.paths.paths.blessings;

import me.modos21.paths.entities.PathPlayer;
import me.modos21.paths.paths.Path;

import java.util.function.Consumer;

public record Blessing(Path path, String name, Consumer<PathPlayer> effect) {
}
