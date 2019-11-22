/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanManager;

import static controllers.UsuarioController.admin;
import controllers.util.JsfUtil;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import models.Usuario;

/**
 *
 * @author leojf
 */
@Named(value = "sessionManagedBean1")
public class SessionManagedBean implements Serializable {

    public static Usuario user;
    private static HttpServletRequest httpservlet;

    /**
     * Creates a new instance of SessionManagedBean
     */
    public SessionManagedBean() {
    }

    public static Usuario getUsuarioLogin() {
        return SessionManagedBean.user;
    }

    public static boolean isAdmin() {
        if (getUsuarioLogin() != null) {
            if (getUsuarioLogin().getFkIdRol().getId() == 1) {
                return true;
            }
        }
        return false;
    }

    public static void setUsuarioLogin(Usuario user) {
        httpservlet = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        httpservlet.getSession().setAttribute("username", user.getUsername());
        httpservlet.getSession().setAttribute("name", user.getNombre());
        if (user.getFkIdRol() != null) {
            httpservlet.getSession().setAttribute("rol", user.getFkIdRol().getId());
        } else {
            httpservlet.getSession().setAttribute("rol", 2);
        }
        httpservlet.getSession().setAttribute("user", user);

        SessionManagedBean.user = user;
    }

    public String logout() {
        SessionManagedBean.user = null;
        try {
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            FacesContext.getCurrentInstance().getExternalContext().redirect("/FinalProjectJava/faces/view/login/login.xhtml");
        } catch (Exception e) {

        }
        return "logout";
    }

    public void checkSession(int level) throws IOException {
        if (SessionManagedBean.user != null) {
            if (level == 0 || level != user.getFkIdRol().getId()) {
                String redirect = "/FinalProjectJava/faces/view/index.xhtml";
                switch (user.getFkIdRol().getId()) {
                    case 1:
                        redirect = "/FinalProjectJava/faces/view/indexAdmin.xhtml";
                        break;
                }
                FacesContext
                        .getCurrentInstance()
                        .getExternalContext()
                        .redirect(redirect);
            }
        } else {
            if (level != 0) {
                FacesContext
                        .getCurrentInstance()
                        .getExternalContext()
                        .redirect("/FinalProjectJava/faces/view/login/login.xhtml");
            }
        }
    }
}
