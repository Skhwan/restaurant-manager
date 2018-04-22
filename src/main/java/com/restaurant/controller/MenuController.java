package com.restaurant.controller;

import com.restaurant.database.MenuDao;
import com.restaurant.model.Menu;
import com.restaurant.util.MenuResponseWrapper;
import com.restaurant.util.ResponseConstant;
import com.restaurant.util.ResponseWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

/**
 * Created by khwanchanok on 4/22/2018 AD.
 */
@Controller
public class MenuController {

    private final Logger logger = LoggerFactory.getLogger(MenuController.class);

    @Autowired
    MenuDao menuDao;

    public ResponseEntity<ResponseWrapper> addMenu(Map<String, String> body){
        Menu menu = new Menu(body.get("name"), body.get("description"), body.get("image"), Integer.parseInt(body.get("price")));
        String additional = body.get("additional");
        menu.setAdditional(additional.trim().split("\\s*,\\s*"));

        ResponseWrapper responseWrapper = new ResponseWrapper();

        int result = menuDao.addMenu(menu);
        if(result > 0){
            responseWrapper.setResponseCode(ResponseConstant.SUCCESS_CODE);
            responseWrapper.setResponseDesc(ResponseConstant.SUCCESS);
            responseWrapper.setResponseStatus(ResponseConstant.SUCCESS);
        }else {
            responseWrapper.setResponseCode(ResponseConstant.FAIL_CODE);
            responseWrapper.setResponseDesc(ResponseConstant.FAIL);
            responseWrapper.setResponseStatus("Got error while adding menu : " + menu.getName());
        }

        logger.info(responseWrapper.toString());
        ResponseEntity<ResponseWrapper> response = new ResponseEntity<>(responseWrapper, HttpStatus.OK);
        return response;
    }

    public ResponseEntity<ResponseWrapper> removeMenu(String menuName){
        ResponseWrapper responseWrapper = new ResponseWrapper();

        int result = menuDao.removeMenu(menuName);
        if(result > 0){
            responseWrapper.setResponseCode(ResponseConstant.SUCCESS_CODE);
            responseWrapper.setResponseDesc(ResponseConstant.SUCCESS);
            responseWrapper.setResponseStatus(ResponseConstant.SUCCESS);
        }else {
            responseWrapper.setResponseCode(ResponseConstant.FAIL_CODE);
            responseWrapper.setResponseDesc(ResponseConstant.FAIL);
            responseWrapper.setResponseStatus("Got error while removing menu : " + menuName);
        }

        logger.info(responseWrapper.toString());
        ResponseEntity<ResponseWrapper> response = new ResponseEntity<>(responseWrapper, HttpStatus.OK);
        return response;
    }

    public ResponseEntity<ResponseWrapper> searchMenu(String keyword, int limit, int offset){
        MenuResponseWrapper responseWrapper = new MenuResponseWrapper();

        List<Menu> menus = menuDao.searchMenu(keyword, limit, offset);

        int nextOffset = offset + limit;
        int prevOffset = offset - limit;
        String path = "/restaurant-manager/searchMenu";
        String nextPage = getNextPageForSearchResult(keyword, limit, nextOffset, path);
        String prevPage = getPrevPage(limit, prevOffset, path);

        responseWrapper.setMenus(menus);
        responseWrapper.setNextPage(nextPage);
        responseWrapper.setPreviousPage(prevPage);
        responseWrapper.setResponseCode(ResponseConstant.SUCCESS_CODE);
        responseWrapper.setResponseStatus(ResponseConstant.SUCCESS);
        responseWrapper.setResponseDesc(ResponseConstant.SUCCESS);

        logger.info(responseWrapper.toString());
        ResponseEntity<ResponseWrapper> response = new ResponseEntity<>(responseWrapper, HttpStatus.OK);
        return response;
    }

    public ResponseEntity<ResponseWrapper> getAllMenu(int limit, int offset){
        MenuResponseWrapper responseWrapper = new MenuResponseWrapper();

        List<Menu> menus = menuDao.getAllMenu(limit, offset);

        int nextOffset = offset + limit;
        int prevOffset = offset - limit;
        String path = "/restaurant-manager/getAllMenu";
        String nextPage = getNextPage(limit, nextOffset, path);
        String prevPage = getPrevPage(limit, prevOffset, path);

        responseWrapper.setMenus(menus);
        responseWrapper.setNextPage(nextPage);
        responseWrapper.setPreviousPage(prevPage);
        responseWrapper.setResponseCode(ResponseConstant.SUCCESS_CODE);
        responseWrapper.setResponseStatus(ResponseConstant.SUCCESS);
        responseWrapper.setResponseDesc(ResponseConstant.SUCCESS);

        logger.info(responseWrapper.toString());
        ResponseEntity<ResponseWrapper> response = new ResponseEntity<>(responseWrapper, HttpStatus.OK);
        return response;
    }

    public String getNextPageForSearchResult(String keyword, int limit, int nextOffset, String path){
        String nextPage = null;
        if (menuDao.hasNextPageForKeyword(keyword, nextOffset)){
            nextPage = path + "?limit=" + limit + "&offset=" + nextOffset;
        }
        return nextPage;
    }

    public String getNextPage(int limit, int nextOffset, String path){
        String nextPage = null;
        if (menuDao.hasNextPage(nextOffset)){
            nextPage = path + "?limit=" + limit + "&offset=" + nextOffset;
        }
        return nextPage;
    }

    public String getPrevPage(int limit, int prevOffset, String path){
        String prevPage = null;
        if (prevOffset >= 0){
            prevPage = path + "?limit=" + limit + "&offset=" + prevOffset;
        }
        return prevPage;
    }
}
