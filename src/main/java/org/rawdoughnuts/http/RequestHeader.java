package org.rawdoughnuts.http;

/**
 * @author Albert Reyes
 * @see RequestParser
 */
public class RequestHeader {
    private Control control;
    private Conditionals conditionals;
    private ContentNegotiation contentNegotiation;
    private AuthenticationCredentials authenticationCredentials;
    private Context context;

    protected RequestHeader() {
        control = new Control();
        conditionals = new Conditionals();
        contentNegotiation = new ContentNegotiation();
        authenticationCredentials = new AuthenticationCredentials();
        context = new Context();
    }

    public Control getControl() {
        return control;
    }

    public Conditionals getConditionals() {
        return conditionals;
    }

    public ContentNegotiation getContentNegotiation() {
        return contentNegotiation;
    }

    public AuthenticationCredentials getAuthenticationCredentials() {
        return authenticationCredentials;
    }

    public Context getContext() {
        return context;
    }
}
