package com.starfish_studios.naturalist.client.model;

import com.starfish_studios.naturalist.Naturalist;
import com.starfish_studios.naturalist.common.entity.EmperorPenguin;
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
public class EmperorPenguinModel extends GeoModel<EmperorPenguin> {
    @Override
    public ResourceLocation getModelResource(EmperorPenguin entity) {
        return new ResourceLocation(Naturalist.MOD_ID, "geo/entity/emperor_penguin.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EmperorPenguin entity) {
        if (entity.isBaby()) {
            return new ResourceLocation(Naturalist.MOD_ID, "textures/entity/emperor_penguin/baby.png");
        } else {
            return new ResourceLocation(Naturalist.MOD_ID, "textures/entity/emperor_penguin/emperor_penguin.png");
        }
    }

    @Override
    public ResourceLocation getAnimationResource(EmperorPenguin entity) {
        return new ResourceLocation(Naturalist.MOD_ID, "animations/emperor_penguin.rp_anim.json");
    }

    @Override
    public void setCustomAnimations(EmperorPenguin entity, long instanceId, AnimationState<EmperorPenguin> animationState) {
        super.setCustomAnimations(entity, instanceId, animationState);

        if (animationState == null) return;

        EntityModelData extraDataOfType = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
        CoreGeoBone head = this.getAnimationProcessor().getBone("head");

        head.setRotX(extraDataOfType.headPitch() * Mth.DEG_TO_RAD);
        head.setRotY(extraDataOfType.netHeadYaw() * Mth.DEG_TO_RAD);
    }
}
