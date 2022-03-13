import java.util.ArrayList;

public class PublishingRetailer {
    int ID;
    String name;
    ArrayList<IPublishingArtifact> iPublishingArtifacts = new ArrayList<>();
    ArrayList<Country> countries = new ArrayList<>();

    public PublishingRetailer(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }


}
