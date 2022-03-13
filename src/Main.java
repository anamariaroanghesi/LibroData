import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;

public class Main {
    public static void main(String[] args) {
        Administration aux = new Administration();

        try (BufferedReader br = new BufferedReader(new FileReader("init/books.in"))) {
                String line;
                line = br.readLine();
                while ((line = br.readLine()) != null) {
                    String[] field = line.split("###");
                    int ID = Integer.parseInt(field[0]);
                    int pageCount = Integer.parseInt(field[4]);
                    int languageID = Integer.parseInt(field[6]);
                    try{
                        Date date = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").parse(field[7]);
                        Book book = new Book(ID, field[1], field[2], field[3], pageCount, field[5], languageID, date);
                        aux.books.add(book);
                    }catch(Exception e){
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }
                }
        }catch(IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("init/authors.in"))) {
            String line;
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] field = line.split("###");
                int ID = Integer.parseInt(field[0]);

                Author author = new Author(ID, field[1], field[2]);
                aux.authors.add(author);
            }
        }catch(IOException e){
        System.out.println("An error occurred.");
        e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("init/books-authors.in"))) {
            String line;
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] field = line.split("###");
                int bookID = Integer.parseInt(field[0]);
                int authorID = Integer.parseInt(field[1]);

                for(Book book: aux.books)
                    if(book.ID == bookID){
                        for(Author author: aux.authors)
                            if(author.ID == authorID){
                                book.authors.add(author);
                                break;
                            }
                        break;
                    }
            }
        }catch(IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("init/languages.in"))) {
            String line;
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] field = line.split("###");
                int ID = Integer.parseInt(field[0]);

                Language language = new Language(ID, field[1], field[2]);
                aux.languages.add(language);
            }
        }catch(IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("init/editorial-groups.in"))) {
            String line;
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] field = line.split("###");
                int ID = Integer.parseInt(field[0]);

                EditorialGroup editorialGroup = new EditorialGroup(ID, field[1]);
                aux.editorialGroups.add(editorialGroup);
            }
        }catch(IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("init/publishing-brands.in"))) {
            String line;
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] field = line.split("###");
                int ID = Integer.parseInt(field[0]);

                PublishingBrand publishingBrand = new PublishingBrand(ID, field[1]);
                aux.publishingBrands.add(publishingBrand);
            }
        }catch(IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("init/editorial-groups-books.in"))) {
            String line;
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] field = line.split("###");
                int editorialGroupID = Integer.parseInt(field[0]);
                int bookID = Integer.parseInt(field[1]);

                for(EditorialGroup editorialGroup: aux.editorialGroups)
                    if(editorialGroup.ID == editorialGroupID){
                        for(Book book: aux.books)
                            if(book.ID == bookID){
                                editorialGroup.books.add(book);
                                break;
                            }
                        break;
                    }
            }
        }catch(IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("init/publishing-brands-books.in"))) {
            String line;
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] field = line.split("###");
                int publishingBrandID = Integer.parseInt(field[0]);
                int bookID = Integer.parseInt(field[1]);

                for(PublishingBrand publishingBrand: aux.publishingBrands)
                    if(publishingBrand.ID == publishingBrandID){
                        for(Book book: aux.books)
                            if(book.ID == bookID){
                                publishingBrand.books.add(book);
                                break;
                            }
                        break;
                    }
            }
        }catch(IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("init/publishing-retailers.in"))) {
            String line;
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] field = line.split("###");
                int ID = Integer.parseInt(field[0]);

                PublishingRetailer publishingRetailer = new PublishingRetailer(ID, field[1]);
                aux.publishingRetailers.add(publishingRetailer);
            }
        }catch(IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("init/countries.in"))) {
            String line;
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] field = line.split("###");
                int ID = Integer.parseInt(field[0]);

                Country country = new Country(ID, field[1]);
                aux.countries.add(country);
            }
        }catch(IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("init/publishing-retailers-countries.in"))) {
            String line;
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] field = line.split("###");
                int publishingRetailerID = Integer.parseInt(field[0]);
                int countryID = Integer.parseInt(field[1]);

                for(PublishingRetailer publishingRetailer: aux.publishingRetailers)
                    if(publishingRetailer.ID == publishingRetailerID){
                        for(Country country: aux.countries)
                            if(country.ID == countryID){
                                publishingRetailer.countries.add(country);
                                break;
                            }
                        break;
                    }
            }
        }catch(IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("init/publishing-retailers-books.in"))) {
            String line;
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] field = line.split("###");
                int publishingRetailerID = Integer.parseInt(field[0]);
                int bookID = Integer.parseInt(field[1]);

                for(PublishingRetailer publishingRetailer: aux.publishingRetailers)
                    if(publishingRetailer.ID == publishingRetailerID){
                        for(Book book: aux.books)
                            if(book.ID == bookID){
                                publishingRetailer.iPublishingArtifacts.add(book);
                                break;
                            }
                        break;
                    }
            }
        }catch(IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("init/publishing-retailers-editorial-groups.in"))) {
            String line;
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] field = line.split("###");
                int publishingRetailerID = Integer.parseInt(field[0]);
                int editorialGroupID = Integer.parseInt(field[1]);

                for(PublishingRetailer publishingRetailer: aux.publishingRetailers)
                    if(publishingRetailer.ID == publishingRetailerID){
                        for(EditorialGroup editorialGroup: aux.editorialGroups)
                            if(editorialGroup.ID == editorialGroupID){
                                publishingRetailer.iPublishingArtifacts.add(editorialGroup);
                                break;
                            }
                        break;
                    }
            }
        }catch(IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("init/publishing-retailers-publishing-brands.in"))) {
            String line;
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] field = line.split("###");
                int publishingRetailerID = Integer.parseInt(field[0]);
                int publishingBrandID = Integer.parseInt(field[1]);

                for(PublishingRetailer publishingRetailer: aux.publishingRetailers)
                    if(publishingRetailer.ID == publishingRetailerID){
                        for(PublishingBrand publishingBrand: aux.publishingBrands)
                            if(publishingBrand.ID == publishingBrandID){
                                publishingRetailer.iPublishingArtifacts.add(publishingBrand);
                                break;
                            }
                        break;
                    }
            }
        }catch(IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        ////////////////////////////////tests///////////////////////////////

        /*getBooksForPublishingRetailerID*/
        for(int i = 1; i <= 5; i++){
            java.io.File f = new java.io.File("Teste/getBooksForPublishingRetailerID" + i + ".txt");
            try {
                PrintWriter pw = new PrintWriter(f);
                int ID = (int) (Math.random() * (33 - 1)) + 1;
                pw.println("Books for publishing retailer with id " + ID);
                LinkedHashSet<Book> books = aux.getBooksForPublishingRetailerID(ID);
                for (Book book : books)
                    pw.println(book.Publish());
                pw.close();
            }catch(Exception e){
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

        /*getLanguagesForPublishingRetailerID*/
        for(int i = 1; i <= 5; i++) {
            java.io.File f = new java.io.File("Teste/getLanguagesForPublishingRetailerID" + i + ".txt");
            try {
                PrintWriter pw = new PrintWriter(f);
                int ID = (int) (Math.random() * (33 - 1)) + 1;
                pw.println("Languages for publishing retailer with id " + ID);
                LinkedHashSet<Language> languages = aux.getLanguagesForPublishingRetailerID(ID);
                for (Language language : languages)
                    pw.println(language.name + " " + language.ID);
                pw.close();
            }catch(Exception e){
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

        /*getCountriesForBookID*/
        for(int i = 1; i <= 5; ) {
            java.io.File f = new java.io.File("Teste/getCountriesForBookID" + i + ".txt");
            try {
                PrintWriter pw = new PrintWriter(f);
                int ID = (int) (Math.random() * (900 - 204)) + 204;
                LinkedHashSet<Country> countries = aux.getCountriesForBookID(ID);
                if (countries.isEmpty() != true) {
                    i++;
                    pw.println("Countries for books with id " + ID);
                    for (Country country : countries)
                        pw.println(country.ID + " " + country.countryCode);
                }
                pw.close();
            }catch(Exception e){
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

        /*getAllBooksForRetailerIDs*/
        for(int i = 1; i <= 5; i++){
            java.io.File f = new java.io.File("Teste/getAllBooksForRetailerIDs" + i + ".txt");
            try {
                PrintWriter pw = new PrintWriter(f);
                int ID1 = (int) (Math.random() * (33 - 1)) + 1;
                int ID2 = (int) (Math.random() * (33 - 1)) + 1;
                pw.println("All books for publishing retailers with ids " + ID1 + " " + ID2);

                LinkedHashSet<Book> books = aux.getAllBooksForRetailerIDs(ID1, ID2);
                for (Book book : books)
                    pw.println(book.Publish());
                pw.close();
            }catch(Exception e){
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

        /*getCommonBooksForRetailerIDs*/
        for(int i = 1; i <= 5; i++){
            java.io.File f = new java.io.File("Teste/getCommonBooksForRetailerIDs" + i + ".txt");
            try {
                PrintWriter pw = new PrintWriter(f);
                int ID1 = (int) (Math.random() * (33 - 1)) + 1;
                int ID2 = (int) (Math.random() * (33 - 1)) + 1;
                pw.println("Common books for publishing retailers with ids " + ID1 + " " + ID2);

                LinkedHashSet<Book> books = aux.getCommonBooksForRetailerIDs(ID1, ID2);
                for (Book book : books)
                    pw.println(book.Publish());
                pw.close();
            }catch(Exception e){
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

    }
}
