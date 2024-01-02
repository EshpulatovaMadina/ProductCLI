package org.example.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface BaseRepo <T>{
    ObjectMapper objectMapper = new ObjectMapper()
            .enable(SerializationFeature.INDENT_OUTPUT)
            .enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
    default List<T> readFromFile(String path, Class<T> elementType) {
        try {
            CollectionType listType = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, elementType);
            return objectMapper.readValue(new File(path), listType);
        }catch (MismatchedInputException e){
            return new ArrayList<>();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    default void writeToFile(List<T> data, String path) {
        try {
            objectMapper.writeValue(new File(path), data);
        } catch (MismatchedInputException e){

        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    Optional<T> save(T t);

    List<T> getAll();


}
