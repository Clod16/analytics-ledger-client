package model;

import java.util.ArrayList;
import java.util.Collection;

public class DataSources {
    private String id;
    private String payload;
    private Collection<EdgeGateways> edgeGatewaysCollection;

    public DataSources(String id, String payload, Collection<EdgeGateways> edgeGatewaysCollection) {
        this.id = id;
        this.payload = payload;
        this.edgeGatewaysCollection = new ArrayList<>();
    }

    public Collection<EdgeGateways> getEdgeGatewaysCollection() {
        return edgeGatewaysCollection;
    }

    public void setEdgeGatewaysCollection(Collection<EdgeGateways> edgeGatewaysCollection) {
        this.edgeGatewaysCollection = edgeGatewaysCollection;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }


}
