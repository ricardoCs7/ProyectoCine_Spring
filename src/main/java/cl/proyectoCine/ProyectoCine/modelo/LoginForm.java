/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.proyectoCine.ProyectoCine.modelo;

/**
 *
 * @author Ricardo
 */
public class LoginForm {
    
    private String userName;
    private String password;

    public LoginForm() {
        super();
        
        
    }

    public LoginForm(String userName, String passsword) {
        this.userName = userName;
        this.password = password;
    }

       
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPasssord(String password) {
        this.password = password;
    }
    
    
    
}
