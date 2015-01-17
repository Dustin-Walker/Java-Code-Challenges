import java.util.HashMap;

public class AcronymExpander {

    public static void main(String[] args) {
        AcronymExpander ae = new AcronymExpander();
        ae.preloadAcronymList();
        System.out.println(ae.expander("imo that was wp. Anyway I've g2g"));
    }

    private HashMap<String, String> acronymList = new HashMap<String, String>();

    public void preloadAcronymList(){
        acronymList.put("lol", "laugh out loud");
        acronymList.put("dw", "don't worry");
        acronymList.put("hf", "have fun");
        acronymList.put("gg", "good game");
        acronymList.put("brb", "be right back");
        acronymList.put("g2g", "got to go");
        acronymList.put("wtf", "what the fuck");
        acronymList.put("wp", "well played");
        acronymList.put("gl", "good luck");
        acronymList.put("imo", "in my opinion");
    }

    /**
     * Replaces acronyms in the string with expanded words.
     * @param s String to be modified
     * @return Modified string with acronyms replaced with full words
     */
    public String expander(String s){
        for(String ls : acronymList.keySet())
                s = s.replaceAll("\\b"+ls+"\\b", acronymList.get(ls));
        return s;
    }
}
