package com.starfish_studios.naturalist.client.model;

import com.starfish_studios.naturalist.Naturalist;
import com.starfish_studios.naturalist.common.entity.Toucan;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

@Environment(EnvType.CLIENT)
public class ToucanModel extends GeoModel<Toucan> {
    @Override
    public ResourceLocation getModelResource(Toucan toucan) {
        return new ResourceLocation(Naturalist.MOD_ID, "geo/entity/toucan.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Toucan toucan) {
        if (toucan.getVariant().getName().equals("keel_billed")) {
            return new ResourceLocation(Naturalist.MOD_ID, "textures/entity/toucan/keel_billed.png");
        } else if (toucan.getVariant().getName().equals("choco")) {
            return new ResourceLocation(Naturalist.MOD_ID, "textures/entity/toucan/choco.png");
        } else {
            return new ResourceLocation(Naturalist.MOD_ID, "textures/entity/toucan/toucan.png");
        }
    }


    @Override
    public ResourceLocation getAnimationResource(Toucan toucan) {
        return new ResourceLocation(Naturalist.MOD_ID, "animations/toucan.animation.json");
    }
}
