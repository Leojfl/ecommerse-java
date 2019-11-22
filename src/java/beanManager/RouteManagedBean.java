/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanManager;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author leojf
 */
@ManagedBean(name = "routeManagedBean", eager = true)
@RequestScoped

public class RouteManagedBean implements Serializable {

    public static int urlRoute = -1;
    public static String redirect = "?faces-redirect=true";

    /**
     * Creates a new instance of RouteManagedBean
     */
    public RouteManagedBean() {
    }

    public static Boolean getUrlRoute(String option) {
        Object request = FacesContext.getCurrentInstance().getExternalContext().getRequest();
        if (request instanceof HttpServletRequest) {
            String url = ((HttpServletRequest) request).getRequestURL().toString();
            if(url.indexOf(option)!= -1){
                return true;
            }
        } 
        return false;
    }

    public static int setUrlRoute(int newUrlroute) {
        urlRoute = newUrlroute;
        return urlRoute;
    }

    public String goProductIndex() {
        urlRoute = 0;

        return "page";
    }

    public String goCategoryIndex() {
        urlRoute = 1;

        return "indexCategory";
    }

}
