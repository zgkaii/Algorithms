package hashmap;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/02/19 15:13
 * @Description: 535. TinyURL 的加密与解密 https://leetcode-cn.com/problems/encode-and-decode-tinyurl/
 */
public class DecodeTinyurl {
    List<String> urls = new ArrayList<String>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        urls.add(longUrl);
        return String.valueOf(urls.size() - 1);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int index = Integer.valueOf(shortUrl);
        return (index < urls.size()) ? urls.get(index) : "";
    }
}
