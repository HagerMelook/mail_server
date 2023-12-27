package com.example.Backend;
public class FileMetadata {

    private String fileName;
    private long fileSize;

    public FileMetadata() {

    }

    public FileMetadata(String fileName, long fileSize) {
        this.fileName = fileName;
        this.fileSize = fileSize;
    }

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

}
