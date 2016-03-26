package id.api;

/**
 * Created by robertsikora on 25.03.2016.
 */
enum Version {
    v1;

    public static String current(){
        return v1.name();
    }
}
