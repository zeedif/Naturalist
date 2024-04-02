package com.starfish_studios.naturalist.client.model;

import com.starfish_studios.naturalist.Naturalist;
import com.starfish_studios.naturalist.common.entity.Crab;
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
public class CrabModel extends GeoModel<Crab> {
    @Override
    public ResourceLocation getModelResource(Crab entity) {
        return new ResourceLocation(Naturalist.MOD_ID, "geo/entity/crab.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Crab entity) {
        return new ResourceLocation(Naturalist.MOD_ID, "textures/entity/crab/red.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Crab entity) {
        return new ResourceLocation(Naturalist.MOD_ID, "animations/crab.rp_anim.json");
    }

    @Override
    public void setCustomAnimations(Crab entity, long instanceId, AnimationState<Crab> animationState) {
        super.setCustomAnimations(entity, instanceId, animationState);

        if (animationState == null) return;

        EntityModelData extraDataOfType = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
        CoreGeoBone left_eye = this.getAnimationProcessor().getBone("left_eye");
        CoreGeoBone right_eye = this.getAnimationProcessor().getBone("right_eye");

//        left_eye.setRotZ(extraDataOfType.headPitch() * Mth.DEG_TO_RAD);
//        left_eye.setRotY(extraDataOfType.netHeadYaw() * Mth.DEG_TO_RAD);
//        right_eye.setRotX(extraDataOfType.headPitch() * Mth.DEG_TO_RAD);
//        right_eye.setRotZ(extraDataOfType.netHeadYaw() * Mth.DEG_TO_RAD);
    }
}
