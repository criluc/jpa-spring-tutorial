#!/bin/sh
#
# Software per esercizioni
#
# Java 8 (JDK 8u74 per Windows 64 bit)
# E' necessario approvare la licenza e scaricarlo da 
# http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
#
# Eclipse (per Java EE Developer, Windows 64 bit)
# http://download.eclipse.org/technology/epp/downloads/release/mars/2/eclipse-jee-mars-2-win32-x86_64.zip
#
# Tomcat 8 (Core per windows 64 bit)
# http://it.apache.contactlab.it/tomcat/tomcat-8/v8.0.32/bin/apache-tomcat-8.0.32-windows-x64.zip
#
# H2 database (windows installer)
# http://www.h2database.com/h2-setup-2016-01-21.exe

if [ -z "$1" ]
  then 
      echo "Specifica la directory di destinazione"
      exit 0
fi

DEST_DIR=$1
echo "Downloading files in ${DEST_DIR}"

wget -O "$DEST_DIR/eclipse-jee-mars-2-win32-x86_64.zip" \
     http://download.eclipse.org/technology/epp/downloads/release/mars/2/eclipse-jee-mars-2-win32-x86_64.zip
     
wget -O "$DEST_DIR/apache-tomcat-8.0.32-windows-x64.zip" \
     http://it.apache.contactlab.it/tomcat/tomcat-8/v8.0.32/bin/apache-tomcat-8.0.32-windows-x64.zip

wget -O "$DEST_DIR/h2-setup-2016-01-21.exe" \
     http://www.h2database.com/h2-setup-2016-01-21.exe

echo "Ricordati di scaricare JDK 8 per Windows da http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html"


