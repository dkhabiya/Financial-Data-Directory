/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import model.Accounts;
import model.Cards;
import model.Customer;
import model.Details;
import model.Preferences;
import service.AccountsService;
import service.CardsService;
import service.CustomerService;
import service.DetailsService;
import service.PreferencesService;
import service.UserService;

/**
 * Checker Controller
 * @author D
 */

@Named
@RequestScoped
public class CheckerController extends BaseController {
    
    @Inject LoginController loginController;
    @EJB UserService userService;
    @EJB CustomerService customerService;
    @EJB DetailsService detailsService;
    @EJB AccountsService accountsService;
    @EJB PreferencesService preferencesService;
    @EJB CardsService cardsService;
    
    private List<Customer> customer;
    private List<Details> details;
    private List<Accounts> accounts;
    private List<Preferences> preferences;
    private List<Cards> cards;
    private String userFullName;

    /**
     *
     */
    public CheckerController() {
    }

    /**
     *
     */
    @PostConstruct
    protected void postConstruct() {
        super.postConstruct();
        String userName = loginController.getRemoteUser();
        userFullName = userService.findUserName(userName);
        customer = customerService.findByChecker(userName);
        details = detailsService.findByChecker(userName);
        accounts = accountsService.findByChecker(userName);
        preferences = preferencesService.findByChecker(userName);
        cards = cardsService.findByChecker(userName);
    }

    /**
     *
     * @return
     */
    public String getUserFullName() {
        return userFullName;
    }

    /**
     *
     * @param userFullName
     */
    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }
}
