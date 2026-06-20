package com.cognizant.mockitoadvanced.exercise3;
public class FileService {
    private final FileReader reader;
    private final FileWriter writer;
    public FileService(FileReader reader, FileWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }
    public String processFile() {
        String content = reader.read();
        String processed = "Processed " + content;
        writer.write(processed);
        return processed;
    }
}
