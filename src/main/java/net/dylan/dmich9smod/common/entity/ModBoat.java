package net.dylan.dmich9smod.common.entity;

import net.dylan.dmich9smod.init.ModBlocksAndItems;
import net.dylan.dmich9smod.init.ModEntityTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class ModBoat extends Boat {
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE =
            SynchedEntityData.defineId(ModBoat.class, EntityDataSerializers.INT);

    public ModBoat(EntityType<? extends ModBoat> entityType, Level level) {
        super(entityType, level);
        this.blocksBuilding = true;
    }

    public ModBoat(Level worldIn, double x, double y, double z) {
        this(ModEntityTypes.BOAT_ENTITY.get(), worldIn);
        this.setPos(x, y, z);
        this.xo = x;
        this.yo = y;
        this.zo = z;
    }

    protected void addAdditionalSaveData(CompoundTag compound) {
        compound.putString("Type", this.getModBoatType().getName());
    }

    protected void readAdditionalSaveData(CompoundTag compound) {
        if (compound.contains("Type", 8)) {
            this.setBoatType(ModBoat.Type.byName(compound.getString("Type")));
        }
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ID_TYPE, Type.ANGUISH.ordinal());
    }

    @Override
    public Item getDropItem() {
        switch (this.getModBoatType()) {
            case ANGUISH:
                return ModBlocksAndItems.ANGUISH_BOAT.get();
            case FRIGHT:
                return ModBlocksAndItems.FRIGHT_BOAT.get();
            case MIGHT:
                return ModBlocksAndItems.MIGHT_BOAT.get();
            case DREAM:
                return ModBlocksAndItems.DREAM_BOAT.get();
            case FRACTURED:
                return ModBlocksAndItems.FRACTURED_BOAT.get();
            case MAPLE:
                return ModBlocksAndItems.MAPLE_BOAT.get();
            default:
                return Items.OAK_BOAT;
        }
    }

    public void setBoatType(ModBoat.Type boatType) {
        this.entityData.set(DATA_ID_TYPE, boatType.ordinal());
    }

    public ModBoat.Type getModBoatType() {
        return ModBoat.Type.byId(this.entityData.get(DATA_ID_TYPE));
    }

    public enum Type {
        ANGUISH("anguish"),
        FRIGHT("fright"),
        MIGHT("might"),
        DREAM("dream"),
        FRACTURED("fractured"),
        MAPLE("maple");

        private final String name;
        Type(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public static ModBoat.Type byId(int id) {
            ModBoat.Type[] types = values();
            if (id < 0 || id >= types.length) {
                id = 0;
            }

            return types[id];
        }

        public static ModBoat.Type byName(String nameIn) {
            ModBoat.Type[] types = values();

            for (int i = 0; i < types.length; ++i) {
                if (types[i].getName().equals(nameIn)) {
                    return types[i];
                }
            }

            return types[0];
        }
    }
}