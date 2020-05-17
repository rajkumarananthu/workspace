----------------------------------------------------------------------------------------------------

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

----------------------------------------------------------------------------------------------------

# Installing GTK+ in Linux
* to use gtk2/gtk3 applications in linux, there is not need to install anything, all the required
  libraries will already be present
* to develop/compile gtk2/gtk3 applications we need to install the following library
* ` sudo apt-get install libgtk-3-dev `

----------------------------------------------------------------------------------------------------

# Compiling GTK+ applications
* a handy tool called *pkg-config* - which provides meta data about installed libraries
* if we want to use a specific library - it will provide the necessary dependent libraries and
  include files
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
* the *--cflags* option will provide the preprocessor and compile flags required to compile the
  GTK+ programs, including flags for all the dependencies
* the *--libs* option lists the necessary libraries
* to compile a source file of GTK+ application we use the following command
* ```
  g++ -o <exe_file_name> <source_file_name> `pkg-config --libs --cflags gtk+-3.0`
  ```

----------------------------------------------------------------------------------------------------
* NOTE: All the .md files are desciption files or learning files, all the .cpp/.hpp files are code files

**Source: https://developer.gnome.org/gtk3/stable/**
**Source: http://zetcode.com/tutorials/gtktutorial/**
