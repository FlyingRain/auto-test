package com.flyingrain.autotest.mvc.jersey;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.ext.MessageBodyReader;
import jakarta.ws.rs.ext.Provider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Provider
@Consumes(MediaType.APPLICATION_JSON)
public class CustomDateDeserializer implements MessageBodyReader<Date> {
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return type.equals(Date.class);
    }

    @Override
    public Date readFrom(Class<Date> type, Type genericType, Annotation[] annotations, MediaType mediaType,
                         MultivaluedMap<String, String> httpHeaders, InputStream entityStream) throws IOException, WebApplicationException {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(entityStream));
            String dateStr = reader.readLine();
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            throw new WebApplicationException("Error parsing date", e);
        }
    }
}
