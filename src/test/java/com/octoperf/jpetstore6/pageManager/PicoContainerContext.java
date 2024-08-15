package com.octoperf.jpetstore6.pageManager;

import com.octoperf.jpetstore6.pages.*;
import lombok.Getter;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;
import org.picocontainer.injectors.ConstructorInjection;

/**
 * Provides the PicoContainer context for managing the lifecycle and dependencies of page objects.
 * <p>
 * This class initializes and configures a {@link MutablePicoContainer} to manage various page objects
 * used in the application. The container is set up with all the page components that can be injected
 * and managed throughout the application's lifecycle.
 * </p>
 * <p>
 * The container includes the following page components:
 * <ul>
 *   <li>{@link P02_WelcomePage}</li>
 *   <li>{@link P03_CatalogPage}</li>
 *   <li>{@link P06_SignInPage}</li>
 *   <li>{@link P05_RegistrationPage}</li>
 *   <li>{@link P07_MyAccountPage}</li>
 *   <li>{@link P08_CategoryPage}</li>
 *   <li>{@link P09_ProductPage}</li>
 *   <li>{@link P10_ItemPage}</li>
 *   <li>{@link P11_CartPage}</li>
 *   <li>{@link P14_OrderConfirmationPage}</li>
 *   <li>{@link P12_OrderFormPage}</li>
 *   <li>{@link P15_OrderInformationPage}</li>
 *   <li>{@link P13_ShippingAddressPage}</li>
 *   <li>{@link P16_MyOrdersPage}</li>
 *   <li>{@link P04_HelpPage}</li>
 * </ul>
 * </p>
 * <p>
 * The container is configured using {@link ConstructorInjection}, allowing for automatic dependency
 * injection based on the constructor parameters.
 * </p>
 */
public class PicoContainerContext {

    /**
     * The PicoContainer instance used for managing page objects.
     * <p>
     * This static field holds the {@link MutablePicoContainer} instance that is used throughout the
     * application to manage the lifecycle and dependencies of page objects.
     * </p>
     */
    @Getter
    private static final MutablePicoContainer container;

    static {
        container = new DefaultPicoContainer(new ConstructorInjection());
        container.addComponent(P02_WelcomePage.class);
        container.addComponent(P03_CatalogPage.class);
        container.addComponent(P06_SignInPage.class);
        container.addComponent(P05_RegistrationPage.class);
        container.addComponent(P07_MyAccountPage.class);
        container.addComponent(P08_CategoryPage.class);
        container.addComponent(P09_ProductPage.class);
        container.addComponent(P10_ItemPage.class);
        container.addComponent(P11_CartPage.class);
        container.addComponent(P14_OrderConfirmationPage.class);
        container.addComponent(P12_OrderFormPage.class);
        container.addComponent(P15_OrderInformationPage.class);
        container.addComponent(P13_ShippingAddressPage.class);
        container.addComponent(P16_MyOrdersPage.class);
        container.addComponent(P04_HelpPage.class);
    }
}