package jaxrs.examples.client.cache;

import javax.ws.rs.core.MultivaluedMap;

/**
 * @author Bill Burke
 * @author Marek Potociar
 */
public class CacheEntry {

    private int status;
    private MultivaluedMap<String, String> headers;
    private byte[] body;

    public CacheEntry(int status, MultivaluedMap<String, String> headers, byte[] body) {
        this.status = status;
        this.headers = headers;
        this.body = body;
    }

    public int getStatus() {
        return status;
    }

    public MultivaluedMap<String, String> getHeaders() {
        return headers;
    }

    public byte[] getBody() {
        return body;
    }
}
