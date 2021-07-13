package subaraki.petbuddy.petform;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.PigModel;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Quaternion;
import subaraki.petbuddy.api.IPetFormBase;
import subaraki.petbuddy.client.entity.RenderEntityPetBuddy;
import subaraki.petbuddy.client.entity.layers.LayerPetFormBase;
import subaraki.petbuddy.server.entity.PetBuddyEntity;

public class PigForm implements IPetFormBase {

    protected final PigModel<PetBuddyEntity> model;

    public PigForm() {

        model = new PigModel<>();
    }

    @Override
    public float getScale()
    {

        return 0.35F;
    }

    @Override
    public Item getFormItem()
    {

        return Items.PORKCHOP;
    }

    @Override
    public boolean canVisuallySwimLikePlayer()
    {

        return false;
    }

    @Override
    public void heldItemRotationAndOffset(MatrixStack stack)
    {

        stack.translate(2.3, .2, 1);
        stack.mulPose(new Quaternion(0, 0, -45f, true));
        stack.scale(2, 2, 2);
    }

    @Override
    public String getID()
    {

        return "pig";
    }

    @Override
    public float getNameRenderOffset()
    {

        return -0.4f;
    }

    @Override
    public EntityModel<PetBuddyEntity> getDefaultModel()
    {

        return model;
    }

    @Override
    public LayerRenderer<PetBuddyEntity, PlayerModel<PetBuddyEntity>> getLayer(RenderEntityPetBuddy parent_renderer)
    {

        return new LayerPig(parent_renderer);
    }

    private class LayerPig extends LayerPetFormBase {

        private final ResourceLocation PIG_LOCATION = new ResourceLocation("textures/entity/pig/pig.png");

        public LayerPig(IEntityRenderer<PetBuddyEntity, PlayerModel<PetBuddyEntity>> parent_renderer) {

            super(parent_renderer);
        }

        @Override
        protected ResourceLocation getTextureLocation(PetBuddyEntity p_229139_1_)
        {

            return PIG_LOCATION;
        }

        @Override
        public IPetFormBase getForm()
        {

            return PigForm.this;
        }

    }

    @Override
    public float getBob(PetBuddyEntity buddy, float tickCount)
    {

        return 0;
    }

    @Override
    public void tick(PetBuddyEntity buddy)
    {

    }

}