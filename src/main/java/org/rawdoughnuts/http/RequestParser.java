package org.rawdoughnuts.http;

import java.io.IOException;
import java.util.Optional;

/**
 * RFC27023 3.5
 * @author Albert Reyes
 */
public interface RequestParser {
    RequestLine parseRequestLine () throws IOException;
    RequestHeader parseHeader () throws IOException;
    Optional<byte[]> parseBody () throws IOException;
}
