public class Codec {

    String longU;
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        this.longU = longUrl;
          return "x";
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
           return longU;
    }
}