package net.remclean.mapleforest.item;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.remclean.mapleforest.MapleForest;
import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    ARMOR_PAD("hunters", 25, new int[] {2,7,5,2}, 25,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 1.5f, 0.5f, () -> Ingredient.ofItems(ModItems.ARMOR_PAD));

    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantablity;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistence;
    private final Supplier<Ingredient> repairIngredient;

    private static final int[] BASE_DURABILITY = {11, 16, 15, 13};

    ModArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantablity, SoundEvent equipSound, float toughness, float knockbackResistence, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantablity = enchantablity;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistence = knockbackResistence;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurability(ArmorItem.Type type) {
        return BASE_DURABILITY[type.ordinal()] * this.durabilityMultiplier;
    }

    @Override
    public int getProtection(ArmorItem.Type type) {
        return protectionAmounts[type.ordinal()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantablity;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return MapleForest.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistence;
    }
}
