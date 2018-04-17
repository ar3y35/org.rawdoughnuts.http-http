package org.rawdoughnuts.http;

import java.util.List;

public class ContentNegotiation {
    private List<String> mediaType;
    private List<String> charset;
    private List<String> encoding;
    private List<String> language;

    protected ContentNegotiation() {}
}
