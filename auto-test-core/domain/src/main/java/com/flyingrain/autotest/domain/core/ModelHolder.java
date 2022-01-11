package com.flyingrain.autotest.domain.core;

import com.flyingrain.autotest.domain.model.Case;
import com.flyingrain.autotest.domain.model.Module;
import com.flyingrain.autotest.domain.model.Project;
import com.flyingrain.autotest.domain.model.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wally
 * @date 2021-12-08
 */
@Component
public class ModelHolder {

    private static final Logger logger = LoggerFactory.getLogger(ModelHolder.class);

    private final Map<Long, Project> projectMap = new ConcurrentHashMap<>(8);

    private final Map<Long, Module> moduleMap = new ConcurrentHashMap<>(8);

    private final Map<Long, Service> serviceMap = new ConcurrentHashMap<>(8);

    private final Map<Long, Case> caseMap = new ConcurrentHashMap<>(16);

    public Project addIfAbsentProject(Project project) {
        if (project == null) {
            logger.warn("project is null!");
            return null;
        }
        return projectMap.putIfAbsent(project.getId(), project);
    }

    public void swapIfExistProject(Project project) {
        if (project == null) {
            logger.warn("project is null!");
            return;
        }
        projectMap.put(project.getId(), project);
    }

    public void swapIfExistModule(Module module) {
        if (module == null) {
            logger.warn("module is null!");
            return;
        }
        moduleMap.put(module.getId(), module);
    }

    public void swapIfExistService(Service service) {
        if (service == null) {
            logger.warn("service is null!");
            return;
        }
        serviceMap.put(service.getId(), service);

    }

    public Project getProjectById(long projectId) {
        return projectMap.get(projectId);
    }

    public Module getModuleById(long moduleId) {
        return moduleMap.get(moduleId);
    }

    public Module addIfAbsentModule(Module module) {
        if (module == null) {
            logger.warn("module is null!");
            return null;
        }
        return moduleMap.putIfAbsent(module.getId(), module);
    }

    public Service getServiceById(long serviceId) {
        return serviceMap.get(serviceId);
    }

    public Service addServiceIfAbsent(Service service) {
        if (service == null) {
            logger.warn("service is null");
            return null;
        }
        return serviceMap.putIfAbsent(service.getId(), service);
    }

    public List<Module> getProjectModules(long projectId) {
        List<Module> modules = new ArrayList<>();
        moduleMap.forEach((k, v) -> {
            if (v.getProjectId() == projectId) {
                modules.add(v);
            }
        });
        return modules;
    }

    public List<Service> getModuleServices(long moduleId) {
        List<Service> services = new ArrayList<>();
        serviceMap.forEach((k, v) -> {
            if (v.getModuleId() == moduleId) {
                services.add(v);
            }
        });
        return services;
    }

}
