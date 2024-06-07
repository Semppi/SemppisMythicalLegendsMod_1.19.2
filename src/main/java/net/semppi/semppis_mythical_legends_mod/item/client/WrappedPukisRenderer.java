package net.semppi.semppis_mythical_legends_mod.item.client;

import net.semppi.semppis_mythical_legends_mod.item.custom.WrappedPukis;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class WrappedPukisRenderer extends GeoItemRenderer<WrappedPukis> {
    public WrappedPukisRenderer() {
        super(new WrappedPukisModel());
    }
}
