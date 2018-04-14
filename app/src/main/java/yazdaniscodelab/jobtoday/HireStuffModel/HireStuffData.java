package yazdaniscodelab.jobtoday.HireStuffModel;

import android.widget.EditText;

/**
 * Created by Yazdani on 4/1/2018.
 */

public class HireStuffData {


    private String jobTitle;
    private String jobDescription;
    private String jobPosition;
    private String jobExperience;

    private String jobStart;
    private String jobAddress;
    private String jobSkills;
    private String jobContact;

    private String id;
    private String date;


    public HireStuffData(String jobTitle, String jobDescription, String jobPosition, String jobExperience, String jobStart, String jobAddress, String jobSkills, String jobContact, String id, String date) {
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.jobPosition = jobPosition;
        this.jobExperience = jobExperience;
        this.jobStart = jobStart;
        this.jobAddress = jobAddress;
        this.jobSkills = jobSkills;
        this.jobContact = jobContact;
        this.id = id;
        this.date = date;
    }

    public HireStuffData(){

    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public String getJobExperience() {
        return jobExperience;
    }

    public void setJobExperience(String jobExperience) {
        this.jobExperience = jobExperience;
    }

    public String getJobStart() {
        return jobStart;
    }

    public void setJobStart(String jobStart) {
        this.jobStart = jobStart;
    }

    public String getJobAddress() {
        return jobAddress;
    }

    public void setJobAddress(String jobAddress) {
        this.jobAddress = jobAddress;
    }

    public String getJobSkills() {
        return jobSkills;
    }

    public void setJobSkills(String jobSkills) {
        this.jobSkills = jobSkills;
    }

    public String getJobContact() {
        return jobContact;
    }

    public void setJobContact(String jobContact) {
        this.jobContact = jobContact;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }




}
