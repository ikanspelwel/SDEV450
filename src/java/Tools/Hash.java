package Tools;

/** 
 * @Course: SDEV 450 ~ Enterprise Java Programming
 * @Author Name: Adam Ring
 * @Date: Nov 15, 2017
 * @Subclass Hash Description: Core of this function obtained from 
 * https://stackoverflow.com/questions/415953/how-can-i-generate-an-md5-hash
 * but modified for our use.
 */
public class Hash {

    private static String getHash(String txt, String hashType) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance(hashType);
            byte[] array = md.digest(txt.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            //error action
        }
        return null;
    }

    public static String md5(String txt) {
        return Hash.getHash(txt, "MD5");
    }

    public static String sha1(String txt) {
        return Hash.getHash(txt, "SHA1");
    }
}
