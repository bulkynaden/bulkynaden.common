package es.bulkynaden.common.classes;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The File class represents a file with properties such as name, size, data, and type.
 * It implements the {@link IFile} interface.
 */
@Data
@EqualsAndHashCode(of = {"name", "size", "data", "type"})
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