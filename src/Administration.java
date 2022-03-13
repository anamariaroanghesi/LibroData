import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Administration {
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<Author> authors = new ArrayList<>();
    ArrayList<Language> languages = new ArrayList<>();
    ArrayList<EditorialGroup> editorialGroups = new ArrayList<>();
    ArrayList<PublishingBrand> publishingBrands = new ArrayList<>();
    ArrayList<PublishingRetailer> publishingRetailers = new ArrayList<>();
    ArrayList<Country> countries = new ArrayList<>();

    LinkedHashSet<Book> getBooksForPublishingRetailerID(int publishingRetailerID){
        LinkedHashSet<Book> set = new LinkedHashSet<>();

        for(PublishingRetailer publishingRetailer: publishingRetailers)
            if(publishingRetailer.ID == publishingRetailerID){
                for(IPublishingArtifact iPublishingArtifact: publishingRetailer.iPublishingArtifacts)
                    if(iPublishingArtifact instanceof Book)
                        set.add((Book)iPublishingArtifact);
                    else if(iPublishingArtifact instanceof EditorialGroup)
                        set.addAll(((EditorialGroup) iPublishingArtifact).books);
                    else if(iPublishingArtifact instanceof PublishingBrand)
                        set.addAll(((PublishingBrand) iPublishingArtifact).books);
            }

        return set;
    }

    LinkedHashSet<Language> getLanguagesForPublishingRetailerID(int publishingRetailerID){
        LinkedHashSet<Language> set = new LinkedHashSet<>();
        LinkedHashSet<Book> books = getBooksForPublishingRetailerID(publishingRetailerID);

        for(Book book: books) {
            for (Language language : languages)
                if (language.ID == book.languageID)
                    set.add(language);
        }

        return set;
    }

    LinkedHashSet<Country> getCountriesForBookID(int bookID){
        LinkedHashSet<Country> set = new LinkedHashSet<>();

        for(PublishingRetailer publishingRetailer: publishingRetailers){
            LinkedHashSet<Book> books = getBooksForPublishingRetailerID(publishingRetailer.ID);
            for(Book book: books)
                if(book.ID == bookID){
                    set.addAll(publishingRetailer.countries);
                    break;
                }
        }

        return set;
    }

    LinkedHashSet<Book> getCommonBooksForRetailerIDs(int retailerID1, int retailerID2){
        LinkedHashSet<Book> set = getBooksForPublishingRetailerID(retailerID1);
        set.retainAll(getBooksForPublishingRetailerID(retailerID2));

        return set;
    }

    LinkedHashSet<Book> getAllBooksForRetailerIDs (int retailerID1, int retailerID2){
        LinkedHashSet<Book> set = getBooksForPublishingRetailerID(retailerID1);
        set.addAll(getBooksForPublishingRetailerID(retailerID2));

        return set;
    }
}
