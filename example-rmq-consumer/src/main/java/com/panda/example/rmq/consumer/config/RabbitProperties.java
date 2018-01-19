package com.panda.example.rmq.consumer.config;

import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Ssl;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.rabbitmq")
public class RabbitProperties {

	/**
	 * RabbitMQ host.
	 */
	private String host = "localhost";

	/**
	 * RabbitMQ port.
	 */
	private int port = 5672;

	/**
	 * Login user to authenticate to the broker.
	 */
	private String username;

	/**
	 * Login to authenticate against the broker.
	 */
	private String password;

	/**
	 * SSL configuration.
	 */
	private final Ssl ssl = new Ssl();

	/**
	 * Virtual host to use when connecting to the broker.
	 */
	private String virtualHost;

	/**
	 * Comma-separated list of addresses to which the client should connect.
	 */
	private String addresses;

	/**
	 * Requested heartbeat timeout, in seconds; zero for none.
	 */
	private Integer requestedHeartbeat;

	/**
	 * Enable publisher confirms.
	 */
	private boolean publisherConfirms;

	/**
	 * Enable publisher returns.
	 */
	private boolean publisherReturns;

	/**
	 * Connection timeout, in milliseconds; zero for infinite.
	 */
	private Integer connectionTimeout;


	public String getHost() {
		return this.host;
	}


	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return this.port;
	}


	public void setPort(int port) {
		this.port = port;
	}

	public String getAddresses() {
		return this.addresses;
	}


	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public Ssl getSsl() {
		return this.ssl;
	}

	public String getVirtualHost() {
		return this.virtualHost;
	}

	public void setVirtualHost(String virtualHost) {
		this.virtualHost = ("".equals(virtualHost) ? "/" : virtualHost);
	}

	public Integer getRequestedHeartbeat() {
		return this.requestedHeartbeat;
	}

	public void setRequestedHeartbeat(Integer requestedHeartbeat) {
		this.requestedHeartbeat = requestedHeartbeat;
	}

	public boolean isPublisherConfirms() {
		return this.publisherConfirms;
	}

	public void setPublisherConfirms(boolean publisherConfirms) {
		this.publisherConfirms = publisherConfirms;
	}

	public boolean isPublisherReturns() {
		return this.publisherReturns;
	}

	public void setPublisherReturns(boolean publisherReturns) {
		this.publisherReturns = publisherReturns;
	}

	public Integer getConnectionTimeout() {
		return this.connectionTimeout;
	}

	public void setConnectionTimeout(Integer connectionTimeout) {
		this.connectionTimeout = connectionTimeout;
	}


}