package controllers;

import bean.ImagenFacade;
import bean.OrdenFacade;
import models.Producto;
import controllers.util.JsfUtil;
import controllers.util.PaginationHelper;
import bean.ProductoFacade;
import bean.ProductoOrdenFacade;
import bean.UsuarioFacade;
import beanManager.RouteManagedBean;
import beanManager.SessionManagedBean;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import models.CategoriaProducto;
import models.Imagen;
import models.Orden;
import models.ProductoOrden;
import models.Usuario;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import sun.security.pkcs11.P11TlsKeyMaterialGenerator;

@Named("productoController")
@SessionScoped
@ManagedBean
public class ProductoController implements Serializable {

    private Producto current;
    private Imagen modelImg;
    private UploadedFile file;
    private final ArrayList files;
    private DataModel items;
    private DataModel orderCard;
    @EJB
    private bean.ProductoFacade ejbFacade;
    @EJB
    private bean.ImagenFacade imgFacade;
    @EJB
    private bean.OrdenFacade orderFacade;
    @EJB
    private bean.UsuarioFacade userFacade;
    @EJB
    private bean.ProductoOrdenFacade productOrderFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;
    private Producto selectedProduct;
    private Collection<Orden> userOrders;

    public ProductoController() {
        files = new ArrayList();
    }

    public ProductoFacade getEjbFacade() {
        return ejbFacade;
    }

    public void setEjbFacade(ProductoFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
    }

    public UsuarioFacade getUserFacade() {
        if (userFacade == null) {
            userFacade = new UsuarioFacade();
        }
        return userFacade;
    }

    public void setUserFacade(UsuarioFacade userFacade) {
        this.userFacade = userFacade;
    }

    public OrdenFacade getOrderFacade() {
        if (orderFacade == null) {
            orderFacade = new OrdenFacade();
        }

        return orderFacade;
    }

