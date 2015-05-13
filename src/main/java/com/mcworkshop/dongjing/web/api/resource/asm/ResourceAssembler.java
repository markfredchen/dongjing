package com.mcworkshop.dongjing.web.api.resource.asm;

import com.mcworkshop.dongjing.domain.BaseEntity;
import com.mcworkshop.dongjing.web.api.resource.BaseResource;

/**
 * Created by markfredchen on 4/10/15.
 */
public interface ResourceAssembler<T extends BaseResource, V extends BaseEntity> {
    T toResource(V entity);
}
