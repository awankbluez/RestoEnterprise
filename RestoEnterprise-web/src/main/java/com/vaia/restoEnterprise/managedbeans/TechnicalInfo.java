/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.restoEnterprise.managedbeans;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import org.apache.log4j.Logger;

/**
 *
 * @author awank
 */
@ManagedBean(eager = true)
@ApplicationScoped
public class TechnicalInfo {

   private static final Logger LOGGER = Logger.getLogger(TechnicalInfo.class.getName());
   private String primeFaces;
   private String primeFacesExt;
   private String jsfImpl;
   private String server;
   private String revision;
   private String buildTime;
   private String projectPhase;
   private String primeFacesTheme;

   @PostConstruct
   private void initizlize() {
      ResourceBundle rb;
      try {
         rb = ResourceBundle.getBundle("RestoEnterprise");

         String strAppProps = rb.getString("application.properties");
         int lastBrace = strAppProps.indexOf("}");
         strAppProps = strAppProps.substring(1, lastBrace);

         Map<String, String> appProperties = new HashMap<>();
         String[] appProps = strAppProps.split("[\\s,]+");
         for (String appProp : appProps) {
            String[] keyValue = appProp.split("=");
            if (keyValue != null && keyValue.length > 1) {
               appProperties.put(keyValue[0], keyValue[1]);
            }
         }

         primeFaces = "PrimeFaces: " + appProperties.get("org.primefaces.version");
         primeFacesExt = "PrimeFaces Extensions: " + appProperties.get("org.primefaces.ext.version");
         jsfImpl = "JSF-Impl.: " + appProperties.get("com.sun.faces.displayName") + " " + appProperties.get("com.sun.faces.version");
         server = "Server: Glassfish " + appProperties.get("glassfish.server.version");
         revision = "SVN-Revision: " + appProperties.get("svn.revision");

         DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
         Calendar calendar = Calendar.getInstance();
         calendar.setTimeInMillis(Long.valueOf(appProperties.get("timestamp")));
         buildTime = "Build time: " + formatter.format(calendar.getTime());
         projectPhase = "Project phase: " + appProperties.get("project.stage");
         primeFacesTheme = "PrimeFaces Theme:" + appProperties.get("org.primefaces.theme");
      } catch (MissingResourceException e) {
         LOGGER.error("Resource bundle 'RestoEnterprise' not found.");
      }
   }

   public static Logger getLOGGER() {
      return LOGGER;
   }

   public String getPrimeFaces() {
      return primeFaces;
   }

   public String getPrimeFacesExt() {
      return primeFacesExt;
   }

   public String getJsfImpl() {
      return jsfImpl;
   }

   public String getServer() {
      return server;
   }

   public String getRevision() {
      return revision;
   }

   public String getBuildTime() {
      return buildTime;
   }

   public String getProjectPhase() {
      return projectPhase;
   }

   public String getPrimeFacesTheme() {
      return primeFacesTheme;
   }
}
