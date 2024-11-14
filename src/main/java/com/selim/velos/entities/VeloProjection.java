package com.selim.velos.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "modelVel", types = { Velo.class })
public interface VeloProjection {
    public String getModelVelo();
}
