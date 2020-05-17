# Introduction
* used for creating graphical user interfaces, based on C programming language
* most of the present world GUI softwares are developed using **Qt** or **GTK+**
* Object Oriented system is created with *Glib* object system
* dependency libraries of GTK+
  - Glib - general purpose utility library, provides useful programming features
  - Pango - enables internationalization
  - ATK - accessibility toolkit
  - GDK - wrapper around low level drawing and windowing functions
  - GdkPixBuf - toolkit for image loading and pixel buffer manipulation
  - Cairo - for creating 2D vector graphics (after version 2.8)

# Compiling GTK+ applications
* a handy tool called *pkg-config* - which provides meta data about installed libraries
* if we want to use a specific library - it will provide the necessary dependent libraries and include files
* usage of **pkg-config**
  ```
  pkg-config --cflags gtk+-2.0
  ```
* Sample O/p:
  ```
  ```  
* usage of **pkg-config**
  ```
  pkg-config --libs gtk+-2.0
  ```
* Sample O/p:
  ```
  ```  
* the *--cflags* option will provide the preprocessor and compile flags required to compile the GTK+ programs, including flags for all the dependencies
* the *--libs* option lists the necessary libraries


**Source: http://zetcode.com/tutorials/gtktutorial/**
