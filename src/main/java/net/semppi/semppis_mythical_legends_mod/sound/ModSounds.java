package net.semppi.semppis_mythical_legends_mod.sound;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.ObjectHolder;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.semppi.semppis_mythical_legends_mod.SemppisMythicalLegendsMod;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, SemppisMythicalLegendsMod.MOD_ID);

    public static final SoundEvent LLAMA_HURT = new SoundEvent(new ResourceLocation(SemppisMythicalLegendsMod.MOD_ID, "llama_hurt"));
    public static final SoundEvent LLAMA_DEATH = new SoundEvent(new ResourceLocation(SemppisMythicalLegendsMod.MOD_ID, "llama_death"));

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
        SOUND_EVENTS.register("llama_hurt", () -> LLAMA_HURT);
        SOUND_EVENTS.register("llama_death", () -> LLAMA_DEATH);
    }

}