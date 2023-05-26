package UI.PageBuilder;

public interface InteractivePage {
    PageOption[] getPageActions();
    String getMenu();
    void chosenOption();
    void changePage();
}
