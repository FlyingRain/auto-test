package com.flyingrain.autotest.domain.core.loader;

import com.flyingrain.autotest.domain.model.Case;
import com.flyingrain.autotest.domain.model.Model;
import com.flyingrain.autotest.facade.intf.requests.ModelTypeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wally
 * @date 2021-12-13
 */
@Component
public class CommonModelLoader implements InitializingBean {

    private Logger logger = LoggerFactory.getLogger(CommonModelLoader.class);

    @Autowired
    private List<ModelLoader> modelLoaders;


    private final Map<String, ModelLoader> loaderMap = new HashMap<>();


    public <T> T loadModel(long modelId, ModelTypeEnum modelTypeEnum) {
        ModelLoader loader = getModelLoader(modelTypeEnum);
        if (loader == null) return null;
        return (T) loader.loadModel(modelId);
    }

    private ModelLoader getModelLoader(ModelTypeEnum modelTypeEnum) {
        ModelLoader loader = loaderMap.get(modelTypeEnum.name());
        if (loader == null) {
            logger.error("no such loader!:[{}]", modelTypeEnum);
            return null;
        }
        return loader;
    }

    public List<Case> loadModelCases(Model model) {
        ModelTypeEnum modelTypeEnum = model.getModelType();
        ModelLoader loader = getModelLoader(modelTypeEnum);
        return loader.loadAllCases(model);
    }

    public void unloadModel(long modelId, ModelTypeEnum modelTypeEnum) {

    }


    @Override
    public void afterPropertiesSet() throws Exception {
        if (!CollectionUtils.isEmpty(modelLoaders)) {
            modelLoaders.forEach(loader -> {
                loaderMap.put(loader.loadType().name(), loader);
            });
        }
    }
}
