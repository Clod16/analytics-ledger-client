import it.eng.jledgerclient.exception.JLedgerClientException;
import model.AnalyticsInstances;
import model.DataSources;
import model.EdgeGateways;

import java.util.Collection;

/**
 * @author clod16
 */

public interface AnalyticsLedgerClient {

    String createAnalyticsInstances(AnalyticsInstances analyticsInstances) throws JLedgerClientException;
    void  updateAnalyticsInstances(String id, String egid) throws JLedgerClientException;
    void delateAnalyticsInstances(String id, String egid) throws JLedgerClientException;
    AnalyticsInstances getAnalyticsInstancesById(String id) throws JLedgerClientException;
    AnalyticsInstances getAnalyticsInstancesByIdByEgid(String id, String egid) throws JLedgerClientException;
    Collection<AnalyticsInstances> getAnalyticsInstances() throws JLedgerClientException;

    String createDataSources(DataSources dataSources) throws JLedgerClientException;
    void deleteDataSources(String id, String egid) throws JLedgerClientException;
    Collection<DataSources> getDataSources() throws JLedgerClientException;
    DataSources getDataSourcesbyId( String id) throws JLedgerClientException;

    String createEdgeGateways(EdgeGateways edgeGateways) throws JLedgerClientException;
    void updateEdgeGateways(String egid) throws JLedgerClientException;
    Collection<EdgeGateways> getEdgeGateways() throws JLedgerClientException;
    EdgeGateways getEdgeGatewaysByEgid(String egid) throws JLedgerClientException;

}
