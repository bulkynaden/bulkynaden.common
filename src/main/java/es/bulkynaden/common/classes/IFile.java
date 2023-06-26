package es.bulkynaden.common.classes;

/**
 * The IFile interface represent a file.
 */
public interface IFile {
    /**
     * Returns the name of the file.
     *
     * @return The name of the file as a String.
     */
    String getName();

    /**
     * Assigns the name of the file.
     *
     * @param name A String representing the name of the file.
     */
    void setName(String name);

    /**
     * Returns the size of the file in bytes.
     *
     * @return The size of the file as a long value in bytes.
     */
    long getSize();

    /**
     * Assigns the size of the file in bytes.
     *
     * @param size A long value representing the size of the file in bytes.
     */
    void setSize(long size);

    /**
     * Returns the data contained in the file.
     *
     * @return The file's data as a byte array.
     */
    byte[] getData();

    /**
     * Assigns data to the file.
     *
     * @param data A byte array representing the data to be assigned to the file.
     */
    void setData(byte[] data);

    /**
     * Returns the type of the file.
     *
     * @return The type of the file as a String.
     */
    String getType();

    /**
     * Assigns a type to the file.
     *
     * @param type A String representing the type of the file.
     */
    void setType(String type);
}
