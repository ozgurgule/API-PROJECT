package Day_6;

public class RegionPost {

private int region_id;
private String  region_name;
public RegionPost(){

}

    public int getRegion_id() {
        return region_id;
    }

    public RegionPost(int region_id, String region_name) {
        this.region_id = region_id;
        this.region_name = region_name;
    }

    public void setRegion_id(int region_id) {
        this.region_id = region_id;
    }

    public String getRegion_name() {
        return region_name;
    }

    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    }
}
