package org.systemsbiology.cytoweb.mvc.controllers;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.bind.ServletRequestUtils;
import org.systemsbiology.cytoweb.network.Provider;
import org.apache.commons.lang.ObjectUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: trollswagen
 * Date: Dec 10, 2006
 * Time: 1:42:12 PM
 */
public class NetworkActionsController extends MultiActionController {
    private Provider provider;

    /*
     * Dependency Injection Methods
     */
    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    /*
    * Public Methods
    */
    public ModelAndView getNetwork(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String networkFile = ServletRequestUtils.getStringParameter(request, "networkFile");
        if (!ObjectUtils.equals(networkFile, "")) {
            getProvider().setNetworkFile(networkFile);
        }

        ModelAndView modelAndView = new ModelAndView("network");
        modelAndView.addObject("network", getProvider().getNetwork());
        return modelAndView;
    }
}