    public void setOrderFacade(OrdenFacade orderFacade) {
        this.orderFacade = orderFacade;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public Producto getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Producto selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public ProductoOrdenFacade getProductOrderFacade() {
        if (productOrderFacade == null) {
            productOrderFacade = new ProductoOrdenFacade();
        }
        return productOrderFacade;
    }

    public void setProductOrderFacade(ProductoOrdenFacade productOrderFacade) {
        this.productOrderFacade = productOrderFacade;
    }

    public Collection<Orden> getUserOrders() {
        Usuario user = SessionManagedBean.user;

        userOrders = null;
        if (user != null) {
            user = getUserFacade().find(SessionManagedBean.user.getId());
            userOrders = user.getOrdenCollection();
        }
        return userOrders;
    }

    public Producto getSelected() {
        if (current == null) {
            current = new Producto();
            selectedItemIndex = -1;
        }
        return current;
    }

    private ProductoFacade getFacade() {
        return ejbFacade;
    }

    private ImagenFacade getImgFacade() {
        if (imgFacade == null) {
            imgFacade = new ImagenFacade();
        }
        return imgFacade;
    }

    public void handleFileUpload(FileUploadEvent event) {
        files.add(event.getFile());
        FacesMessage msg = new FacesMessage("Correcto", " Se subieron las imagens correctamente");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (Producto) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Producto();
        selectedItemIndex = -1;
        files.clear();
        return "Create" + RouteManagedBean.redirect;
    }

    public String create() {

        try {
            current.setActivo(true);
            if (files.size() > 0) {
                getFacade().create(current);
                List<Producto> list = getFacade().findAll();
                Producto product = list.get(list.size() - 1);
                InputStream inputStream;
                OutputStream outputStream;
                /**
                 * ****The correct form is update the relation in model Product
                 * *******
                 */
//                Collection<Imagen> collectionImg= new ArrayList<>();
                String parentPath = "C:/Users/leojf/OneDrive/Documents/NetBeansProjects/FinalProjectJava/web/resources/img/";
                for (int x = 0; x < files.size(); x++) {
                    modelImg = new Imagen();
                    modelImg.setFkIdProducto(product);
                    file = (UploadedFile) files.get(x);
                    String fileName = "imgPro_" + System.currentTimeMillis() + "." + extension(file.getFileName());
                    modelImg.setUrl("/FinalProjectJava/resources/img/" + fileName);
                    File newFile = new File(parentPath, fileName);
                    inputStream = file.getInputstream();
                    outputStream = new FileOutputStream(newFile);
                    int read = 0;
                    byte[] bytes = new byte[1024];
                    while ((read = inputStream.read(bytes)) != -1) {
                        outputStream.write(bytes, 0, read);
                    }
                    getImgFacade().create(modelImg);
                    items = null;
                }
                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ProductoCreated"));
                return prepareCreate();
            }
            JsfUtil.addErrorMessage("Se necesita subir al menos una imagen");
            return null;
        } catch (Exception e) {
            System.out.println(e);
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String extension(String fileName) {
        String extension = "";
        int i = fileName.lastIndexOf('.');
        if (i > 0) {
            extension = fileName.substring(i + 1);
        }
        return extension;
    }

    public String prepareEdit() {
        current = (Producto) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ProductoUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Producto) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ProductoDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {

        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    public Orden getOrderCard() {
        Usuario user = SessionManagedBean.user;
        Orden order = null;

        if (user != null) {
            user = getUserFacade().find(SessionManagedBean.user.getId());
            Collection<Orden> orders = getOrderFacade().findAll();
            if (orders.size() > 0) {
                for (Orden orderUser : orders) {
                    if (orderUser.getStatus() == 1 && orderUser.getFkIdUsuario().getId() == user.getId()) {
                        order = orderUser;
                        break;
                    }
                }
            }
        }
        return order;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public Producto getProducto(java.lang.Integer id) {
        return ejbFacade.find(id);
    }

    public String addCart(Producto product) {
        String success = "true";
        Usuario user = SessionManagedBean.user;
        if (product.getCantidad() > 0) {
            if (user == null) {
                JsfUtil.addErrorMessage("Inicie sesión por favor");
            } else {
                user = getUserFacade().find(user.getId());
                Collection<Orden> list = getOrderFacade().findAll();
                Orden userOrder = null;
                ProductoOrden newProducto = new ProductoOrden();
                newProducto.setCantidad(1);
                newProducto.setPrecio(product.getPrecio());
                newProducto.setFkIdProducto(product);

                for (Orden order : list) {
                    if (order.getStatus() == 1 && order.getFkIdUsuario().getId() == user.getId()) {
                        userOrder = order;
                        break;
                    }
                }

                if (userOrder == null) {
                    userOrder = new Orden();
                    userOrder.setStatus(1);
                    userOrder.setFecha(new Date());
                    userOrder.setFkIdUsuario(user);
                    getOrderFacade().create(userOrder);
                    List<Orden> orders = getOrderFacade().findAll();
                    for (int i = 0; i < orders.size(); i++) {
                        userOrder = orders.get(i);
                    }
                    newProducto.setFkIdOrden(userOrder);
                    getProductOrderFacade().create(newProducto);
                } else {
                    Collection<ProductoOrden> productsOrder = userOrder.getProductoOrdenCollection();
                    productsOrder.add(newProducto);
                    newProducto.setFkIdOrden(userOrder);
                    newProducto.setFkIdOrden(userOrder);
                    getProductOrderFacade().create(newProducto);
                    userOrder.setProductoOrdenCollection(productsOrder);
                    getOrderFacade().edit(userOrder);
                }
                product.setCantidad(product.getCantidad() - 1);
                getFacade().edit(product);
                JsfUtil.addSuccessMessage("Producto agregado al carrito");
            }
        } else {
            JsfUtil.addErrorMessage("Producto agotado");
        }
        return success;
    }

    public void confirOrder() throws IOException {
        Orden order = getOrderCard();
        String redirect = "/FinalProjectJava/faces/view/ecommerce/carrito.xhtml";
        if (order != null) {
            order.setStatus(2);
            getOrderFacade().edit(order);
            redirect = "/FinalProjectJava/faces/view/ecommerce/ordenes.xhtml";
        }
        FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .redirect(redirect);
    }

    public double totalOrder(Orden order) {
        Collection<ProductoOrden> products = order.getProductoOrdenCollection();
        double total = 0;
        for (ProductoOrden product : products) {
            total += product.getPrecio();
        }
        return total;
    }

    @FacesConverter(forClass = Producto.class)
    public static class ProductoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ProductoController controller = (ProductoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "productoController");
            return controller.getProducto(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Producto) {
                Producto o = (Producto) object;
                return getStringKey(o.getId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Producto.class.getName());
            }
        }

    }

    @FacesConverter(forClass = Imagen.class)
    public static class ImagenControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ImagenController controller = (ImagenController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "imagenController");
            return controller.getImagen(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Imagen) {
                Imagen o = (Imagen) object;
                return getStringKey(o.getId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Imagen.class.getName());
            }
        }

    }

}
