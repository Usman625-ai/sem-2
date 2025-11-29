// write a function that returns true if a given url fulfills the following criteria, otherwise returns false;
// A valid url may start with http:// or https:// or www. after these three possibilities of start of a url next is a series of
// subdomains/domains/toplevel-domains seperated by dot("." characters) each of which must be larger than 2 characters containing of
// alphabets or digits.
class ValidUrlChecker {

    public static void main(String[] args) {
        ValidUrlChecker obj = new ValidUrlChecker();

        // Test cases
        System.out.println(obj.urlChecker("https://google.com"));       // true
        System.out.println(obj.urlChecker("www.amazon.in"));            // true
        System.out.println(obj.urlChecker("ftp://google.com"));         // false (wrong prefix)
        System.out.println(obj.urlChecker("https://12.abc.e"));         // false (last part < 3)
    }

    public boolean urlChecker(String url) {

        String original = url;
        // Check starting prefix
        if (url.startsWith("http://")) {
            url = url.substring(7);
        } 
        // substring basically jo index given hoti hai usse pehle k saary elements remove krdeta hai 
        // like if 7 then it will remove 0 1 2 3 4 5 6 index of a given string and return a new string with remaining elements
        else if (url.startsWith("https://")) {
            url = url.substring(8);
        }
        else if (url.startsWith("www.")) {
            url = url.substring(4);
        }
        else {
            return false;
        }

        // Split by dot remember dot is regex thats why \\ lagana zrori hai
        String[] parts = url.split("\\.");
        // 

        // Every domain part must be >= 3 characters
        for (String p : parts) {

            if (p.length() < 3)
                return false;

            // it is basically like [] k andr elements ki range given hai like A-Z tk ki range a-z tk ki range or 0-9 tk ki range
            // agr isk ilawa kch bhi aya tu false like . or - ya kch bhi tu false
            if (!p.matches("[A-Za-z0-9]+"))
                return false;
        }

        return true;
    }
}
