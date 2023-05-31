/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.IOException;

/**
 *
 * @author Yahya
 */
public class ViewManager {

    public static RegisterPage regPage;
    public static AdminDashboard adminPage;
    public static accountlode al;
    public static updateAccountLode ual;

    private ViewManager() {
    }

    public static void openRegisterPage() {
        if (regPage == null) {
            regPage = new RegisterPage();
            regPage.show();
        } else {
            regPage.show();
        }

    }

    public static void closeRegisterPage() {
        if (regPage != null) {
            regPage.close();
        }
    }

    public static void openAdminPage() throws IOException {
        if (adminPage == null) {
            adminPage = new AdminDashboard();
            adminPage.show();
        } else {
            adminPage.show();
        }

    }

    public static void closeAdminPage() {
        if (adminPage != null) {
            adminPage.close();
        }
    }

    public static void openNewuser() throws IOException {
        if (al == null) {
            al = new accountlode();
            al.show();
        } else {
            al.show();
        }

    }

    public static void closeNewuser() {
        if (ual != null) {
            ual.close();
        }
    }

    public static void openUpdateAccount() throws IOException {
        if (ual == null) {
            ual = new updateAccountLode();
            ual.show();
        } else {
            ual.show();
        }

    }

    public static void closeUpdateAccount() {
        if (ual != null) {
            ual.close();
        }
    }
}
