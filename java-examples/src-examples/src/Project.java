package src;

import java.util.Calendar;
import java.util.Objects;

public class Project {
    private String projectName;
    private Calendar startDate;
    private boolean state;

    public Project(String projectName, Calendar startDate, boolean state) {
        this.projectName = projectName;
        this.startDate = startDate;
        this.state = state;
    }
    public Project(String projectName, Calendar startDate, String state) {
        this.projectName = projectName;
        this.startDate = startDate;
        if (state.equals("Open"))
            this.state = true;
        else if (state.equals("Close")) {
            this.state=false;

        }
    }

    public String isState() {
        if (state)
            return "Open";
        else
            return "Close";
    }

    public void setState(boolean state) {
        this.state = state;
    }
    public void setState(String state) {
        if (state == "Open")
            this.state = true;
        else if (state == "Close")
            this.state = false;
    }
    public void close()
    {
        if (state)
            state = false;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Calendar getStartDate() {
        return startDate;
    }
    private static String formatCalendar(Calendar cal) {
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH) + 1; // Ay 0'dan başlar, bu yüzden 1 ekleyin
        int year = cal.get(Calendar.YEAR);

        // İki haneli gün ve ay varsa önlerine sıfır ekle
        String dayStr = String.format("%02d", day);
        String monthStr = String.format("%02d", month);

        // Tarihi dd/mm/yyyy formatında döndür
        return dayStr + "/" + monthStr + "/" + year;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "Project [" +
                "projectName='" + projectName + '\'' +
                ", startDate=" + formatCalendar(startDate) +
                ", state=" + state +
                ']';
    }
}
