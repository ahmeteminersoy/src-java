package example.app;

import java.util.Calendar;

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
        if (state == "Open")
            this.state = true;
        else if (state == "Close") {
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

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }
}
