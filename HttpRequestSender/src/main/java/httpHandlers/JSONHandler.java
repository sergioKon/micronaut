package httpHandlers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.MediaType;


public class JSONHandler  extends  HTTPAbstractHandler{

    @Override
    protected void InitMediaType() {
        super.mediaType= MediaType.APPLICATION_JSON;
    }

    @Override
    public void proceed(HttpServletRequest request) {

    }
}
