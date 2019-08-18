import java.io.*;
import java.util.*;

class FlattenDictionary {
  
	/*
  input:  dict = {
            "Key1" : "1",
            "Key2" : {
                "a" : "2",
                "b" : "3",
                "c" : {
                    "d" : "3",
                    "e" : {
                        "" : "1"
                    }
                }
            }
        }

output: {
            "Key1" : "1",
            "Key2.a" : "2",
            "Key2.b" : "3",
            "Key2.c.d" : "3",
            "Key2.c.e" : "1"
        }
        
   entrySet
   if valus instance HashMap
   
   
  */
    static HashMap<String, String> flattenDictionary(HashMap<String, Object> dict) {
        LinkedHashMap<String, String> res = new LinkedHashMap<>();    
        if (dict.isEmpty())
            return res;
        String prefix = "";
        helpFunc(dict, res, prefix);
        return res;
    }

    private static void helpFunc(HashMap<String, Object> dict,
                                 HashMap<String, String> res,
                                 String prefix) {
        dict.forEach((key, value) -> {
            if (!"".equals(prefix) && !"".equals(key)) {
                key = prefix.concat(".").concat(key);
            } else {
                key = prefix.concat(key);
            }
            if (value instanceof String) {
                res.put(key,
                        value.toString());
            } else if (value instanceof HashMap) {
                helpFunc((HashMap) value, res, key);
            }
        });
    }
	
    public static void main(String[] args) {
        HashMap<String, Object> dict = new HashMap<>();

        dict.put("Key1", "1");

        HashMap<String, Object> key2 = new HashMap<>();
        key2.put("a", "2");
        key2.put("b", "3");
        key2.put("c", "3");

        HashMap<String, Object> c = new HashMap<>();
        c.put("d", "3");

        HashMap<String, Object> e = new HashMap<>();
        e.put("", "1");
        c.put("e", e);

        key2.put("c", c);

        dict.put("Key2", key2);

        HashMap<String, String> stringStringHashMap = flattenDictionary(dict);

        stringStringHashMap
                .forEach((key, value) -> System.out.println(key + " : " + value));

    }
}
