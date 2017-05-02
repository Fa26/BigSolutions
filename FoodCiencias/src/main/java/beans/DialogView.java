/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
 
import org.primefaces.event.CloseEvent;
import org.primefaces.event.MoveEvent;
/**
 *
 * @author mint
 */
@ManagedBean
@RequestScoped
public class DialogView {

    /**
     * Creates a new instance of DialogView
     */
    
    public void handleClose(CloseEvent event) {
        addMessage(event.getComponent().getId() + " closed", "So you don't like nature?");
    }
 
    public void handleMove(MoveEvent event) {
        addMessage(event.getComponent().getId() + " moved", "Left: " + event.getLeft() + ", Top: " + event.getTop());
    }
     
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
}
