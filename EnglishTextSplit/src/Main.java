public class Main {
    public static void main(String[] args) {
        String textENG = "After you open Visual Studio, you can see the three basic parts of the IDE: " +
                "tool windows, menus and toolbars, and the main window space. " +
                "Tool windows are docked on the left and right sides of the app window. " +
                "The Quick Launch box, the menu bar, and the standard toolbar are found at the top. " +
                "The center of the window contains the Start Page. " +
                "When you open a solution or project, editors and designers appear in this space. " +
                "When you develop an app, most of your time is spent in this central area. " +
                "Visual Studio uses projects to organize the code for an app, and solutions to organize your projects. " +
                "A project contains all the options, configurations, and rules used to build your apps. " +
                "It also manages the relationship between all the project's files and any external files. " +
                "To create your app, first, you create a new project and solution.";

        String[] splitTextArray = textENG.split("\\s+");

        System.out.println("Колличество слов: " + textENG.length());

        for (var s : splitTextArray)
            System.out.println(s);
    }
}
