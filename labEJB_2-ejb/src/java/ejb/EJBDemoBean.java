/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;

/**
 *
 * @author tosha
 */
@Stateful
@LocalBean
public class EJBDemoBean implements EJBDemo{
    private String login = "admin";
    private String password = "qwerty";
    private boolean regUser = false;
    private int count = 0;
    @Override
    public boolean login(String login, String psw) {
        if(this.login.equals(login) && this.password.equals(psw)){
            regUser = true;
            return true;
        }
        return false;
    }

    @Override
    public String getMessage(String login) {
        if(regUser && count < 3){
            count++;        
            return "Hello " + login + " " + count;
        }
        count = 0;
        regUser = false;
        return "user not reg";
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
