package com.octoperf.jpetstore6.pageManager;

import com.octoperf.jpetstore6.pages.*;
import com.octoperf.jpetstore6.sharedData.ScenarioContext;
import org.picocontainer.MutablePicoContainer;
import lombok.RequiredArgsConstructor;

/**
 * Manages the retrieval of page objects using a PicoContainer for dependency injection.
 * <p>
 * The {@link PageManager} class interacts with the PicoContainer to provide instances of various page objects
 * based on the specified page name. It uses the container to fetch the appropriate page object that is
 * pre-configured and managed for the application.
 * </p>
 */
@RequiredArgsConstructor
public class PageManager {

    /**
     * The PicoContainer instance used for retrieving page objects.
     * <p>
     * This field is initialized using the {@link PicoContainerContext} class and is used to get the
     * appropriate page objects based on the page name.
     * </p>
     */
    private final MutablePicoContainer container = PicoContainerContext.getContainer();

    /**
     * The scenario context used for managing shared data across steps.
     */
    private final ScenarioContext scenarioContext;

    /**
     * Retrieves a page object based on the given page name.
     * <p>
     * The method uses a switch-case to determine the page object to return based on the page name provided.
     * If the page name is unknown, an {@link IllegalArgumentException} is thrown.
     * </p>
     *
     * @param pageName the name of the page to retrieve
     * @return the page object corresponding to the specified page name
     * @throws IllegalArgumentException if the page name is not recognized
     */
    public P01_BasePage getPage(String pageName) {
        switch (pageName) {
            case "Welcome":
                return container.getComponent(P02_WelcomePage.class);
            case "MyOrders":
                return container.getComponent(P16_MyOrdersPage.class);
            case "Help":
                return container.getComponent(P04_HelpPage.class);
            case "Catalog":
                return container.getComponent(P03_CatalogPage.class);
            case "SignIn":
                return container.getComponent(P06_SignInPage.class);
            case "Registration":
                return container.getComponent(P05_RegistrationPage.class);
            case "MyAccount":
                return container.getComponent(P07_MyAccountPage.class);
            case "Category":
                return container.getComponent(P08_CategoryPage.class);
            case "Product":
                return container.getComponent(P09_ProductPage.class);
            case "Item":
                return container.getComponent(P10_ItemPage.class);
            case "Cart":
                return container.getComponent(P11_CartPage.class);
            case "OrderConfirmation":
                return container.getComponent(P14_OrderConfirmationPage.class);
            case "OrderForm":
                return container.getComponent(P12_OrderFormPage.class);
            case "OrderInformation":
                return container.getComponent(P15_OrderInformationPage.class);
            case "ShippingAddress":
                return container.getComponent(P13_ShippingAddressPage.class);
            default:
                throw new IllegalArgumentException("Unknown page: " + pageName);
        }
    }
}