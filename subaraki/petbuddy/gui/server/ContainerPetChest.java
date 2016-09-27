package subaraki.petbuddy.gui.server;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.SlotItemHandler;
import subaraki.petbuddy.capability.PetInventory;
import subaraki.petbuddy.capability.PetInventoryCapability;

public class ContainerPetChest extends Container{

	private PetInventory inventory;

	public ContainerPetChest(EntityPlayer player) {
		this.inventory = player.getCapability(PetInventoryCapability.CAPABILITY, null);

		int index = 0; //prevent obo
		for(int x = 0; x < 3; x++)
			for(int y = 0; y < 3; y++)
				addSlotToContainer(new SlotPetChest(inventory, index++, 8+ x*18, 18 + y*18));

		for (int row = 0; row < 9; ++row) {
			this.addSlotToContainer(new Slot(player.inventory, row,
					8 + (row * 18), 144));
		}
		// players inventory
		for (int y = 0; y < 3; ++y) {
			for (int x = 0; x < 9; ++x) {
				this.addSlotToContainer(new Slot(player.inventory,
						(x + ((y + 1) * 9)), 8 + (x * 18),
						86 + (y * 18)));
			}
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return true;
	}
	
	@Override
	public ItemStack slotClick(int slotId, int dragType, ClickType clickTypeIn, EntityPlayer player) {
		return super.slotClick(slotId, dragType, clickTypeIn, player);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
		  ItemStack itemstack = null;
	        Slot slot = (Slot)this.inventorySlots.get(index);

	        if (slot != null && slot.getHasStack())
	        {
	            ItemStack itemstack1 = slot.getStack();
	            itemstack = itemstack1.copy();

	            if (index < 9)
	            {
	                if (!this.mergeItemStack(itemstack1, 9, this.inventorySlots.size(), true))
	                {
	                    return null;
	                }
	            }
	            else if (!this.mergeItemStack(itemstack1, 0, 9, false))
	            {
	                return null;
	            }

	            if (itemstack1.stackSize == 0)
	            {
	                slot.putStack((ItemStack)null);
	            }
	            else
	            {
	                slot.onSlotChanged();
	            }
	        }

	        return itemstack;
	}
}
