package com.github.saboteur.ertelecom.carrentalservice.mapper;

import com.github.saboteur.ertelecom.carrentalservice.model.Name;
import org.springframework.stereotype.Component;

@Component
public class NameMapper implements Mapper<Name, String> {

    @Override
    public String convertToDto(Name entity) {
        if (entity == null)
            return null;

        StringBuilder sb = new StringBuilder();

        if (entity.getLast().length() > 0)
            sb.append(entity.getLast()).append(' ');
        if (entity.getFirst().length() > 0)
            sb.append(entity.getFirst()).append(' ');
        if (entity.getMiddle().length() > 0)
            sb.append(entity.getMiddle()).append(' ');

        int len = sb.length() - 1;
        if (sb.charAt(len) == ' ')
            sb.deleteCharAt(len);

        return sb.toString();
    }

    @Override
    public Name convertToEntity(String s) throws IllegalArgumentException {
        if (s == null)
            throw new IllegalArgumentException("Name shouldn't be null");

        String[] words = s.split(" ");

        if (words.length != 3)
            throw new IllegalArgumentException("Incorrect name provided");

        return new Name(
            words[1],
            words[2],
            words[0]
        );
    }

}
