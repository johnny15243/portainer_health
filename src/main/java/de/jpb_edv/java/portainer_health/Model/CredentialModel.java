package de.jpb_edv.java.portainer_health.Model;

import java.util.Objects;

public class CredentialModel{
    String Username;
    String Password;

    public CredentialModel(String Username, String Password) {
        this.Username = Username;
        this.Password = Password;
    }

    public CredentialModel() {
    }

    public String getUsername() {
        return this.Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return this.Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public CredentialModel Username(String Username) {
        setUsername(Username);
        return this;
    }

    public CredentialModel Password(String Password) {
        setPassword(Password);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CredentialModel)) {
            return false;
        }
        CredentialModel credentialModel = (CredentialModel) o;
        return Objects.equals(Username, credentialModel.Username) && Objects.equals(Password, credentialModel.Password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Username, Password);
    }

    @Override
    public String toString() {
        return "{" +
            " Username='" + getUsername() + "'" +
            ", Password='" + getPassword() + "'" +
            "}";
    }


}
