package by.training.epam.controller.command.impl;

import by.training.epam.controller.command.ICommand;
import by.training.epam.controller.servlet.JspPageName;
import by.training.epam.controller.servlet.RequestParameter;
import by.training.epam.service.IUserService;
import by.training.epam.service.exception.ServiceException;
import by.training.epam.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Class {@code SetAdminRight} is the class which responsible for reception parameters from {@link HttpServletRequest}
 * and generate attributes for it.
 *
 * @author Sergei Kalashynski
 * @version 1.0
 */
public class SetAdminRight implements ICommand {
    private static Logger logger = Logger.getLogger(SetAdminRight.class);
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();

    /**
     * Override method {@link ICommand#execute(HttpServletRequest, HttpServletResponse)}
     * Redirect parameters to {@link IUserService#setAdminRight(String)}
     * @return path of jsp page
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        IUserService IUserService = serviceFactory.getUserServiceImpl();
        try {
            logger.debug("\"" + ((String) request.getSession().getAttribute(RequestParameter.LOGIN.getValue())) + "\" try to set admin right for user");
            String idUser = request.getParameter(RequestParameter.ID_USER.getValue());
            IUserService.setAdminRight(idUser);
            request.setAttribute(RequestParameter.INFORMATION.getValue(), "Set admin right. Success!!!");
            logger.debug("\"" + ((String) request.getSession().getAttribute(RequestParameter.LOGIN.getValue())) + "\" set admin right for user");
        } catch (ServiceException e) {
            logger.error("\"" + ((String) request.getSession().getAttribute(RequestParameter.LOGIN.getValue())) + "\"", e);
            request.setAttribute(RequestParameter.INFORMATION.getValue(), e.getCause().getMessage());
        }
        return JspPageName.INDEX_PAGE.getPath();
    }
}