package com.sfera.dbcast.config;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class CustomListDeserializer extends StdDeserializer<Set<Character>>{

    public CustomListDeserializer(){
        this(null);
    }

    public CustomListDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Set<Character> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        return new HashSet<>();
    }
}
