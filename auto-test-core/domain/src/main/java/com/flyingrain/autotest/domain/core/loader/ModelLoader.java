package com.flyingrain.autotest.domain.core.loader;

import com.flyingrain.autotest.domain.model.Case;
import com.flyingrain.autotest.domain.model.Model;
import com.flyingrain.autotest.facade.intf.requests.ModelTypeEnum;

import java.util.List;

/**
 * @author wally
 * @date 2021-12-08
 */
public interface ModelLoader<T extends Model> {

    T loadModel(long modelId);

    void unloadModel(long modelId);

    void loadModel(T model);

    List<Case> loadAllCases(T model);

    ModelTypeEnum loadType();
}
