package com.paneedah.weaponlib.compatibility;

import com.paneedah.mwc.WorldGeneratorEventHandler;
import com.paneedah.mwc.vectors.Vector3D;
import com.paneedah.weaponlib.Explosion;
import com.paneedah.weaponlib.ModContext;
import com.paneedah.weaponlib.ai.EntityCustomMob;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.client.shader.ShaderGroup;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAITarget;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.stats.StatBase;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.client.event.RenderGameOverlayEvent.Pre;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.event.entity.item.ItemTossEvent;

import java.io.IOException;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

@Deprecated
public interface Compatibility {

	World world(Entity entity);

    IAttribute getMovementSpeedAttribute();

	NBTTagCompound getTagCompound(ItemStack itemStack);

	void setTagCompound(ItemStack itemStack, NBTTagCompound tagCompound);

	ItemStack getItemStack(ItemTossEvent event);

	EntityPlayer getPlayer(ItemTossEvent event);

	ItemStack getHeldItemMainHand(EntityLivingBase player);

    int getCurrentInventoryItemIndex(EntityPlayer player);

	void ensureTagCompound(ItemStack itemStack);

    void playSound(EntityLivingBase player, SoundEvent sound, float volume, float pitch);

    void playSoundToNearExcept(EntityLivingBase player, SoundEvent object, float volume, float pitch);

	boolean isClientSide();

	EntityPlayer getClientPlayer();

	FontRenderer getFontRenderer();

	ScaledResolution getResolution(Pre event);

	ElementType getEventType(Pre event);

	ItemStack getHelmet();

    ItemStack getHelmet(EntityLivingBase entity);

    void registerKeyBinding(KeyBinding key);

	void registerWithEventBus(Object object);

	void registerWithFmlEventBus(Object object);

	void registerSound(SoundEvent sound);

	void registerItem(Item item, String name);
	
	void registerItem(Item item, ResourceLocation name);

	void runInMainClientThread(Runnable runnable);

	void registerModEntity(Class<? extends Entity> class1, String string, int i, Object mod, int j, int k, boolean b);

    <T, E> T getPrivateValue(Class<? super E> classToAccess, E instance, String... fieldNames);

	int getButton(MouseEvent event);

	EntityPlayer getEntity(FOVUpdateEvent event);

    EntityLivingBase getEntity(@SuppressWarnings("rawtypes") RenderLivingEvent.Pre event);

	void setNewFov(FOVUpdateEvent event, float fov);

    RenderPlayer getRenderer(@SuppressWarnings("rawtypes") RenderLivingEvent.Pre event);

	GuiScreen getGui(GuiOpenEvent event);

    RayTraceResult getObjectMouseOver();

	IBlockState getBlockAtPosition(World world, RayTraceResult position);

	void destroyBlock(World world, RayTraceResult position);

	void addItemToPlayerInventory(EntityPlayer player, final Item item, int slot);

	boolean consumeInventoryItem(InventoryPlayer inventoryPlayer, Item item);

    boolean isGlassBlock(IBlockState block);

	float getEffectOffsetX();

	float getEffectOffsetY();

    ItemStack consumeInventoryItem(Item item, Predicate<ItemStack> condition, EntityPlayer player, int maxSize);

	ItemStack getInventoryItemStack(EntityPlayer player, int inventoryItemIndex);

    void consumeInventoryItemFromSlot(EntityPlayer player, int nextAttachmentSlot);

	void addShapedRecipe(ItemStack itemStack, Object... materials);

    void addShapedOreRecipe(ItemStack itemStack, Object... materials);

    void registerBlock(ModContext context, Block block, String name);

	void registerWorldGenerator(WorldGeneratorEventHandler worldGeneratorEventHandler, int i);

	ArmorMaterial addArmorMaterial(String name, String textureName, int durability, int[] reductionAmounts, int enchantability, SoundEvent soundOnEquip, float toughness);

    void addBlockHitEffect(BlockPos pos, double x, double y, double z, EnumFacing enumFacing);

    String getPlayerName(EntityPlayer player);

    void clickBlock(BlockPos blockPos, EnumFacing sideHit);

    boolean isAirBlock(World world, BlockPos blockPos);

    void addChatMessage(Entity entity, String message);

    Entity getRenderViewEntity();

    void setRenderViewEntity(Entity entity);

    void addBreakingParticle(ModContext modContext, double x, double y, double z);

    float getAspectRatio(ModContext modContext);

    void setStackSize(ItemStack itemStack, int size);

    ItemStack tryConsumingCompatibleItem(List<? extends Item> compatibleParts, int maxSize, EntityPlayer player, Predicate<ItemStack> ...conditions);

    Item findItemByName(String itemName);

    RayTraceResult rayTraceBlocks(Entity entity, Vector3D vec3, Vector3D vec31);

    AxisAlignedBB expandEntityBoundingBox(Entity entity, double f, double f2, double f3);

    AxisAlignedBB getBoundingBox(Entity entity);

