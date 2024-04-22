package com.flyingrain.autotest.mvc.jersey;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJaxbJsonProvider;

import java.text.SimpleDateFormat;

public class JacksonConfigurator extends JacksonJaxbJsonProvider {
    public JacksonConfigurator() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        setMapper(mapper);
    }

}
