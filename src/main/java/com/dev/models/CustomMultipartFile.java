package com.dev.models;

import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class CustomMultipartFile implements MultipartFile {
    private byte[] bytes;
    private String originalFilename;

    public CustomMultipartFile(byte[] bytes, String originalFilename) {
        this.bytes = bytes;
        this.originalFilename = originalFilename;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getOriginalFilename() {
        return originalFilename;
    }

    @Override
    public String getContentType() {
        return "image/jpeg";
    }

    @Override
    public boolean isEmpty() {
        return bytes == null || bytes.length == 0;
    }

    @Override
    public long getSize() {
        return bytes.length;
    }

    @Override
    public byte[] getBytes() {
        return bytes;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new ByteArrayInputStream(bytes);
    }

    @Override
    public void transferTo(File dest) throws IOException, IllegalStateException {
        try (FileOutputStream outputStream = new FileOutputStream(dest)) {
            outputStream.write(bytes);
        }
    }
}
