package model;

public class AnalyticsInstances {
    private String id;
    private String payload;
    private EdgeGateways edgeGateways;

    public AnalyticsInstances(String id, String payload, EdgeGateways edgeGateways) {
        this.id = id;
        this.payload = payload;
        this.edgeGateways = edgeGateways;
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

    public EdgeGateways getEdgeGateways() {
        return edgeGateways;
    }

    public void setEdgeGateways(EdgeGateways edgeGateways) {
        this.edgeGateways = edgeGateways;
    }
}
