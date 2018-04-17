package org.rawdoughnuts.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author Albert Reyes
 * @see RequestLine
 * @see RequestHeader
 */
public class BufferedRequestParser implements RequestParser {
    protected final BufferedReader reader;

    public BufferedRequestParser(final BufferedReader r) {
        reader = r;
    }

    @Override
    public RequestLine parseRequestLine() throws IOException {
        String line = reader.readLine();
        String[] attrs = line.split(" ");
        if (attrs.length!=3) {
            throw new RuntimeException("Invalid number of attributes found in request line <"+line+">.");
        }

        return new RequestLine(Method.valueOf(attrs[0]), attrs[1], attrs[2]);
    }

    @Override
    public RequestHeader parseHeader() throws IOException {
        Map<String, String[]> data = new HashMap();
        String l = reader.readLine();
        while (!l.equals(" ")) {

        }

        RequestHeader request = new RequestHeader();
        return request;
    }

    @Override
    public Optional<byte[]> parseBody() throws IOException {
        return Optional.of(new byte[0]);
    }
}
