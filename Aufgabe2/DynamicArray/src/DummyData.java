public class DummyData {
    String content;
    public DummyData(        ) { content = "leer"; }
    public DummyData(String s) { content = s; }
    public DummyData(int    i) { content = ""+i; }
    public String getContent() { return content; }
    public boolean equals(DummyData x) { return x.getContent()==content; }
}
