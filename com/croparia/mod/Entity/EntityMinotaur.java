package com.croparia.mod.Entity;

import com.croparia.mod.Entity.AI.EntityAIBaseAttack;
import com.croparia.mod.Init.ItemMod;
import com.croparia.mod.World.Dim.FireDim;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityMinotaur extends EntityMob
{

    
    public EntityMinotaur(World world)
    {
        super(world);
        this.setSize(1, 2);
    }

    protected void initEntityAI()
    {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(6, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(6, new EntityAIMoveTowardsTarget(this, 1, 20F));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(1, new EntityAIBaseAttack(this, 1.0D, false));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
        this.tasks.addTask(8, new EntityAILookIdle(this));


    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(600.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.30D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(80.0D / 2);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(30.0D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1.0D);
        this.isImmuneToFire = true;

    }

    @Override
    public void onDeath(DamageSource cause)
    {
        super.onDeath(cause);
                
    	if(cause.getTrueSource() instanceof EntityPlayer)
        {
    	    if(this.getCustomNameTag() == "Minotaur")
    		{
    			this.dropItem(FireDim.block, 1);
    		}
    	    else
    	    {
	    	    this.dropItem(ItemMod.elemental_fire, 8);
	    	    this.dropItem(ItemMod.elemental_fire_chestplate, 1);
	    	    this.dropItem(ItemMod.fire_sword, 1);
    	    }
        
        }
    }
    
    @Override

    protected void updateAITasks()

    {

     super.updateAITasks();


    }

    public void addTrackingPlayer(EntityPlayerMP player)

    {

        super.addTrackingPlayer(player);


    }
    
    public void removeTrackingPlayer(EntityPlayerMP player)
    {
        super.removeTrackingPlayer(player);
    }
}
