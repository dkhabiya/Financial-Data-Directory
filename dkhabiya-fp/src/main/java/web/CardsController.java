/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import model.Accounts;
import model.Cards;
import service.AccountsService;
import service.CardsService;
import service.UserService;

/**
 * Card Controller
 * @author D
 */

@Named
@SessionScoped
public class CardsController extends BaseController implements Serializable {

    private static final Logger LOG = Logger.getLogger(CardsController.class.getName());

    @Inject LoginController loginController;
    @EJB UserService userService;
    @EJB AccountsService accountsService;
    @EJB CardsService cardsService;
    
    private Cards cards;
    private Accounts accounts;
    
    /**
     * Default constructor
     */
    public CardsController() {
    }

    /**
     *
     */
    @PostConstruct
    protected void postConstruct() {
        super.postConstruct();
        
        cards = new Cards();
    }

    /**
     *
     * @return
     */
    public Cards getCards() {
        return cards;
    }

    /**
     *
     * @param cards
     */
    public void setCards(Cards cards) {
        this.cards = cards;
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
     * Create Empty Card
     * @param a
     * @return
     */
    public String doCreateEmpty(Accounts a) {    
        this.cards = new Cards();
        this.accounts = a;
        return loginController.userRoute("cards/cardAdd.xhtml");
    }
    
    /**
     * Create Card
     * @param cd
     * @param a
     * @return
     */
    public String doCreate(Cards cd, Accounts a) {
        cardsService.doCreate(cd, loginController.getRemoteUser(), a);
        return loginController.userRoute("cards/cardView.xhtml");
    }
    
    /**
     * View Card
     * @param cardNo
     * @return
     */
    public String doView(long cardNo) { 
        cards = cardsService.findByCardNo(cardNo);
        return loginController.userRoute("cards/cardView.xhtml");
    }
    
    /**
     * Delete Card
     * @param cd
     * @return
     */
    public String doDelete(Cards cd) {
        cardsService.doDelete(cd);
        return loginController.userRoute("welcome.xhtml");
    }
    
    /**
     * Update Card
     * @param cd
     * @return
     */
    public String doUpdate(Cards cd) {
        cardsService.doUpdate(cd, loginController.getRemoteUser());
        return loginController.userRoute("cards/cardView.xhtml");
    }
    
    /**
     * Authorise Card
     * @param cd
     * @return
     */
    public String doAuth(Cards cd) {
       cardsService.doAuth(cd, loginController.getRemoteUser());
        
        return loginController.userRoute("welcome.xhtml");
    }
}
