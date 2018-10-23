package model;

import java.util.ArrayList;
import java.util.Collection;

public class DataSources {
    private String id;
    private String payload;
    private Collection<EdgeGateways> edgeGatewaysCollection;
    private String egid;

    public DataSources(String id, String payload, Collection<EdgeGateways> edgeGatewaysCollection, String egid)  {
        this.id = id;
        this.payload = payload;
        this.edgeGatewaysCollection = new ArrayList<>();
        this.egid = egid;
    }

    public Collection<EdgeGateways> getEdgeGatewaysCollection() {
        return edgeGatewaysCollection;
    }

    public void setEdgeGatewaysCollection(Collection<EdgeGateways> edgeGatewaysCollection) {
        this.edgeGatewaysCollection = edgeGatewaysCollection;
    }

    public String getEgid() {
        return egid;
    }

    public void setEgid(String egid) {
        this.egid = egid;
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
