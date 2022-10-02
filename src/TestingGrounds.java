public class TestingGrounds {
    public static void main(String[] args) {
        String s = "0123456_FOR TEST ONLY_20220801.PDF";
        System.out.println(s.substring(s.lastIndexOf('_')+1, s.lastIndexOf('.')));

        String t = "20220801_0123456_API_ACH.PDF";
        String t2 = t.substring(0, t.indexOf('_'));
        System.out.println(formatDate(t2));
    }

    public static String formatDate(String nDate) {
        return nDate.substring(4,6) + "/" + nDate.substring(6,8) + "/" + nDate.substring(0, 4);
    }
}
