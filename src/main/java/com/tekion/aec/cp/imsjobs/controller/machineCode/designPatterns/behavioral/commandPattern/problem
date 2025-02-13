Imagine that you’re working on a new text-editor app.
Your current task is to create a toolbar with a bunch of buttons for various operations of the editor.
You created a very neat Button class that can be used for buttons on the toolbar,
 as well as for generic buttons in various dialogs.

 While all of these buttons look similar, they’re all supposed to do different things.
 Where would you put the code for the various click handlers of these buttons?
 The simplest solution is to create tons of subclasses for each place where the button is used.
 These subclasses would contain the code that would have to be executed on a button click.

 here’s the ugliest part. Some operations, such as copying/pasting text, would need to be invoked from multiple places.
  For example, a user could click a small “Copy” button on the toolbar, or copy something via the context menu, or just hit Ctrl+C on the keyboard.


Solutions:

Good software design is often based on the principle of separation of concerns,
which usually results in breaking an app into layers.

