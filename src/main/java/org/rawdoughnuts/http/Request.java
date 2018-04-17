package org.rawdoughnuts.http;

import java.util.Optional;

/**
 * @author Albert Reyes
 * @see RequestParser
 */
public class Request {
    private final RequestLine requestLine;
    private final RequestHeader header;
    private byte[] body;

    public Request (final RequestLine line, final RequestHeader header) {
        this (line, header, null);
    }
    public Request(final RequestLine line, final RequestHeader header, byte[] body) {
        requestLine = line;
        this.header = header;
        this.body = body;
    }

    public RequestLine getRequestLine() {
        return requestLine;
    }

    public RequestHeader getHeader() {
        return header;
    }

    public Optional<byte[]> getBody () {
        return Optional.of(body);
    }
}
