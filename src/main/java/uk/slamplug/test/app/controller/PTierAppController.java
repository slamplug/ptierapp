package uk.slamplug.test.app.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.slamplug.test.app.model.CustomerDetails;
import uk.slamplug.test.app.rest.PTierAppConnector;

@Controller
@SuppressWarnings("UnusedDeclaration")
@RequestMapping("/ui")
public class PTierAppController {
    private static final Logger logger = LoggerFactory.getLogger(PTierAppController.class);

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String getCustomerDetails(@PathVariable("id") long id) throws IOException {
        logger.info("getCustomerDetails, id {" + id + "}");
        CustomerDetails customerDetails = new PTierAppConnector().getCustomerDetails(id);
        logger.info("Got CustomerDetails [" + customerDetails.toString() + "] from app tier");
        return new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(customerDetails);
    }
}
