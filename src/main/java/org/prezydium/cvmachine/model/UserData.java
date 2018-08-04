package org.prezydium.cvmachine.model;

public class UserData {

    private String firstName;
    private String lastName;
    private Address address;
    private String email;
    private String phone;
    private String linkedInProfile;
    private String vcsRepo;

    public UserData() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLinkedInProfile() {
        return linkedInProfile;
    }

    public void setLinkedInProfile(String linkedInProfile) {
        this.linkedInProfile = linkedInProfile;
    }

    public String getVcsRepo() {
        return vcsRepo;
    }

    public void setVcsRepo(String vcsRepo) {
        this.vcsRepo = vcsRepo;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserData{");
        sb.append("firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", address=").append(address);
        sb.append(", email='").append(email).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", linkedInProfile='").append(linkedInProfile).append('\'');
        sb.append(", vcsRepo='").append(vcsRepo).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
