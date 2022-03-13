import java.util.ArrayList;
import java.util.Date;

public class Book implements IPublishingArtifact{
    int ID;
    String name;
    String subtitle;
    String ISBN;
    int pageCount;
    String keywords;
    int languageID;
    Date createdOn;
    ArrayList<Author> authors = new ArrayList<Author>();

    public String getName() {
        return name;
    }
    public String getSubtitle() {
        return subtitle;
    }
    public String getISBN() {
        return ISBN;
    }
    public int getPageCount() {
        return pageCount;
    }
    public String getKeywords() {
        return keywords;
    }
    public int getLanguageID() {
        return languageID;
    }
    public Date getCreatedOn() {
        return createdOn;
    }


    public Book(int ID, String name, String subtitle, String ISBN, int pageCount, String keywords, int languageID, Date createdOn) {
        this.ID = ID;
        this.name = name;
        this.subtitle = subtitle;
        this.ISBN = ISBN;
        this.pageCount = pageCount;
        this.keywords = keywords;
        this.languageID = languageID;
        this.createdOn = createdOn;
    }

    public String Publish() {
        String aux = new String();
        for(Author i: this.authors)
            aux = aux.concat(i.firstName + " " + i.lastName + " ");

        String str = "<xml>\n" + "\t<title>" + this.getName() + "</title>\n"
                + "\t<subtitle>" + this.getSubtitle() + "</subtitle>\n"
                + "\t<isbn>" + this.getISBN() + "</isbn>\n"
                + "\t<pageCount>" + this.getPageCount() + "</pageCount>\n"
                + "\t<keywords>" + this.getKeywords() + "</keywords>\n"
                + "\t<languageID>" + this.getLanguageID() + "</languageID>\n"
                + "\t<createdOn>" + this.getCreatedOn() + "<createdOn>\n"
                + "\t<authors>" + aux + "<authors>\n"
                + "</xml>";
        return str;
    }

    public String BookInfo() {
        String aux = new String();
        for(Author i: this.authors)
            aux = aux.concat(i.firstName + " " + i.lastName + " ");

        String str = "\t\t<book>\n" +
                "\t\t\t<title>" + this.getName() + "</title>\n" +
                "\t\t\t<subtitle>" + this.getSubtitle() + "</subtitle>\n" +
                "\t\t\t<isbn>" + this.getISBN() + "</isbn>\n" +
                "\t\t\t<pageCount>" + this.getPageCount() + "</pageCount>\n" +
                "\t\t\t<keywords>" + this.getKeywords() + "</keywords>\n" +
                "\t\t\t<languageID>" + this.getLanguageID() + "</languageID>\n" +
                "\t\t\t<createdOn>" + this.getCreatedOn() + "<createdOn>\n" +
                "\t\t\t<authors>" + aux + "<authors>\n" +
                "\t\t</book>\n";
        return str;
    }


}

