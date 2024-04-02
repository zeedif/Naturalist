package com.starfish_studios.naturalist.client.model;

import com.starfish_studios.naturalist.Naturalist;
import com.starfish_studios.naturalist.common.entity.Moose;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.item.Items;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

@Environment(EnvType.CLIENT)
public class MooseModel extends GeoModel<Moose> {
    @Override
    public ResourceLocation getModelResource(Moose entity) {
        return new ResourceLocation(Naturalist.MOD_ID, "geo/entity/moose.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Moose entity) {
        if (entity.isBaby()) {
            return new ResourceLocation(Naturalist.MOD_ID, "textures/entity/moose_baby.png");
        }
        return new ResourceLocation(Naturalist.MOD_ID, "textures/entity/moose.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Moose entity) {
        return new ResourceLocation(Naturalist.MOD_ID, "animations/moose.rp_anim.json");
    }

    @Override
    public void setCustomAnimations(Moose entity, long instanceId, AnimationState<Moose> animationState) {
        super.setCustomAnimations(entity, instanceId, animationState);

        if (animationState == null) return;

        EntityModelData extraDataOfType = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
        CoreGeoBone head = this.getAnimationProcessor().getBone("head");
        CoreGeoBone leftAntler = this.getAnimationProcessor().getBone("leftAntler");
        CoreGeoBone rightAntler = this.getAnimationProcessor().getBone("rightAntler");
        CoreGeoBone bell = this.getAnimationProcessor().getBone("bell");

        if (entity.isBaby()) {
            head.setScaleX(1.6F);
            head.setScaleY(1.6F);
            head.setScaleZ(1.6F);
            leftAntler.setHidden(true);
            rightAntler.setHidden(true);
            bell.setHidden(true);
        } else {
            head.setScaleX(1.0F);
            head.setScaleY(1.0F);
            head.setScaleZ(1.0F);
            leftAntler.setHidden(false);
            rightAntler.setHidden(false);
            bell.setHidden(false);
        }

        head.setRotX(extraDataOfType.headPitch() * Mth.DEG_TO_RAD);
        head.setRotY(extraDataOfType.netHeadYaw() * Mth.DEG_TO_RAD);
    }
}
