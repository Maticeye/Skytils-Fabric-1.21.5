package com.tvojepaketi.skytils;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = SkytilsMod.MODID)
public class SkytilsConfig implements ConfigData {
    @ConfigEntry.BoundedDiscrete(min = 1, max = 100)
    public int someValue = 10;
}
