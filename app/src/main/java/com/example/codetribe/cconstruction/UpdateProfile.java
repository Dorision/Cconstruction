package com.example.codetribe.cconstruction;

/**
 * Created by codetribe on 8/23/2017.
 */

public class UpdateProfile {

    private String mFirstName;
    private String mLastName;
    private String mEmailAddress;
    private String mLocation;
    private String mGender;
    private String mIdentity;
    private String mPassword;
    private String mConfirmPassword;



    public UpdateProfile(){

    }

    public UpdateProfile(String firstName, String lastName, String emailAddress, String location, String identity, String gender, String password, String confirmPassword){

        mFirstName=firstName;
        mLastName=lastName;
        mLocation=location;
        mEmailAddress=emailAddress;
        mIdentity=identity;
        mGender=gender;
        mPassword=password;
        mConfirmPassword=confirmPassword;


    }


    public UpdateProfile(String firstName, String emailAddress, String password, String confirmPassword){

        mFirstName=firstName;
        mEmailAddress=emailAddress;
        mPassword=password;
        mConfirmPassword=confirmPassword;


    }

    public String getmFirstName() {
        return mFirstName;
    }
    public void setmFirstName(String firstName){
        firstName=mFirstName;

    }

    public String getmLastName() {
        return mLastName;
    }
    public void setmLastName(String lastName){
        lastName=mLastName;
    }

    public String getmEmailAddress() {
        return mEmailAddress;
    }

    public void setmEmailAddress(String emailAddress){
        mEmailAddress=emailAddress;
    }

    public String getmGender() {
        return mGender;
    }
    public void setmGender(String gender){
        mGender=gender;
    }

    public String getmIdentity() {
        return mIdentity;
    }
    public void setmIdentity(String identity){
        mIdentity=identity;
    }


    public String getmLocation() {
        return mLocation;
    }
    public void setmLocation( String location){
        mLocation=location;
    }


    public String getmPassword() {
        return mPassword;
    }
    public void setmPassword( String password){
        mPassword=password;
    }

    public String getmConfirmPassword() {
        return mConfirmPassword;
    }
    public void setmConfirmPassword(String confirmPassword){
        mConfirmPassword=confirmPassword;
    }

}
