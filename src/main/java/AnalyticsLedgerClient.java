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
    String createAnalyticsInstances(String id, String payload, String egid) throws JLedgerClientException;
    void  updateAnalyticsInstances(AnalyticsInstances analyticsInstances) throws JLedgerClientException;
    void  updateAnalyticsInstances(String id, String payload, String egid) throws JLedgerClientException;
    void delateAnalyticsInstances(String id, String egid) throws JLedgerClientException;
    AnalyticsInstances getAnalyticsInstancesById(String id) throws JLedgerClientException;
    AnalyticsInstances getAnalyticsInstancesByIdByEgid(String id, String egid) throws JLedgerClientException;
    Collection<AnalyticsInstances> getAnalyticsInstances() throws JLedgerClientException;

    String createDataSources(DataSources dataSources) throws JLedgerClientException;
    String createDataSources(String id, String payload, String egid) throws JLedgerClientException;
    void updateDataSources(DataSources dataSources) throws JLedgerClientException;
    void updateDataSources(String id, String payload, String egid) throws JLedgerClientException;
    void deleteDataSources(String id, String egid) throws JLedgerClientException;
    Collection<DataSources> getDataSources() throws JLedgerClientException;
    DataSources getDataSourcesbyId( String id) throws JLedgerClientException;
    DataSources getDataSourcesbyIdByEgid( String id, String egid) throws JLedgerClientException;

    String createEdgeGateways(EdgeGateways edgeGateways) ;
    String createEdgeGateways(String id, String payload, String egid);
    void updateEdgeGateways(EdgeGateways edgeGateways);
    void updateEdgeGateways(String egid, String payload);
    Collection<EdgeGateways> getEdgeGateways() ;
    EdgeGateways getEdgeGatewaysByEgid(String egid);
    void deleteEdgeGateways(String egid);

}