/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import model.Accounts;
import model.Cards;
import model.Customer;
import model.Preferences;
import service.AccountsService;
import service.CardsService;
import service.CustomerService;
import service.PreferencesService;
import service.UserService;

/**
 * Account Controller
 * @author D
 */

@Named
@SessionScoped
public class AccountController extends BaseController implements Serializable {

    private static final Logger LOG = Logger.getLogger(AccountController.class.getName());

    @Inject 
    LoginController loginController;
    
    @EJB UserService userService;
    @EJB AccountsService accountsService;
    @EJB PreferencesService preferencesService;
    @EJB CardsService cardsService;
    @EJB CustomerService customerService;
    
    private Accounts accounts;
    private Preferences preferences;
    private Customer customer;
    private List<Cards> cards;
    
    /**
     * Default constructor
     */
    public AccountController() {
    }

    /**
     *
     */
    @PostConstruct
    protected void postConstruct() {
        super.postConstruct();
        
        accounts = new Accounts();
        preferences = new Preferences();
        customer = new Customer();
    }

    /**
     *
     * @return
     */
    public Accounts getAccounts() {
        return accounts;
    }

    /**
     *
     * @param accounts
     */
    public void setAccounts(Accounts accounts) {
        this.accounts = accounts;
    }

    /**
     *
     * @return
     */
    public Preferences getPreferences() {
        return preferences;
    }

    /**
     *
     * @param preferences
     */
    public void setPreferences(Preferences preferences) {
        this.preferences = preferences;
    }

    /**
     *
     * @return
     */
    public List<Cards> getCards() {
        return cards;
    }

    /**
     *
     * @param cards
     */
    public void setCards(List<Cards> cards) {
        this.cards = cards;
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
     * @param customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    /**
     * Create Empty Account
     * @param c
     * @return
     */
    public String doCreateEmpty(Customer c){
        this.accounts = new Accounts();
        this.preferences = new Preferences();
        this.customer = c;
        
        return loginController.userRoute("accounts/accountAdd.xhtml");
    }
    
    /**
     * Create Account
     * @param a
     * @param p
     * @param c
     * @return
     */
    public String doCreate(Accounts a, Preferences p, Customer c) {
        preferencesService.doCreate(p, loginController.getRemoteUser());
        accountsService.doCreate(a, p, c, loginController.getRemoteUser());
        
        return loginController.userRoute("accounts/accountView.xhtml");
    }
    
    /**
     * View Account
     * @param accountId
     * @return
     */
    public String doView(long accountId) { 
        accounts = accountsService.findByAccountId(accountId);
        preferences = preferencesService.findByAccountId(accountId);
        cards = cardsService.findByAccountId(accountId);
        
        return loginController.userRoute("accounts/accountView.xhtml");
    }
    
    /**
     * Update Account
     * @param a
     * @param p
     * @return
     */
    public String doUpdate(Accounts a, Preferences p) {
        //Update Preferences
        preferencesService.doUpdate(p, loginController.getRemoteUser());
        //Update Account
        accountsService.doUpdate(a, loginController.getRemoteUser());
        
        return loginController.userRoute("accounts/accountView.xhtml");
    }
    
    /**
     * Delete Accounts
     * @param a
     * @return
     */
    public String doDelete(Accounts a){
        //Get card details
        cards = cardsService.findByAccountId(a.getAccountID());
        
        for (Cards card : cards) {
            cardsService.doDelete(card);
        }
        
        accountsService.doDelete(a);
        
        return loginController.userRoute("welcome.xhtml");
    }
    
    /**
     * Authorise Account
     * @param a
     * @param p
     * @return
     */
    public String doAuth(Accounts a, Preferences p) {
        
        preferencesService.doAuth(p, loginController.getRemoteUser());
        accountsService.doAuth(a, p, loginController.getRemoteUser());
        
        return loginController.userRoute("welcome.xhtml");
    }
}
