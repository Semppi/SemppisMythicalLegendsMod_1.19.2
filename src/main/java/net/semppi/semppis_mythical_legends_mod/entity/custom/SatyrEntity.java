package net.semppi.semppis_mythical_legends_mod.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.NeutralMob;
import java.util.UUID;

import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.util.GoalUtils;
import net.minecraft.world.item.ItemStack;
import java.util.Collection;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.animal.Rabbit;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.server.level.ServerLevel;
import net.semppi.semppis_mythical_legends_mod.entity.variant.SatyrVariant;
import net.semppi.semppis_mythical_legends_mod.item.ModItems;
import software.bernie.geckolib3.core.AnimationState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class SatyrEntity extends Animal implements IAnimatable, NeutralMob {
    /// ToDo: Fix the depcracated function
    private AnimationFactory factory = new AnimationFactory(this);
    private SatyrVariant variant = SatyrVariant.DEFAULT;

    @Override
    public AgeableMob getBreedOffspring(ServerLevel world, AgeableMob ageableMob) {
        // Implement the logic to create offspring of the satyr entity when breeding.
        // Return the newly created offspring entity based on your requirements.
        return null;
    }
    @Override
    public void startPersistentAngerTimer() {
        // Do nothing
    }

    @Override
    public int getRemainingPersistentAngerTime() {
        return 0;
    }

    @Override
    public void setRemainingPersistentAngerTime(int time) {
        // Do nothing
    }

    @Override
    public UUID getPersistentAngerTarget() {
        return null;
    }

    @Override
    public void setPersistentAngerTarget(UUID target) {
        // Do nothing
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("Variant", this.variant.getId());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.variant = SatyrVariant.byId(compound.getInt("Variant"));
    }

    public SatyrVariant getSatyrVariant() {
        return this.variant;
    }

    public SatyrEntity(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
        this.setVariant();
    }

    public boolean isBrown() {
        return this.variant == SatyrVariant.Brown;
    }
    /// ToDo: Satyr seems to change its variant every time it's loaded in game or leaves render distance

    public void setVariant() {
        if (this.random.nextBoolean()) {
            this.variant = SatyrVariant.DEFAULT;
        } else {
            this.variant = SatyrVariant.Brown;
        }
    }

    public static AttributeSupplier setAttributes() {
        return net.minecraft.world.entity.animal.Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 16.0D)
                .add(Attributes.ATTACK_DAMAGE, 3.0f)
                .add(Attributes.ATTACK_SPEED, 1.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.4f)
                .build();
    }
    /// ToDo: Have the satyr entity defend it's self and attack back if they are attacked by an entity

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2D, false));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Rabbit.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, false));
    }
    private void applyOpenDoorsAbility() {
        if (GoalUtils.hasGroundPathNavigation(this)) {
            ((GroundPathNavigation)this.getNavigation()).setCanOpenDoors(true);
        }

    }
    /// ToDo: Add the vanilla head tracking to the satyr entity

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.satyr.walk", true));
            return PlayState.CONTINUE;
        }

        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.satyr.idle", true));
        return PlayState.CONTINUE;
    }

    private PlayState attackPredicate(AnimationEvent event) {
        if (this.swinging && event.getController().getAnimationState().equals(AnimationState.Stopped)) {
            event.getController().markNeedsReload();
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.satyr.attack", false));
            this.swinging = false;
        }


        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller",
                0, this::predicate));
        data.addAnimationController(new AnimationController(this, "attackController",
                0, this::attackPredicate));
    }



    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.GOAT_STEP, 0.15F, 1.0F);
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.PANDA_AGGRESSIVE_AMBIENT;
    }



    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.LLAMA_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.LLAMA_DEATH;
    }

    protected float getSoundVolume() {
        return 0.2F;
    }
    /// ToDo: Add the looting enchantment effect to satyrs drop for humanoid flesh if killed with the looting enchant

    @Override
    protected void dropFromLootTable(DamageSource source, boolean causedByPlayer) {
        // Drop humanoid flesh
        int dropCount = this.random.nextInt(3) + 1; // Randomly generate a number between 1 and 3
        for (int i = 0; i < dropCount; i++) {
            this.spawnAtLocation(new ItemStack(ModItems.HUMANOID_FLESH.get()));
        }

        super.dropFromLootTable(source, causedByPlayer);
    }
}