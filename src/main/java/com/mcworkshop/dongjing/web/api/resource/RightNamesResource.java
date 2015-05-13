package com.mcworkshop.dongjing.web.api.resource;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by markfredchen on 3/28/15.
 */
public class RightNamesResource {

    private List<String> rightNames = new ArrayList<>();

    public List<String> getRightNames() {
        return rightNames;
    }

    public void setRightNames(List<String> rightNames) {
        this.rightNames = rightNames;
    }
}
