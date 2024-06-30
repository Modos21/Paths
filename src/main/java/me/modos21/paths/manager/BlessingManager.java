package me.modos21.paths.manager;

import me.modos21.paths.paths.blessings.Blessing;

import java.util.ArrayList;

public final class BlessingManager extends ArrayList<Blessing> {

    public ArrayList<Blessing> getBlessings() {
        return this;
    }

    public void registerBlessing(Blessing blessing) {
        this.add(blessing);
    }
}
