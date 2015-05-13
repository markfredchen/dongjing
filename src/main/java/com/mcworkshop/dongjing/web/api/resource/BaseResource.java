package com.mcworkshop.dongjing.web.api.resource;


import com.mcworkshop.dongjing.domain.BaseEntity;

/**
 * Created by markfredchen on 3/6/15.
 */
abstract public class BaseResource {

    abstract public <T extends BaseEntity> T toEntity();
}
