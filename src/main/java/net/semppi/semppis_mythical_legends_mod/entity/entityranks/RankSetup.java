package net.semppi.semppis_mythical_legends_mod.entity.entityranks;

import net.semppi.semppis_mythical_legends_mod.entity.ModEntityTypes;

import java.util.Arrays;

public class RankSetup {
    public static void setupCreatureRanks() {


        //CreatureRankManager.registerRank(ModEntityTypes.ALICANTO.get(), new CommonRank());
        CreatureRankManager.registerRank(ModEntityTypes.LOVELAND_FROGMAN.get(), new CommonRank());
        CreatureRankManager.registerRank(ModEntityTypes.MANDRAKE.get(), new CommonRank());
        CreatureRankManager.registerRank(ModEntityTypes.PUKIS.get(), new CommonRank());
        CreatureRankManager.registerRank(ModEntityTypes.SATYR.get(), new CommonRank());
        //CreatureRankManager.registerRank(ModEntityTypes.COLOSSALLOBSTER.get(), new RareRank());
        //CreatureRankManager.registerRank(ModEntityTypes.WENDIGO.get(), new RareRank());
        //CreatureRankManager.registerRank(ModEntityTypes.BEHEMOTH.get(), new MythicalRank());
        //CreatureRankManager.registerRank(ModEntityTypes.MALPHAS.get(), new MythicalRank());

        //PersonalityTraitsManager.assignTraits(ModEntityTypes.ALICANTO.get(), Arrays.asList("territorial", "distrusting", "cautious", "cunning"));
        PersonalityTraitsManager.assignTraits(ModEntityTypes.LOVELAND_FROGMAN.get(), Arrays.asList("timid", "naive", "communal", "hesitant"));
        PersonalityTraitsManager.assignTraits(ModEntityTypes.MANDRAKE.get(), Arrays.asList("sensitive", "secluded", "capricious", "content"));
        PersonalityTraitsManager.assignTraits(ModEntityTypes.PUKIS.get(), Arrays.asList("protective", "cunning", "capricious", "mischievous"));
        PersonalityTraitsManager.assignTraits(ModEntityTypes.SATYR.get(), Arrays.asList("playful", "rowdy", "mischievous", "libidinous"));
        PersonalityTraitsManager.assignTraits(ModEntityTypes.COLOSSALLOBSTER.get(), Arrays.asList("territorial", "aggressive", "cautious", "persistent"));
        PersonalityTraitsManager.assignTraits(ModEntityTypes.WENDIGO.get(), Arrays.asList("aggressive", "reclusive", "greedy", "aloof"));
        PersonalityTraitsManager.assignTraits(ModEntityTypes.BEHEMOTH.get(), Arrays.asList("arrogant", "tranquil", "aloof", "stoic"));
        PersonalityTraitsManager.assignTraits(ModEntityTypes.MALPHAS.get(), Arrays.asList("cunning", "suave", "confident", "manipulative", "curious"));
    }
}