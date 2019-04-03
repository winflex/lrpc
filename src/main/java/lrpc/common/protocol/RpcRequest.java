package lrpc.common.protocol;

import java.util.concurrent.atomic.AtomicLong;

import lrpc.common.Invocation;

/**
 * 
 * @author winflex
 */
public class RpcRequest extends RpcMessage<Invocation> {

	private static final long serialVersionUID = -3291542680694765400L;

	public RpcRequest(Invocation inv) {
		setType(TYPE_INVOKE_REQUEST);
		setId(sequence.incrementAndGet());
		setData(inv);
	}
	
	private static final AtomicLong sequence = new AtomicLong();
}
