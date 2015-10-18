package zero.maestrocli;

import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

class SysoutWrapper extends PrintStream {

    int currentLine;
    public List<String> capturedLines;

    public SysoutWrapper() {
        super(System.out);

        capturedLines = new LinkedList<String>();
    }

    @Override
    public void println() {
        super.println();

        capturedLines.add("");
    }

    @Override
    public void println(char x) {
        super.println(x);

        capturedLines.add(((Character) x).toString());
    }

    @Override
    public void println(char[] x) {
        super.println(x);

        capturedLines.add(x.toString());

    }

    @Override
    public void println(double x) {
        super.println(x);

        capturedLines.add(((Double) x).toString());
    }

    @Override
    public void println(float x) {
        super.println(x);

        capturedLines.add(((Float) x).toString());
    }

    @Override
    public void println(int x) {
        super.println(x);

        capturedLines.add(((Integer) x).toString());
    }

    @Override
    public void println(long x) {
        super.println(x);

        capturedLines.add(((Long) x).toString());
    }

    @Override
    public void println(String x) {
        super.println(x);

        capturedLines.add(x);
    }

    @Override
    public void println(Object o) {
        super.println(o);

        capturedLines.add(o.toString());
    }

}