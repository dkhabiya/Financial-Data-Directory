/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import model.Accounts;
import model.Cards;
import model.Customer;
import model.Details;
import service.AccountsService;
import service.CardsService;
import service.CustomerService;
import service.DetailsService;
import service.PreferencesService;
import service.UserService;

/**
 * Customer Controller
 * @author D
 */

@Named
@Stateless
public class CustomerController extends BaseController {

    private static final Logger LOG = Logger.getLogger(CustomerController.class.getName());

    @Inject LoginController loginController;
    @EJB UserService userService;
    @EJB CustomerService customerService;
    @EJB DetailsService detailsService;
    @EJB AccountsService accountsService;
    @EJB CardsService cardsService;
    @EJB PreferencesService preferncesService; 
    
    private Customer customer;
    private Details details;
    private List<Accounts> accounts;
    private List<Cards> cards;
    
    /**
     * Default constructor
     */
    public CustomerController() {
    }

    /**
     *
     */
    @PostConstruct
    protected void postConstruct() {
        super.postConstruct();

        customer = new Customer();
        details = new Details();
    }

    /**
     *
     * @return
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     *
     * @param c
     */
    public void setCustomer(Customer c) {
        this.customer = c;
    }

    /**
     *
     * @return
     */
    public Details getDetails() {
        return details;
    }

    /**
     *
     * @param d
     */
    public void setDetails(Details d) {
        this.details = d;
    }

    /**
     *
     * @return
     */
    public List<Accounts> getAccounts() {
        return accounts;
    }

    /**
     *
     * @param a
     */
    public void setAccounts(List<Accounts> a) {
        this.accounts = a;
    }

    /**
     * Create Empty Customer
     * @return
     */
    public String doCreateEmpty(){
        this.customer = new Customer();
        this.details = new Details();
        return loginController.userRoute("customer/customerAdd.xhtml");
    }
    
    /**
     * Create Customer
     * @param c
     * @param d
     * @return
     */
    public String doCreate(Customer c, Details d) {
        detailsService.doCreate(d, loginController.getRemoteUser());
        customerService.doCreate(c, d, loginController.getRemoteUser());

        return loginController.userRoute("welcome.xhtml");
    }
    
    /**
     * View Customer
     * @param custId
     * @return
     */
    public String doView(long custId) { 
        customer = customerService.findByCustId(custId);
        details = detailsService.findByCustDetailId(customer.getDetails().getDetailID());
        accounts = accountsService.findByCustId(custId);

        return loginController.userRoute("customer/customerView.xhtml");
    }
    
    /**
     * Update Customer
     * @param c
     * @param d
     * @return
     */
    public String doUpdate(Customer c, Details d) {
        customerService.doUpdate(c, d, loginController.getRemoteUser());
        return loginController.userRoute("customer/customerView.xhtml");
    }
      
    /**
     * Delete Customer
     * @param c
     * @return
     */
    public String doDelete(Customer c) {
        
        //Find required entities
        accounts = accountsService.findByCustId(c.getCustId());
        cards = cardsService.findByCustId(c.getCustId());
        
        //Delete Cards
        for (Cards card : cards) {
            cardsService.doDelete(card);
        }
        
        //Delete Accounts
        for (Accounts account : accounts) {
            accountsService.doDelete(account);
        }
        
        //Delete Customer
        customerService.doDelete(c);
        
        return loginController.userRoute("welcome.xhtml");
    }
    
    /**
     * Authorise Customer
     * @param c
     * @param d
     * @return
     */
    public String doAuth(Customer c, Details d) {
        
        detailsService.doAuth(d, loginController.getRemoteUser());
        customerService.doAuth(c, d, loginController.getRemoteUser());
        
        return loginController.userRoute("welcome.xhtml");
    }
}