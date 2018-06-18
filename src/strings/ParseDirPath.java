package strings;

import java.util.ArrayDeque;
import java.util.StringJoiner;

public class ParseDirPath {

    public static String simplifyPath(String path) {
        StringBuilder result = new StringBuilder();
        if(path.length() == 0)
            return "/";
        String[] dir = path.split("/");
        ArrayDeque<String> q = new ArrayDeque<>();
        for(String cur : dir) {
            if("..".equals(cur)) {
                if(!q.isEmpty())
                    q.removeLast();
            }

            else if(".".equals(cur) || "".equals(cur))
                continue;
            else {
                q.add(cur);
            }
        }
        while(!q.isEmpty()) {
            result.append( "/" + q.removeFirst()); //Always use stringbuilder for appending, saves memory and faster
        }
        if(result.length() == 0)
            return "/";
        else
            return result.toString();
    }
}