    List<Entity> getEntitiesWithinAABBExcludingEntity(World world, Entity entity, AxisAlignedBB boundingBox);

    void spawnParticle(World world, String particleName, double d, double e, double f, double motionX, double motionY, double motionZ);

    IBlockState getBlockAtPosition(World world, BlockPos blockPos);

    boolean isBlockPenetratableByBullets(Block block);
    
    boolean isBlockPenetratableByBullets(IBlockState blockState);

    boolean canCollideCheck(Block block, IBlockState metadata, boolean hitIfLiquid);

    float getCompatibleShellCasingForwardOffset();

    boolean madeFromHardMaterial(IBlockState iBlockState);

    void playSoundAtEntity(Entity entity, SoundEvent explosionSound, float volume, float pitch);

    boolean canDropBlockFromExplosion(IBlockState block, Explosion explosion);

    void onBlockExploded(World worldObj, IBlockState blockState, BlockPos blockpos, Explosion explosion);

    float getExplosionResistance(World world, IBlockState block, BlockPos blockpos, Entity entity,
            Explosion explosion);

    float getExplosionResistance(World worldObj, Entity exploder, Explosion explosion, BlockPos blockpos, IBlockState blockState);

    boolean isSpectator(EntityPlayer entityplayer);

    boolean isCreative(EntityPlayer entityplayer);

    void setBlockToFire(World world, BlockPos blockpos1);

    double getBlastDamageReduction(EntityLivingBase entity, double d10);

    boolean verifyExplosion(World world, Entity exploder, Explosion explosion, BlockPos blockpos, IBlockState blockState, float f);

    boolean isFullBlock(IBlockState blockState);

    void dropBlockAsItemWithChance(World world, IBlockState blockState, BlockPos blockpos, float f, int i);

    IBlockState getBlockBelow(World world, BlockPos blockpos1);

    void playSound(World world, double posX, double posY, double posZ, SoundEvent explosionSound, float volume, float pitch);

    DamageSource genericDamageSource();

    boolean isFlying(EntityPlayer player);

    String getLocalizedString(String format, Object...args);

    Vector3D getLookVec(EntityLivingBase player);

    void setEntityAttribute(EntityLivingBase entity, IAttribute attributes, double value);

    void addStat(EntityPlayer entityplayer, StatBase achievementList);

    float getLightBrightness(World world, BlockPos pos);

    void setItemStackToSlot(Entity entity, EntityEquipmentSlot entityEquipmentSlot, ItemStack itemStack);

    boolean isStrafingSupported();

    void strafe(EntityCustomMob entity, float forward, float strafe);

    void registerEgg(ModContext context, Class<? extends Entity> entityClass, String entityName, int primaryEggColor, int secondaryEggColor);

    void useShader(EntityRenderer entityRenderer, boolean value);

    boolean is3dRenderable(Item item);

    float getCompatibleAimingRotationYaw(EntityLivingBase thrower);
    
    <T> void setPrivateValue(Class<T> class1, T instance, Object value, String...fieldNames);

    ItemStack createItemStack(NBTTagCompound tagCompound);

    EntityAITarget createAINearestAttackableTarget(EntityLivingBase e, Class<? extends EntityLivingBase> targetClass, boolean checkSight);
    
    EntityAIBase createAiAvoidEntity(EntityLivingBase e, Class<? extends EntityLivingBase> entityClassToAvoid, float avoidDistanceIn, double farSpeedIn, double nearSpeedIn);

    Entity getTrueDamageSource(DamageSource cause);

    ShaderGroup getShaderGroup(EntityRenderer entityRenderer);

    void setShaderGroup(EntityRenderer entityRenderer, ShaderGroup shaderGroup);

    WorldType getWorldType(World world);

    ItemStack findNextBestItem(Collection<? extends Item> compatibleItems, Comparator<ItemStack> comparator, EntityPlayer player);
    
    ItemStack tryConsumingCompatibleItem(Collection<? extends Item> compatibleItems, Comparator<ItemStack> comparator, EntityPlayer player);

    ItemStack getItemStackFromSlot(EntityEquipmentSlot compatibleSlot);

    boolean isStencilEnabled(Framebuffer framebuffer);

    void enableStencil(Framebuffer framebuffer);

    void resizeEntityBoundingBox(Entity entity, double x, double y, double z);

    boolean areOptifineShadersOn();

    Entity getEntityByUuid(UUID uuid, World world);

    TileEntity getTileEntity(World world, BlockPos pos);

    void registerTileEntity(Class<? extends TileEntity> tileEntityClass, String name);

    boolean isValidArmor(ItemStack itemstack, EntityEquipmentSlot entityEquipmentSlot, Entity entity);

    NBTTagCompound readTagCompound(PacketBuffer packetBuf) throws IOException;

    void writeTagCompound(PacketBuffer packetBuf, NBTTagCompound tagCompound) throws IOException;

    void addBloodParticle(ModContext modContext, double x, double y, double z, double velX, double velY, double velZ);
}
