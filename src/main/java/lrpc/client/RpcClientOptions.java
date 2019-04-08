package lrpc.client;

import lrpc.util.Endpoint;
import lrpc.util.StringUtils;

/**
 * 
 * @author winflex
 */
public class RpcClientOptions {
	
	private Endpoint endpoint;
	
	private int ioThreads;
	
	private int connectTimeoutMillis = 3000;
	
	private int requestTimeoutMillis = Integer.MAX_VALUE; // default to forever
	
	private int maxConnections = 1;
	
	/**
	 * 序列化扩展点名字, 默认使用kryo序列化
	 */
	private String serializer = "kryo";
	
	/**
	 * 动态代理扩展点名字, 内置使用jdk
	 */
	private String proxy = "jdk";

	
	public RpcClientOptions(Endpoint endpoint) {
		this.endpoint = endpoint;
	}

	public Endpoint getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(Endpoint endpoint) {
		this.endpoint = endpoint;
	}

	public void setRequestTimeoutMillis(int requestTimeoutMillis) {
		this.requestTimeoutMillis = requestTimeoutMillis;
	}

	public int getMaxConnections() {
		return maxConnections;
	}

	public void setMaxConnections(int maxConnections) {
		this.maxConnections = maxConnections;
	}

	public int getIoThreads() {
		return ioThreads;
	}

	public void setIoThreads(int ioThreads) {
		this.ioThreads = ioThreads;
	}

	public int getConnectTimeoutMillis() {
		return connectTimeoutMillis;
	}

	public void setConnectTimeoutMillis(int connectTimeoutMillis) {
		if (connectTimeoutMillis <= 0) {
			throw new IllegalArgumentException("The connectTimeoutMillis must be positive");
		}
		this.connectTimeoutMillis = connectTimeoutMillis;
	}

	public int getRequestTimeoutMillis() {
		return requestTimeoutMillis;
	}

	public void setInvokeTimeoutMillis(int invokeTimeoutMillis) {
		if (invokeTimeoutMillis <= 0) {
			throw new IllegalArgumentException("The invokeTimeoutMillis must be positive");
		}
		this.requestTimeoutMillis = invokeTimeoutMillis;
	}

	public String getSerializer() {
		return serializer;
	}

	public void setSerializer(String serializer) {
		if (StringUtils.isEmpty(serializer)) {
			throw new IllegalArgumentException("The serializer can't be null");
		}
		this.serializer = serializer;
	}

	public String getProxy() {
		return proxy;
	}

	public void setProxy(String proxy) {
		if (StringUtils.isEmpty(proxy)) {
			throw new IllegalArgumentException("The proxy can't be null");
		}
		this.proxy = proxy;
	}
}
