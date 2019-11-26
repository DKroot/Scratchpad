package gov.nih.cit.itasng.rest;

import javax.annotation.Nullable;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.autoconfigure.jersey.ResourceConfigCustomizer;

/**
 * Miscellaneous REST helpers
 */
public abstract class RestResource implements ResourceConfigCustomizer {

  // All JAX-RS resources must be registered
  @Override
  public void customize(ResourceConfig config) {
    config.register(this.getClass());
  }

  /**
   * Generates Bad Request (400) for expected validation errors.
   *
   * @param customMessage message to include in the report
   * @param uriInfo (optional) original request URI info
   * @return Bad Request (400) with {@link BadRequestResponse}
   * @see BadRequestResponse
   */
  Response badRequestResponse(String customMessage, @Nullable UriInfo uriInfo, Object details) {
    return Response.status(Status.BAD_REQUEST) //
        .entity(new BadRequestResponse(customMessage, uriInfo, details)) //
        .build();
  }

  /**
   * Generates Conflict (409) when user confirmation is required
   *
   * @param customMessage message to include in the report
   * @return Conflict (409) {@link ConflictResponse}
   * @see ConflictResponse
   */
  Response conflictResponse(String customMessage, @Nullable UriInfo uriInfo) {
    return Response.status(Status.CONFLICT) //
        .entity(new ConflictResponse(customMessage, uriInfo)) //
        .build();
  }

  /*
   * Generates Bad Request (400) for expected validation errors.
   *
   * @param customMessage message to include in the report
   * @param uriInfo (optional) original request URI info
   * @param cause bad request cause
   * @return Bad Request (400) with {@link BadRequestResponse}
   * @see BadRequestResponse
   */
  /*protected Response badRequestResponse(String customMessage, @Nullable UriInfo uriInfo,
      @Nonnull Throwable cause) {
    return Response.status(Status.BAD_REQUEST) //
        .entity(new BadRequestResponse(customMessage, uriInfo, cause)) //
        .build();
  }*/

  /*default Response cacheableResponse(ResponseBuilder rb, LocalDateTime responseTimestamp)
      throws URISyntaxException {
    rb.lastModified(DateTimeUtils.toJavaUtilDate(responseTimestamp));
    *//*
    Correct default legacy "Expires: 0" header lest developers get confused. When both
    Cache-Control and Expires are present, Cache-Control takes precedence.
    *//*
    rb.expires(
        DateTimeUtils.toJavaUtilDate(responseTimestamp.plusSeconds(DEFAULT_CACHE_AGE_IN_SECONDS)));

    *//*
    Majority of caches ignore "Pragma: no-cache" response header.
    See https://www.mnot.net/cache_docs/#PRAGMA
    *//*
    // Suppress default "Pragma: no-cache" header.
    //rb.header("Pragma", null);

    *//*
    The new instance will have the following default settings:
    * private = false
    * noCache = false
    * noStore = false
    * noTransform = true
    * mustRevalidate = false
    * proxyRevalidate = false
    * An empty list of private fields
    * An empty list of no-cache fields
    * An empty map of cache extensions
    *//*
    CacheControl cc = new CacheControl();

    *//*
    The browser can cache "private" responses. However, these responses are typically intended
    for a single user, so an intermediate cache is not allowed to cache them. For example, a
    user's browser can cache an HTML page with private user information, but a CDN can't cache
    the page.
    *//*
    cc.setPrivate(true);
    cc.setMaxAge(DEFAULT_CACHE_AGE_IN_SECONDS);

    return rb.cacheControl(cc).build();
  }*/

  /*default Response uncacheableResponse(ResponseBuilder rb) {
   *//*
    The new instance will have the following default settings:
    * private = false
    * noCache = false
    * noStore = false
    * noTransform = true
    * mustRevalidate = false
    * proxyRevalidate = false
    * An empty list of private fields
    * An empty list of no-cache fields
    * An empty map of cache extensions
    *//*
    CacheControl cc = new CacheControl();
    cc.setNoStore(true);

    return rb.cacheControl(cc).build();
  }*/
}
