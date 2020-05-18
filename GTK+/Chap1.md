# Basics
* GTK+ is a widget toolkit, everything is a widget in this. All the widgets are organized in hierarchy.
* Window is the main container, the other widgets like buttons, drop-down menus, input fields etc., are added to window.
* We can describe the complex applications using GTK+ specific markup language
* GTK+ is event driven
* *gtk_application_new("<app_identifier>", <flags>);* create a GTKApplication object
* A GTKApplication will have an activate signal, we connect this to some method/function using
  *g_signal_connect(<Widget/application ptr>, "<name of the signal>", G_CALLBACK(activate), NULL)*
* This activate is called when we run the application using 
  *g_application_run(<application ptr>, argc, argv);* we pass argc and argv so that if any cmd line
  args to be parsed it will be done there in the activate signal mapped method/function
* *gtk_application_window_new()* will create a new window(GtkWindow) - a window will have a title bar,
  frame and window control depending on the platform.
* *gtk_window_set_title()* will set the title of the window object that is passed to the function
* *GTK_WINDOW()* work as casting operator to cast to (GtkWindow\*)
* *gtk_window_set_default_size()* will set the size of the window
* *gtk_widget_show_all()* enables all the widgets so far created - until not enabled we will not be
  able to see the widgets
* When the X is pressed the *gtk_application_run()* returns with a status, then we use the function
  *g_object_unref(app)* to free the memory allocated to GtkApplication
* As GTK+ is event driven, every input event (generally caused by user interacting with the application), so when an
  event is triggered the widgets communicate in the form of signals
* *gtk_button_box_new()* creates a GtkButtonBox which takes a GtkOrientation enum as parameter
* *gtk_container_add(container, other_container)* add the container specified to other_container
* *gtk_button_new_with_label()* creates a button with the specified label
* *g_signal_connect()* will connect/map a function to the click event on the button
* *g_signal_connect_swapped()* differ from *g_signal_connect()* in how the callback function is treated, this will allow
  you to specify the paramter for the callback function
* *gtk_widget_destroy()* will destroy the widget passed as parameter

# Packing:
* A typical GUI based application will have many widgets. Packing defines how the child widgets are organized in the
  parent widget. GTK+ have many layout containers to support this packing.

# GtkBuilder
* To build a large & complicated GUI applications, we may require hunderds to thousands of widgets, to do all this setup
  work using C/C++ source code may sometimes lead to confusion and change the UI may become difficult.
* GTK+ support a helper to make this part easy, we can use an XML format to explain the widget hierarchy and then parse
  the XML file using *GtkBuilder* to create the layout.
* *gtk_builder_new()* creates & returns a GtkBuilder\*
* *gtk_builder_add_from_file()* will take a filename and GtkBuilder\* to bind the builder to XML file
* *gtk_builder_get_object()* will return a GtkObject\* to construct objects for the GUI application. (GtkBuilder can be
  used to create/contruct objects that are not widgets, that is why it returns GObject\*)
* *gtk_builder_add_from_string()* will take a layout from the string passed as argument

# Glade
* A GUI editor with drag&drop features to modify your UI, it will load the layout from a file.

# Writing a small application
* Check the *frst_app* folder for the source code
