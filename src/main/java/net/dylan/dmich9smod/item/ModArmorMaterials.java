package net.dylan.dmich9smod.item;
import net.dylan.dmich9smod.block.ModBlocksAndItems;
import net.dylan.dmich9smod.dmich9sMod;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.util.Lazy;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    CARNELIAN("carnelian", 6, new int[]{1, 2, 4, 2}, 16,
            SoundEvents.ARMOR_EQUIP_GOLD, 0F, 0.0F, () -> Ingredient.of(ModBlocksAndItems.CARNELIAN.get())),
    STRONTIUM("strontium", 12, new int[]{1, 3, 5, 2}, 16,
            SoundEvents.ARMOR_EQUIP_GOLD, 0F, 0.0F, () -> Ingredient.of(ModBlocksAndItems.STRONTIUM_INGOT.get())),
    GARNET("garnet", 24, new int[]{2, 5, 7, 2}, 12,
            SoundEvents.ARMOR_EQUIP_GOLD, 1F, 0.0F, () -> Ingredient.of(ModBlocksAndItems.GARNET.get())),
    AZURITE("azurite", 35, new int[]{3, 6, 8, 3}, 30,
            SoundEvents.ARMOR_EQUIP_GOLD, 2.5F, 0.0F, () -> Ingredient.of(ModBlocksAndItems.AZURITE.get())),
    SERENDIBITE("serendibite", 55, new int[]{4, 7, 9, 4}, 15,
            SoundEvents.ARMOR_EQUIP_GOLD, 1.5F, 0.5F, () -> Ingredient.of(ModBlocksAndItems.SERENDIBITE.get())),
    AMBROSIA("ambrosia", 44, new int[]{5, 8, 10, 5}, 25,
            SoundEvents.ARMOR_EQUIP_GOLD, 4F, 0.3F, () -> Ingredient.of(ModBlocksAndItems.AMBROSIA.get()));



    private static final int[] HEALTH_PER_SLOT = new int[]{13, 15, 16, 11};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] slotProtections;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final Lazy<Ingredient> repairIngredient;

    ModArmorMaterials(String name, int durabilityMultiplier, int[] slotProtections, int enchantmentValue,
                      SoundEvent sound, float toughness,
                      float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.slotProtections = slotProtections;
        this.enchantmentValue = enchantmentValue;
        this.sound = sound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = Lazy.of(repairIngredient);
    }

    public int getDurabilityForSlot(EquipmentSlot pSlot) {
        return HEALTH_PER_SLOT[pSlot.getIndex()] * this.durabilityMultiplier;
    }

    public int getDefenseForSlot(EquipmentSlot pSlot) {
        return this.slotProtections[pSlot.getIndex()];
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public SoundEvent getEquipSound() {
        return this.sound;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    public String getName() { return dmich9sMod.MOD_ID + ":" + this.name; }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}