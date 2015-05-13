package com.mcworkshop.dongjing.web.api.resource;

import java.util.UUID;

/**
 * Created by markfredchen on 3/27/15.
 */
public class IdResource {
    private UUID id;

    public IdResource(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
