package com.tvojepaketi.skytils;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerPlayConnectionEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;

public class SkytilsMod implements ModInitializer {
    public static final String MODID = "skytils";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

    // Primer predmeta
    public static final Item MOJ_ITEM = new Item(new Item.Settings().group(ItemGroup.MISC));

    @Override
    public void onInitialize() {
        // Registracija predmeta
        registerItems();
        // Dogodek ob povezavi igralca
        ServerPlayConnectionEvents.JOIN.register((handler, server, sender) -> {
            LOGGER.info("Igralec se je pridružil!");
        });

        // Konfiguracija
        AutoConfig.register(SkytilsConfig.class, JanksonConfigSerializer::new);

        LOGGER.info("Skytils mod initializiran!");
    }

    private void registerItems() {
        Registry.register(Registry.ITEM, new Identifier(MODID, "moj_item"), MOJ_ITEM);
    }
}
