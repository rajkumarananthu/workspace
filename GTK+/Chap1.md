# Basics
* GTK+ is a widget toolkit, everything is a widget in this. All the widgets are organized in hierarchy.
* Window is the main container - the other widgets like buttons, drop-down menus, input fields etc.,
  are added to window.

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
