package com.starfish_studios.naturalist.client.model;

import com.starfish_studios.naturalist.Naturalist;
import com.starfish_studios.naturalist.common.entity.Capybara;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

@Environment(EnvType.CLIENT)
public class CapybaraModel extends GeoModel<Capybara> {
    @Override
    public ResourceLocation getModelResource(Capybara entity) {
        return new ResourceLocation(Naturalist.MOD_ID, "geo/entity/capybara.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Capybara entity) {
        return new ResourceLocation(Naturalist.MOD_ID, "textures/entity/capybara.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Capybara entity) {
        return new ResourceLocation(Naturalist.MOD_ID, "animations/capybara.rp_anim.json");
    }

    @Override
    public void setCustomAnimations(Capybara entity, long instanceId, AnimationState<Capybara> animationState) {
        super.setCustomAnimations(entity, instanceId, animationState);

        if (animationState == null) return;

        EntityModelData extraDataOfType = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
        CoreGeoBone head = this.getAnimationProcessor().getBone("head");

        if (entity.isBaby()) {
            head.setScaleX(1.4F);
            head.setScaleY(1.4F);
            head.setScaleZ(1.4F);
        } else {
            head.setScaleX(1.0F);
            head.setScaleY(1.0F);
            head.setScaleZ(1.0F);
        }
        head.setRotX(extraDataOfType.headPitch() * Mth.DEG_TO_RAD);
        head.setRotY(extraDataOfType.netHeadYaw() * Mth.DEG_TO_RAD);
    }
}
