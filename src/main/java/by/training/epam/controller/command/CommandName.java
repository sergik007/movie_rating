package by.training.epam.controller.command;

/**
 * This enum contains types of user's command.
 * @author Sergei Kalashynski
 * @version 1.0
 */
public enum CommandName {
    SIGN_IN, SIGN_UP, WRONG_REQUEST, SHOW_MOVIES, ADD_MOVIE,
    CHANGE_LOCAL, EXIT, REDIRECT, SHOW_MOVIE, REMOVE_MOVIE,
    SHOW_PAGE_FOR_ADD_MOVIE, REGAIN_MOVIE, SHOW_USERS, PERSONAL_USER,
    SORT_FILMS_BY_DATE, SORT_FILMS_BY_RATING, ADD_STATISTIC,
    BLOCK_USER, UNBLOCK_USER, REMOVE_COMMENT,
    ALERT, EDIT_MOVIE, SHOW_PAGE_FOR_EDIT_MOVIE,
    SET_ADMIN_RIGHT, SET_USER_RIGHT, SHOW_MAIN_PAGE,
    CHANGE_USER,CHANGE_USER_RATING;
}
