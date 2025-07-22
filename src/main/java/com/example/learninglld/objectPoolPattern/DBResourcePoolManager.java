package com.example.learninglld.objectPoolPattern;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBResourcePoolManager {
    private List<DBResource> freeResources = new ArrayList<>();
    private List<DBResource> inUseResources = new ArrayList<>();
    private Integer INITIAL_POOL_SIZE = 3;
    private Integer MAX_POOL_SIZE = 5;
    private static DBResourcePoolManager instance;

    private DBResourcePoolManager() {
        for(int i = 0; i < INITIAL_POOL_SIZE; i++) {
            freeResources.add(new DBResource());
        }
    }

    public static DBResourcePoolManager getInstance() {
        if(instance == null) {
            synchronized (DBResourcePoolManager.class) {
                if(instance == null) {
                    instance = new DBResourcePoolManager();
                }
            }
        }
        return instance;
    }

    public synchronized DBResource getDBResource() throws InterruptedException {
        if(freeResources.isEmpty() && inUseResources.size() < MAX_POOL_SIZE) {
            freeResources.add(new DBResource());
        }
        else if(freeResources.isEmpty() && inUseResources.size() >= MAX_POOL_SIZE) {
            System.out.println("Pool is full. Waiting for a resource to be released.");
            return null;
        }
        DBResource resource = freeResources.remove(freeResources.size() - 1);
        inUseResources.add(resource);
        return resource;
    }

    public synchronized void releaseDBResource(DBResource resource) {
        inUseResources.remove(resource);
        freeResources.add(resource);
    }
}
