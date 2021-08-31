package utn.isi.dan.blog.danmsblog.aspect;

public class ErrorResponse {
    // should be an error code unique to our application.
    private String error;

    // The message portion of the body is usually considered presentable on user
    // interfaces. Therefore, we should translate this title if we support
    // internationalization. Use Accept-Language header
    private String message;

    // The detail portion is intended for use by developers of clients and not the
    // end user, so the translation is not necessary.
    private String detail;

    // we could also provide a URL — such as the help field — that clients can
    // follow to discover more information:
    // private String help;
    
    public ErrorResponse(String error, String message, String detail) {
        this.error = error;
        this.message = message;
        this.detail = detail;
    }


    public String getError() {
        return this.error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetail() {
        return this.detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

}
