import it.eng.jledgerclient.exception.JLedgerClientException;
import it.eng.jledgerclient.fabric.HLFLedgerClient;
import it.eng.jledgerclient.fabric.config.ConfigManager;
import it.eng.jledgerclient.fabric.config.Configuration;
import it.eng.jledgerclient.fabric.config.Organization;
import it.eng.jledgerclient.fabric.helper.LedgerInteractionHelper;
import it.eng.jledgerclient.fabric.utils.JsonConverter;
import model.AnalyticsInstances;
import model.DataSources;
import model.EdgeGateways;
import model.Function;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hyperledger.fabric.sdk.ChaincodeEventListener;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FabricAnalyticsLedgerClient extends HLFLedgerClient implements AnalyticsLedgerClient {

    private final static Logger log = LogManager.getLogger(FabricAnalyticsLedgerClient.class);

    public FabricAnalyticsLedgerClient() throws JLedgerClientException {
        doLedgerClient();
    }

    private void doLedgerClient() throws JLedgerClientException {
        try {
            configManager = ConfigManager.getInstance();
            Configuration configuration = configManager.getConfiguration();
            if (null == configuration || null == configuration.getOrganizations() || configuration.getOrganizations().isEmpty()) {
                log.error("Configuration missing!!! Check you config file!!!");
                throw new JLedgerClientException("Configuration missing!!! Check you config file!!!");
            }
            List<Organization> organizations = configuration.getOrganizations();
            if (null == organizations || organizations.isEmpty())
                throw new JLedgerClientException("Organizations missing!!! Check you config file!!!");
            //for (Organization org : organizations) {
            //FIXME multiple Organizations
            ledgerInteractionHelper = new LedgerInteractionHelper(configManager, organizations.get(0));
            //}
        } catch (Exception e) {
            log.error(e);
            throw new JLedgerClientException(e);
        }
    }

    @Override
    public String doRegisterEvent(String eventName, ChaincodeEventListener chaincodeEventListener) throws JLedgerClientException {
        return super.doRegisterEvent(eventName, chaincodeEventListener);
    }


    @Override
    public String createAnalyticsInstances(AnalyticsInstances analyticsInstances) throws JLedgerClientException {
        if (analyticsInstances == null) {
            throw new JLedgerClientException(Function.createAnalyticsInstances.name() + "... no input data!");
        }
        List<String> args = new ArrayList<>();
        args.add(JsonConverter.convertToJson(analyticsInstances));
        final String returns = doInvoke(Function.createAnalyticsInstances.name(), args);
        log.debug("Payload retrieved: " + returns);
        return returns;
    }

    @Override
    public String createAnalyticsInstances(String id, String payload, String egid) throws JLedgerClientException {
        if (id.isEmpty() || egid.isEmpty() || payload.isEmpty()) {
            throw new JLedgerClientException(Function.createAnalyticsInstances.name() + "... some input are empty");
        }
        List<String> args = new ArrayList<>();
        args.add(id);
        args.add(payload);
        args.add(egid);
        final String ret = doInvoke(Function.createAnalyticsInstances.name(), args);
        log.debug("Payload retrieved: " + ret);
        return ret;
    }

    @Override
    public void updateAnalyticsInstances(AnalyticsInstances analyticsInstances) throws JLedgerClientException {
        if (analyticsInstances == null) {
            throw new JLedgerClientException(Function.updateAnalyticsInstances.name() + "... no imput data!");
        }
        List<String> args = new ArrayList<>();
        args.add(JsonConverter.convertToJson(analyticsInstances));
        final String ret = doInvoke(Function.updateAnalyticsInstances.name(), args);
        log.debug("Payload retrieved: " + ret);

    }

    @Override
    public void updateAnalyticsInstances(String id, String payload, String egid) throws JLedgerClientException {
        if (id.isEmpty() || egid.isEmpty() || payload.isEmpty()) {
            throw new JLedgerClientException(Function.updateAnalyticsInstances.name() + "... some input are empty");
        }
        List<String> args = new ArrayList<>();
        args.add(id);
        args.add(payload);
        args.add(egid);
        final String ret = doInvoke(Function.updateAnalyticsInstances.name(), args);
        log.debug("Payload retrieved: " + ret);

    }

    @Override
    public void delateAnalyticsInstances(String id, String egid) throws JLedgerClientException {
        if (id.isEmpty() || egid.isEmpty()) {
            throw new JLedgerClientException(Function.delateAnalyticsInstances.name() + " argument empty...");
        }
        List<String> args = new ArrayList<>();
        args.add(id);
        args.add(egid);
        final String ret = doInvoke(Function.delateAnalyticsInstances.name(), args);
        log.debug("Payload retrieved: " + ret);

    }

    @Override
    public AnalyticsInstances getAnalyticsInstancesById(String id) throws JLedgerClientException {
        if (id.isEmpty()) {
            throw new JLedgerClientException(Function.getAnalyticsInstancesById.name() + "... some input are empty");
        }
        List<String> args = new ArrayList<>();
        args.add(id);
        final String ret = doInvoke(Function.getAnalyticsInstancesById.name(), args);
        log.debug("Payload retrieved: " + ret);
        return (AnalyticsInstances) JsonConverter.convertFromJson(ret, AnalyticsInstances.class, false);
    }

    @Override
    public AnalyticsInstances getAnalyticsInstancesByIdByEgid(String id, String egid) throws JLedgerClientException {
        if (id.isEmpty() || egid.isEmpty()) {
            throw new JLedgerClientException(Function.getAnalyticsInstancesByIdByEgid.name() + "... some input are empty");
        }
        List<String> args = new ArrayList<>();
        args.add(id);
        args.add(egid);
        final String ret = doInvoke(Function.getAnalyticsInstancesByIdByEgid.name(), args);
        log.debug("Payload retrieved: " + ret);
        return (AnalyticsInstances) JsonConverter.convertFromJson(ret, AnalyticsInstances.class, false);
    }

    @Override
    public Collection<AnalyticsInstances> getAnalyticsInstances() throws JLedgerClientException {
        List<String> args = new ArrayList<>();
        final String ret = doInvoke(Function.getAnalyticsInstances.name(), args);
        log.debug("Payload retrieved: " + ret);
        return (Collection<AnalyticsInstances>) JsonConverter.convertFromJson(ret, AnalyticsInstances.class, true);
    }

    @Override
    public String createDataSources(DataSources dataSources) throws JLedgerClientException {
        if (dataSources == null) {
            throw new JLedgerClientException(Function.createDataSources.name() + "... no input data");
        }
        List<String> args = new ArrayList<>();
        args.add(JsonConverter.convertToJson(dataSources));
        final String ret = doInvoke(Function.createDataSources.name(), args);
        log.debug("Payload retrieved: " + ret);
        return ret;
    }

    @Override
    public String createDataSources(String id, String payload, String egid) throws JLedgerClientException {
        if (id.isEmpty() || egid.isEmpty() || payload.isEmpty()) {
            throw new JLedgerClientException(Function.createDataSources.name() + "... some input are empty");
        }
        List<String> args = new ArrayList<>();
        args.add(id);
        args.add(payload);
        args.add(egid);
        final String ret = doInvoke(Function.createDataSources.name(), args);
        log.debug("Payload retrieved: " + ret);
        return ret;
    }

    @Override
    public void updateDataSources(DataSources dataSources) throws JLedgerClientException {
        if (dataSources == null) {
            throw new JLedgerClientException(Function.updateDataSources.name() + "... no input data");
        }
        List<String> args = new ArrayList<>();
        args.add(JsonConverter.convertToJson(dataSources));
        final String ret = doInvoke(Function.createDataSources.name(), args);
        log.debug("Payload retrieved: " + ret);
    }

    @Override
    public void updateDataSources(String id, String payload, String egid) throws JLedgerClientException {
        if (id.isEmpty() || egid.isEmpty() || payload.isEmpty()) {
            throw new JLedgerClientException(Function.updateDataSources.name() + "... some input are empty");
        }
        List<String> args = new ArrayList<>();
        args.add(id);
        args.add(payload);
        args.add(egid);
        final String ret = doInvoke(Function.updateDataSources.name(), args);
        log.debug("Payload retrieved: " + ret);
    }

    @Override
    public void deleteDataSources(String id, String egid) throws JLedgerClientException {
        if (id.isEmpty() || egid.isEmpty()) {
            throw new JLedgerClientException(Function.deleteDataSources.name() + " argument empty...");
        }
        List<String> args = new ArrayList<>();
        args.add(id);
        args.add(egid);
        final String ret = doInvoke(Function.deleteDataSources.name(), args);
        log.debug("Payload retrieved: " + ret);
    }

    @Override
    public Collection<DataSources> getDataSources() throws JLedgerClientException {
        List<String> args = new ArrayList<>();
        final String ret = doInvoke(Function.getDataSources.name(), args);
        log.debug("Payload retrieved: " + ret);
        return (Collection<DataSources>) JsonConverter.convertFromJson(ret, DataSources.class, true);
    }

    @Override
    public DataSources getDataSourcesbyId(String id) throws JLedgerClientException {
        if (id.isEmpty()) {
            throw new JLedgerClientException(Function.getDataSourcesbyId.name() + "... some input are empty");
        }
        List<String> args = new ArrayList<>();
        args.add(id);
        final String ret = doInvoke(Function.getDataSourcesbyId.name(), args);
        log.debug("Payload retrieved: " + ret);
        return (DataSources) JsonConverter.convertFromJson(ret, DataSources.class, false);
    }

    @Override
    public DataSources getDataSourcesbyIdByEgid(String id, String egid) throws JLedgerClientException {
        if (id.isEmpty()) {
            throw new JLedgerClientException(Function.getDataSourcesbyIdByEgid.name() + "... some input are empty");
        }
        List<String> args = new ArrayList<>();
        args.add(id);
        final String ret = doInvoke(Function.getDataSourcesbyIdByEgid.name(), args);
        log.debug("Payload retrieved: " + ret);
        return (DataSources) JsonConverter.convertFromJson(ret, DataSources.class, false);    }

    @Override
    public String createEdgeGateways(EdgeGateways edgeGateways) {
        return null;
    }

    @Override
    public String createEdgeGateways(String id, String payload, String egid) {
        return null;
    }

    @Override
    public void updateEdgeGateways(EdgeGateways edgeGateways) {

    }

    @Override
    public void updateEdgeGateways(String egid, String payload) {

    }

    @Override
    public Collection<EdgeGateways> getEdgeGateways() {
        return null;
    }

    @Override
    public EdgeGateways getEdgeGatewaysByEgid(String egid) {
        return null;
    }

    @Override
    public void deleteEdgeGateways(String egid) {

    }
}
