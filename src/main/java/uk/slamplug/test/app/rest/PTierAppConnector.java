package uk.slamplug.test.app.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;
import uk.slamplug.test.app.model.CustomerDetails;

import java.io.IOException;

public class PTierAppConnector {

    private static final Logger logger = LoggerFactory.getLogger(PTierAppConnector.class);

    public CustomerDetails getCustomerDetails(final long id) throws IOException {
        logger.info("getCustomerDetails(), id {" + id + "}");
        final String url = buildUrl(id);
        logger.info("getCustomerDetails(), url {" + url + "}");
        return new RestTemplate().getForObject(url, CustomerDetails.class);
    }

    private String buildUrl(final long id) {
        return getBackendUrl() + "/app/customer/" + id;
    }

    private String getBackendUrl() {
        return "http://" + getEnvValueOrdefault("app.host", "192.168.56.20") + ":" + getEnvValueOrdefault("app.port", "9400");
    }

    private String getEnvValueOrdefault(final String envKey, final String defaultValue) {
        logger.info("getEnvValueOrdefault(), envKey {" + envKey + "}");
        return (!isEmptyString(System.getenv(envKey))) ? System.getenv(envKey) : defaultValue;
    }

    private boolean isEmptyString(final String in) {
        return ((in == null) || in.isEmpty());
    }
}
