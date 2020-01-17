package gov.nih.cit.itasng.rest;

import com.fasterxml.jackson.core.JsonParseException;
import javax.ws.rs.ext.Provider;

// @formatter:off
/**
 * Custom error report on JsonParseException in reading JSON requests. A mapper class must be
 * created per each exception type because the more specific mapper always gets invoked.<br>
 * See <a href="https://stackoverflow.com/questions/43599955/how-to-customize-error-response-when-deserializing-failed"
 * target="_blank">How to customize error response when deserializing failed</a>.
 */
// @formatter:on
@Provider
public class JsonParseExceptionMapper extends JaxRsRequestErrorMapper<JsonParseException> {

}