import java.util.ArrayList;

public class EditorialGroup implements IPublishingArtifact{
    int ID;
    String name;
    ArrayList<Book> books = new ArrayList<>();

    public EditorialGroup(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public int getID() {
        return ID;
    }
    public String getName() {
        return name;
    }

    public String Publish(){
        String str = "<xml>\n" + "\t<editorialGroup>\n" +
                "\t\t<ID>" + this.getID() + "</ID>\n" +
                "\t\t<Name>" + this.getName() + "</Name>\n" +
                "\t</editorialGroup>\n" + "\t<books>\n";
        for(Book book: books)
            str = str.concat(book.BookInfo());

        str = str.concat("\t</books>\n" + "</xml>");

        return str;
    }
}
