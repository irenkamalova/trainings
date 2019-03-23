package com.kamalova.pramp;

public class DeletionDistance {

    static int deletionDistance(String str1, String str2) {
        // base case
        if (str1.isEmpty()) {
            return str2.length();
        }
        if (str2.isEmpty()) {
            return str1.length();
        }

        // induction step
        if (str1.charAt(0) == str2.charAt(0)) {
            return deletionDistance(str1.substring(1),
                    str2.substring(1));
        }
        if (str1.length() > str2.length()) {
            return deletionDistance(str1.substring(1), str2) + 1;
        }
        return deletionDistance(str1, str2.substring(1)) + 1;
        // conclusion: you can use a cycle here to save stack memory
        // todo cycle implementation?
    }

    static int deletionDistanceFromEnd(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();

        // base case
        if (str1.isEmpty()) {
            return str2.length();
        }
        if (str2.isEmpty()) {
            return str1.length();
        }

        // induction step
        if (str1.charAt(l1 - 1) == str2.charAt(l2 - 1)) {
            return deletionDistanceFromEnd(str1.substring(0, l1 - 1),
                    str2.substring(0, l2 - 1));
        }
        // last characters are not equals:
        if (l1 > l2) {
            return 1 + deletionDistanceFromEnd(str1.substring(0, l1 - 1), str2);
        }
        return 1 + deletionDistanceFromEnd(str1, str2.substring(0, l2 - 1));
    }


    public static void main(String[] args) {
        System.out.println(deletionDistance("ab", "ba"));
    }

    // deletionDistanceFromEnd(dog,  frog) = deletionDistanceFromEnd(do, fro)
    //

    // deletionDistanceFromEnd(dghp,  dgppp) = deletionDistanceFromEnd(dghp, dgpp)

    // string1[last], string2[last], -> simular -> putting to List,
    // not -> deletionDistanceFromEnd(string1, string2.substring)

    // deletionDistanceFromEnd(dghl,  dgpk) -> deletionDistanceFromEnd(dgh,  dgp)

    // M > N -> M

    // heat hit
    // h ->
    //--
    // i from 0, cur = string1[i]
    // j from 0, cur2 = str2[j]
    // cur == cur2; result+=1; break cycle;
    // O(N * M)
    //--





    // dog forog

    // d -> func(char d) -> ...

    // aba bab

    // dog frog
    // -> og -> d, f, r -> 3

    // some thing
    // -> "" -> all symbols 4 + 5 -> 9
}
