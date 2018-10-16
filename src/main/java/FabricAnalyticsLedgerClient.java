import it.eng.jledgerclient.exception.JLedgerClientException;
import model.AnalyticsInstances;
import model.DataSources;
import model.EdgeGateways;

import java.util.Collection;

public class FabricAnalyticsLedgerClient implements AnalyticsLedgerClient {


    @Override
    public String createAnalyticsInstances(AnalyticsInstances analyticsInstances) throws JLedgerClientException {
        return null;
    }

    @Override
    public void updateAnalyticsInstances(String id, String egid) throws JLedgerClientException {

    }

    @Override
    public void delateAnalyticsInstances(String id, String egid) throws JLedgerClientException {

    }

    @Override
    public AnalyticsInstances getAnalyticsInstancesById(String id) throws JLedgerClientException {
        return null;
    }

    @Override
    public AnalyticsInstances getAnalyticsInstancesByIdByEgid(String id, String egid) throws JLedgerClientException {
        return null;
    }

    @Override
    public Collection<AnalyticsInstances> getAnalyticsInstances() throws JLedgerClientException {
        return null;
    }

    @Override
    public String createDataSources(DataSources dataSources) throws JLedgerClientException {
        return null;
    }

    @Override
    public void deleteDataSources(String id, String egid) throws JLedgerClientException {

    }

    @Override
    public Collection<DataSources> getDataSources() throws JLedgerClientException {
        return null;
    }

    @Override
    public DataSources getDataSourcesbyId(String id) throws JLedgerClientException {
        return null;
    }

    @Override
    public String createEdgeGateways(EdgeGateways edgeGateways) throws JLedgerClientException {
        return null;
    }

    @Override
    public void updateEdgeGateways(String egid) throws JLedgerClientException {

    }

    @Override
    public Collection<EdgeGateways> getEdgeGateways() throws JLedgerClientException {
        return null;
    }

    @Override
    public EdgeGateways getEdgeGatewaysByEgid(String egid) throws JLedgerClientException {
        return null;
    }
}
