#include <gtk/gtk.h>

void print_msg (GtkWidget *widget, gpointer window) {
    g_print("Button Clicked\n");
}


GdkPixbuf *create_pixbuf(const gchar *filename) {
    GdkPixbuf *pixbuf;
    GError *error = nullptr;
    // gdk_pixbuf_new_from_file() - create a new pixbuf by loading the an image from the file.
    pixbuf = gdk_pixbuf_new_from_file (filename, &error);

    if (!pixbuf) {
        fprintf(stderr, "%s\n", error->message);
        g_error_free(error);
    }
    
    return pixbuf;
}


int main (int argc, char *argv[]) {
    // GtkWidget is the base class for all widgets in GTK+ library - manages widgets life cycle,
    // states and style
    GtkWidget *window;
    GtkWidget *button;
    GtkWidget *halign;

    // gtk_init() function initilaizes the GTK+ and parses some of the command line options, this
    // must be called before any other call to GTK+ functions
    gtk_init (&argc, &argv);

    // gtk_window_new() - creates a new window, type GTK_WINDOW_TOPLEVEL specifies top level window
    // top level window have a titlebar and a border, and managed by window manager
    window = gtk_window_new (GTK_WINDOW_TOPLEVEL);
    // gtk_window_set_title() - sets a title to the window, if none is set by us, GTK+ uses
    // file name as title by default
    gtk_window_set_title (GTK_WINDOW(window), "Mnemonic");
    // gtk_window_set_default_size() - sets the size of the window
    gtk_window_set_default_size (GTK_WINDOW(window), 300, 200);
    // gtk_window_set_position - sets the position of the window on the screen
    gtk_window_set_position (GTK_WINDOW(window), GTK_WIN_POS_CENTER);
    // gtk_window_set_icon() - sets the icon for the window
    gtk_window_set_icon (GTK_WINDOW(window), create_pixbuf("web.png"));
    // gtk_container_set_border_width() - set some border space around the edges of the window
    gtk_container_set_border_width (GTK_CONTAINER(window), 15);
    
    // Mnemonic is a shortcut key that activate a widget, they can be used with labels, buttons,
    // menu items, create by adding '_' character to thw widget's label, it causes the next character
    // to be the mnemonic, this character is combined with mouseless modifier usually Alt
    // mnemonic - Alt+B
    // gtk_button_new_with_mnemonic () - with label as mnemonic
    // gtk_button_new_with_label() - with a label
    button = gtk_button_new_with_mnemonic ("_Button");
    // set the tool tip text
    gtk_widget_set_tooltip_text(button, "Button Widget");

    // when the button is fired, the function print_msg is called, which will print a message to console
    g_signal_connect (button, "clicked", G_CALLBACK(print_msg), NULL);

    // GtkAlignment is a basic container which can be used to align its child to the sides of the
    // window
    // gtk_alignment_new(xalign, yalign, xscaling, yscaling);
    halign = gtk_alignment_new (0,0,0,0);
    gtk_container_add (GTK_CONTAINER(halign), button);
    // halign is set as the main container of the window
    gtk_container_add (GTK_CONTAINER(window), halign);

    // gtk_widget_show() - shows the created widget on the screen, any widget that is not shown will
    // not appear on the screen
    // gtk_widget_show_all() - if there are multiple widgets then it is easy to show them all
    gtk_widget_show_all(window);

    // the window doesn't react to destroy signal (X symbol) by default, we have to assign an action
    // to that, g_signal_connect_swapped() is used to do that
    g_signal_connect_swapped(G_OBJECT(window), "destroy", G_CALLBACK(gtk_main_quit), NULL);

    gtk_main();

    return 0;
}
