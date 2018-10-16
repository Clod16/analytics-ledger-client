package model;

public class EdgeGateways {
    private String egid;
    private String payload;


    public EdgeGateways(String egid, String payload) {
        this.egid = egid;
        this.payload = payload;
    }

    public String getEgid() {
        return egid;
    }

    public void setEgid(String egid) {
        this.egid = egid;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }
}
