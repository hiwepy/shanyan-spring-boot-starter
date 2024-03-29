package com.shanyan.spring.boot;

import java.net.ProxySelector;
import java.net.Socket;
import java.time.Duration;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;
import okhttp3.ConnectionPool;
import okhttp3.Response;
import okhttp3.WebSocketListener;
import okio.Source;

@ConfigurationProperties(FlashMobileOkHttp3Properties.PREFIX)
@Data
public class FlashMobileOkHttp3Properties {

	public static final String PREFIX = "shanyan.okhttp3";


	/**
     * Configure this client to follow redirects from HTTPS to HTTP and from HTTP to HTTPS.
     *
     * <p>If unset, protocol redirects will be followed. This is different than the built-in {@code
     * HttpURLConnection}'s default.
     */
	private boolean followSslRedirects;
	
	/** 
	 * Configure this client to follow redirects. If unset, redirects will be followed.
	 */
	private boolean followRedirects;
	
	/**
     * Configure this client to retry or not when a connectivity problem is encountered. By default,
     * this client silently recovers from the following problems:
     *
     * <ul>
     *   <li><strong>Unreachable IP addresses.</strong> If the URL's host has multiple IP addresses,
     *       failure to reach any individual IP address doesn't fail the overall request. This can
     *       increase availability of multi-homed services.
     *   <li><strong>Stale pooled connections.</strong> The {@link ConnectionPool} reuses sockets
     *       to decrease request latency, but these connections will occasionally time out.
     *   <li><strong>Unreachable proxy servers.</strong> A {@link ProxySelector} can be used to
     *       attempt multiple proxy servers in sequence, eventually falling back to a direct
     *       connection.
     * </ul>
     *
     * Set this to false to avoid retrying requests when doing so is destructive. In this case the
     * calling application should do its own recovery of connectivity failures.
     */
	private boolean retryOnConnectionFailure;

	/*
     * Sets the default timeout for complete calls. A value of 0 means no timeout, otherwise values
     * must be between 1 and {@link Integer#MAX_VALUE} when converted to milliseconds.
     *
     * <p>The call timeout spans the entire call: resolving DNS, connecting, writing the request
     * body, server processing, and reading the response body. If the call requires redirects or
     * retries all must complete within one timeout period.
     *
     * <p>The default value is 0 which imposes no timeout.
     */
	private int callTimeout;
	
	 /*
     * Sets the default connect timeout for new connections. A value of 0 means no timeout,
     * otherwise values must be between 1 and {@link Integer#MAX_VALUE} when converted to
     * milliseconds.
     *
     * <p>The connectTimeout is applied when connecting a TCP socket to the target host.
     * The default value is 10 seconds.
     */
	private int connectTimeout = 10;
	
	/**
     * Sets the default read timeout for new connections. A value of 0 means no timeout, otherwise
     * values must be between 1 and {@link Integer#MAX_VALUE} when converted to milliseconds.
     *
     * <p>The read timeout is applied to both the TCP socket and for individual read IO operations
     * including on {@link Source} of the {@link Response}. The default value is 10 seconds.
     *
     * @see Socket#setSoTimeout(int)
     * @see Source#timeout()
     */
	private int readTimeout = 10;
	
	 /**
     * Sets the default write timeout for new connections. A value of 0 means no timeout, otherwise
     * values must be between 1 and {@link Integer#MAX_VALUE} when converted to milliseconds.
     *
     * <p>The write timeout is applied for individual write IO operations.
     * The default value is 10 seconds.
     *
     */
	private int writeTimeout = 10;
	
	/**
     * Sets the interval between HTTP/2 and web socket pings initiated by this client. Use this to
     * automatically send ping frames until either the connection fails or it is closed. This keeps
     * the connection alive and may detect connectivity failures.
     *
     * <p>If the server does not respond to each ping with a pong within {@code interval}, this
     * client will assume that connectivity has been lost. When this happens on a web socket the
     * connection is canceled and its listener is {@linkplain WebSocketListener#onFailure notified
     * of the failure}. When it happens on an HTTP/2 connection the connection is closed and any
     * calls it is carrying {@linkplain java.io.IOException will fail with an IOException}.
     *
     * <p>The default value of 0 disables client-initiated pings.
     */
	private int pingInterval = 0;
	
	/** 
	 * The maximum number of idle connections for each address. 
	 */
	private int maxIdleConnections = 200;
	
	/** 
	 * keep alive Duration. The default value is 30000 seconds. 
	 */
	private Duration keepAliveDuration = Duration.ofSeconds(30000);
	
}