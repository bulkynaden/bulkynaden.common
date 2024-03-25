package es.bulkynaden.common;

/**
 * The IFileHolder interface represents an object that holds a file.
 */
public interface IFileHolder {
    
    /**
     * Returns the file associated with the venue.
     *
     * @return An IFile object representing the associated file.
     */
    IFile getFile();

    /**
     * Assigns a file to the venue.
     *
     * @param file An IFile object representing the file to be assigned to the venue.
     */
    void setFile(IFile file);
}