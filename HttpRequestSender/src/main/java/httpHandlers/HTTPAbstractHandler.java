package httpHandlers;


import converters.DataParser;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.MediaType;

import java.io.IOException;


public abstract class HTTPAbstractHandler {


    protected MediaType mediaType;
    protected  DataParser dataParser = null;
    public  MediaType getMediaType(){
        return  mediaType;
    }

    public HTTPAbstractHandler() {
     //   log.debug(" you are handling {} client mime type ",this.getClass().getSimpleName());
        InitMediaType();
    }

    protected abstract void InitMediaType();

    abstract public  void proceed(HttpServletRequest request) throws IOException;
}
