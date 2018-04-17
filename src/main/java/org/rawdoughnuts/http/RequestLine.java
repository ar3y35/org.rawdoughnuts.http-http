package org.rawdoughnuts.http;

/**
 * <p>
 * <a href="https://tools.ietf.org/html/rfc7230#section-3.1.1">IETF RFC7230 3.1.1</a>
 * This class is immutable
 * </p>
 *
 * @author Albert Reyes
 * @see Request
 * @see RequestParser
 */
public class RequestLine {
    private final Method method;
    private final String target;
    private final String version;

    /**
     * All parameters are required.  Null MUST NOT be passed.
     *
     * @param method
     * @param target
     * @param version
     */
    protected RequestLine(Method method, String target, String version) {
        if (method==null) {throw new NullPointerException("Method is required");}
        if (target==null) {throw new NullPointerException("Target is required");}
        if (version==null) {throw new NullPointerException("Version is required");}
        this.method = method;
        this.target = target;
        this.version = version;
    }

    public Method getMethod() {
        return method;
    }

    public String getTarget() {
        return target;
    }

    public String getVersion() {
        return version;
    }
}
