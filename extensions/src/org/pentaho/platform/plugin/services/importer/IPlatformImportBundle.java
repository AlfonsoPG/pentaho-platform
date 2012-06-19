package org.pentaho.platform.plugin.services.importer;

import org.pentaho.platform.api.repository2.unified.RepositoryFileAcl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * A struct-like object for bundling related objects together for import into the platform. Bundles contain all
 * information necessary for import into the platform. While this interface includes a hash-map optional paramters
 * function, it should be subclassed if many properties are accessed this way.
 *
 * @author mlowery, nbaker
 */
public interface IPlatformImportBundle {

  /**
   * This allows for arbitrary parent-child trees to be imported. Note this does not support the folder/file
   * paradigm and is instead a logical relationship between import bundles.
   *
   * @return a list of "child" bundles.
   */
  List<IPlatformImportBundle> getChildBundles();


  /**
   * Optional content name. Repository content this will be stored based on this name
   *
   * @return
   */
  String getName();

  /**
   * Optional InputStream for content with a binary component.
   */
  InputStream getInputStream() throws IOException;

  /**
   * Optional character set for the binary InputStream. UTF-8 will be used by default for in the case of binary text
   * content
   *
   * @return Character set for the associated InputStream
   */
  String getCharset();

  /**
   * mime-type to be used to resolve an IPlatformImportHandler. If not set the IPlatformImporter will attempt to
   * resolve a mime-type based on the configured IPlatformImportMimeResolver
   *
   * @return mime-type
   */
  String getMimeType();

  /**
   * Convenience method for extra properties. A subclass would be preferred if there are a great number of properties
   * accessed from this method.
   *
   * @param prop
   * @return
   */
  Object getProperty(String prop);
}