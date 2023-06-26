package es.bulkynaden.common.classes;

import lombok.Data;

/**
 * The File class represents a file with properties such as name, size, data, and type.
 * It implements the IFile interface.
 */
@Data
public class File implements IFile {
    /**
     * The name of the file.
     */
    private String name;

    /**
     * The size of the file in bytes.
     */
    private long size;

    /**
     * The data of the file represented as a byte array.
     */
    private byte[] data;

    /**
     * The type of the file.
     */
    private String type;
}