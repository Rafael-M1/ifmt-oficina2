package br.com.ifmt.edu.api.config;

import java.io.IOException;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class MultipartFileToByteArrayConverter implements Converter<MultipartFile, byte[]> {

    @Override
    public byte[] convert(MultipartFile multipartFile) {
        try {
            return multipartFile.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
