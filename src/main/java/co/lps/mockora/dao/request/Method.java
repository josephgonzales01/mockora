package co.lps.mockora.dao.request;

/**
 * co.lps.mockora.dao.request
 *
 * @author : josephg
 * @since : 6/07/2019
 */
public enum Method {
    GET(0, "GET"),
    POST(1, "POST"),
    PUT(2, "PUT"),
    PATCH(3, "PATCH"),
    DELETE(4, "DELETE");

    private final int key;
    private final String name;

    Method(int key, String name) {
        this.key = key;
        this.name = name;
    }


}
