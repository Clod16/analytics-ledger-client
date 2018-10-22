package model;

import java.util.ArrayList;
import java.util.Collection;

public class AnalyticsInstances {
    private String id;
    private String payload;
    private Collection<EdgeGateways> edgeGatewaysArrayList;

    public AnalyticsInstances(String id, String payload, Collection<EdgeGateways> edgeGatewaysArrayList) {
        this.id = id;
        this.payload = payload;
        this.edgeGatewaysArrayList = new ArrayList<>();
    }

    public Collection<EdgeGateways> getEdgeGatewaysArrayList() {
        return edgeGatewaysArrayList;
    }

    public void setEdgeGatewaysArrayList(Collection<EdgeGateways> edgeGatewaysArrayList) {
        this.edgeGatewaysArrayList = edgeGatewaysArrayList;
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
