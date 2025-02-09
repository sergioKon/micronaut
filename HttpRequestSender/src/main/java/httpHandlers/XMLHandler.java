package httpHandlers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.MediaType;



public class XMLHandler extends HTTPAbstractHandler {
    @Override
    public void proceed(HttpServletRequest request) {
    }


    @Override
    protected void InitMediaType() {
        super.mediaType= MediaType.APPLICATION_XML;
    }
}
