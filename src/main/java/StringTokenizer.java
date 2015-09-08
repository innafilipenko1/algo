import java.io.*;
import java.util.Iterator;

public class StringTokenizer implements Iterable<String>, Iterator<String> {


    private InputStream in;

    public StringTokenizer(InputStream in) {
        this.in = in;
    }

    public String nextToken() throws IOException {
        StringBuilder buf = new StringBuilder();

        int c;
        while ((c = in.read()) != -1) {
            buf.append((char)c);
        }
        return buf.toString();
    }

    @Override
    public Iterator<String> iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        try {
            return in.available() != 0;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String next() {
        char c = 0;
        try {
            while (in.available() != 0) {
                c = (char)in.read();

                if (Character.isLetter(c)) {
                    return String.valueOf(c);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "";
    }

    @Override
    public void remove() {

    }
}