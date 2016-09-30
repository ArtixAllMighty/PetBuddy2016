package subaraki.petbuddy.capability;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.items.ItemStackHandler;

public class PetInventory {

	private PetStackHandler inventory;
	private String petname = null;
	
	private EntityPlayer player;

	private boolean holdsChest = false;
	
	public PetInventory(){
		inventory = new PetStackHandler();
	}

	public EntityPlayer getPlayer() { 
		return player; 
	}

	public void setPlayer(EntityPlayer newPlayer){
		this.player = newPlayer;
	}

	/*
	 * Internal method used by IStorage in the capability
	 */
	public ItemStackHandler getInventoryHandler(){return inventory;}

	public NBTBase writeData(){
		//hook into the tagcompound of the ItemStackHandler
		NBTTagCompound tag = inventory.serializeNBT();
		//add our own tags
		tag.setBoolean("chest", holdsChest);
		tag.setString("petname", petname);
		//save mix of itemstacks and personal tags
		return tag;
	}
	
	public void readData(NBTBase nbt){
		inventory.deserializeNBT((NBTTagCompound)nbt);
		holdsChest = ((NBTTagCompound)nbt).getBoolean("chest");
		petname = ((NBTTagCompound)nbt).getString("petname");
	}
	
	public void setHoldingChest(){
		holdsChest = true;
	}
	
	public boolean canAccesStorage(){
		return holdsChest;
	}
	
	public String getPetName(){
		return petname;
	}
	
	public void setPetName(String name){
		petname = name;
	}
}
