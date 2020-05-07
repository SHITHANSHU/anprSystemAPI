package io.dropwizard.api;

import java.util.UUID;

public class session {
    private  String id;
    private  String accessToken;
    private int type;
    public session(String id) {
        this.id = id;
        this.accessToken = UUID.randomUUID().toString().substring(0,23);
    }
    public session(String id,String accessToken,int type ) {
        this.id = id;
        this.accessToken = accessToken;
        this.type=type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
