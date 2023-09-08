package HomeTask2;

public class OriginatorDocument {
    private String text = ""; // текст документа

    public void append(String text) {
        this.text += text;
        System.out.printf("Добавлен блок: %s\n", text);
    }

    public void print() {
        System.out.printf("Актуальное содержимое текста: %s\n", this.text);
    }

    public MementoDocument saveState() {
        return new MementoDocument(text);
    }

    public void restoreState(MementoDocument memento) {
        this.text = memento.getText();
    }
}