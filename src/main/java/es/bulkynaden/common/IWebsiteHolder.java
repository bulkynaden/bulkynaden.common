package es.bulkynaden.common;

/**
 * The IWebsiteHolder interface represents an object that holds information about a website.
 * It provides methods to get and set the website URL.
 */
public interface IWebsiteHolder {

    /**
     * Returns the website URL of the website holder object.
     *
     * @return the website URL.
     */
    String getWebsite();

    /**
     * Sets the website URL for the website holder object.
     *
     * @param website the new website URL to be set
     */
    void setWebsite(String website);
}