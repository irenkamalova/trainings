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
}
