/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.util;

import java.util.MissingResourceException;
import java.util.ResourceBundle;
import org.apache.log4j.Logger;

/**
 *
 * @author awank
 */
public final class VersionProvider {

   private static final Logger LOGGER = Logger.getLogger(VersionProvider.class.getName());
   private static final VersionProvider INSTANCE = new VersionProvider();
   private String version;

   private VersionProvider() {
      ResourceBundle rb;
      try {
         rb = ResourceBundle.getBundle("RestoEnterprise");
         version = rb.getString("application.version");
      } catch (MissingResourceException e) {
         LOGGER.error("Resource bundle 'RestoEnterprise' was not found or error while reading current version.");
      }
   }

   public static String getVersion() {
      return INSTANCE.version;
   }
}
