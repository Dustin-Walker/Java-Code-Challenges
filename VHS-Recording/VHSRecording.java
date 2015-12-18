import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class VHSRecording {

    public static final int TITLE_INDEX_BEGINS = 10;
    /*
            You receive a timetable with when the shows start and when it ends.
            You return the maximum number of shows you can record.
            We can switch between channels instantaneously,
            so if a shows start on the same time a other one stops, you can record them.
             */
    private String mustSeeShowTitle;

    public static void main(String args[]) {
        VHSRecording vhsRecording = new VHSRecording();
        String file = "sample.data";
        try {
            List<String> stringList = vhsRecording.readFile(file);
            Set<Show> shows = vhsRecording.stringListToShowSet(stringList);
            List<Show> sortedShows = vhsRecording.sortShowsByEndTime(shows);
            for (Show show : sortedShows){
                System.out.println(show.getStartTime() + " " + show.getEndTime() + " " + show.getTitle());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Return the maximum number of shows that can be watched without shows overlapping from the input set
     * @param shows List of shows ordered by end time
     * @return Set of shows contained on the viewing schedule
     */
    public Set<Show> viewingScheduleWithMaxShows(Set<Show> shows){
        List<Show> showList = sortShowsByEndTime(shows);
        int currentEndTime = Integer.MAX_VALUE;
        int currentStartTime = Integer.MAX_VALUE;
        Show showToBeAdded = null;
        for (Show show : showList) {


        }
    }


    private List<String> readFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        return Files.readAllLines(path);
    }

    private Set<Show> stringListToShowSet(List<String> stringList){
        if (stringList.isEmpty()){
            return null;
        }
        Set<Show> showSet = new HashSet<>(stringList.size());
        // if the first show does not have the #### #### TITLE format
        if (!stringList.get(0).matches("\\d{4}\\s\\d{4}.*")){
            // This is a must see show
            System.out.println("Must see show: " + stringList.get(0));
            this.mustSeeShowTitle = stringList.remove(0);
        }
        for (String string : stringList){
            int startTime = Integer.valueOf(string.split("\\s")[0]);
            int endTime = Integer.valueOf(string.split("\\s")[1]);
            if (string.length() >= 10) {
                // Show has a title
                String showTitle = string.substring(TITLE_INDEX_BEGINS);
                showSet.add(new Show(startTime, endTime, showTitle));
            } else {
                // Show has no title
                showSet.add(new Show(startTime, endTime));
            }
        }
        return showSet;
    }

    /**
     * Sort the set into descending order using the show end time
     * @param showSet Set of TV shows
     * @return List in descending order by end time
     */
    private List<Show> sortShowsByEndTime(Set<Show> showSet){
        Comparator<? super Show> sortByEndTime = new Comparator<Show>() {
            @Override
            public int compare(Show o1, Show o2) {
                if (o1.getEndTime() > o2.getEndTime())
                    return -1;
                else if (o1.getEndTime() < o2.getEndTime())
                    return 1;
                else
                    return 0;
            }
        };
        return showSet.stream().sorted(sortByEndTime).collect(Collectors.toList());
    }


}
